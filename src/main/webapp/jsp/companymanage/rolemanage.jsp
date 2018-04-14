<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色权限管理</title>
</head>
<body>
	
	<!-- 向角色中添加用户的模态框 -->
	<div class="modal fade" id="userPlusBtnModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">用户+</h4>
	      </div>
	      <div class="modal-body">
	        <table class="table table-hover" id="userRolePlusInfo_table">
				<tbody>
	
				</tbody>
				</table>
		      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	        <button type="button" class="btn btn-primary" id="userAddRole_btn">添加</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<!-- 从角色中删除用户的操作 -->
	<div class="modal fade" id="userMinusBtnModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">用户-</h4>
	      </div>
	      <div class="modal-body">
	        <table class="table table-hover" id="userRoleMinusInfo_table">
				<tbody>
	
				</tbody>
				</table>
		      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	        <button type="button" class="btn btn-primary" id="userMinusRole_btn">删除</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<!-- 添加权限 -->
	<div class="modal fade" id="permissionPlusBtnModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">权限+</h4>
	      </div>
	      <div class="modal-body">
	        <table class="table table-hover" id="permissionPlusInfo_table">
				<tbody>
	
				</tbody>
				</table>
		      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	        <button type="button" class="btn btn-primary" id="permissionPlusRole_btn">添加</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<div class="body-right" id="">
		<div class="panel panel-primary">
			<div class="panel-heading">角色权限管理</div>
			<div class="panel-body panel-body-my">
				<div class="row">
					<div class="col-md-4">
						<button class="btn btn-primary" id="role_add_modal_btn">新增</button>
						<button class="btn btn-danger" id="role_delete_all_btn">删除</button>
					</div>
				</div>
				<table class="table table-hover" id="roleInfo_table">
					<thead>
						<tr>
							<th>id</th>
							<th>角色</th>
							<th>用户操作</th>
							<th>权限操作</th>
						</tr>
					</thead>
					<tbody>

					</tbody>
				</table>
				<div class="row">
					<div id="roleInfo_page_Info" class="col-md-5 col-md-offset-4"></div>
					<div id="roleInfo_page_nav" class="col-md-6 col-md-offset-4">
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

<script type="text/javascript">

//向角色中添加用户的操作
$(document).on("click",".userPlusBtn",function(){

	//获取当前行的roleid
	var roleid = $(this).parents("tr")[0].children[0].innerHTML;
	//给模态框的添加按钮添加属性，设置为roleid
	$("#userAddRole_btn").attr("userRole-roleid",roleid);

	//查询用户
	role_getUserInfoPlus(1,"#userRolePlusInfo_table tbody");

	//弹出模态框
	$("#userPlusBtnModal").modal({
		backdrop:"static"
	});
});

//查询用户，用于为其添加角色
function role_getUserInfoPlus(pageNum,ele_table){

	//清空模态框的信息
	$(ele_table).empty();
	
	//点击用户+，查找用户，并将用户的id给checkbox
	$.ajax({
		url:"getUserRoleInfo",
		type:"GET",
		data:"pageNum="+pageNum,
		success:function(e){
			//将用户添加到模态框
			var userMyMessageList = e.myMessage.list.reverse();
			//每一行添加8个人
			var userRole = $("<tr></tr>");
			//每一行添加人数的计数单位
			var count = 0;
			$.each(userMyMessageList,function(index,item){
				count++;
				var checkBox = $("<input type='checkbox' class='check_item_userRolePlus' />");
				var usernameTd = $("<td></td>").append(checkBox).append(item.username);
				//将loginid设置为checkbox的属性
				checkBox.attr("checkBox-lgoinid",item.loginid);
				userRole.append(usernameTd);
				if(count == 4){
					userRole.prependTo(ele_table);
					count = 0;
					userRole = $("<tr></tr>");
				}
			});
			//如果还剩下几个未添加，则直接在最末添加
			userRole.prependTo(ele_table);
			//添加上下页按钮
			var userRolePreBtn = $("<button></button>").addClass("btn btn-danger btn-sm").append("上一页");
			var userRoleNextBtn = $("<button></button>").addClass("btn btn-danger btn-sm").append("下一页");
			var preBtnTd = $("<td></td>").append(userRolePreBtn);
			var NextBtnTd = $("<td></td>").append(userRoleNextBtn);
			//判断是否有上页
			if(e.myMessage.hasPreviousPage == false){
				userRolePreBtn.addClass("disabled");
			}else{
				userRolePreBtn.click(function() {
					role_getUserInfoPlus(e.myMessage.pageNum - 1,"#userRolePlusInfo_table tbody");
				});
			}
			//判断是否有下页
			if(e.myMessage.hasNextPage == false){
				userRoleNextBtn.addClass("disabled");
			}else{
				userRoleNextBtn.click(function(){
					role_getUserInfoPlus(e.myMessage.pageNum + 1,"#userRolePlusInfo_table tbody");
				});
			}
			$("<tr></tr>")
			.append(preBtnTd)
			.append(NextBtnTd)
			.appendTo(ele_table);
		}
	});
}

