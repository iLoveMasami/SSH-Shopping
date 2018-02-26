package iLoveMasami.back.service;

import org.springframework.transaction.annotation.Transactional;

import iLoveMasami.back.dao.AdminUserDao;
import iLoveMasami.back.entity.AdminUser;

/**
 * 
 * @author iLoveMasami
 * @date   2018年2月5日 下午9:43:08
 */
@Transactional
public class AdminUserService {
	private AdminUserDao adminUserDao;

	public void setAdminUserDao(AdminUserDao adminUserDao) {
		this.adminUserDao = adminUserDao;
	}
	/**
	 * 业务层登录方法
	 * @param adminUser
	 * @return
	 */
	public AdminUser login(AdminUser adminUser) {
		
		return adminUserDao.login(adminUser);
	}
	
}
