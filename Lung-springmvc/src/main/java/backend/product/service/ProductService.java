package backend.product.service;

import java.util.List;

import backend.product.model.ProductBean;

public interface ProductService {

	//show all
			public List<ProductBean> getProduct();
			
			//save
			public void saveProduct(ProductBean theProductBean);
			
			//getOrder
			public ProductBean getProductBean(Integer pd_id);
			
			//delete
			public void deleteProduct(Integer pd_id);
		
	}

