package backend.activity.dao.impl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import backend.activity.dao.ActivityDao;
import backend.activity.model.ActivityBean;

@Repository
public class ActivityDaoImpl implements ActivityDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<ActivityBean> getActivity() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<ActivityBean> cq = cb.createQuery(ActivityBean.class);
		Root <ActivityBean> root = cq.from(ActivityBean.class);
		cq.select(root);
		Query query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void saveActivity(ActivityBean theActivityBean) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(theActivityBean);
	}

	@Override
	public ActivityBean getActivityBean(Integer ac_id) {
		Session session = sessionFactory.getCurrentSession();
		ActivityBean theActivityBean = session.get(ActivityBean.class, ac_id);
		return theActivityBean;
	}

	@Override
	public void deleteActivity(Integer ac_id) {
		Session session = sessionFactory.getCurrentSession();
		ActivityBean theActivityBean = session.byId(ActivityBean.class).load(ac_id);
		session.delete(theActivityBean);
	}

}
