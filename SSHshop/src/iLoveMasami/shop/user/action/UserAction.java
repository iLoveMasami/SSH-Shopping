package iLoveMasami.shop.user.action;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 用户模块Action类
 * @author iLoveMasami
 * @date   2018年1月23日 下午4:40:10
 */
public class UserAction extends ActionSupport{
	//跳转到用户注册页面的执行方法
	public String registPage()
	{
		return "registPage";
	}
}
