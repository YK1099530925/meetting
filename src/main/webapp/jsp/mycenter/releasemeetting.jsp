<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<!-- 发布会议 -->
	<div class="body-right">
		<div class="panel panel-info">
			<div class="panel-heading">发布会议</div>
			<div class="panel-body panel-body-my">
				<div class="input-group  col-md-5">
					<span class="input-group-addon">发送者：</span> <input
						id="senduserName" type="text" class="form-control"
						placeholder="Username" value="${sessionScope.userName }" disabled>
				</div>
				<br>
				<div class="input-group  col-md-5">
					<span class="input-group-addon">&nbsp; 主 题：</span> <input
						name="sendtheme" type="text" class="form-control"
						placeholder="title" value="">
				</div>
				<br>
				<div class="input-group col-md-10">
					<label class="sr-only" for="inputHelpBlock"></label>
					<textarea name="textmeetting" class="form-control" rows="10"
						cols="100"></textarea>
				</div>
				<br>
				<div class="input-group">
					<div class="col-md-2">
						<a id="release" type="submit" class="btn btn-default">发布</a>
					</div>
					<div class="col-md-offset-2 col-md-2">
						<a id="cancelmeetting" type="submit" class="btn btn-default">跳页面</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	//生成随机数作为会议的会议id
	getMeettingId = function(){
		var meettingId = 0;
		r = Math.random();
		r1 = r * 1000;
		r3 = Math.random();
		r4 = r1 * r3 * 10 + 101;
		meettingId = parseInt(r4);
		return meettingId;
	}

	$("#release").click(function() {
		var releaseUser = "${sessionScope.userName }";
		//获得会议的meettingid，通过随机数获得
		var meettingid = getMeettingId();
		//将发布会议的消息封装起来
		var title = document.getElementsByName("sendtheme")[0].value;
		var meettingInfo = document.getElementsByName("textmeetting")[0].value;
		var message = '{"releaseUser":"'+releaseUser+'","title":"'+title+'","meettingInfo":"'+meettingInfo+'","meettingid":"'+meettingid+'"}';
		
		/*将数据保存到数据库的消息表中，成功之后在通知每个用户有消息来了*/
		$.ajax({
			url:"messageInfo",
			type:"post",
			data:{"message":message},
			success:function(e){
				if(e=="success"){
					alert("会议发布成功");
					//发布会议成功后，将信息显示出来
					showReleasemeettingInfo();
				}
			}
		});
	});

 
	$("#cancelmeetting").click(function(){
		/*var message = '{"title":"开发","meettingInfo":"全体成员"}';
		  $.ajax({
			url:"test",
			type:"post",
			data: {"message":message},
			success:function(e){
				alert(e=="success");
			}
		}); */ 
	});


	/*发布后将信息显示出来，在获取会议的同时，将其unread设置为0*/
	showReleasemeettingInfo = function(){
		/*当发布会议成功之后，将跳到checkinfo页面，在这里将从信息表中查找会议信息，
		将发布人，发布的消息添加到checkinfo和mymessage页面中，在mymessage
		页面使用input隐藏域存储会议的信息，然后点击查看之后，将从中读取信息到
		checkinfo页面，另外成功之后，还需要设置对应的unread为0*/
		//若要跳到消息页面，需要给消对应的li元素添加active
		document.getElementById("mymessageLi").className="active";
		//移除当前页面的active
		$("#releasemeettingLi").removeClass("active");
		//让mymessage页面处于active
		document.getElementById("mymessage").className="in active"
		//移除当前页面active
		$("#releasemeetting").removeClass("in active");
		//让查看信息（checkinfo页面）置位最顶层
		document.getElementById("myunreadmessage").style.zIndex = -1;
		document.getElementById("checkinfoback").style.zIndex = 1;
		//Ajax请求，从数据库中拿到当前发布会议的信息
 		$.ajax({
			url:"getOneMeettingInfo",
			type:"get",
			success:function(e){
				//发送人
				var senduserName = "${sessionScope.userName}";
				//会议id
				var meettingId = e.meettingid;
				//会议标题
				var title = e.title;
				//会议信息
				var infomation = e.infomation;
				/* 将发布的会议添加到将要跳转的checkinfo页面中 */
				document.getElementById("senduserName").value=senduserName;
				document.getElementById("sendtheme").value=title;
				document.getElementById("sendMeettingInfo").value=infomation;
				//动态添加向mymessage页面添加一行
				//添加checkbox
				var checkBox = $("<td><input type='checkbox' /></td>");
				//添加发送者名字
				var sendUserName = $("<td></td>").append(senduserName);
				//添加标题
				var title = $("<td></td>").append(title);
				//添加会议（隐藏会议）
				var meettingInfoHidden = $("<input type='hidden' value='"+infomation+"' />");
				var meettingInfoHiddenTd = $("<td></td>").append(meettingInfoHidden);
				//上面的td全部添加到tr中，在加入到tbody中
				$("<tr onclick='entercheckinfo(this)'></tr>")
					.append(checkBox)
					.append(sendUserName)
					.append(title)
					.append(meettingInfoHiddenTd)
					.prependTo("#messageList tbody");	
			}
		});
	}
	
</script>
</html>