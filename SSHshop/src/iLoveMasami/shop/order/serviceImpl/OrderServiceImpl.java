package iLoveMasami.shop.order.serviceImpl;

import org.springframework.transaction.annotation.Transactional;

import iLoveMasami.shop.entity.Order;
import iLoveMasami.shop.order.dao.OrderDao;
import iLoveMasami.shop.order.service.OrderService;
import iLoveMasami.shop.utils.PageBean;

/**
 * 
 * @author iLoveMasami
 * @date   2018年2月1日 下午7:02:10
 */
@Transactional
public class OrderServiceImpl implements OrderService {
	private OrderDao orderDao;

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}


	@Override
	public void save(Order order) {
		orderDao.save(order);
	}


	@Override
	public PageBean<Order> findByPageUid(Integer uid, Integer page) {
		PageBean<Order> pageBean = new PageBean<Order>();
		return null;
	}
	
}
