package iLoveMasami.back.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import iLoveMasami.back.entity.AdminUser;

/**
 * 
 * @author iLoveMasami
 * @date 2018年2月5日 下午9:42:41
 */
public class AdminUserDao extends HibernateDaoSupport {

	public AdminUser login(AdminUser adminUser) {
		String hql = "from AdminUser where username = ? and password = ?";
		List<AdminUser> list = 
				this.getHibernateTemplate().find(hql,adminUser.getUsername(),adminUser.getPassword());
		if(list != null && list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}

}
