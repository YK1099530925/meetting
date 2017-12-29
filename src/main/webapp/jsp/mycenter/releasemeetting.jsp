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
					<span class="input-group-addon" id="senduserName">发送者：</span> <input
						type="text" class="form-control" placeholder="Username"
						aria-describedby="senduserName" value="">
				</div>
				<br>
				<div class="input-group  col-md-5">
					<span class="input-group-addon" id="sendtheme">&nbsp; 主 题：</span> <input
						type="text" class="form-control" placeholder="title"
						aria-describedby="senduserName" value="">
				</div>
				<br>
				<div class="input-group col-md-10">
					<label class="sr-only" for="inputHelpBlock"></label>
					<textarea class="form-control" rows="10" cols="100"></textarea>
				</div>
				<br>
				<div class="input-group">
					<div class="col-md-2">
						<a id="release" type="submit" class="btn btn-default">发布</a>
					</div>
					<div class="col-md-offset-2 col-md-2">
						<a id="cancel" type="submit" class="btn btn-default">取消</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(function(){
		$("#release").click(function(){
			
		});
	});
</script>
</html>