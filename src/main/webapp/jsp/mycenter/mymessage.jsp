<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 我的所有信息 -->
	<jsp:include page="checkinfo.jsp"></jsp:include>
	<!-- 右 -->
	<div class="body-right" id="myunreadmessage">
		<div class="panel panel-primary">
			<div class="panel-heading">我的消息</div>
			<div class="panel-body panel-body-my">
				<!-- 接收消息体 -->
				<button class="btn btn-primary btn-sm">标记为已读</button>
				<button id="deleteMeettingInfo" class="btn btn-danger btn-sm">删除</button>
				<table id="messageList" class="table table-hover">
					<thead>
						<tr>
							<td><input type="checkbox" id="check_all"/></td>
							<td><label>状态</label></td>
							<td><label>发送者</label></td>
							<td><label>主题</label></td>
						</tr>
					</thead>
					<tbody>
						<tr ondblclick="entercheckinfo(this)">
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
					<div id="page_Info" class="col-md-5 col-md-offset-4"></div>
					<div id="page_nav" class="col-md-6 col-md-offset-4">
					</div>
				</div>
			</div>
		</div>
	</div>



</body>
<script type="text/javascript">
	//显示会议详细信息
	function entercheckinfo(a) {
		//让查看信息页面置位最顶层
		document.getElementById("myunreadmessage").style.zIndex = -1;
		document.getElementById("checkinfoback").style.zIndex = 1;
		var state = a.children[1].children[1];
		//设置ckeckinfo页面的值
		//得到发送者子节点
		var senduserNameTd = a.children[2].innerHTML;
		//得到标题子节点
		var sendthemeTd = a.children[3].innerHTML;
		//得到会议信息子节点（隐藏的子节点）
		var meettingInfoTd = a.children[4].firstChild.defaultValue;
		//得到会议id自己点
		var meettingId = a.children[5].firstChild.defaultValue;
		//改变状态(如果未打开，则改变状态)
		if (state.className != "glyphicon glyphicon-folder-open") {
			$.ajax({
				url : "setUnread",
				type : "post",
				data : "meettingid=" + meettingId
						+ "&loginId=${sessionScope.loginId}",
				success : function(e) {
					//当成功改变unread的值后，修改状态
					state.className = "glyphicon glyphicon-folder-open";
				}
			});
		}
		//设置checkinfo页面的值
		document.getElementById("senduserName").value = senduserNameTd;
		document.getElementById("sendtheme").value = sendthemeTd;
		document.getElementById("sendMeettingInfo").value = meettingInfoTd;

	}
</script>
</html>