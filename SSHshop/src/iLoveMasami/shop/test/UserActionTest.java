package iLoveMasami.shop.test;

import iLoveMasami.shop.entity.User;
import iLoveMasami.shop.service.UserService;

public class UserActionTest {
	
	public static void main(String[] args) {
		UserService userService = new UserService();
		User user = new User();
		user.setUsername("test");
		user.setPassword("12345678");
		user.setEmail("zyz940228@163.com");
		user.setAddress("testAddress");
		user.setPhone("123456789");
		user.setName("7777");
		user.setUid(66);
		userService.save(user);
	}
}
