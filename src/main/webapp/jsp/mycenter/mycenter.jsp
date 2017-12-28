<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人中心</title>
</head>
<body>
	<jsp:include page="../head.jsp"></jsp:include>

	<div class="body row">
		<!-- 左 -->
		<div class="body-left">
			<ul class="nav nav-pills nav-stacked nav-tabs">
				<li class="active"><a class="text-muted" href="#myinfo"
					data-toggle="tab"><span class="glyphicon glyphicon-user"></span>&nbsp;个人信息</a></li>
				<li><a class="text-muted" href="#mymessege" data-toggle="tab"><span
						class="glyphicon glyphicon-comment"></span>&nbsp;我的消息</a></li>
				<li><a class="text-muted" href="#mymeetting" data-toggle="tab"><span
						class="glyphicon glyphicon-list-alt"></span>&nbsp;我的会议</a></li>
				<li><a class="text-muted" href="#askmeetting" data-toggle="tab"><span
						class="glyphicon glyphicon-pencil"></span>&nbsp;申请会议</a></li>
			</ul>
		</div>

		<!-- 右 -->
		<div class="tab-content">
			<div class="tab-pane fade in active" id="myinfo">
				<jsp:include page="myinfo.jsp"></jsp:include>
			</div>
			<div class="tab-pane fade" id="mymessege">
				<jsp:include page="mymessege.jsp"></jsp:include>
			</div>
			<div class="tab-pane fade" id="mymeetting">
				<jsp:include page="mymeetting.jsp"></jsp:include>
			</div>
			<div class="tab-pane fade" id="askmeetting">
				<jsp:include page="askmeetting.jsp"></jsp:include>
			</div>
		</div>

	</div>

</body>
<script type="text/javascript">
	$(function() {
		$("#myinfo").click(function() {

		});
	});
</script>
</html>