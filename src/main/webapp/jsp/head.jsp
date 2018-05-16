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
<%-- <script type="text/javascript" src="${appPath }/js/jquery-1.12.4.min.js"></script> --%>

<link href="${appPath }/js/editormd/css/editormd.min.css" rel="stylesheet">
<script type="text/javascript" src="${appPath }/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="${appPath }/js/editormd/editormd.min.js"></script>

<link href="${appPath }/js/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="${appPath }/js/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script src="${appPath }/js/dateFormat.js"></script>
<script src="${appPath }/js/myJs.js"></script>
<script src="${appPath }/js/news.js"></script>
<script src="${appPath }/js/usermanage.js"></script>
<script src="${appPath }/js/deptmanage.js"></script>
<script src="${appPath }/js/askMeettingInfo.js"></script>
<link href="${appPath }/css/home.css" rel="stylesheet">
<title>会议管理系统</title>
</head>
<body>
	<!-- 头 -->
	<div class="head row" style="background-color: #2c2c2c; opacity: 0.9;">

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
		<!-- <div class="head-last-margin col-md-1">
			<a class="text-muted" href="#home" data-toggle="tab">
				<h4>系统首页</h4>
			</a>
		</div> -->
		<!-- shiro的标签，如果有此权限则可以显示 -->
		<shiro:hasPermission name="user">
			<div class="head-last-margin col-md-1">
				<a class="text-muted" href="#companymanage" data-toggle="tab">
					<h4>公司管理</h4>
				</a>
			</div>
 			<div class="head-last-margin col-md-1">
				<a class="text-muted" href="#releaseNews" data-toggle="tab">
					<h4>发布新闻</h4>
				</a>
			</div> 
		</shiro:hasPermission>
		<div class="head-last-margin col-md-1">
			<a class="text-muted" href="#newscenter"  data-toggle="tab">
				<h4>新闻中心</h4>
			</a>
		</div>
		<div class="head-last-margin col-md-2">
			<a class="text-muted" href="#mycenter" data-toggle="tab">
				<h4>个人中心</h4>
			</a>
		</div>

		<div class="col-md-1" style="margin-top: 15px;">
			<c:if test="${sessionScope.userName != null }">
				<a href="#mycenter" data-toggle="tab"> <label>${sessionScope.userName }</label>
				</a>
				<a  href="index.jsp">&nbsp;注销</a>
			</c:if>
			<c:if test="${sessionScope.userName == null }">
				<a href="index.jsp"><label>登录</label></a>
			</c:if>
		</div>
		
	</div>
	<!-- body -->
	<div class="tab-content">

		<!-- 首页 -->
		<%-- <div class="tab-pane fade" id="home">
			<jsp:include page="body.jsp"></jsp:include>
		</div> --%>
		
		<!-- 员工管理 -->
		<div class="tab-pane fade" id="companymanage">
			<jsp:include page="companymanage/companymanage.jsp"></jsp:include>
		</div>
		
		<!-- 发布新闻 -->
		<div class="tab-pane fade" id="releaseNews">
			<jsp:include page="newscenter/editor.jsp"></jsp:include>
		</div>
		
		<!-- 新闻管理 -->
		<div class="tab-pane fade in active" id="newscenter">
			<jsp:include page="newscenter/newscenter.jsp"></jsp:include>
		</div>

		<!-- 个人中心 -->
		<div class="tab-pane fade" id="mycenter">
			<jsp:include page="mycenter/mycenter.jsp"></jsp:include>
		</div>
	</div>
</body>
<script type="text/javascript">

	//在页面加载完成之后，执行该操作
	$(window).load(function(){
		//flagCount：所有用户（包括经理）未被通知的会议消息条数
		var flagCount = ${requestScope.flagCount};
		if(flagCount > 0){
			alert("你有"+flagCount+"条会议信息");
		}

		//员工申请会议给经理的提示消息
		var askMeettingCount = ${requestScope.askMeettingCount};
		if(askMeettingCount > 0){
			alert("有"+askMeettingCount+"条新申请的会议");
		}

		//员工申请的会议被处理的结果提示消息
		var result = "";
		var meettingResult = "${requestScope.meettingResult}";
		if(meettingResult.length != 0){
			var results = meettingResult.split("-");
			for(var i = 0; i < results.length; i++){
				result += results[i] + "\n";
			}
			alert(result);
		}
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
		alert("消息：" + e.data);
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