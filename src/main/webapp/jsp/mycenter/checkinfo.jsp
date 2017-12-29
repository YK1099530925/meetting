<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<!-- 查看信息 -->
	<div class="body-right" id="checkinfoback">
		<div class="panel panel-info">
			<div class="panel-heading">
				<a id="backmymessage"><span class="glyphicon glyphicon-chevron-left"></span>我的消息</a>
			</div>
			<div class="panel-body panel-body-my">
				<div class="input-group  col-md-5">
					<span class="input-group-addon" id="senduserName">发送者：</span> <input
						type="text" class="form-control" placeholder="Username"
						aria-describedby="senduserName" value="某某" disabled>
				</div>
				<br>
				<div class="input-group  col-md-5">
					<span class="input-group-addon" id="sendtheme">&nbsp; 主 题：</span> <input
						type="text" class="form-control" placeholder="Username"
						aria-describedby="senduserName" value="股东大会" disabled>
				</div>
				<br>
				<div class="input-group col-md-10">
					<label class="sr-only" for="inputHelpBlock"></label>
					<textarea class="form-control" rows="10" cols="100"
						disabled="disabled">今天下午开会！！</textarea>
				</div>
				<br>
				<div class="input-group">
					<div class=" col-md-2">
						<a type="submit" class="btn btn-default">确认</a>
					</div>
					<div class="col-md-offset-1 col-md-2">
						<a type="submit" class="btn btn-default">拒绝</a>
					</div>
					<div class="col-md-offset-1 col-md-2">
						<a type="submit" class="btn btn-default">回复</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	
</body>
<script type="text/javascript">
	$(function(){
		$("#backmymessage").click(function(){
			/* 当点击返回的时候，将他透明度设置为0，然后将上一个透明度设置为1 */
			//document.getElementById("checkinfoback").style.opacity=0;
			document.getElementById("myunreadmessage").style.zIndex = 1;
			document.getElementById("checkinfoback").style.zIndex = -1;
		});
	});
</script>
</html>