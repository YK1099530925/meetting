<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 我的所有信息 -->
	<jsp:include page="checkinfo.jsp"></jsp:include>
	<!-- 右 -->
	<div class="body-right" id="myunreadmessage">
		<div class="panel panel-info">
			<div class="panel-heading">我的消息</div>
			<div class="panel-body panel-body-my">
				<!-- 接收消息体 -->
				<button class="btn btn-info btn-sm">删除</button>
				<button class="btn btn-info btn-sm">标记为已读</button>
				<table class="table table-hover">
					<tr>
						<td><input type="checkbox" /></td>
						<td><label>发送者</label></td>
						<td>主题</td>
					</tr>
					<tr>
						<td><input type="checkbox" /></td>
						<td><a onclick="entercheckinfo()"><label>杨宽</label></a></td>
						<td><a onclick="entercheckinfo()"><label>开会</label></a></td>
					</tr>
				</table>
			</div>
		</div>
	</div>



</body>
<script type="text/javascript">
	$(function() {
		
	});

	function entercheckinfo(){
		document.getElementById("myunreadmessage").style.zIndex = -1;
		document.getElementById("checkinfoback").style.zIndex = 1;
	}
</script>
</html>