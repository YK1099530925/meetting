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
				<form id="myInfoForm" class="form-horizontal">
					<div class="form-group">
						<label for="loginId" class="col-sm-2 control-label">账号</label>
						<div class="col-sm-5">
							<input type="text" class="form-control" id="loginId"
								name="loginId" value="" disabled>
						</div>
					</div>
					<div class="form-group">
						<label for="username" class="col-sm-2 control-label">姓名</label>
						<div class="col-sm-5">
							<input type="text" class="form-control" id="username"
								name="username" value="" disabled>
						</div>
					</div>
					<div class="form-group">
						<label for="sex" class="col-sm-2 control-label">性别</label>
						<div class="col-sm-5">
							<input type="text" class="form-control" id="sex" name="sex"
								value="" disabled>
						</div>
					</div>
					<div class="form-group">
						<label for="birthday" class="col-sm-2 control-label">出生日期</label>
						<div class="col-sm-5">
							<input type="text" class="form-control" id="birthday"
								name="birthday" value="" disabled>
						</div>
					</div>
					<div class="form-group">
						<label for="tel" class="col-sm-2 control-label">联系方式</label>
						<div class="col-sm-5">
							<input type="text" class="form-control" id="tel" name="tel"
								value="" disabled>
						</div>
					</div>
					<div class="form-group">
						<label for="addr" class="col-sm-2 control-label">住址</label>
						<div class="col-sm-5">
							<input type="text" class="form-control" id="addr" name="addr"
								value="" disabled>
						</div>
					</div>
					<div class="form-group">
						<label for="deptname" class="col-sm-2 control-label">部门id</label>
						<div class="col-sm-5">
							<input type="text" class="form-control" id="deptname"
								name="departMent.deptname" value="" disabled>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<a id="update" type="submit" class="btn btn-default"
								data-toggle="modal" data-target="#updateMyInfoModal">修改信息</a> <a
								id="save" type="submit" class="btn btn-default">保存信息</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- 员工修改的模态框 -->
	<div class="modal fade" id="updateMyInfoModal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<!-- 头 -->
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">修改信息</h4>
				</div>
				<!-- 身体 -->
				<div class="modal-body">
					<form id="myInfoForm" class="form-horizontal">
						<div class="form-group">
							<label for="loginIdModal" class="col-sm-2 control-label">账号</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="loginIdModal"
									name="loginid" value="" disabled>
							</div>
						</div>
						<div class="form-group">
							<label for="usernameModal" class="col-sm-2 control-label">姓名</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="usernameModal"
									name="username" value="">
							</div>
						</div>
						<div class="form-group">
							<label for="sexModal" class="col-sm-2 control-label">性别</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="sexModal" name="sex"
									value="">
							</div>
						</div>
						<div class="form-group">
							<label for="birthdayModal" class="col-sm-2 control-label">出生日期</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="birthdayModal"
									name="birthday" value="">
							</div>
						</div>
						<div class="form-group">
							<label for="telModal" class="col-sm-2 control-label">联系方式</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="telModal" name="tel"
									value="">
							</div>
						</div>
						<div class="form-group">
							<label for="addrModal" class="col-sm-2 control-label">住址</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="addrModal"
									name="addr" value="">
							</div>
						</div>
						<div class="form-group">
							<label for="deptnameModal" class="col-sm-2 control-label">部门id</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="deptnameModal"
									name="departMent.deptname" value="" disabled>
							</div>
						</div>
					</form>
				</div>
				<!-- 尾 -->
				<div class="modal-footer">
					<button id="cancelMyInfoUpdateModal" type="button"
						class="btn btn-default" data-dismiss="modal">取消</button>
					<button id="saveMyInfoUpdateModal" type="button"
						class="btn btn-default" data-dismiss="modal">保存</button>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	/* 点击修改时：将所有信息添加到模态框中 */
	$("#update").click(function() {

		$("#loginIdModal")[0].value = $("#loginId")[0].value;
		$("#usernameModal")[0].value = $("#username")[0].value;
		$("#sexModal")[0].value = $("#sex")[0].value;
		$("#birthdayModal")[0].value = $("#birthday")[0].value;
		$("#telModal")[0].value = $("#tel")[0].value;
		$("#addrModal")[0].value = $("#addr")[0].value;
		$("#deptnameModal")[0].value = $("#deptname")[0].value;

		/* $("#username").removeAttr("disabled");
		$("#sex").removeAttr("disabled");
		$("#birthday").removeAttr("disabled");
		$("#tel").removeAttr("disabled");
		$("#addr").removeAttr("disabled"); */
	});
	/* {"user":$("#updateMyInfoModal form").serialize()} */
	$("#saveMyInfoUpdateModal").click(function() {
		var loginId = ${sessionScope.loginId};
		$.ajax({
			url : "updateMyInfo/"+loginId,
			type : "PUT",
			data : $("#updateMyInfoModal form").serialize(),
			success : function(result) {
				alert("修改成功");
				/* 修改成功之后，将页面表单的数据变换过来 */
				myInfo();
			}
		});
	});
</script>
</html>