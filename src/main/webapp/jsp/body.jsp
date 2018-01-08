<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	
	<!-- 中 -->
	<div class="body row bg-info">
		<!-- 左 -->
		<div class="body-left">
			<ul class="nav nav-pills nav-stacked">
				<li><a class="text-muted" href="#"><span
						class="glyphicon glyphicon-inbox"></span>&nbsp;会议室</a></li>
				<li><a class="text-muted" href="#"><span
						class="glyphicon glyphicon-list-alt"></span>&nbsp;资料室</a></li>
				<li><a class="text-muted" href="#"><span
						class="glyphicon glyphicon-user"></span>&nbsp;员工管理</a></li>
			</ul>
		</div>

		<!-- 右 -->
		<jsp:include page="meet.jsp"></jsp:include>

	</div>
</body>
</html>