<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<!-- 我的个人资料 -->
	<div class="body-right">
		<div class="panel panel-primary">
			<div class="panel-heading">修改密码</div>
			<div class="panel-body panel-body-my">
				<form id="myInfoForm" class="form-horizontal">
					<div class="form-group">
						<label for="oldPassword" class="col-sm-2 control-label">原密码</label>
						<div class="col-sm-5">
							<input type="password" class="form-control" id="oldPassword"
								name="oldPassword" value="">
						</div>
					</div>
					<div class="form-group">
						<label for="newPassword" class="col-sm-2 control-label">新密码</label>
						<div class="col-sm-5">
							<input type="password" class="form-control" id="newPassword"
								name="newPassword" value="">
						</div>
					</div>
					<div class="form-group">
						<label for="confirmPassword" class="col-sm-2 control-label">确认密码</label>
						<div class="col-sm-5">
							<input type="password" class="form-control" id="confirmPassword" name="confirmPassword"
								value="">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<a id="updatePassword_btn" type="submit" class="btn btn-default">确认</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	//修改密码：通过loginid判断初始密码是否正确，正确则修改，否则修改失败
	$("#updatePassword_btn").click(function(){

		//如果没有填完，提示信息填写完整
		
		var loginid = ${sessionScope.loginId};
		var oldPassword = $("#oldPassword")[0].value;
		var newPassword = $("#newPassword")[0].value;
		var confirmPassword = $("#confirmPassword")[0].value;
		//判断两次密码是否相同（后续处理）
		if(newPassword != confirmPassword){
			alert("两次密码不相同");
			$("#oldPassword")[0].value="";
			$("#newPassword")[0].value="";
			$("#confirmPassword")[0].value="";
			return;
		}
		//发送请求，修改密码
 		$.ajax({
			url:"updatePassword",
			type:"POST",
			data:{"loginid":loginid,"oldPassword":oldPassword,"newPassword":newPassword},
			success:function(e){
				alert(e);

			}
		});
	});
</script>
</html>