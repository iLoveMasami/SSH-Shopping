package iLoveMasami.shop.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 二级分类实体类
 * @author iLoveMasami
 * @date   2018年1月29日 下午4:01:53
 */
public class CategorySecond {
	private Integer csid;
	private String csname;
	//存一级分类对象
	private Category category;
	//配置商品的集合
	private Set<Product> products = new HashSet<>();
	public Integer getCsid() {
		return csid;
	}
	public void setCsid(Integer csid) {
		this.csid = csid;
	}
	public String getCsname() {
		return csname;
	}
	public void setCsname(String csname) {
		this.csname = csname;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	
}
