<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<!-- 查看信息 -->
	<div class="body-right" id="checkAskMeetinginfoback">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<a style="color: white;" id="backmymessage"><span
					class="glyphicon glyphicon-chevron-left"></span>返回</a>
			</div>
			<div class="panel-body panel-body-my">
				<div class="input-group  col-md-5">
					<span class="input-group-addon">申请人：</span> <input
						id="askUserName" type="text" class="form-control"
						placeholder="Username" aria-describedby="askUserName" value=""
						disabled>
				</div>
				<br>
				<div class="input-group  col-md-5">
					<span class="input-group-addon">&nbsp; 主标题：</span> <input
						id="askTitle" type="text" class="form-control" placeholder="title"
						aria-describedby="askTitle" value="" disabled>
				</div>
				<br>
				<div class="input-group col-md-10">
					<label class="sr-only" for="inputHelpBlock"></label>
					<textarea id="askMeettingInfo" class="form-control" rows="10"
						cols="100" disabled="disabled"></textarea>
				</div>
				<input id="askMeettingId" type="hidden"/>
				<input id="askUserId" type="hidden"/>
				<input id="askUserDeptId" type="hidden"/>
				
				<br>
				<div class="input-group">
					<div class=" col-md-2">
						<a id="agreeAskMeetting" class="btn btn-default">同意</a>
					</div>
					<div class="col-md-offset-2 col-md-2">
						<a id="disagreeAskMeetting" class="btn btn-default">反对</a>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
<script type="text/javascript">
	$("#checkAskMeetinginfoback").click(function() {
		/* 当点击返回的时候，将他透明度设置为0，然后将上一个透明度设置为1 */
		//document.getElementById("checkinfoback").style.opacity=0;
		document.getElementById("myunreadAskMeettingmessage").style.zIndex = 1;
		document.getElementById("checkAskMeetinginfoback").style.zIndex = -1;
	});

	//同意申请
	$("#agreeAskMeetting").click(function() {
		var askUserName = $("#askUserName")[0].value;
		var askTitle = $("#askTitle")[0].value;
		var askMeettingInfo = $("#askMeettingInfo")[0].value;
		var askMeettingId = $("#askMeettingId")[0].value;
		var askUserId = $("#askUserId")[0].value;
		var askUserDeptId = $("#askUserDeptId")[0].value;
		
/* 		var message = '{"releaseUser":"'+releaseUser
					+'","title":"'+title
					+'","meettingInfo":"'+meettingInfo
					+'","meettingid":"'+meettingidRandom
					+'","deptId":"'+ deptId
					+'","filename":"'+ filename
					+'","objURL":"'+ objURL
					+'"}'; */
		var message = '{"releaseUser":"'+askUserName
					+'","title":"'+askTitle
					+'","meettingInfo":"'+askMeettingInfo
					+'","meettingid":"'+askMeettingId
					+'","deptId":"'+ askUserDeptId
					+'"}';
		
		$.ajax({
			url:"messageInfo",
			type:"post",
			data:{"message":message,"loginId":askUserId},
			success:function(e){
				if(e=="success"){
					//处理申请的会议
					handleMeetting(1,askMeettingId,askUserId);
					
					//处理完成之后，标志前面“已处理”
					
				}
			}
		});
	});

	//不同意申请
	$("#disagreeAskMeetting").click(function() {
		var askMeettingId = $("#askMeettingId")[0].value;
		var askUserId = $("#askUserId")[0].value;
		handleMeetting(0,askMeettingId,askUserId);
		//处理完成之后，标志前面“已处理”
	});

	//处理会议（参数：同意：1，拒绝：0）
	handleMeetting = function(agree,askMeettingId,askUserId){
		/*1：修改此会议（根据会议id找到）的agree
		 *2：通知申请人，消息已处理
		 *3： */
		$.ajax({
			url:"isOrAgreeAskMeetting",
			type:"post",
			data:{"agree":agree,"askMeettingId":askMeettingId,"askUserId":askUserId},
			success:function(e){
				alert("处理成功");
				//处理成功然后回到上一页面（重新刷新整个页面）
				askMeettingInfo(1);
				document.getElementById("myunreadAskMeettingmessage").style.zIndex = 1;
				document.getElementById("checkAskMeetinginfoback").style.zIndex = -1;
			}
		});
	}
</script>
</html>