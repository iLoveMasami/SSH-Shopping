package iLoveMasami.shop.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import iLoveMasami.shop.entity.User;

/**
 * 
 * @author iLoveMasami
 * @date 2018年1月24日 下午4:12:55
 */
public class UserDao extends HibernateDaoSupport {
	// 根据姓名查询用户
	public User findByUsername(String username) {
		// 使用HQL查询
		String hql = "from User where username = ?";
		List<User> list = this.getHibernateTemplate().find(hql, username);
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	// 注册用户存入数据库
	public void save(User user) {
		this.getHibernateTemplate().save(user);
	}

	public User findByCode(String code) {
		String hql = "from User where code = ?";
		List<User> list = this.getHibernateTemplate().find(hql, code);
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	public void update(User existUser) {
		this.getHibernateTemplate().update(existUser);
	}

	// public User login(User user) {
	// String hql = "from User where username = ? and password = ? and state =
	// ?";
	// List<User> list = this.getHibernateTemplate().find(hql,
	// user.getUsername(),user.getPassword(),1);
	// if(list != null && list.size()>0){
	// return list.get(0);
	// }else{
	// return null;
	// }
	// }
	public User login(User user) {
		String hql = "from User where username = ? and password = ?";
		List<User> list = this.getHibernateTemplate().find(hql, user.getUsername(), user.getPassword());
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			String hql2 = "from User where email = ? and password = ?";
			List<User> list2 = this.getHibernateTemplate().find(hql2, user.getUsername(), user.getPassword());
			if (list2 != null && list2.size() > 0)
				return list2.get(0);
		}
		return null;
	}
}
