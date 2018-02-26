package iLoveMasami.back.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import iLoveMasami.back.entity.AdminUser;

/**
 * 后台权限校验拦截器：拦截没有登录的用户
 * @author iLoveMasami
 * @date   2018年2月8日 下午7:13:08
 */
public class PrivilegeInterceptor extends MethodFilterInterceptor{
	/**
	 * 执行拦截的方法
	 */
	@Override
	protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
		//判断session中是否保存了后台用户的信息
		AdminUser adminUser= (AdminUser) ServletActionContext.getRequest().getSession().getAttribute("existAdminUser");
		if(adminUser == null){
			//没有登录
			ActionSupport actionSupport = (ActionSupport) actionInvocation.getAction();
			actionSupport.addActionError("请先登录！！！");
			return "loginFail";
		}else{
			return actionInvocation.invoke();
		}
	}

}
