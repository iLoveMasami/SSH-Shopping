package iLoveMasami.shop.index.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import iLoveMasami.shop.entity.Category;
import iLoveMasami.shop.entity.Product;
import iLoveMasami.shop.service.CategoryService;
import iLoveMasami.shop.service.ProductService;

/**
 * 首页访问的action
 * 
 * @author iLoveMasami
 * @date 2018年1月23日 下午3:50:49
 */
public class IndexAction extends ActionSupport {
	//注入一级分类Service
	private CategoryService categoryService;
	//注入商品Service
	private ProductService productService;
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}


	// 访问首页的方法
	public String execute() {
		List<Category> clist = categoryService.findAll();
		//将一级分类存入到Session的范围
		ActionContext.getContext().getSession().put("cList", clist);
		//查询热门商品
		List<Product> hlist = productService.findHot();
		//将热门商品保存到值栈中
		ActionContext.getContext().getValueStack().set("hList", hlist);
		
		/*
		 * 查询最新商品 
		 */
		List<Product> nlist = productService.findNew();
		ActionContext.getContext().getValueStack().set("nList", nlist);
		return "index";
	}
	
}
