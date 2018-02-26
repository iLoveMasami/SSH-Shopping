<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

<title>订单页面</title>
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
					<li  >生成订单成功</li>
				</ul>
			</div>
	
		
				<table>
					<tbody>
					<tr>
						<th colspan="5">订单编号：<s:property value="model.oid"/></th>
					</tr>
					<tr>
						<th>图片</th>
						<th>商品</th>
						<th>价格</th>
						<th>数量</th>
						<th>小计</th>
						
					</tr>
					<s:iterator value="model.orderItems" var="orderItems">
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
				</tbody>
			</table>
				<dl id="giftItems" class="hidden" style="display: none;">
				</dl>
				<div class="total">
					<em id="promotion"></em>
					商品金额: <strong id="effectivePrice">￥<s:property value="model.total"/></strong>
				</div>
			<form id="orderForm" action="./order_payOrder.action" method="post">
				<input type="hidden" name="order.oid" value=""/>
				<div class="span24">
					<p>
							收货地址：<input name="order.user.addr" type="text" value="<s:property value="model.user.address"/>" style="width:350px" />
								<br />
							收货人&nbsp;&nbsp;&nbsp;：<input name="order.user.username" type="text" value="<s:property value="model.user.name"/>" style="width:150px" />
								<br /> 
							联系方式：<input name="order.user.phone" type="text"value="<s:property value="model.user.phone"/>" style="width:150px" />

						</p>
						<hr />
						<p>
							选择银行：<br/>
							<input type="radio" name="pd_FrpId" value="ICBC-NET-B2C" checked="checked"/>工商银行
							<img src="${pageContext.request.contextPath}/resources/bank_img/icbc.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="pd_FrpId" value="BOC-NET-B2C"/>中国银行
							<img src="${pageContext.request.contextPath}/resources/bank_img/bc.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="pd_FrpId" value="ABC-NET-B2C"/>农业银行
							<img src="${pageContext.request.contextPath}/resources/bank_img/abc.bmp" align="middle"/>
							<br/>
							<input type="radio" name="pd_FrpId" value="BOCO-NET-B2C"/>交通银行
							<img src="${pageContext.request.contextPath}/resources/bank_img/bcc.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="pd_FrpId" value="PINGANBANK-NET"/>平安银行
							<img src="${pageContext.request.contextPath}/resources/bank_img/pingan.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="pd_FrpId" value="CCB-NET-B2C"/>建设银行
							<img src="${pageContext.request.contextPath}/resources/bank_img/ccb.bmp" align="middle"/>
							<br/>
							<input type="radio" name="pd_FrpId" value="CEB-NET-B2C"/>光大银行
							<img src="${pageContext.request.contextPath}/resources/bank_img/guangda.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="pd_FrpId" value="CMBCHINA-NET-B2C"/>招商银行
							<img src="${pageContext.request.contextPath}/resources/bank_img/cmb.bmp" align="middle"/>
						</p>
						<hr />
						<p style="text-align:right">
							<a href="javascript:document.getElementById('orderForm').submit();">
								<img src="${pageContext.request.contextPath}/resources/images/finalbutton.gif" width="204" height="51" border="0" />
							</a>
						</p>
				</div>
			</form>
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