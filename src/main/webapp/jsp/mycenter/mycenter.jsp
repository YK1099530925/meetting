<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
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
				<li id="myinfoLi" class="active"><a class="text-muted" onclick="myInfo()" href="#myinfo" data-toggle="tab"><span
						class="glyphicon glyphicon-user"></span>&nbsp;个人信息</a></li>
				<li id="mymessageLi" class=""><a class="text-muted" onclick="mymessage(1)" href="#mymessage" data-toggle="tab"><span
						class="glyphicon glyphicon-comment"></span>&nbsp;我的消息</a></li>
						
				<!-- <li id="mymeettingLi" class=""><a class="text-muted" href="#mymeetting" data-toggle="tab"><span
						class="glyphicon glyphicon-list-alt"></span>&nbsp;文件上传测试</a></li> -->
				<!-- 
				<li id="askmeettingLi" class=""><a class="text-muted" href="#askmeetting" data-toggle="tab"><span
						class="glyphicon glyphicon-pencil"></span>&nbsp;申请会议</a></li>
						 -->
				<li id="releasemeettingLi" class=""><a class="text-muted"
					href="#releasemeetting" data-toggle="tab"><span
						class="glyphicon glyphicon-pencil"></span>&nbsp;发布会议</a></li>
				<shiro:hasPermission name="user:*">
					<li id="askMeettingMessageLi" class=""><a class="text-muted" onclick="askMeettingInfo(1)" href="#askMeettingMessage"
						data-toggle="tab"><span class="glyphicon glyphicon-pencil"></span>&nbsp;会议申请消息</a></li>
				</shiro:hasPermission>
				<li id="updatePasswordLi" class=""><a class="text-muted"
					href="#updatePassword" data-toggle="tab"><span
						class="glyphicon glyphicon-pencil"></span>&nbsp;修改密码</a></li>
			</ul>
		</div>

		<!-- 右 -->
		<div class="tab-content">
			<div class="tab-pane fade in active" id="myinfo">
				<jsp:include page="myinfo.jsp"></jsp:include>
			</div>
			<div class="tab-pane fade" id="mymessage">
				<jsp:include page="mymessage.jsp"></jsp:include>
			</div>
			
			<%-- <div class="tab-pane fade" id="mymeetting">
				<jsp:include page="mymeetting.jsp"></jsp:include>
			</div> --%>
			<%-- 
			<div class="tab-pane fade" id="askmeetting">
				<jsp:include page="askmeetting.jsp"></jsp:include>
			</div>
			 --%>
			<div class="tab-pane fade" id="releasemeetting">
				<jsp:include page="releasemeetting.jsp"></jsp:include>
			</div>
			<div class="tab-pane fade" id="askMeettingMessage">
				<jsp:include page="askMeettingMessage.jsp"></jsp:include>
			</div>
			<div class="tab-pane fade" id="updatePassword">
				<jsp:include page="updatePassword.jsp"></jsp:include>
			</div>
		</div>

	</div>

</body>
<script type="text/javascript">

	//页面加载完之后执行的操作
	$(window).load(function(){
		myInfo();
	});

	/* 将日期格式化 */
