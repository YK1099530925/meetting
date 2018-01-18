<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
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
	<div class="head row" style="background-color: #bce8f1; opacity: 0.9;">

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
			<a class="text-muted" href="#home" data-toggle="tab">
				<h4>首页</h4>
			</a>
		</div>
		<!-- shiro的标签，如果有此权限则可以显示 -->
		<shiro:hasPermission name="user">
			<div class="head-last-margin col-md-1">
				<a class="text-muted" href="#" data-toggle="tab">
					<h4>其他</h4>
				</a>
			</div>
		</shiro:hasPermission>
		<div class="head-last-margin col-md-1">
			<a class="text-muted" href="#" data-toggle="tab">
				<h4>其他</h4>
			</a>
		</div>
		<div class="head-last-margin col-md-2">
			<a class="text-muted" href="#mycenter" data-toggle="tab">
				<h4>个人中心</h4>
			</a>
		</div>

		<!-- 用户 -->
		<div class="head-last-margin col-md-1">
			<c:if test="${sessionScope.userName != null }">
				<a href="#mycenter" data-toggle="tab"> <label>${sessionScope.userName }</label>
				</a>
			</c:if>
			<c:if test="${sessionScope.userName == null }">
				<a href="index.jsp"><label>登录</label></a>
			</c:if>
		</div>
	</div>
	<!-- body -->
	<div class="tab-content">

		<div class="tab-pane fade" id="home">
			<jsp:include page="body.jsp"></jsp:include>
		</div>

		<!-- 个人中心 -->
		<div class="tab-pane fade in active" id="mycenter">
			<jsp:include page="mycenter/mycenter.jsp"></jsp:include>
		</div>
	</div>
</body>
<script type="text/javascript">

	$(window).load(function(){
		var flagCount = ${requestScope.flagCount};
		if(flagCount > 0){
			alert("你有"+flagCount+"条新消息");
		}
		//出现问题：只有manager权限的登录才有${requestScope.askMeettingCount}
		/* var askMeettingCount = ${requestScope.askMeettingCount};
		if(askMeettingCount > 0){
			alert("你有"+askMeettingCount+"条新申请的消息");
		} */
	});

	/* 使用shiro的时候，使用192.168.0.118会出现连接问题，但是写localhost不会出现 */
	var webServer = "ws://localhost:8080/metting/websocket/${sessionScope.loginId}";//服务器地址
	var websocket = new WebSocket(webServer);//创建websocket对象;

	//建立连接的回调方法
	websocket.onopen = function(e) {
		//alert("建立了websocket连接");
	};
	//关闭连接的回调方法
	websocket.onclose = function(e) {
		alert("客户端关闭了连接");
		//alert("关闭了websocket连接");

	};
	//收到服务器信息，用e.data获取
	websocket.onmessage = function(e) {
		alert("服务器推送消息：" + e.data);
	};
	//产生异常
	websocket.onerror = function(e) {
	};

	//监听离开页面，当离开页面的时候
	/* 	window.onbeforeunload = function() {
			closeWebsocket();
		} */

	//关闭websocket连接
	/* 	function closeWebsocket() {
			websocket.close();
			alert("客户端连接关闭");
		} */
</script>
</html>