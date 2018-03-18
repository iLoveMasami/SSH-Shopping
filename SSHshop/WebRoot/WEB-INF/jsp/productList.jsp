<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- saved from url=(0048)http://localhost:8080/mango/product/list/1.jhtml -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>网上商城</title>
<link href="${pageContext.request.contextPath}/resources/css/common.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/resources/css/product.css" rel="stylesheet" type="text/css"/>

</head>
<body>
<div class="container header">
<%@ include file="common/logo.jsp" %>	
	<div class="span9">
<div class="headerAd">
					<img src="${pageContext.request.contextPath}/resources/image/header.jpg" width="320" height="50" alt="正品保障" title="正品保障">
</div>	</div>
	
<%@ include file="common/head.jsp" %>
	
</div>	
<div class="container productList">
		<div class="span6">
			<div class="hotProductCategory">
						<s:iterator value="#session.cList" var="c">
						<!-- <dl>定义列表 -->
						<dl>
							<dt>
								<a href="${pageContext.request.contextPath}/product_findByCid.action?cid=<s:property value="#c.cid"/>&page=1"><s:property value="#c.cname"/></a>
							</dt>
							<!-- 显示二级分类 -->
								<s:iterator value="#c.categorySeconds" var="cs">
									<dd>
										<a href="${pageContext.request.contextPath}/product_findByCsid.action?csid=<s:property value="#cs.csid"/>&page=1"><s:property value="#cs.csname"/></a>
									</dd>
									</s:iterator>
						</dl>
						</s:iterator>											
			</div>
		</div>
		<div class="span18 last">
			
			<form id="productForm" action="${pageContext.request.contextPath}/resources/image/蔬菜 - Powered By Mango Team.htm" method="get">
				<input type="hidden" id="brandId" name="brandId" value="">
				<input type="hidden" id="promotionId" name="promotionId" value="">
				<input type="hidden" id="orderType" name="orderType" value="">
				<input type="hidden" id="pageNumber" name="pageNumber" value="1">
				<input type="hidden" id="pageSize" name="pageSize" value="20">
					
				<div id="result" class="result table clearfix">
						<ul>
						<s:iterator value="pageBean.list" var="p">
						<li>
								<a href="${pageContext.request.contextPath}/product_findByPid.action?pid=<s:property value="#p.pid"/>">
									<img src="${pageContext.request.contextPath}/resources/image/<s:property value="#p.image"/>" width="170" height="170"  style="display: inline-block;">
											   
									<span style='color:green'>
									 <s:property value="#p.pname"/>
									</span>
											 
									<span class="price">
									商城价： ￥<s:property value="#p.shop_price"/>/份
									</span>
											 
									</a>
						</li>
						</s:iterator>	
						</ul>
				</div>
	<div class="pagination">
	<span>第<s:property value="pageBean.page"/>/<s:property value="pageBean.totalPage"/>页</span>
	<s:if test="cid != null">
			<s:if test="pageBean.page!=1">
			<a href="${pageContext.request.contextPath}/product_findByCid.action?cid=<s:property value="cid"/>&page=1" class="firstPage">&nbsp;</a>
			<a href="${pageContext.request.contextPath}/product_findByCid.action?cid=<s:property value="cid"/>&page=<s:property value="pageBean.page-1"/>" class="previousPage">&nbsp;</a>
			<!-- 分页算法，固定为5页 -->
			</s:if>
				<s:if test="pageBean.totalPage<=5">
					<s:set name="begin" value="1"/>
					<s:set name="end" value="pageBean.totalPage"/>
			</s:if>
			<s:else>
				<s:if test="pageBean.page<3">
					<s:set name="begin" value="1"/>
					<s:set name="end" value="5"/>
				</s:if>
				<s:elseif test="pageBean.page>pageBean.totalPage-2">
					<s:set name="begin" value="pageBean.totalPage-4"/>
					<s:set name="end" value="pageBean.totalPage"/>
				</s:elseif>
				<s:else>
					<s:set name="begin" value="pageBean.page-2"/>
					<s:set name="end" value="pageBean.page+2"/>
				</s:else>
			</s:else>
			<!-- 迭代生成页数 -->
			<s:iterator begin="#begin" end="#end" var="i">
				<s:if test="pageBean.page != #i">
				<a href="${pageContext.request.contextPath}/product_findByCid.action?cid=<s:property value="cid"/>&page=<s:property value="#i"/>"><s:property value="#i"/></a>
				</s:if>
				<s:else>
				<span class="currentPage"><s:property value="#i"/></span>
				</s:else>
			</s:iterator>
			<s:if test="pageBean.page!=pageBean.totalPage">
			<a class="nextPage" href="${pageContext.request.contextPath}/product_findByCid.action?cid=<s:property value="cid"/>&page=<s:property value="pageBean.page+1"/>">&nbsp;</a>			
			<a class="lastPage" href="${pageContext.request.contextPath}/product_findByCid.action?cid=<s:property value="cid"/>&page=<s:property value="pageBean.totalPage"/>">&nbsp;</a>
			</s:if>
	</s:if>
	<s:if test="csid != null">
		<s:if test="pageBean.page!=1">
			<a href="${pageContext.request.contextPath}/product_findByCsid.action?cid=<s:property value="csid"/>&page=1" class="firstPage">&nbsp;</a>
			<a href="${pageContext.request.contextPath}/product_findByCsid.action?cid=<s:property value="csid"/>&page=<s:property value="pageBean.page-1"/>" class="previousPage">&nbsp;</a>
			<!-- 分页算法，固定为5页 -->
			<!-- 
				1.如果总页数小于5页，则开始页为1，结束页为总页数
				2.否则的话
					2.1 如果当前页是1~3，则显示1~5页
					2.2如果当前页是最后的三页，则显示总页数~（总页数-4）
					2.3除此以外，显示（当前页数-2）~（当前页数+2）
			 -->
			</s:if>
				<s:if test="pageBean.totalPage<=5">
					<s:set name="begin" value="1"/>
					<s:set name="end" value="pageBean.totalPage"/>
			</s:if>
			<s:else>
				<s:if test="pageBean.page<3">
					<s:set name="begin" value="1"/>
					<s:set name="end" value="5"/>
				</s:if>
				<s:elseif test="pageBean.page>pageBean.totalPage-2">
					<s:set name="begin" value="pageBean.totalPage-4"/>
					<s:set name="end" value="pageBean.totalPage"/>
				</s:elseif>
				<s:else>
					<s:set name="begin" value="pageBean.page-2"/>
					<s:set name="end" value="pageBean.page+2"/>
				</s:else>
			</s:else>
			<!-- 迭代生成页数 -->
			<s:iterator begin="#begin" end="#end" var="i">
				<s:if test="pageBean.page != #i">
				<a href="${pageContext.request.contextPath}/product_findByCsid.action?cid=<s:property value="csid"/>&page=<s:property value="#i"/>"><s:property value="#i"/></a>
				</s:if>
				<s:else>
				<span class="currentPage"><s:property value="#i"/></span>
				</s:else>
			</s:iterator>
			<s:if test="pageBean.page!=pageBean.totalPage">
			<a class="nextPage" href="${pageContext.request.contextPath}/product_findByCsid.action?cid=<s:property value="csid"/>&page=<s:property value="pageBean.page+1"/>">&nbsp;</a>			
			<a class="lastPage" href="${pageContext.request.contextPath}/product_findByCsid.action?cid=<s:property value="csid"/>&page=<s:property value="pageBean.totalPage"/>">&nbsp;</a>
			</s:if>
	</s:if>
	</div>
			</form>
		</div>
	</div>
<div class="container footer">
	<div class="span24">
		<div class="footerAd">
					<img src="${pageContext.request.contextPath}/resources/image/footer.jpg" width="950" height="52" alt="我们的优势" title="我们的优势">
</div>	</div>
	<%@ include file="common/foot.jsp" %>
</div>
</body></html>