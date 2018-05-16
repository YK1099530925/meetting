<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<style type="text/css">
.seat{
	width:10px;
	height:30px;
	border: 1px solid black;
}
</style>
</head>

<body>
	<!-- 查看信息 -->
	<div class="body-right" id="checkinfoback">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<a style="color: white;" id="backmymessage"><span class="glyphicon glyphicon-chevron-left"></span>返回</a>
			</div>
			<div class="panel-body panel-body-my">
				<div class="input-group  col-md-5">
					<span class="input-group-addon" >发送者：</span> <input
						id="senduserName" type="text" class="form-control" placeholder="Username"
						aria-describedby="senduserName" value="" disabled>
				</div>
				<br>
				<div class="input-group  col-md-5">
					<span class="input-group-addon">&nbsp; 主 题：</span> <input
						id="sendtheme" type="text" class="form-control" placeholder="title"
						aria-describedby="senduserName" value="" disabled>
				</div>
				<br>
				<div class="input-group col-md-10">
					<label class="sr-only" for="inputHelpBlock"></label>
					<textarea id="sendMeettingInfo" class="form-control" rows="10" cols="100"
						disabled="disabled"></textarea>
				</div>
				<br>
				<div class="input-group col-md-10">
					<!-- 文件下载，label显示文件名，a标签href为真实路径 -->
					<label id="filenameLabel"></label>
					<a id="downloadFile" class="btn btn-default btn-sm" download>下载</a>
				</div>
				<br>
				<div class="input-group">
					<div class=" col-md-2">
						<a id="chooseSeatBtn" class="btn btn-default">选座</a>
					</div>
					<div class="col-md-offset-3 col-md-2">
						<a id="" class="btn btn-default">自评</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="chooseSeatModal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<!-- 头 -->
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">选择位置</h4>
				</div>
				<!-- 身体 -->
				<div class="modal-body">
					<div class="row">
						<div id="seat1" class="btn btn-default seat col-md-1 col-md-offset-4"></div>
						<div id="seat2" class="btn btn-default seat col-md-1 col-md-offset-1"></div>
						<div id="seat3" class="btn btn-default seat col-md-1 col-md-offset-1"></div>
						<div id="seat4" class="btn btn-default seat col-md-1 col-md-offset-1"></div>
					</div>
				
					<div class="row">
						<a id="seat0" class="btn btn-default seat col-md-1 col-md-offset-3"></a>
						<a id="seat5" class="btn btn-default seat col-md-1 col-md-offset-6"></a>
					</div>
					<br>
					<div class="row">
						<div id="seat9" class="btn btn-default seat col-md-1 col-md-offset-4"></div>
						<div id="seat8" class="btn btn-default seat col-md-1 col-md-offset-1"></div>
						<div id="seat7" class="btn btn-default seat col-md-1 col-md-offset-1"></div>
						<div id="seat6" class="btn btn-default seat col-md-1 col-md-offset-1"></div>
					</div>
				</div>
				<!-- 尾 -->
				<div class="modal-footer">
					<button type="button"
						class="btn btn-default" data-dismiss="modal">关闭</button>
					<button id="chooseSeatConfirmButton" type="button"
						class="btn btn-default" data-dismiss="modal">确定</button>
				</div>
			</div>
		</div>
	</div>
	
