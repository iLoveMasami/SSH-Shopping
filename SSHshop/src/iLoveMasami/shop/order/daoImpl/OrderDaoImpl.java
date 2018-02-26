package iLoveMasami.shop.order.daoImpl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import iLoveMasami.shop.entity.Order;
import iLoveMasami.shop.order.dao.OrderDao;

/**
 * 
 * @author iLoveMasami
 * @date   2018年2月1日 下午7:02:13
 */
public class OrderDaoImpl extends HibernateDaoSupport implements OrderDao{
	/* (non-Javadoc)
	 * @see iLoveMasami.shop.order.daoImpl.OrderDao#save(iLoveMasami.shop.entity.Order)
	 */
	@Override
	public void save(Order order) {
		this.getHibernateTemplate().save(order);
	}

}