/* 	dateFormat = function(date){
		var y = date.year;
		var m = date.month + 1;
		var d = date.date;
		//判断是2000年前还是后
		if(y >= 50){
			y = 1900 + y;
		}else{
			y = 2000 + y;
		}
		var birthday = y + "-" + m + "-" + d;
		return birthday;
	} */
	

	$(function() {

		var loginId = ${sessionScope.loginId};
		//添加个人信息到myInfo.jsp中
		//查询库，将整个用户信息（除密码，返回给前台）
		myInfo = function(){
			$.ajax({
				url:"getMyPersonalInfoController",
				type:"get",
				data:{"loginId":loginId},
				success:function(e){
					var loginId = e.user.loginid;
					var userName = e.user.username;
					var sex = e.user.sex;
					var birthday = e.user.birthday;
					var tel = e.user.tel;
					var addr = e.user.addr;
					var departMent = e.user.departMent.deptname;
					$("#loginId")[0].value = loginId;
					$("#username")[0].value = userName;
					$("#sex")[0].value = sex;
					$("#birthday")[0].value = dateFormat(birthday);
					$("#tel")[0].value = tel;
					$("#addr")[0].value = addr;
					$("#deptname")[0].value = departMent;
					
				}
			});
		}
		
		var thisPage;
		//点击我的信息，查询数据库，获取我所有的信息，添加到mymessage.jsp中,如果有unread为1的，设置为未读状态
		//传入第几页，查询第几页
		mymessage = function(pagN){
			$.ajax({
				url:"getMyMessage",
				type:"get",
				data:"loginId=${sessionScope.loginId}&pageNum="+pagN,
				success:function(e){
					//将本页保存
					thisPage = e.myMessage.pageNum;
					//添加会议body信息
					addMeettingList(e);
					//添加页码信息
					addpageInfo(e,"#page_Info");
					//添加分页导航标签
					addPageNav(e,"#page_nav");
				}
			});
		}

		//点击会议申请消息，查询数据库，获取信息
		askMeettingInfo = function(pagN){
			$.ajax({
				url:"getAllAskMeettingInfo",
				type:"get",
				data:"loginId=${sessionScope.loginId}&pageNum="+pagN,
				success:function(e){
					//将本页保存
					thisPage = e.myMessage.pageNum;
					//添加会议申请body信息
					addAskMeettingMessage(e);
					//添加页码信息
					addpageInfo_askMeettingInfo(e,"#page_Info_askMeetting");
					//添加分页导航标签
					addPageNav_askMeettingInfo(e,"#page_nav_askMeetting");
				}
			});
		}

		//将查询出的会议动态添加到mymessage.jsp中
		function addMeettingList(e){
			$("#messageList tbody").empty();
			var myMessageList1 = e.myMessage.list;
			//翻转list
			var myMessageList = myMessageList1.reverse();
			//循环添加每一项会议到页面
			$.each(myMessageList,function(index,item){
				var checkBox = $("<td><input type='checkbox' class='check_item' /></td>");
				var state = $("<td></td>").append("<label></label>");
				//判断会议信息是否已读
				if(item.unread == 1){
					state.append("<span class='glyphicon glyphicon-folder-close'></span>");
				}else{
					state.append("<span class='glyphicon glyphicon-folder-open'></span>");
				}
				//发送者
				var sendUserName = $("<td></td>").append(item.meettingInfo.releaseuser);
				//会议标题
				var title = $("<td></td>").append(item.meettingInfo.title);
				//会议信息（隐藏节点）
				var meettingInfoHidden = $("<input type='hidden' value='"+item.meettingInfo.infomation+"' />");
				var meettingInfoHiddenTd = $("<td></td>").append(meettingInfoHidden);
				//会议id（隐藏id）
				var meettingIdHidden = $("<td></td>").append("<input type='hidden' value='"+item.meettingid+"' />");
				$("<tr ondblclick='entercheckinfo(this)'></tr>")
					.append(checkBox)
					.append(state)
					.append(sendUserName)
					.append(title)
					.append(meettingInfoHiddenTd)
					.append(meettingIdHidden)
					.prependTo("#messageList tbody");
				
			});
		}

		//将查询出申请的会议动态添加到askMeettingMessage.jsp中
		function addAskMeettingMessage(e){
			$("#askMeettingInfoList tbody").empty();
			var askMeettingInfoList1 = e.myMessage.list;
			//翻转list
			var askMeettingInfoList = askMeettingInfoList1.reverse();
			
			//循环添加每一项会议到页面
			$.each(askMeettingInfoList,function(index,item){
				var checkBox = $("<td><input type='checkbox' class='check_itemAskMeetting' /></td>");
				var state = $("<td></td>").append("<label></label>");
				//判断会议信息是否已读
				if(item.agree == 2){
					state.append("未处理");
				}else{
					state.append("已处理");
				}
				//发送者
				var sendUserName = $("<td></td>").append(item.askusername);
				//会议标题
				var title = $("<td></td>").append(item.title);
				//会议信息（隐藏节点）
				var meettingInfoHidden = $("<input type='hidden' value='"+item.infomation+"' />");
				var meettingInfoHiddenTd = $("<td></td>").append(meettingInfoHidden);
				//会议id（隐藏id）
				var meettingIdHidden = $("<td></td>").append("<input type='hidden' value='"+item.meettingid+"' />");
				//申请人的id（隐藏id）
				var askUserIdHidden = $("<td></td>").append("<input type='hidden' value='"+item.askuserid+"' />");
				//申请人的deptid
				var askUserDeptIdHidden = $("<td></td>").append("<input type='hidden' value='"+item.deptid+"' />");
				
				$("<tr ondblclick='entercheckAskMeeettinginfo(this)'></tr>")
					.append(checkBox)
					.append(state)
					.append(sendUserName)
					.append(title)
					.append(meettingInfoHiddenTd)
					.append(meettingIdHidden)
					.append(askUserIdHidden)
					.append(askUserDeptIdHidden)
					.prependTo("#askMeettingInfoList tbody");
				
			});
		}

		/* **********mymessage.jsp页面:完成CheckBox全选和删除*********** */
		$("#check_all").click(function(){
			$(".check_item").prop("checked",$(this).prop("checked"));
		});
		$(document).on("click",".check_item",function(){
			var flag = $(".check_item:checked").length == $(".check_item").length;
			$("#check_all").prop("checked",flag);
		});

		//批量删除
		$("#deleteMeettingInfo").click(function(){
			var meettingIds = "";
			var meettingTitles = "";
			$.each($(".check_item:checked"),function(){
				meettingTitles += $(this).parents("tr").find("td:eq(3)").text()+"-";
				meettingIds += $(this).parents("tr")[0].children[5].firstChild.defaultValue+"-";		
			});
			//去除多余的横线
			meettingTitles = meettingTitles.substring(0, meettingTitles.length -1);
			meettingIds = meettingIds.substring(0, meettingIds.length - 1);
			if(confirm("确定删除一下会议？\n"+meettingTitles)){
				$.ajax({
					url:"deleteMeetting/"+meettingIds,
					type:"DELETE",
					success:function(e){
						alert(e);
						//删除之后回到本页
						mymessage(thisPage);
					}
				});
			}
		});
		/* ********************************************************* */
		
		/* **********askMeettingMessage.jsp页面:完成CheckBox全选和删除*********** */
		$("#check_allAskMeetting").click(function(){
			$(".check_itemAskMeetting").prop("checked",$(this).prop("checked"));
		});
		$(document).on("click",".check_itemAskMeetting",function(){
			var flag = $(".check_itemAskMeetting:checked").length == $(".check_itemAskMeetting").length;
			$("#check_allAskMeetting").prop("checked",flag);
		});
		
		//只能删除已经处理过和已经通知过的会议，不能删除未处理的会议和还未通知的会议
		$("#deleteAskMeetting").click(function(){
			var meettingIds = "";
			var askMeettingTitles = "";
			$.each($(".check_itemAskMeetting:checked"),function(){
				askMeettingTitles += $(this).parents("tr").find("td:eq(3)").text()+"-";
				meettingIds += $(this).parents("tr")[0].children[5].firstChild.defaultValue+"-";		
			});
			//去除多余的横线
			askMeettingTitles = askMeettingTitles.substring(0, askMeettingTitles.length -1);
			meettingIds = meettingIds.substring(0, meettingIds.length - 1);
			if(confirm("确定删除一下会议？\n"+askMeettingTitles)){
				$.ajax({
					url:"deleteAskMeetting/"+meettingIds,
					type:"DELETE",
					success:function(e){
						if(e == "DELETEALL"){
							alert("全部删除成功");
						}else{
							alert("有一部分信息不能删除，为您保留");
						}
						//删除之后回到本页
						askMeettingInfo(thisPage);
					}
				});
			}
		});
		
		/* ********************************************************* */
	});
</script>
</html>