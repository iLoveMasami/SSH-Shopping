package iLoveMasami.shop.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import iLoveMasami.shop.entity.Product;
import iLoveMasami.shop.service.ProductService;
import iLoveMasami.shop.vo.Cart;
import iLoveMasami.shop.vo.CartItem;

/**
 * 购物车的Action
 * @author iLoveMasami
 * @date   2018年1月31日 下午8:11:00
 */
public class CartAction extends ActionSupport{
	//接收pid
	private Integer pid;
	//接收数量count
	private Integer count;
	
	//注入商品Service
	private ProductService productService;
	
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	/**
	 * 将购物项添加到购物车
	 * @return
	 */
	public String addCart()
	{
		//封装一个CartItem对象
		CartItem cartItem = new CartItem();
		//设置数量
		cartItem.setCount(count);
		//设置商品
		//根据商品id查询商品
		Product p = productService.findByPid(pid);
		cartItem.setProduct(p);
		//将购物项添加到购物车,因为购物车存入Session中，所以我们要从Session中获得购物车，而不是new一个
		Cart cart =getCart();
		cart.addCart(cartItem);
		return "addCart";
	}
	/**
	 * 要从Session中获得购物车
	 * @return 购物车
	 */
	private Cart getCart() {
		Cart cart = (Cart) ServletActionContext.getRequest().getSession().getAttribute("cart");
		if(cart == null)
		{
			cart  = new Cart();
			ServletActionContext.getRequest().getSession().setAttribute("cart", cart);
		}
		return cart;
	}
	/**
	 * 清空购物车
	 * @return
	 */
	public String clearCart()
	{
		Cart cart = getCart();
		cart.clearCart();
		return "clearCart";
	}
	/**
	 * 显示购物车
	 * @return
	 */
	public String showCart()
	{		
		return "showCart";
	}
	/**
	 * 删除购物项
	 * @return
	 */
	public String removeCart()
	{
		Cart cart = getCart();
		cart.removeCart(pid);
		return "removeCart";
	}
}
