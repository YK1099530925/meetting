<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
	pageContext.setAttribute("appPath", request.getContextPath());
%>
<script type="text/javascript" src="${appPath }/js/jquery-1.12.4.min.js"></script>
<link href="${appPath }/js/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="${appPath }/js/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<link href="${appPath }/css/home.css" rel="stylesheet">
<title>首页</title>
</head>
<body>
	<!-- 头 -->
	<div class="container head row bg-my">

		<!-- logo -->
		<div class="col-md-3">
			<img class="head-logo" alt="" src="${appPath }/imgs/logo1.png">
		</div>

		<div class="head-search col-md-3">
			<form action="#">
				<div class="form-group has-feedback">
					<input type="text" class="form-control"
						aria-describedby="inputSuccess2Status"> <span
						class="btn glyphicon glyphicon-search form-control-feedback"
						aria-hidden="true"></span>
				</div>
			</form>
		</div>

		<!-- 首页标签 -->
		<div class="head-last-margin col-md-1">
			<a class="text-muted" href="${appPath }/jsp/homePage.jsp">
				<h4>首页</h4>
			</a>
		</div>
		<div class="head-last-margin col-md-1">
			<a class="text-muted" href="#">
				<h4>其他</h4>
			</a>
		</div>
		<div class="head-last-margin col-md-1">
			<a class="text-muted" href="#">
				<h4>其他</h4>
			</a>
		</div>
		<div class="head-last-margin col-md-2">
			<a class="text-muted" href="${appPath }/jsp/mycenter/mycenter.jsp">
				<h4>个人中心</h4>
			</a>
		</div>

		<!-- 用户 -->
		<div class="head-last-margin col-md-1">
			<c:if test="${sessionScope.userName != null }">
				<a href="${appPath }/jsp/mycenter/mycenter.jsp"> <label
					id="userName">${sessionScope.userName }</label>
				</a>
			</c:if>
			<c:if test="${sessionScope.userName == null }">
				<a href="${appPath }/index.jsp"><label id="userName">登录</label></a>
			</c:if>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(function() {

	});
</script>
</html>