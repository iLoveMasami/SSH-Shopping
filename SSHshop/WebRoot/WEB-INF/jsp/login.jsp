<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- saved from url=(0080)http://localhost:8080/mango/login.jhtml?redirectUrl=%2Fmango%2Fcart%2Flist.jhtml -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>会员登录</title>

<link href="${pageContext.request.contextPath}/resources/css/common.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet" type="text/css"/>


</head>
<body>

<div class="container header">
<%@ include file="common/logo.jsp" %>	
	<div class="span9">
<div class="headerAd">
					<img src="${pageContext.request.contextPath}/resources/image/header.jpg" width="320" height="50" alt="正品保障" title="正品保障">
</div>	
</div>
	<%@include file="common/head.jsp" %>
</div>	
<div class="container login">
		<div class="span12">
<div class="ad">
					<img src="${pageContext.request.contextPath}/resources/image/login.jpg" width="500" height="330" alt="会员登录" title="会员登录">
</div>		</div>
		<div class="span12 last">
			<div class="wrap">
				<div class="main">
					<div class="title">
						<strong>会员登录</strong>USER LOGIN 
					</div>
					<form id="loginForm" action="${pageContext.request.contextPath}/user_login.action" method="post" novalidate="novalidate" onsubmit="return checkForm();">
						<table>
							<tbody><tr>
								<th>
										用户名/E-mail:
								</th>
								<td>
									<input type="text" id="username" name="username" class="text" maxlength="20">								
								</td>
							</tr>
							<tr>
								<th>
									密&nbsp;&nbsp;码:
								</th>
								<td>
									<input type="password" id="password" name="password" class="text" maxlength="20" autocomplete="off">
								</td>
							</tr>
								<tr>
									<th>
										验证码:
									</th>
									<td>
										<span class="fieldSet">
											<input type="text" id="checkcode" name="checkcode" class="text captcha" maxlength="4" autocomplete="off">
											<img id="checkcodeImg" class="captchaImage" src="${pageContext.request.contextPath}/checkImg.action" title="点击更换验证码" onclick="changeImg()">
										</span>
										<strong><span><s:actionerror/></span></strong>
									</td>
								</tr>
							<tr>
								<th>&nbsp;
									
								</th>
								<td>
									<label>
										<input type="checkbox" id="isRememberUsername" name="isRememberUsername" value="true">记住用户名
									</label>
									<label>
										&nbsp;&nbsp;<a >找回密码</a>
									</label>
								</td>
							</tr>
							<tr>
								<th>&nbsp;
									
								</th>
								<td>
									<input type="submit" class="submit" value="登 录">
									
								</td>
							</tr>
							<tr class="register">
								<th>&nbsp;
									
								</th>
								<td>
									<dl>
										<dt>还没有注册账号？</dt>
										<dd>
											立即注册即可体验在线购物！
											<a href="${pageContext.request.contextPath}/user_registPage.action">立即注册</a>
										</dd>
									</dl>
								</td>
							</tr>
						</tbody></table>
					</form>
				</div>
			</div>
		</div>
	</div>
<div class="container footer">
	<div class="span24">
	  <div class="footerAd"><img src="${pageContext.request.contextPath}/resources/image/footer.jpg" width="950" height="52" alt="我们的优势" title="我们的优势" /></div>	
	</div>
	<div class="span24">
		<ul class="bottomNav">
					<li>
						<a >关于我们</a>
						|
					</li>
					<li>
						<a>联系我们</a>
						|
					</li>
					<li>
						<a>招贤纳士</a>
						|
					</li>
					<li>
						<a>法律声明</a>
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
						<a  target="_blank">配送方式</a>
						|
					</li>
					<li>
						<a>服务声明</a>
						|
					</li>
					<li>
						<a>广告声明</a>
						
					</li>
		</ul>
	</div>
	<div class="span24">
		<div class="copyright">Copyright © 2005-2018 网上商城 版权所有</div>
	</div>
</div>
<script type="text/javascript">
function checkForm(){
	var username = document.getElementById("username").value;
	if(username == null ||username ==''){
		alert("用户名不能为空！");
		return false;//表单就不提交了
	}
	var password = document.getElementById("password").value;
	if(password == null ||password ==''){
		alert("密码不能为空！");
		return false;//表单就不提交了
	}
}
function changeImg(){
	var img = document.getElementById("checkcodeImg");
	img.src = "${pageContext.request.contextPath}/checkImg.action?"+new Date().getTime();
}

</script>
</body>
</html>