package backend.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import backend.order.dao.OrderDao;
import backend.order.service.OrderService;
import backend.order.model.OrderBean;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderDao orderDao;
	
	@Override
	
	public List<OrderBean> getOrders() {
		return orderDao.getOrders();
	}

	@Override
	public void saveOrder(OrderBean theOrderBean) {
		orderDao.saveOrder(theOrderBean);
	}

	@Override
	public OrderBean getOrderBean(Integer od_id) {
		return orderDao.getOrderBean(od_id);
	}

	@Override
	public void deleteOrder(Integer od_id) {
		orderDao.deleteOrder(od_id);
	}

}
