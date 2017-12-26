<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<%
	pageContext.setAttribute("appPath", request.getContextPath());
%>
<script type="text/javascript" src="${appPath }/js/jquery-1.12.4.min.js"></script>
<link href="${appPath }/js/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="${appPath }/js/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

<style type="text/css">
.loginBack{
background: url("img/loginBack.jpg");
}
.login{
border:1px solid black;
}
</style>
</head>
<body class="bg-info">
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-7">
				<h4>账户登录</h4>
			</div>
		</div>

		<div class="row">
			<div class="col-md-5 col-md-offset-5">
				<form class="form-horizontal">
					<div class="form-group">
						<label for="userName" class="col-sm-2 control-label">账号</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="userName"
								placeholder="账号">
						</div>
					</div>
					<div class="form-group">
						<label for="password" class="col-sm-2 control-label">密码</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="password"
								placeholder="密码">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<div class="checkbox">
								<label> <input type="checkbox"> 记住我
								</label>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" id="submit" class="btn btn-default">登录</button>
						</div>
					</div>
				</form>
			</div>
		</div>

	</div>
</body>
<script type="text/javascript">

$(function(){
	$("#submit").click(function(){
		var userName = $("#userName").trim();
		var password = $("#password").trim();
		$.ajax({
			url:"login",
			type:"post",
			data:"userName="+userName+"&password="+password
		});
	});
});

</script>
</html>