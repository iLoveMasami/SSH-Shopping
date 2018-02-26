package iLoveMasami.back.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import iLoveMasami.back.entity.AdminUser;
import iLoveMasami.back.service.AdminUserService;
/**
 * 
 * @author iLoveMasami
 * @date   2018年2月5日 下午9:13:31
 */
public class AdminUserAction extends ActionSupport implements ModelDriven<AdminUser>{
	private AdminUser adminUser = new AdminUser();
	private AdminUserService adminUserService;
	
	public void setAdminUserService(AdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}

	@Override
	public AdminUser getModel() {
		
		return adminUser;
	}
	
	public String login()
	{
		
		AdminUser existAdminUser = adminUserService.login(adminUser);
		if(existAdminUser == null)
		{
			this.addActionError("用户名或者密码错误！");
			return "loginFail";
		}else{
			ServletActionContext.getRequest().getSession().setAttribute("existAdminUser", existAdminUser);
			return "loginSuccess";
		}		
	}
}
