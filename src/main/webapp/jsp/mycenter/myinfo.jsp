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
			<div class="panel-heading">我的基本信息</div>
			<div class="panel-body panel-body-my">
				<form class="form-horizontal">
					<div class="form-group">
						<label for="loginId" class="col-sm-2 control-label">账号</label>
						<div class="col-sm-5">
							<input type="text" class="form-control" id="loginId"
								name="loginId"value="${sessionScope.user.loginid }" disabled>
						</div>
					</div>
					<div class="form-group">
						<label for="username" class="col-sm-2 control-label">姓名</label>
						<div class="col-sm-5">
							<input type="text" class="form-control" id="username"
								name="username" value="${sessionScope.user.username }" disabled>
						</div>
					</div>
					<div class="form-group">
						<label for="sex" class="col-sm-2 control-label">性别</label>
						<div class="col-sm-5">
							<input type="text" class="form-control" id="sex"
								name="sex" value="${sessionScope.user.sex }" disabled>
						</div>
					</div>
					<div class="form-group">
						<label for="birthday" class="col-sm-2 control-label">出生日期</label>
						<div class="col-sm-5">
							<input type="text" class="form-control" id="birthday"
								name="birthday" value="${sessionScope.user.birthday }" disabled>
						</div>
					</div>
					<div class="form-group">
						<label for="tel" class="col-sm-2 control-label">联系方式</label>
						<div class="col-sm-5">
							<input type="text" class="form-control" id="tel"
								name="tel" value="${sessionScope.user.tel }" disabled>
						</div>
					</div>
					<div class="form-group">
						<label for="addr" class="col-sm-2 control-label">住址</label>
						<div class="col-sm-5">
							<input type="text" class="form-control" id="addr"
								name="addr" value="${sessionScope.user.addr }" disabled>
						</div>
					</div>
					<div class="form-group">
						<label for="deptid" class="col-sm-2 control-label">部门id</label>
						<div class="col-sm-5">
							<input type="text" class="form-control" id="deptid"
								name="deptid" value="${sessionScope.user.deptid }" disabled>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<a id="update" type="submit" class="btn btn-default">修改信息</a>
							<a id="save" type="submit" class="btn btn-default">保存信息</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		/* 点击修改时，将disabled属性删除 */
		$("#update").click(function(){
			$("#username").removeAttr("disabled");
			$("#sex").removeAttr("disabled");
			$("#birthday").removeAttr("disabled");
			$("#tel").removeAttr("disabled");
			$("#addr").removeAttr("disabled");
		});
		/* 点击保存时，将disabled添加属性 */
		$("#save").click(function(){
			$("#username").attr("disabled","disabled");
			$("#sex").attr("disabled","disabled");
			$("#birthday").attr("disabled","disabled");
			$("#tel").attr("disabled","disabled");
			$("#addr").attr("disabled","disabled");
		});
	});
</script>
</html>