package backend.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import backend.product.dao.ProductDao;
import backend.product.service.ProductService;
import backend.product.model.ProductBean;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	@Override
	@Transactional
	public List<ProductBean> getProduct() {
		return productDao.getProduct();
	}

	@Override
	@Transactional
	public void saveProduct(ProductBean theProductBean) {
		productDao.saveProduct(theProductBean);
	}

	@Override
	@Transactional
	public ProductBean getProductBean(Integer pd_id) {
		return productDao.getProductBean(pd_id);
	}

	@Override
	@Transactional
	public void deleteProduct(Integer pd_id) {
		productDao.deleteProduct(pd_id);
	}

}
