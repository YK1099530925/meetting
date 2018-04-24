<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="keywords" content="" />
<title>Insert title here</title>
<script type="application/x-javascript">
	 
addEventListener("load", function() { 
	setTimeout(hideURLbar, 0); 
	}, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<link href="css/style.css" rel='stylesheet' type='text/css' media="all" />
<!-- /css files -->
<style type="text/css">

</style>
</head>
<body>
	<h1>会议管理系统</h1>
	<div class="log">
		<div class="content1">
			<h2>登录</h2>
			<form action="${appPath }/login" method="post">
				<input type="text" id="loginId" name="loginId" value="用户名"
					onfocus="this.value = '';"
					onblur="if (this.value == '') {this.value = '用户名';}">
				<input type="password" id="password" name="password" value="PASSWORD"
					onfocus="this.value = '';"
					onblur="if (this.value == '') {this.value = 'PASSWORD';}">
				<div class="button-row">
					<input type="submit" class="sign-in" value="登录"> <input type="button"
						id="register" class="reset" value="注册">
					<div class="clear"></div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>