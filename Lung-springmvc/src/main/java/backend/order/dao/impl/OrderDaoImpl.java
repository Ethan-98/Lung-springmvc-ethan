package backend.order.dao.impl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import backend.order.dao.OrderDao;
import backend.order.model.OrderBean;

@Repository
public class OrderDaoImpl implements OrderDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<OrderBean> getOrders() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<OrderBean> cq = cb.createQuery(OrderBean.class);
		Root <OrderBean> root = cq.from(OrderBean.class);
		cq.select(root);
		Query query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void saveOrder(OrderBean theOrderBean) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(theOrderBean);
	}

	@Override
	public OrderBean getOrderBean(Integer od_id) {
		Session session = sessionFactory.getCurrentSession();
		OrderBean theOrderBean = session.get(OrderBean.class, od_id);
		return theOrderBean;
	}

	@Override
	public void deleteOrder(Integer od_id) {
		Session session = sessionFactory.getCurrentSession();
		OrderBean theOrderBean = session.byId(OrderBean.class).load(od_id);
		session.delete(theOrderBean);
	}

}
