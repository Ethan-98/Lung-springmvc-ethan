package init;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

public class CreateMember {
	
	private static String insert_SQL = "INSERT INTO MemberTable"
			+ " ( MI_NAME, MI_ID, MI_BIRTH, MI_PHONE, MI_EMAIL, MI_ADDRESS, MI_ACCOUNT, MI_PASSWORD, localfileName) VALUES "
			+ " ( ? , ? , ? , ? , ? , ? , ? , ? ,? );";
	
	
	public static void main(String[] args) {

		// create Datasource
		SQLServerDataSource ds = new SQLServerDataSource();
		ds.setUser("sa");
		ds.setPassword("sa123456");
		ds.setServerName("localhost");
		ds.setPortNumber(1433);
		ds.setDatabaseName("Lung");

		try {
			// 連線
			Connection conn = ds.getConnection();
			Statement st = conn.createStatement();
			System.out.println(" > 連線至資料庫Lung");

			// 模擬已有的會員資料 -> 匯入已建好的CSV檔
			FileInputStream fis = new FileInputStream("MemberData.csv");
			InputStreamReader isr = new InputStreamReader(fis, "MS950");
			BufferedReader br = new BufferedReader(isr);
			String row;
			br.readLine();
			int j = 0;
			PreparedStatement pstmt = conn.prepareStatement(insert_SQL);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");  //設定這個日期格式
			while ((row = br.readLine()) != null) {      // 判斷這一行資料是不是null
//				System.out.println(row);                 // 印出csv中的這行資料(含逗號) ->  row = "aa,bb,cc,dd"
				System.out.println(" > 讀取csv");
				System.out.printf(" > csv中第%d行資料為: %s%n",++j,row);   //因為是++j，所以j的初始是第'1'行
				String[] data = row.split(",");          // 用逗號切分後放進陣列 ->  data = ["aa", "bb", "cc", "dd"]

				for (int i = 0; i < data.length; i++) {      // 使用for迴圈，讀取陣列第i行
					System.out.printf(" > 第%d個是: %s%n",i,data[i]);         // 印出陣列第i個，for迴圈run完會印出csv中的一列
				}

				pstmt.setString(1, data[0]); // MI_NAME
				pstmt.setString(2, data[1]); // MI_ID
				pstmt.setDate(3, new java.sql.Date(dateFormat.parse(data[2]).getTime())); // MI_BIRTH
				//按照這個格式(yyyy-MM-dd)去parse csv中的日期   //getTime回傳long型態，指從1970年到這個日期之間的秒數
				pstmt.setString(4, data[3]); // MI_PHONE
				pstmt.setString(5, data[4]); // MI_EMAIL
				pstmt.setString(6, data[5]); // MI_ADDRESS
				pstmt.setString(7, data[6]); // MI_ACCOUNT
				pstmt.setString(8, data[7]); // MI_PASSWORD
				pstmt.setString(9, data[8]); // localfileName


				pstmt.addBatch();
			}
			pstmt.executeBatch();  //執行，把這一行資料塞進DB。
			System.out.println(" > 匯入DB完成");
		} catch (SQLServerException e) {
			e.printStackTrace();
			System.out.println("連線失敗，請檢查資料庫");
		} catch (FileNotFoundException e) {
			System.out.println("請檢察路徑是否有csv檔案");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("匯入資料到SQL失敗，請檢查");
			e.printStackTrace();
		} catch (ParseException e) {
			System.out.println("請檢查生日的日期格式");
			e.printStackTrace();
		}

	}

}
