package iLoveMasami.shop.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import iLoveMasami.shop.entity.Product;
import iLoveMasami.shop.service.CategoryService;
import iLoveMasami.shop.service.ProductService;
import iLoveMasami.shop.utils.PageBean;

/**
 * 商品Action
 * @author iLoveMasami
 * @date   2018年1月26日 下午2:17:40
 */
public class ProductAction extends ActionSupport implements ModelDriven<Product>{
	//用于接收数据的模型驱动
	private Product product = new Product();
	@Override
	public Product getModel() {
		
		return product;
	}
	
	//注入Service
	private ProductService productService;	
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	//接收分类的cid
	private Integer cid;
	//从页面获得
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	//将cid提交给页面
	public Integer getCid() {
		return cid;
	}
	
	//接收当前页数
	private int page;
	public void setPage(int page) {
		this.page = page;
	}
	//接收二级分类的id
	private Integer csid;
	public Integer getCsid() {
		return csid;
	}
	public void setCsid(Integer csid) {
		this.csid = csid;
	}

	//注入一级分类的Service
	private CategoryService categoryService;
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	//根据商品id查询商品
	public String findByPid()
	{
		product = productService.findByPid(product.getPid());
		return "findByPid";
	}
	//根据分类的id查询商品
	public String findByCid()
	{
//		List<Category> clist = categoryService.findAll();----调用一级分类的service
		//这里直接读取session中保存的信息--->通过一级分类查询到二级分类
		//根据一级分类查询商品，带分页的查询
		PageBean<Product> pageBean = productService.findByCid(cid,page);
		//将pageBean存入值栈中
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByCid";
	}
	/**
	 * 根据二级分类id查询商品
	 * @return
	 */
	public String findByCsid()
	{
		PageBean<Product> pageBean = productService.findByPageCsid(csid,page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByCsid";
	}
}
