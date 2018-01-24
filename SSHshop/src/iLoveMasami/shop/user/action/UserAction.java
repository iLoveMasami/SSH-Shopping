package iLoveMasami.shop.user.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import iLoveMasami.shop.user.entity.User;
import iLoveMasami.shop.user.service.UserService;
/**
 * 用户模块Action类
 * @author iLoveMasami
 * @date   2018年1月23日 下午4:40:10
 */
public class UserAction extends ActionSupport implements ModelDriven<User>{
	private User user =new User();
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	//使用模型驱动来接收参数
	@Override
	public User getModel() {		
		return user;
	}
	
	//跳转到用户注册页面的执行方法
	public String registPage()
	{
		return "registPage";
	}
	
	//AJAX进行异步校验用户名的执行方法
	public String findByUsername() throws IOException{
		User existUser = userService.findByUsername(user.getUsername());
		//获得response对象来输出
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		//判断是否存在
		if(existUser!=null){
			//该用户已经存在
			
			response.getWriter().println("<font color='red'>该用户已经存在！</font>");
		}
		else{
			//用户名可以使用
			
			response.getWriter().println("<font color='green'>用户名可以使用</font>");
		}
		return NONE;
	}
	
	//用户注册的方法
	public String regist(){
		//需要完成校验
		userService.save(user);
		this.addActionMessage("注册成功，请去邮箱激活！");
		return "msg";
	}
	
	//用户激活的方法
	public String active(){
		//根据激活码查询用户：
		User existUser = userService.findByCode(user.getCode());
		if(existUser == null){
			//激活码错误
			this.addActionMessage("激活失败：激活码错误！");
		}
		else{
			//激活成功
			//修改用户状态
			existUser.setState(1);
			existUser.setCode(null);
			userService.update(existUser);
			this.addActionMessage("激活成功：请去登录！");
		}
		return "msg";
	}
}
