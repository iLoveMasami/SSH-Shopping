package iLoveMasami.shop.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import iLoveMasami.shop.dao.UserDao;
import iLoveMasami.shop.entity.User;
import iLoveMasami.shop.utils.MD5Util;
import iLoveMasami.shop.utils.MailUtils;
import iLoveMasami.shop.utils.UUIDUtils;

/**
 * 
 * @author iLoveMasami
 * @date 2018年1月24日 下午4:12:51
 */
@Transactional
public class UserService {
	private final Logger log = LoggerFactory.getLogger(UserService.class);

	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	// 根据姓名查询用户
	public User findByUsername(String username) {
		User user = userDao.findByUsername(username);
		return user;
	}

	// 完成用户注册功能
	public void save(User user) {
		try {
			// 完善user对象
			// 0代表用户未激活，1代表用户已激活
			user.setState(0);
			// 设置激活码
			String code = UUIDUtils.getUUID() + UUIDUtils.getUUID();// 32位+32位
			user.setCode(code);
			// 密码MD5加密
			String oldPassword = user.getPassword();
			String newPassword = MD5Util.EncoderByMd5(oldPassword);
			user.setPassword(newPassword);
			userDao.save(user);
			// 发送激活邮件
			MailUtils.sendMail(user.getEmail(), code);
		} catch (Exception e) {
			log.error("exception", e);
		}
	}

	// 根据激活码查询用户
	public User findByCode(String code) {

		return userDao.findByCode(code);
	}

	// 修改用户状态
	public void update(User existUser) {
		userDao.update(existUser);
	}

	// 用户登录
	public User login(User user) {
		try {
			user.setPassword(MD5Util.EncoderByMd5(user.getPassword()));
		} catch (Exception e) {
			log.error("exception", e);
		}
		return userDao.login(user);
	}

}
