package backend.product.dao.impl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import backend.product.dao.ProductDao;
import backend.product.model.ProductBean;


@Repository
public class ProductImplements implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<ProductBean> getProduct() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<ProductBean> cq = cb.createQuery(ProductBean.class);
		Root <ProductBean> root = cq.from(ProductBean.class);
		cq.select(root);
		Query query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void saveProduct(ProductBean theProductBean) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(theProductBean);
	}

	@Override
	public ProductBean getProductBean(Integer pd_id) {
		Session session = sessionFactory.getCurrentSession();
		ProductBean theProductBean = session.get(ProductBean.class, pd_id);
		return theProductBean;
	}

	@Override
	public void deleteProduct(Integer pd_id) {
		Session session = sessionFactory.getCurrentSession();
		ProductBean theProductBean = session.byId(ProductBean.class).load(pd_id);
		session.delete(theProductBean);
	}

}

