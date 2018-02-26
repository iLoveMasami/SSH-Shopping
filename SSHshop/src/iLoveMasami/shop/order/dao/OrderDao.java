package iLoveMasami.shop.order.dao;

import iLoveMasami.shop.entity.Order;

public interface OrderDao {

	/**
	 * Dao层保存订单
	 * @param order
	 */
	void save(Order order);

}