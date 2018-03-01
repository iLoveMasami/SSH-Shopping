package iLoveMasami.shop.order.daoImpl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import iLoveMasami.shop.entity.Order;
import iLoveMasami.shop.order.dao.OrderDao;
import iLoveMasami.shop.utils.PageHibernateCallback;

/**
 * 
 * @author iLoveMasami
 * @date 2018年2月1日 下午7:02:13
 */
public class OrderDaoImpl extends HibernateDaoSupport implements OrderDao {
	@Override
	public void save(Order order) {
		this.getHibernateTemplate().save(order);
	}

	@Override
	public int findByCountUid(Integer uid) {
		String hql = "select  count(*) from Order o where o.user.uid = ?";
		List<Long> list = this.getHibernateTemplate().find(hql, uid);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	public List<Order> findByPageUid(Integer uid, int begin, int limit) {
		String hql = "from Order o where o.user.uid = ? order by ordertime desc";
		List<Order> list = this.getHibernateTemplate()
				.execute(new PageHibernateCallback<Order>(hql, new Object[] { uid }, begin, limit));
		return list;
	}

}
