package iLoveMasami.shop.order.serviceImpl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import iLoveMasami.shop.entity.Order;
import iLoveMasami.shop.order.dao.OrderDao;
import iLoveMasami.shop.order.service.OrderService;
import iLoveMasami.shop.utils.PageBean;

/**
 * 
 * @author iLoveMasami
 * @date 2018年2月1日 下午7:02:10
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
		pageBean.setPage(page);// 设置页数
		int limit = 5;
		pageBean.setLimit(limit);// 设置记录数
		int totalCount = orderDao.findByCountUid(uid);
		pageBean.setTotalCount(totalCount);// 总记录数
		// 设置总页数
		int totalPage = 0;
		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;
		} else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 设置每页显示的数据集合
		int begin = (page - 1) * limit;
		List<Order> list = orderDao.findByPageUid(uid, begin, limit);
		pageBean.setList(list);
		return pageBean;
	}

}
