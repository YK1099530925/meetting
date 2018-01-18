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
						<td><label>未处理</label></td>
						<td>杨宽</td>
						<td>开会</td>
						<td><input type="hidden" value="info" /></td>
						<td><input type="hidden" value="meettingid" /></td>
						<td><input type="hidden" value="askUserid" /></td>
						<td><input type="hidden" value="askUserDeptId" /></td>
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

		//判断是否是已处理，如果是已处理，就将按钮变的不可用
		var handller = "已处理";
		if(a.children[1].innerText == handller){
			$("#agreeAskMeetting").addClass("disabled");
			$("#disagreeAskMeetting").addClass("disabled");
		}else {
			$("#agreeAskMeetting").removeClass("disabled");
			$("#disagreeAskMeetting").removeClass("disabled");
		}

		//申请人姓名
		var askUserName = a.children[2].innerHTML;
		//申请的标题
		var askTitle = a.children[3].innerHTML;
		//申请的内容
		var askInfomation = a.children[4].firstChild.defaultValue;
		//会议id
		var askMeettingId = a.children[5].firstChild.defaultValue;
		//申请人id
		var askUserId = a.children[6].firstChild.defaultValue;
		//部门id
		var askUserDeptId = a.children[7].firstChild.defaultValue;

		//添加到查看页面
		document.getElementById("askUserName").value = askUserName;
		document.getElementById("askTitle").value = askTitle;
		document.getElementById("askMeettingInfo").value = askInfomation;
		document.getElementById("askMeettingId").value = askMeettingId;
		document.getElementById("askUserId").value = askUserId;
		document.getElementById("askUserDeptId").value = askUserDeptId;
		
	}
</script>
</html>