package iLoveMasami.shop.vo;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 购物车对象
 * @author iLoveMasami
 * @date   2018年1月31日 下午7:34:02
 */
public class Cart {
	//使用map来保存购物项集合,map的key是商品的id
	private Map<Integer,CartItem> map = new LinkedHashMap<Integer,CartItem>();
	//购物的总计
	private double total;

	public double getTotal() {
		return total;
	}
	/**
	 * 从map中获得商品，转成单列集合
	 * @return
	 */
	public Collection<CartItem> getCartItems()
	{
		return map.values();
	}
	
	//购物车的功能：增加购物项，删除购物项，清空购物车
	/**
	 * 增加购物项
	 * @param cartItem
	 */
	public void addCart(CartItem cartItem){
		Integer pid = cartItem.getProduct().getPid();
		//存在时，数量增加，总计增加
		if(map.containsKey(pid)){
			//原先的数量
			int count = map.get(pid).getCount();
			//现在的数量
			count += cartItem.getCount();
			map.get(pid).setCount(count);			
		}
		//不存在时，增加购物项
		else{
			map.put(pid, cartItem);
		}
		//增加总计
		total += cartItem.getSubtotal();
	}
	/**
	 * 删除购物项
	 * @param pid
	 */
	public void removeCart(Integer pid){
		//移除的时候得到购物项
		CartItem cartItem = map.remove(pid);	
//		CartItem cartItem = map.get(pid);
		total -= cartItem.getSubtotal();
	}
	/**
	 * 清空购物车,将所有购物项清空，将总计设置为0
	 */
	public void clearCart(){
		map.clear();
		total = 0;
	}
	
}
