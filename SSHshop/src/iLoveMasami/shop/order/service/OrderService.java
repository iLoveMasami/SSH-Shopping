package iLoveMasami.shop.order.service;

import iLoveMasami.shop.entity.Order;
import iLoveMasami.shop.utils.PageBean;

public interface OrderService {

	void save(Order order);

	PageBean<Order> findByPageUid(Integer uid, Integer page);

	Order findByOid(Integer oid);

	/**
	 * 修改订单
	 * 
	 * @param currOrder
	 */
	void update(Order currOrder);

}