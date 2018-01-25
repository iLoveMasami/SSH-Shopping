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
	//接收验证码
	private String checkcode;

	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	//跳转到用户注册页面的执行方法
	public String registPage()
	{
		return "registPage";
	}
	
	/**
	 * AJAX进行异步校验用户名的执行方法
	 * @return
	 * @throws IOException
	 */
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
	
	/**
	 * 用户注册的方法
	 * @return
	 */
	public String regist(){
		//验证码的校验
		String systemCheckcode = ServletActionContext.getRequest().getSession().getAttribute("checkcode").toString();
		if(!checkcode.equalsIgnoreCase(systemCheckcode)){
			//验证码出错
			return "registPage";
		}
		//需要完成校验
		userService.save(user);
		this.addActionMessage("注册成功，请去邮箱激活！");
		return "msg";
	}
	
	/**
	 * 用户激活的方法
	 * @return
	 */
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
	/**
	 * 跳转到登录页面
	 * @return
	 */
	public String loginPage(){
		return "loginPage";
	}
	/**
	 * 用户登录
	 * @return
	 */
	public String login(){
		String systemCheckcode = ServletActionContext.getRequest().getSession().getAttribute("checkcode").toString();
		String userCheckcode = checkcode;
		if(!userCheckcode.equalsIgnoreCase(systemCheckcode)){
			//验证码出错
			this.addActionError("验证码错误");
			return "loginPage";
		}
		User existUser = userService.login(user);
		if(existUser==null){
			//登录失败
			this.addActionError("登录失败：用户名或者密码错误！！");
			return LOGIN;
		}else if(existUser.getState()==0){
			//登录失败
			this.addActionError("登录失败：该用户尚未激活！");
			return LOGIN;
		}else{
			//登录成功
			//将用户信息存入session
			ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
			//跳转到首页
			return "loginSuccess";
		}
	}
	/**
	 * 用户退出
	 * @return
	 */
	public String quit(){
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit";
	}
	
	public String checkAuthcode() throws IOException{
		String code1 = ServletActionContext.getRequest().getSession().getAttribute("checkcode").toString();		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		if(!code1.equalsIgnoreCase(checkcode)){
			//验证码错误
			response.getWriter().println("<font color='red'>验证码错误</font>");
		}else{
			//验证码正确
			response.getWriter().println("<font color='green'>验证码正确</font>");
		}
		return NONE;
	}
}
