package iLoveMasami.shop.vo;

import iLoveMasami.shop.entity.Product;

/**
 * 购物项对象
 * @author iLoveMasami
 * @date   2018年1月31日 下午7:34:22
 */
public class CartItem {
	private Product product;    //购物项中商品信息
	private int count;		//购买某种商品的数量
	private double subtotal;	//购买某种商品的金额
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	//金额自动计算
	public double getSubtotal() {
		return product.getShop_price() * count;
	}
	
	
}
