<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<!-- 发布会议 -->
	<div class="body-right">
		<div class="panel panel-info">
			<div class="panel-heading">发布会议</div>
			<div class="panel-body panel-body-my">
				<div class="input-group  col-md-5">
					<span class="input-group-addon">发送者：</span> <input
						id="senduserName" type="text" class="form-control" placeholder="Username"
						value="${sessionScope.userName }" disabled>
				</div>
				<br>
				<div class="input-group  col-md-5">
					<span class="input-group-addon">&nbsp; 主 题：</span> <input
						name="sendtheme" type="text" class="form-control" placeholder="title"
						value="">
				</div>
				<br>
				<div class="input-group col-md-10">
					<label class="sr-only" for="inputHelpBlock"></label>
					<textarea name="textmeetting" class="form-control" rows="10" cols="100"></textarea>
				</div>
				<br>
				<div class="input-group">
					<div class="col-md-2">
						<a id="release" type="submit" class="btn btn-default">发布</a>
					</div>
					<div class="col-md-offset-2 col-md-2">
						<a id="cancelmeetting" type="submit" class="btn btn-default">取消</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(function(){
		
	});

	$("#release").click(function(){
		var sendtheme = document.getElementsByName("sendtheme")[0].value;
		var textmeetting = document.getElementsByName("textmeetting")[0].value;
		websocket.send(data);
	});
</script>
</html>