</body>
<script type="text/javascript">
	$(function(){
		$("#backmymessage").click(function(){
			/* 当点击返回的时候，将他透明度设置为0，然后将上一个透明度设置为1 */
			//document.getElementById("checkinfoback").style.opacity=0;
			document.getElementById("myunreadmessage").style.zIndex = 1;
			document.getElementById("checkinfoback").style.zIndex = -1;
		});
	});

	//点击选座，显示座位信息，通过meettingid查找数据库，将对应有值的元素设置为红色按钮
	$("#chooseSeatBtn").click(function(){
		//给chooseSeatConfirmButton按钮设置两个属性，oldSeat（原位置）和newSeat（现在新选的位置），
		//点击选座按钮时，先将newSeat设置为空，防止选了座位，但是没有提交，然后再次点击提交引发的问题
		$("#chooseSeatConfirmButton").attr("newSeat","");
		//通过meettingid获取会议位置信息
		var meettingid = $(this).attr("meettingid");
		$.ajax({
			url:"getMeettingRoomInfo",
			type:"GET",
			data:{"meettingid":meettingid},
			success:function(e){
				var count = 0;
				//key是seat属性（位置），val是loginid（seat的值）
				jQuery.each(e, function(key, val) {  
					//e中第一个（0位置）位置是meettingid，因此第一次直接跳过，不进行操作
					var loginid = ${sessionScope.loginId};
					var seatx = "#" + key;
					//count!=0就代表去掉了meettingid这个属性的位置
					if(count != 0){
						//接下来从seat0开始
						if(val != 0){
							//如果是本人开始选择的座位，则将原座位设置为chooseSeatConfirmButton的oldSeat属性
							if(loginid == val){
								$("#chooseSeatConfirmButton").attr("oldSeat",key);
							}
							//将按钮变为红色，并设置其loginid属性，并将其变为不可点击
							//$(seatx).toggleClass("btn-danger");
							$(seatx).addClass("btn-danger");
							$(seatx).attr("loginid",val);
							$(seatx).attr("disabled");
						}else{
							//将没有被选择的座位设置loginid为0
							$(seatx).attr("loginid",0);
							//当选择位置后，并未确定，直接关闭，则将其复原
							if($(seatx).hasClass('btn-danger')){
								$(seatx).toggleClass("btn-danger");
							}
						}
					}
					count++;
				});
			}
		});
		//弹出模态框
		$("#chooseSeatModal").modal({
			backdrop:"static"
		});
	});

	//点击按钮变红，再次点击变白(toggleClass:若有此类，则移除，若没有则添加)
	$(".seat").click(function(){
		//点击每一个座位的时候判断，是否已经选过一个位置，如果是，请重新选择
		//1.如果是白色（还未被选座），则判断是否已经选过位置
		if(!($(this).hasClass('btn-danger'))){
			var chooseSeatCount = 0;
			var sessionScopeLoginid = ${sessionScope.loginId};
			$.each($(".seat"),function(){
				if($(this).attr("loginid") == sessionScopeLoginid){
					chooseSeatCount++;
				}
			});
			if(chooseSeatCount == 1){
				alert("你已经选择一个位置，若需重新选择，则取消之前的选择");
				return;
			}
		}
		var loginid = $(this).attr("loginid");
		var sessionLoginid = ${sessionScope.loginId};
		//2.如果点击的按钮式红色（即loginid不为0），并且不是自己的选的作为，就不做操作
		if(loginid != 0 && loginid != sessionLoginid){
			return;
		}
		//3.如果是红色就变白，如果是白酒变红
		$(this).toggleClass("btn-danger");
		//按下按钮，变为红色，添加属性loginid，并给chooseSeatConfirmButton添加newSeat属性，否则删除属性loginid
		if($(this).hasClass('btn-danger')){
			//给chooseSeatConfirmButton按钮添加newSeat属性
			$("#chooseSeatConfirmButton").attr("newSeat",this.id);
			$(this).attr("loginid",sessionLoginid);
		}else{
			$("#chooseSeatConfirmButton").attr("newSeat","");
			$(this).removeAttr("loginid");
		}
	});

	//确定位置(如何找到用户选择的位置)
	$("#chooseSeatConfirmButton").click(function(){

		//不用遍历选择的位置了，直接通过chooseSeatConfirmButton按钮的新旧位置属性，变可以完成位置的修改
		var newSeat = $(this).attr("newSeat");
		var oldSeat = $(this).attr("oldSeat");
		if(newSeat == ""){
			alert("你没有换位置");
			return;
		}
		//判断位置有没有选择，如果选择了，就发送ajax 请求
		var meettingid = $("#chooseSeatBtn").attr("meettingid");
		var loginid = ${sessionScope.loginId};
		$.ajax({
			url:"chooseSeat",
			type:"POST",
			data:{"meettingid":meettingid,"loginid":loginid,"oldSeat":oldSeat,"newSeat":newSeat},
			success:function(e){
				alert("选座成功");
			}
		});
		//遍历被选择的位置（找到loginid为sessionloginid的位置）
/* 		$.each($(".seat"),function(){
			var meettingid = $("#chooseSeatBtn").attr("meettingid");
			var loginid = $(this).attr("loginid");
			var sessionLoginid = ${sessionScope.loginId};
			if(loginid == sessionLoginid){
				//将用户保存到此位置
				$.ajax({
					url:"chooseSeat",
					type:"POST",
					data:{"meettingid":meettingid,"loginid":loginid,"seat":this.id},
					success:function(e){
						alert("选择成功");
					}
				});
			}
		}); */
	});
	
</script>
</html>