//为某个或多个用户添加角色（需要用户的loginId和知道要添加到那个角色）
$("#userAddRole_btn").click(function(){
	//获取用户的loginid和当前角色id
	
	var roleid = $(this).attr("userRole-roleid");
	
	var loginids = "";
	var usernames = "";
	
	//遍历被选中的CheckBox
	$.each($(".check_item_userRolePlus:checked"),function(){
		//$(this).attr("checkBox-lgoinid")
		loginids += $(this).attr("checkBox-lgoinid") + "-";
		usernames += $(this)[0].nextSibling.data + "-";
	});
	//去掉多余的横线
	loginids = loginids.substring(0, loginids.length - 1);
	usernames = usernames.substring(0, usernames.length - 1);
	//发送请求将选中的用户设置为对应角色
	if(confirm("确定将以下用户添加到此角色？\n"+usernames)){
		$.ajax({
			url:"addUserRole",
			type:"POST",
			data:{"loginids":loginids,"roleid":roleid},
			success:function(e){
				alert("添加成功");
				$("#userPlusBtnModal").modal('hide');
			}
		});
	}
});

/**********************************************************************/
//从角色中删除用户的操作
$(document).on("click",".userMinusBtn",function(){
	//获取当前行的roleid
	var roleid = $(this).parents("tr")[0].children[0].innerHTML;
	//给模态框的添加按钮添加属性，设置为roleid
	$("#userMinusRole_btn").attr("userRole-roleid",roleid);

	//查询用户的角色添加到模态框
	role_getUserInfoMinus(1,"#userRoleMinusInfo_table tbody",roleid);

	//弹出模态框
	$("#userMinusBtnModal").modal({
		backdrop:"static"
	});
});

function role_getUserInfoMinus(pageNum,ele_table,roleid){

	//清空模态框的信息
	$(ele_table).empty();
	
	//查询有此角色的用户，添加到模态框
	$.ajax({
		url:"getHasRoleUser",
		type:"GET",
		data:{"pageNum":pageNum,"roleid":roleid},
		success:function(e){
			//将用户添加到模态框
			var userMyMessageList = e.myMessage.list.reverse();
			//每一行添加4个人
			var userRole = $("<tr></tr>");
			//每一行添加人数的计数单位
			var count = 0;
			$.each(userMyMessageList,function(index,item){
				count++;
				var checkBox = $("<input type='checkbox' class='check_item_userRoleMinus' />");
				var usernameTd = $("<td></td>").append(checkBox).append(item.username);
				//将loginid设置为checkbox的属性
				checkBox.attr("checkBox-lgoinid",item.loginid);
				userRole.append(usernameTd);
				if(count == 4){
					userRole.prependTo(ele_table);
					count = 0;
					userRole = $("<tr></tr>");
				}
			});
			//如果还剩下几个未添加，则直接在最末添加
			userRole.prependTo(ele_table);
			//添加上下页按钮
			var userRolePreBtn = $("<button></button>").addClass("btn btn-danger btn-sm").append("上一页");
			var userRoleNextBtn = $("<button></button>").addClass("btn btn-danger btn-sm").append("下一页");
			var preBtnTd = $("<td></td>").append(userRolePreBtn);
			var NextBtnTd = $("<td></td>").append(userRoleNextBtn);
			//判断是否有上页
			if(e.myMessage.hasPreviousPage == false){
				userRolePreBtn.addClass("disabled");
			}else{
				userRolePreBtn.click(function() {
					role_getUserInfoMinus(e.myMessage.pageNum - 1,"#userRoleMinusInfo_table tbody",roleid);
				});
			}
			//判断是否有下页
			if(e.myMessage.hasNextPage == false){
				userRoleNextBtn.addClass("disabled");
			}else{
				userRoleNextBtn.click(function(){
					role_getUserInfoMinus(e.myMessage.pageNum + 1,"#userRoleMinusInfo_table tbody",roleid);
				});
			}
			$("<tr></tr>")
			.append(preBtnTd)
			.append(NextBtnTd)
			.appendTo(ele_table);
		}
	});
}

