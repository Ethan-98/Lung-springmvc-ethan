package backend.animal.dao;

import java.util.List;

import javax.persistence.Query;//查詢語句全
import javax.persistence.criteria.CriteriaBuilder;//過濾 建立條件式持久層
import javax.persistence.criteria.CriteriaQuery;//查詢條件式
import javax.persistence.criteria.Root;//查詢最裡面

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;//持久層

import backend.animal.bean.AbDogBean;

@Repository
public class AbDogDaoImpl implements AbDogDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override //全部查詢 session會話集合 儲存體 
	public List<AbDogBean> getAbDog() {
        Session session = sessionFactory.getCurrentSession();//取得現在目標
        CriteriaBuilder cb = session.getCriteriaBuilder();//建立標準的查詢方式
        CriteriaQuery < AbDogBean > cq = cb.createQuery(AbDogBean.class);//建立簡單查詢的基本方法
        Root < AbDogBean > root = cq.from(AbDogBean.class);//查詢欄位
        cq.select(root);//執行
        Query query = session.createQuery(cq);//query接查詢到的資料
        return query.getResultList();//把紀錄丟給這個list
    }

	

	@Override //新增 更正
	public void saveAbDog(AbDogBean abdogbean) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(abdogbean);

	}

	@Override //單筆查詢
	public AbDogBean getAbDogById(int Id) {
        Session currentSession = sessionFactory.getCurrentSession();
        AbDogBean abdogbean = currentSession.get(AbDogBean.class, Id);
        return abdogbean;
	}

	@Override//刪除
	public void deleteAbDog(int Id) {
        Session session = sessionFactory.getCurrentSession();
        AbDogBean book = session.byId(AbDogBean.class).load(Id);
        session.delete(book);

	}

}
    