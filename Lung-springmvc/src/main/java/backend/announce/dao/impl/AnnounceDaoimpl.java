package backend.announce.dao.impl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import backend.announce.dao.AnnounceDao;
import backend.announce.model.AnnounceBean;
@Repository
public class AnnounceDaoimpl implements AnnounceDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<AnnounceBean> getAnnounce() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<AnnounceBean> cq = cb.createQuery(AnnounceBean.class);
		Root<AnnounceBean> root = cq.from(AnnounceBean.class);
		cq.select(root);
		Query query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void saveAnnounce(AnnounceBean theAnnounceBean) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(theAnnounceBean);
	}

	@Override
	public AnnounceBean getAnnounceBean(Integer anNo) {
		Session session = sessionFactory.getCurrentSession();
		AnnounceBean theAnnounceBean = session.get(AnnounceBean.class, anNo);
		return theAnnounceBean;
	}

	@Override
	public void deleteAnnounce(Integer anNo) {
		Session session = sessionFactory.getCurrentSession();
		AnnounceBean theAnnounceBean = session.byId(AnnounceBean.class).load(anNo);
		session.delete(theAnnounceBean);
	}


}
