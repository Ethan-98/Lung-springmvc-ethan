package backend.order.dao;

import java.util.List;

import backend.order.model.OrderBean;


public interface OrderDao {
	
	//show all
	public List<OrderBean> getOrders();
	
	//save
	public void saveOrder(OrderBean theOrderBean);
	
	//getOrder
	public OrderBean getOrderBean(Integer od_id);
	
	//delete
	public void deleteOrder(Integer od_id);
}
