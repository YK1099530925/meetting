<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="checkAskMeettinginfo.jsp"></jsp:include>

	<div class="body-right" id="myunreadAskMeettingmessage">
		<div class="panel panel-primary">
			<div class="panel-heading">会议申请消息</div>
		</div>
		<div class="panel-body panel-body-my">
			<button class="btn btn-info btn-sm">删除</button>
			<button class="btn btn-info btn-sm">标记为已读</button>
			<table id="askMeettingInfoList" class="table table-hover">
				<thead>
					<tr>
						<td><input type="checkbox" /></td>
						<td><label>状态</label></td>
						<td><label>申请者</label></td>
						<td><label>标题</label></td>
					</tr>
				</thead>
				<tbody>
					<tr ondblclick="entercheckAskMeeettinginfo(this)">
						<td><input type="checkbox" /></td>
						<td><label><span
								class="glyphicon glyphicon-folder-close"></span></label></td>
						<td>杨宽</td>
						<td>开会</td>
						<td><input type="hidden" value="会议信息" /></td>
						<td><input type="hidden" value="1111" /></td>
					</tr>
				</tbody>
			</table>
			<div class="row">
				<div id="page_Info_askMeetting" class="col-md-5 col-md-offset-4"></div>
				<div id="page_nav_askMeetting" class="col-md-6 col-md-offset-4">
				</div>
			</div>
		</div>
	</div>
</body>

<script type="text/javascript">
	function entercheckAskMeeettinginfo(a) {
		//让查看信息页面置位最顶层
		document.getElementById("myunreadAskMeettingmessage").style.zIndex = -1;
		document.getElementById("checkAskMeetinginfoback").style.zIndex = 1;
	}
</script>
</html>