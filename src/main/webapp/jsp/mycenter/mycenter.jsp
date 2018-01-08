<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人中心</title>
</head>
<body>
	<div class="body row">
		<!-- 左 -->
		<div class="body-left">
			<ul class="nav nav-pills nav-stacked nav-tabs">
				<li id="myinfoLi" class=""><a class="text-muted" href="#myinfo" data-toggle="tab"><span
						class="glyphicon glyphicon-user"></span>&nbsp;个人信息</a></li>
				<li id="mymessageLi" class=""><a class="text-muted" onclick="mymessage()" href="#mymessage" data-toggle="tab"><span
						class="glyphicon glyphicon-comment"></span>&nbsp;我的消息</a></li>
				<li id="mymeettingLi" class=""><a class="text-muted" href="#mymeetting" data-toggle="tab"><span
						class="glyphicon glyphicon-list-alt"></span>&nbsp;我的会议</a></li>
				<li id="askmeettingLi" class=""><a class="text-muted" href="#askmeetting" data-toggle="tab"><span
						class="glyphicon glyphicon-pencil"></span>&nbsp;申请会议</a></li>
				<li id="releasemeettingLi" class="active"><a class="text-muted"
					href="#releasemeetting" data-toggle="tab"><span
						class="glyphicon glyphicon-pencil"></span>&nbsp;发布会议</a></li>
				<li id="websocketLi" class=""><a class="text-muted" href="#websocket"
					data-toggle="tab"><span class="glyphicon glyphicon-pencil"></span>&nbsp;websocket</a></li>
			</ul>
		</div>

		<!-- 右 -->
		<div class="tab-content">
			<div class="tab-pane fade" id="myinfo">
				<jsp:include page="myinfo.jsp"></jsp:include>
			</div>
			<div class="tab-pane fade" id="mymessage">
				<jsp:include page="mymessage.jsp"></jsp:include>
			</div>
			<div class="tab-pane fade" id="mymeetting">
				<jsp:include page="mymeetting.jsp"></jsp:include>
			</div>
			<div class="tab-pane fade" id="askmeetting">
				<jsp:include page="askmeetting.jsp"></jsp:include>
			</div>
			<div class="tab-pane fade in active" id="releasemeetting">
				<jsp:include page="releasemeetting.jsp"></jsp:include>
			</div>
			<div class="tab-pane fade" id="websocket">
				<jsp:include page="websocket.jsp"></jsp:include>
			</div>
		</div>

	</div>

</body>
<script type="text/javascript">
	$(function() {
		//点击我的信息，先查询数据库，如果有unread为1的，就将他添加到mymessage.jsp中
		mymessage = function(){
			$.ajax({
				url:"getMyMessage",
				type:"get",
				data:"loginId=${sessionScope.loginId}",
				success:function(e){
					$("#messageList tbody").empty();
					var myMessageList = e.myMessage;
					$.each(myMessageList,function(index,item){
						var checkBox = $("<td><input type='checkbox' /></td>");
						var state = $("<td></td>").append("<label></label>");
						//判断会议信息是否已读
						if(item.unread == 1){
							state.append("<span class='glyphicon glyphicon-folder-close'></span>");
						}else{
							state.append("<span class='glyphicon glyphicon-folder-open'></span>");
						}
						
						var sendUserName = $("<td></td>").append(item.meettingInfo.releaseuser);
						var title = $("<td></td>").append(item.meettingInfo.title);
						var meettingInfoHidden = $("<input type='hidden' value='"+item.meettingInfo.infomation+"' />");
						var meettingInfoHiddenTd = $("<td></td>").append(meettingInfoHidden);
						$("<tr ondblclick='entercheckinfo(this)'></tr>")
							.append(checkBox)
							.append(state)
							.append(sendUserName)
							.append(title)
							.append(meettingInfoHiddenTd)
							.prependTo("#messageList tbody");
					});
					
				}
			});
		}
		
		$("#myinfo").click(function() {

		});
	});
</script>
</html>