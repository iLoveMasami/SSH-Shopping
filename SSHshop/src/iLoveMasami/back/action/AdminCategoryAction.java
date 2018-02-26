package iLoveMasami.back.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import iLoveMasami.shop.entity.Category;
import iLoveMasami.shop.service.CategoryService;
/**
 * 
 * @author iLoveMasami
 * @date   2018年2月6日 下午6:59:10
 */
public class AdminCategoryAction extends ActionSupport implements ModelDriven<Category>{
	private Category category = new Category();
	private CategoryService categoryService;
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	@Override
	public Category getModel() {
		
		return category;
	}
	/**
	 * 展示一级分类列表
	 * @return
	 */
	public String findAll()
	{
		List<Category> cList = categoryService.findAll();
		ActionContext.getContext().getValueStack().set("cList", cList);
		return "findAll";
	}
	/**
	 * 保存一级分类
	 * @return
	 */
	public String save()
	{
		categoryService.save(category);	
		return "saveSuccess";
	}
}
