package backend.animal.service;
import java.util.List;

import backend.animal.bean.*;

public interface AbDogService {
    public List < AbDogBean > getAbDog(); //查詢全部資料 要return集合型

    public void saveAbDog(AbDogBean abdogbean);//後面帶實體類bean引數過來

    public AbDogBean getAbDogById(int Id);//帶引數 查詢單筆 /更正用 回傳一筆資料

    public void deleteAbDog(int Id);//帶一個ID過去

}
