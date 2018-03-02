package iLoveMasami.shop.order.dao;

import java.util.List;

import iLoveMasami.shop.entity.Order;

public interface OrderDao {

	/**
	 * Dao层保存订单
	 * 
	 * @param order
	 */
	void save(Order order);

	/**
	 * 我的订单的个数统计
	 * 
	 * @param uid
	 * @return
	 */
	int findByCountUid(Integer uid);

	/**
	 * 我的订单的查询
	 * @param uid
	 * @param begin
	 * @param limit
	 * @return
	 */
	List<Order> findByPageUid(Integer uid, int begin, int limit);
	/**
	 * 根据订单id查询订单
	 * @param oid
	 * @return
	 */
	Order findByOid(Integer oid);

}