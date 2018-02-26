package iLoveMasami.shop.service;

import java.util.List;

import iLoveMasami.shop.dao.ProductDao;
import iLoveMasami.shop.entity.Product;
import iLoveMasami.shop.utils.PageBean;

/**
 * 
 * @author iLoveMasami
 * @date   2018年1月26日 下午1:42:16
 */
public class ProductService {
	private ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	//查询首页热门商品
	public List<Product> findHot() {
		
		return productDao.findHot();
	}
	/*
	 *查询首页最热商品 
	 */
	public List<Product> findNew() {
		
		return productDao.findNew();
	}
	/*
	 * 根据商品id查询商品
	 */
	public Product findByPid(Integer pid) {
		
		return productDao.findByPid(pid);
	}

	/**
	 * 根据一级分类的cid查询商品，并且有分页功能
	 * @param cid
	 * @param page:第几页
	 * @return
	 */
	public PageBean<Product> findByCid(Integer cid, int page) {
		PageBean<Product> pageBean = new PageBean<Product>();
		//设置当前页数
		pageBean.setPage(page);
		//设置每页显示的记录数
		int limit = 8;
		pageBean.setLimit(limit);
		//设置总记录数
		int totalCount = productDao.findCountCid(cid);//查询数据库得到总记录数
		pageBean.setTotalCount(totalCount);
		//设置总页数
		int totalPage = 0;
		//可以采用ceil来优化代码
		//totalPage = (int) Math.ceil(totalCount/limit);
		if(totalCount % limit == 0)
		{
			totalPage=totalCount / limit;
		}
		else
		{
			totalPage=totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		//每页显示的集合，查询得出
		//从哪开始
		int begin = (page-1)*limit;
		List<Product> list = productDao.findByPageCid(cid,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	/**
	 * 根据二级分类的cid查询商品，并且有分页功能
	 * @param csid
	 * @param page
	 * @return
	 */
	public PageBean<Product> findByPageCsid(Integer csid, int page) {
		PageBean<Product> pageBean = new PageBean<Product>();
		//设置当前页数
		pageBean.setPage(page);
		//设置每页显示的记录数
		int limit = 8;
		pageBean.setLimit(limit);
		//设置总记录数
		int totalCount = productDao.findCountCsid(csid);//查询数据库得到总记录数
		pageBean.setTotalCount(totalCount);
		//设置总页数
		int totalPage = 0;
		if(totalCount % limit == 0)
		{
			totalPage=totalCount / limit;
		}
		else
		{
			totalPage=totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		//每页显示的集合，查询得出
		//从哪开始
		int begin = (page-1)*limit;
		List<Product> list = productDao.findByPageCsid(csid,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	

}
