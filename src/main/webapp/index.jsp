<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="keywords" content="" />
<title>登录</title>
<script type="application/x-javascript">
	 
addEventListener("load", function() { 
	setTimeout(hideURLbar, 0); 
	}, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<link href="css/style.css" rel='stylesheet' type='text/css' media="all" />
<%
	pageContext.setAttribute("appPath", request.getContextPath());
%>
<script type="text/javascript" src="${appPath }/js/jquery-1.12.4.min.js"></script>
<link href="${appPath }/js/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="${appPath }/js/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

<script type="text/javascript">
</script>
</head>
<body class="bg-info">

	<div class="modal fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">注册</h4>
	      </div>
	      <div class="modal-body">
	        <form class="form-horizontal">
			  <div class="form-group">
			    <label class="col-sm-2 control-label">姓名</label>
			    <div class="col-sm-10">
			      <input type="text" name="username" class="form-control" id="username_register_input" placeholder="姓名">
			      <span class="help-block"></span>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-2 control-label">密码</label>
			    <div class="col-sm-10">
			      <input type="password" name="password" class="form-control" id="password_register_input" placeholder="密码">
			      <span class="help-block"></span>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-2 control-label">确认密码</label>
			    <div class="col-sm-10">
			      <input type="password" class="form-control" id="confirmPassword_register_input" placeholder="确认密码">
			      <span class="help-block"></span>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-2 control-label">性别</label>
			    <div class="col-sm-10">
			      <label class="radio-inline">
					  <input type="radio" name="sex" id="sex1_register_input" value="男" checked="checked"> 男
					</label>
					<label class="radio-inline">
					  <input type="radio" name="sex" id="sex2_register_input" value="女"> 女
					</label>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-2 control-label">出生日期</label>
			    <div class="col-sm-10">
			      <input type="text" name="birthday" class="form-control" id="birthday_register_input" placeholder="1995-05-12">
			      <span class="help-block"></span>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-2 control-label">联系电话</label>
			    <div class="col-sm-10">
			      <input type="text" name="tel" class="form-control" id="tel_register_input" placeholder="联系电话">
			      <span class="help-block"></span>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-2 control-label">家庭地址</label>
			    <div class="col-sm-10">
			      <input type="text" name="addr" class="form-control" id="addr_register_input" placeholder="家庭地址">
			      <span class="help-block"></span>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-2 control-label">部门</label>
			    <div class="col-sm-4">
			    	<!-- 部门提交部门id即可 -->
			      <select class="form-control" name="deptid">
			      </select>
			    </div>
			  </div>
			</form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	        <button type="button" class="btn btn-primary" id="userInfo_register_btn">注册</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<h1></h1>
	<div class="log">
		<div class="content1">
			<h2>会议管理系统</h2>
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


<%-- 	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-7">
				<h4>账户登录</h4>
			</div>
		</div>

		<div class="row">
			<div class="col-md-5 col-md-offset-5">
				<form class="form-horizontal" action="${appPath }/login"
					method="post">
					<div class="form-group">
						<label for="userName" class="col-sm-2 control-label">账号</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="loginId"
								name="loginId" placeholder="账号">
						</div>
					</div>
					<div class="form-group">
						<label for="password" class="col-sm-2 control-label">密码</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="password"
								name="password" placeholder="密码">
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
							<button type="submit" class="btn btn-default">登录</button>
							<a id="register" class="btn btn-default">注册</a>
						</div>
					</div>
				</form>
			</div>
		</div>

	</div> --%>
</body>
<script type="text/javascript">

$("#register").click(function(){
	//将部门显示在下拉列表中
	registerGetDepts("#registerModal select");
	
	//弹出模态框
	$("#registerModal").modal({
		backdrop:"static"
	});

	$("#userInfo_register_btn").click(function(){
		//校验表单
		
		//注册
 		$.ajax({
			url:"registerUserInfo",
			type:"POST",
			data:$("#registerModal form").serialize(),
			success:function(e){
				$("#registerModal").modal('hide');
				alert("注册成功:您的登录id为：" + e);
			}
		});
		
	});
});

function registerGetDepts(ele){
	$(ele).empty();
	$.ajax({
		url:"getDepts",
		type:"GET",
		success:function(e){
			$.each(e.depts,function(){
				var optionEle = $("<option></option>").append(this.deptname).attr("value",this.id);
				optionEle.appendTo(ele);
			});
		}
	});
}

</script>

</html>