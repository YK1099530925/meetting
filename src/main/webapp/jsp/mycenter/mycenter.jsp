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
				<li id="myinfoLi" class=""><a class="text-muted" href="#myinfo" data-toggle="tab"><span
						class="glyphicon glyphicon-user"></span>&nbsp;个人信息</a></li>
				<li id="mymessageLi" class=""><a class="text-muted" onclick="mymessage(1)" href="#mymessage" data-toggle="tab"><span
						class="glyphicon glyphicon-comment"></span>&nbsp;我的消息</a></li>
				<li id="mymeettingLi" class=""><a class="text-muted" href="#mymeetting" data-toggle="tab"><span
						class="glyphicon glyphicon-list-alt"></span>&nbsp;我的会议</a></li>
				<li id="askmeettingLi" class=""><a class="text-muted" href="#askmeetting" data-toggle="tab"><span
						class="glyphicon glyphicon-pencil"></span>&nbsp;申请会议</a></li>
				<li id="releasemeettingLi" class="active"><a class="text-muted"
					href="#releasemeetting" data-toggle="tab"><span
						class="glyphicon glyphicon-pencil"></span>&nbsp;发布会议</a></li>
				<shiro:hasPermission name="user:*">
					<li id="askMeettingMessageLi" class=""><a class="text-muted" onclick="askMeettingInfo(1)" href="#askMeettingMessage"
						data-toggle="tab"><span class="glyphicon glyphicon-pencil"></span>&nbsp;会议申请消息</a></li>
				</shiro:hasPermission>
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
			<div class="tab-pane fade" id="askMeettingMessage">
				<jsp:include page="askMeettingMessage.jsp"></jsp:include>
			</div>
		</div>

	</div>

</body>
<script type="text/javascript">
	$(function() {
		var thisPage;
		//点击我的信息，查询数据库，获取我所有的信息，添加到mymessage.jsp中,如果有unread为1的，设置为未读状态
		//传入第几页，查询第几页
		mymessage = function(pagN){
			$.ajax({
				url:"getMyMessage",
				type:"get",
				data:"loginId=${sessionScope.loginId}&pageNum="+pagN,
				success:function(e){
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
					//添加会议申请body信息
					addAskMeettingMessage(e);
					//添加页码信息
					addpageInfo(e,"#page_Info_askMeetting");
					//添加分页导航标签
					addPageNav(e,"#page_nav_askMeetting");
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

		//将查询出的会议动态添加到askMeettingMessage.jsp中
		function addAskMeettingMessage(e){
			$("#askMeettingInfoList tbody").empty();
			var askMeettingInfoList1 = e.myMessage.list;
			//翻转list
			var askMeettingInfoList = askMeettingInfoList1.reverse();
			
			//循环添加每一项会议到页面
			$.each(askMeettingInfoList,function(index,item){
				var checkBox = $("<td><input type='checkbox' class='check_item' /></td>");
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

		//添加页码信息
		function addpageInfo(e,page_Info){
			$(page_Info).empty();
			$(page_Info).append("当前第 "+e.myMessage.pageNum+" 页,总共 "
					+e.myMessage.pages+" 页,总共 "
					+e.myMessage.total+" 记录");
			//将本页保存
			thisPage = e.myMessage.pageNum;
		}

		//添加分页导航标签
		function addPageNav(e,page_nav){
			//添加翻页导航栏
			$(page_nav).empty();
			var ul = $("<ul></ul>").addClass("pagination");
			var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
			var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
			//判断是否有前一页
			if(e.myMessage.hasPreviousPage == false){
				firstPageLi.addClass("disabled");
				prePageLi.addClass("disabled");
			}else{
				prePageLi.click(function() {
					mymessage(e.myMessage.pageNum - 1);
				});
				firstPageLi.click(function(){
					mymessage(1);
				});
			}
			var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
			var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
			//判断是否有后一页
			if(e.myMessage.hasNextPage == false){
				nextPageLi.addClass("disabled");
				lastPageLi.addClass("disabled");
			}else{
				nextPageLi.click(function(){
					mymessage(e.myMessage.pageNum + 1);
				});
				lastPageLi.click(function(){
					mymessage(e.myMessage.pages);
				});
			}
			ul.append(firstPageLi).append(prePageLi);
			/* 中间添加页码数 */
			//循环添加li
			var navNum = e.myMessage.navigatepageNums;
			$.each(navNum,function(indexNav,itemNav){
				var numLi = $("<li></li>").append($("<a></a>").append(itemNav));
				if(e.myMessage.pageNum == itemNav){
					numLi.addClass("active");
				}
				numLi.click(function(){
					mymessage(itemNav);
				});
				ul.append(numLi);
			}); 
			ul.append(nextPageLi).append(lastPageLi);

			var navEle = $("<nav></nav>").append(ul);
			navEle.appendTo(page_nav);
		}

		//完成全选
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
	});
</script>
</html>