<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

<title>我的订单页面</title>
<link href="${pageContext.request.contextPath}/resources/css/common.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/resources/css/cart.css" rel="stylesheet" type="text/css"/>

</head>
<body>

<div class="container header">
	<%@ include file="common/logo.jsp" %>
	<div class="span9">
<div class="headerAd">
	<img src="${pageContext.request.contextPath}/resources/image/header.jpg" width="320" height="50" alt="正品保障" title="正品保障"/>
</div>	
</div>
<%@include file="common/head.jsp" %>
		
</div>	

<div class="container cart">

		<div class="span24">
		
			<div class="step step1">
				<ul>
					
					<li  class="current"></li>
					<li  >我的订单</li>
				</ul>
			</div>
	
		
				<table>
					<tbody>
					<s:iterator value="pageBean.list" var="order">
					<tr>
						<th colspan="5">订单编号：<s:property value="#order.oid"/>&nbsp;&nbsp;&nbsp;&nbsp;
							订单状态：
							<s:if test="#order.state == 1"><a href="${pageContext.request.contextPath}/order_findByOid.action?oid=<s:property value="#order.oid"/>"><font color="red">未付款</font></a></s:if>
							<s:if test="#order.state == 2">已付款</s:if>
							<s:if test="#order.state == 3"><a href="#">确认收货</a></s:if>
							<s:if test="#order.state == 4">交易完成</s:if>
							
						</th>
					</tr>
					<s:iterator value="#order.orderItems" var="orderItems">
					<tr>
						<th>图片</th>
						<th>商品</th>
						<th>价格</th>
						<th>数量</th>
						<th>小计</th>
						
					</tr>
						<tr>
							<td width="60">
								<input type="hidden" name="id" value="22"/>
								<img src="${pageContext.request.contextPath}/resources/image/<s:property value="#orderItems.product.image"/>"/>
							</td>
							<td>
								<a target="_blank"><s:property value="#orderItems.product.pname"/></a>
							</td>
							<td>
								<s:property value="#orderItems.product.shop_price"/>
							</td>
							<td class="quantity" width="60">
								<s:property value="#orderItems.count"/>
							</td>
							<td width="140">
								<span class="subtotal">￥<s:property value="#orderItems.subtotal"/></span>
							</td>
						</tr>
						</s:iterator>
					</s:iterator>
				</tbody>
			</table>
						
		</div>
	</div>
<div class="container footer">
	<div class="span24">
		<div class="footerAd">
					<img src="${pageContext.request.contextPath}/resources/image\r___________renleipic_01/footer.jpg" alt="我们的优势" title="我们的优势" height="52" width="950">
</div>
</div>
	<div class="span24">
		<ul class="bottomNav">
					<li>
						<a href="#">关于我们</a>
						|
					</li>
					<li>
						<a href="#">联系我们</a>
						|
					</li>
					<li>
						<a href="#">诚聘英才</a>
						|
					</li>
					<li>
						<a href="#">法律声明</a>
						|
					</li>
					<li>
						<a>友情链接</a>
						|
					</li>
					<li>
						<a target="_blank">支付方式</a>
						|
					</li>
					<li>
						<a target="_blank">配送方式</a>
						|
					</li>
					<li>
						<a >SHOP++官网</a>
						|
					</li>
					<li>
						<a>SHOP++论坛</a>
						
					</li>
		</ul>
	</div>
	<div class="span24">
		<div class="copyright">Copyright © 2005-2018 网上商城 版权所有</div>
	</div>
</div>
</body>
</html>