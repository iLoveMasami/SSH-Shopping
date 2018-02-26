package iLoveMasami.shop.order.action;
/**
 * 订单管理的Action
 * @author iLoveMasami
 * @date   2018年2月1日 下午6:58:01
 */

import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import iLoveMasami.shop.entity.Order;
import iLoveMasami.shop.entity.OrderItem;
import iLoveMasami.shop.entity.User;
import iLoveMasami.shop.order.service.OrderService;
import iLoveMasami.shop.utils.PageBean;
import iLoveMasami.shop.vo.Cart;
import iLoveMasami.shop.vo.CartItem;

public class OrderAction extends ActionSupport implements ModelDriven<Order>{
	//模型驱动对象
	private Order order = new Order();
	@Override
	public Order getModel() {
		
		return order;
	}
	//注入OrderService
	private OrderService orderService;
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	//接收page参数
	private Integer page;
	
	public void setPage(Integer page) {
		this.page = page;
	}
	/**
	 * 生成订单
	 * @return
	 */
	public String save()
	{
		//保存数据到数据库
		//订单属性不全
		order.setOrdertime(new Date());
		order.setState(1);//1是未付款，2是已经付款但是未发货，3是已经发货但是没有确认收货，4是交易完成
		//设置金额总计，总计数据是购物车中信息，购物车信息存储到了session中
		Cart cart = (Cart) ServletActionContext.getRequest().getSession().getAttribute("cart");
		if(cart == null)
		{
			this.addActionError("亲！请先购物哦！");
			return "msg";
		}
		order.setTotal(cart.getTotal());
		//设置订单中的订单项
		for(CartItem cartItem : cart.getCartItems())
		{
			OrderItem orderItem = new OrderItem();
			orderItem.setCount(cartItem.getCount());
			orderItem.setProduct(cartItem.getProduct());
			orderItem.setSubtotal(cartItem.getSubtotal());
			order.getOrderItems().add(orderItem);
		}
		//设置订单所属的用户
		User existUser = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		if(existUser == null){
			//添加错误信息
			this.addActionError("亲！请先登录哦！");
			return "login";
		}
		order.setUser(existUser);
		orderService.save(order);
		//将订单对象显示到页面上:
		//通过值栈的方式显示：因为模型驱动使用的是Order
		return "saveSuccess";
	}
	/**
	 * 我的订单的查询
	 * @return
	 */
	public String findByUid()
	{
		User user = (User) ServletActionContext.getRequest().getSession().
				getAttribute("existUser");
		//调用service
		PageBean<Order> pageBean = orderService.findByPageUid(user.getUid(),page);
		
		return NONE;
	}
}
