<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部门管理</title>
</head>
<body>

	<div class="body-right" id="">
		<div class="panel panel-primary">
			<div class="panel-heading">部门管理</div>
			<div class="panel-body panel-body-my">
				<!-- 接收消息体 -->
				<div class="row">
					<div class="col-md-4">
						<button class="btn btn-primary" id="dept_add_modal_btn">新增</button>
						<button class="btn btn-danger" id="dept_delete_all_btn">删除</button>
					</div>
				</div>
				<table class="table table-hover" id="deptInfo_table">
					<thead>
						<tr>
							<th><input type="checkbox" id="check_all_dept" /></th>
							<th>id</th>
							<th>部门</th>
							<th>部门电话</th>
							<th>部门人数</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>

					</tbody>
				</table>
				<div class="row">
					<div id="deptInfo_page_Info" class="col-md-5 col-md-offset-4"></div>
					<div id="deptInfo_page_nav" class="col-md-6 col-md-offset-4">
					</div>
				</div>
			</div>
		</div>
	</div>
	
</body>
<script type="text/javascript">
	
</script>
</html>