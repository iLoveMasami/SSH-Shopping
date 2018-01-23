package iLoveMasami.shop.index.action;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 首页访问的action
 * @author iLoveMasami
 * @date   2018年1月23日 下午3:50:49
 */
public class IndexAction extends ActionSupport {
	/**
	 * 访问首页的方法
	 */
	public String execute(){
		return "index";
	}
}
