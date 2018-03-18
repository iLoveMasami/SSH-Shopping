package iLoveMasami.shop.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import iLoveMasami.shop.entity.Product;
import iLoveMasami.shop.utils.PageHibernateCallback;

/**
 * 
 * @author iLoveMasami
 * @date   2018年1月26日 下午1:41:54
 */
public class ProductDao extends HibernateDaoSupport{
	/*
	 * 查询首页热门商品
	 */
	public List<Product> findHot() {
		//使用离线条件查询
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		//查询热门的商品，is_hot=1
		criteria.add(Restrictions.eq("is_hot",1));
		//倒序排序输出
		criteria.addOrder(Order.desc("pdate"));
		//执行查询 每页显示10个
		List<Product> list = this.getHibernateTemplate().findByCriteria(criteria, 0, 10);
		if(list!=null&&list.size()>0){
			return list;
		}else{
			return null;
		}		
	}
	/*
	 * 查询首页最热商品 
	 */
	public List<Product> findNew() {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		criteria.addOrder(Order.desc("pdate"));
		List<Product> list= this.getHibernateTemplate().findByCriteria(criteria,0,10);
		if(list!=null&&list.size()>0){
			return list;
		}else{
			return null;
		}	
	}

	/**
	 * 根据商品id查询商品
	 * @param pid:商品id
	 * @return
	 */
	public Product findByPid(Integer pid) {
		
		return this.getHibernateTemplate().get(Product.class, pid);
	}
	/**
	 * 根据分类id查询商品个数
	 * @param cid:一级分类id
	 * @return
	 */
	public int findCountCid(Integer cid) {
		String hql = "select count(*) from Product p where p.categorySecond.category.cid = ?" ;
		List<Long> list = this.getHibernateTemplate().find(hql, cid);
		if(list!=null&&list.size()>0){
			return list.get(0).intValue();
		}else{
			return 0;
		}	
	}
	/**
	 * 根据分类id查询商品集合
	 * @param cid：一级分类id
	 * @param begin：开始的页数
	 * @param limit：每页显示的个数
	 * @return
	 */
	public List<Product> findByPageCid(Integer cid, int begin, int limit) {
		//需要三表联合查询 
		//sql语句：
		//select p.* from category c,categorysecond cs,product p where c.cid = cs.cid and cs.csid = p.csid and c.cid=2
		String hql = "select p from Product p join p.categorySecond cs join cs.category c where c.cid = ?";
		//分页的另一种写法：
		Object[] params = {cid};
		//从HibernateCallback中得到session,因为Spring和Hibernate结合没有分页查询，
		//这种方式session是在spring管理的，一般不会出现session丢失之类的问题
		List<Product> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql,params,begin,limit));
		if(list!=null&&list.size()>0){
			return list;
		}else{
			return null;
		}
	}
	/**
	 * 根据二级分类id查询商品个数
	 * @param csid
	 * @return
	 */
	public int findCountCsid(Integer csid) {
		String hql = "select count(*) from Product p where p.categorySecond.csid = ?";
		List<Long> list = this.getHibernateTemplate().find(hql, csid);
		if(list!=null&&list.size()>0){
			return list.get(0).intValue();
		}else{
			return 0;
		}	
	}
	/**
	 * 根据二级分类id查询商品集合
	 * @param csid
	 * @param begin
	 * @param limit
	 * @return
	 */
	public List<Product> findByPageCsid(Integer csid, int begin, int limit) {
		String hql = "select p from Product p join p.categorySecond cs where cs.csid = ?";
		Object[] params = {csid};
		List<Product> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql,params,begin,limit));
		if(list!=null&&list.size()>0){
			return list;
		}else{
			return null;
		}
	}
	
}
