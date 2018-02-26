package iLoveMasami.shop.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 订单表
 * @author iLoveMasami
 * @date   2018年2月1日 下午6:58:43
 */
public class Order {
	private Integer oid;
	private Double total;
	private Date ordertime;
	private Integer state;
	private String name;
	private String phone;
	private String addr;
	//订单所属用户id
	private User user;
	//订单中所属的多个订单项
	private Set<OrderItem> orderItems = new HashSet<OrderItem>();
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Date getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
}
