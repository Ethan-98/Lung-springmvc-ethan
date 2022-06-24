package backend.member.dao.impl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import backend.member.dao.MemberDao;
import backend.member.model.MemberBean;
import backend.order.dao.OrderDao;
import backend.order.model.OrderBean;

@Repository
public class MemberDaoImpl implements MemberDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override  //查詢
	public List<MemberBean> findAll() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<MemberBean> cq = cb.createQuery(MemberBean.class);
		Root <MemberBean> root = cq.from(MemberBean.class);
		cq.select(root);
		Query query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override  //新增or修改
	public void saveMember(MemberBean theMemberBean) {
		sessionFactory.getCurrentSession().saveOrUpdate(theMemberBean);
	}

	@Override  //for修改
	public MemberBean findById(Integer mi_no) {
		return sessionFactory.getCurrentSession().get(MemberBean.class, mi_no);
	}

	@Override  //刪除
	public void deleteMember(Integer mi_no) {
		Session session = sessionFactory.getCurrentSession();
		MemberBean theMemberBean = session.byId(MemberBean.class).load(mi_no);
		session.delete(theMemberBean);
	}

}
