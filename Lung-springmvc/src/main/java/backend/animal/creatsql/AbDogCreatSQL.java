package backend.animal.creatsql;

 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class AbDogCreatSQL {
	
	public static void main(String[] args) {

       try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Lung","sa", "sa123456");
			Statement stmt = con.createStatement();			
			System.out.print("??��?��??結�?��?�庫");

               System.out.println("??��?��??�? text_db 資�?�庫");

               stmt = con.createStatement();  // ?��??? SQL ??�述?���?

            String sql="CREATE TABLE AbDog("
            		    + "id int IDENTITY  PRIMARY KEY ,"//?��??�給
					    + "abid VARCHAR(45) NOT NULL,"//
        		        + "abname varchar(50)," //
	            		+ "abphone varchar(50)," //
	                    + "abemail varchar(50)," //  
	                    + "abdogname varchar(50),"//寵物???
	                    + "abimage nvarchar(500),"//??��??
	                    + "abaddress varchar(50),"//來�?�地??            
	                    + "abtype varchar(50),"//    ??��??               
	                    + "abage INT ,"//              年�?
	                    + "abdate DATE,"//            ?��???		 
						+ "abremark nvarchar(500))";//??�註

	stmt.executeUpdate(sql);
	
	System.out.println("Created table in given database...");
	 con.close();      

        }

              catch (ClassNotFoundException e) {

            e.printStackTrace();

        }

              catch (SQLException e) {

            e.printStackTrace();

        }

}
}

