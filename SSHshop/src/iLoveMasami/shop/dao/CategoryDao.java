package iLoveMasami.shop.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import iLoveMasami.shop.entity.Category;

/***
 * 
 * @author iLoveMasami
 * @date   2018年1月26日 下午12:57:27
 */
public class CategoryDao extends HibernateDaoSupport{
	//查询所有一级分类
	public List<Category> findAll() {
		String hql = "from Category";
		List<Category> list = this.getHibernateTemplate().find(hql);
		if(list!=null && list.size()>0)
		{
			return list;
		}else{
			return null;
		}
	}
	/**
	 * 增加一级分类的方法
	 * @param category
	 */
	public void save(Category category) {
		this.getHibernateTemplate().save(category);
	}

}