//从某个角色中删除一个或多个用户
$("#userMinusRole_btn").click(function(){
	//获取用户的loginid和当前角色id
	var roleid = $(this).attr("userRole-roleid");
	
	var loginids = "";
	var usernames = "";
	
	//遍历被选中的CheckBox
	$.each($(".check_item_userRoleMinus:checked"),function(){
		//$(this).attr("checkBox-lgoinid")
		loginids += $(this).attr("checkBox-lgoinid") + "-";
		usernames += $(this)[0].nextSibling.data + "-";
	});
	//去掉多余的横线
	loginids = loginids.substring(0, loginids.length - 1);
	usernames = usernames.substring(0, usernames.length - 1);
	//发送请求将选中的用户设置为对应角色
	if(confirm("确定从此角色中删除以下用户？\n"+usernames)){
		$.ajax({
			url:"deleteUserRole/"+loginids+"/"+roleid,
			type:"DELETE",
			success:function(e){
				alert("删除成功");
				$("#userMinusBtnModal").modal('hide');
			}
		});
	}
});

/**********************************************************************/

//权限+
$(document).on("click",".permissionPlusBtn",function(){
	//获取当前行的roleid，因为给按钮添加了属性赋予了roleid，因此取此属性即可
	//var roleid = $(this).parents("tr")[0].children[0].innerHTML;
	var roleid = $(this).attr("permissionPlusBtn-id");
	//给模态框的添加按钮添加属性，设置为roleid
	$("#permissionPlusRole_btn").attr("permissionRole-roleid",roleid);

	//查询用户的角色添加到模态框
	role_getPermissionInfoMinus(1,"#permissionPlusInfo_table tbody",roleid);

	//弹出模态框
	$("#permissionPlusBtnModal").modal({
		backdrop:"static"
	});
});

function role_getPermissionInfoMinus(pageNum,ele_table,roleid){
	//清空模态框的信息
	$(ele_table).empty();

	//发送请求获取权限信息
	$.ajax({
		url:"getPermissionRole",
		type:"GET",
		data:{"pageNum":pageNum},
		success:function(e){
			//将用户添加到模态框
			var userMyMessageList = e.myMessage.list.reverse();
			//每一行添加4个人
			var permissionRole = $("<tr></tr>");
			//每一行添加人数的计数单位
			var count = 0;
			$.each(userMyMessageList,function(index,item){
				count++;
				var checkBox = $("<input type='checkbox' class='check_item_permissionPlus' />");
				var usernameTd = $("<td></td>").append(checkBox).append(item.permissionname);
				//将loginid设置为checkbox的属性
				checkBox.attr("checkBox-permissionid",item.id);
				permissionRole.append(usernameTd);
				if(count == 4){
					permissionRole.prependTo(ele_table);
					count = 0;
					permissionRole = $("<tr></tr>");
				}
			});
			//如果还剩下几个未添加，则直接在最末添加
			permissionRole.prependTo(ele_table);
			//添加上下页按钮
			var permissionRolePreBtn = $("<button></button>").addClass("btn btn-danger btn-sm").append("上一页");
			var permissionRoleNextBtn = $("<button></button>").addClass("btn btn-danger btn-sm").append("下一页");
			var preBtnTd = $("<td></td>").append(permissionRolePreBtn);
			var NextBtnTd = $("<td></td>").append(permissionRoleNextBtn);
			//判断是否有上页
			if(e.myMessage.hasPreviousPage == false){
				permissionRolePreBtn.addClass("disabled");
			}else{
				userRolePreBtn.click(function() {
					role_getPermissionInfoMinus(e.myMessage.pageNum - 1,"#permissionPlusInfo_table tbody",roleid);
				});
			}
			//判断是否有下页
			if(e.myMessage.hasNextPage == false){
				permissionRoleNextBtn.addClass("disabled");
			}else{
				userRoleNextBtn.click(function(){
					role_getPermissionInfoMinus(e.myMessage.pageNum + 1,"#permissionPlusInfo_table tbody",roleid);
				});
			}
			$("<tr></tr>")
			.append(preBtnTd)
			.append(NextBtnTd)
			.appendTo(ele_table);
		}
	});
}

$("#permissionPlusRole_btn").click(function(){
	
	//获取用户的loginid和当前角色id
	
	var roleid = $(this).attr("permissionRole-roleid");
	
	var permissionids = "";
	var permissionnames = "";
	
	//遍历被选中的CheckBox
	$.each($(".check_item_permissionPlus:checked"),function(){
		//$(this).attr("checkBox-lgoinid")
		permissionids += $(this).attr("checkBox-permissionid") + "-";
		permissionnames += $(this)[0].nextSibling.data + "-";
	});
	//去掉多余的横线
	permissionids = permissionids.substring(0, permissionids.length - 1);
	permissionnames = permissionnames.substring(0, permissionnames.length - 1);
	//发送请求，向角色中添加权限
	if(confirm("确定将以下权限添加到此角色？\n"+permissionnames)){
		$.ajax({
			url:"addPermissionRole",
			type:"POST",
			data:{"permissionids":permissionids,"roleid":roleid},
			success:function(e){
				alert("添加成功");
				$("#permissionPlusBtnModal").modal('hide');
			}
		});
	}
});



</script>

</html>