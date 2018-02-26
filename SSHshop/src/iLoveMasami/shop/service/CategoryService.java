package iLoveMasami.shop.service;

import java.util.List;

import iLoveMasami.shop.dao.CategoryDao;
import iLoveMasami.shop.entity.Category;

/**
 * 
 * @author iLoveMasami
 * @date   2018年1月26日 下午12:57:49
 */
public class CategoryService {
	private CategoryDao categoryDao;

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	//查询所有一级分类
	public List<Category> findAll() {		
		return categoryDao.findAll();
	}
	/**
	 * 保存一级分类
	 * @param category
	 */
	public void save(Category category) {
		categoryDao.save(category);
	}
	
}
