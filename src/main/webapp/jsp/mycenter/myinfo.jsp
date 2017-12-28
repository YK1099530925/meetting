<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<!-- 右 -->
	<div class="body-right">
		<div class="panel panel-info">
			<div class="panel-heading">我的基本信息</div>
			<div class="panel-body">
				<form class="form-horizontal">
					<div class="form-group">
						<label for="loginId" class="col-sm-2 control-label">账号</label>
						<div class="col-sm-5">
							<input type="text" class="form-control" id="loginId"
								name="loginId" disabled>
						</div>
					</div>
					<div class="form-group">
						<label for="userName" class="col-sm-2 control-label">姓名</label>
						<div class="col-sm-5">
							<input type="text" class="form-control" id="userName"
								name="userName" disabled>
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
			$("#userName").removeAttr("disabled");
		});
		/* 点击保存时，将disabled添加属性 */
		$("#save").click(function(){
			$("#userName").attr("disabled","disabled");
		});
	});
</script>
</html>