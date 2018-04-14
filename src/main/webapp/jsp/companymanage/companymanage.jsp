<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公司管理</title>
</head>
<body>
	<!-- 员工管理
		  部门管理
		  角色权限管理
		  密码管理  -->
	
	<div class="body row">
		<!-- 左 -->
		<div class="body-left">
			<ul class="nav nav-pills nav-stacked nav-tabs">
				<li id="usermanageLi" class="active"><a class="text-muted" onclick="showUserInfo(1)" href="#usermanage" data-toggle="tab"><span
						class="glyphicon glyphicon-user"></span>&nbsp;员工管理</a></li>
				<li id="deptmanageLi" class=""><a class="text-muted" onclick="showDeptInfo(1)" href="#deptmanage" data-toggle="tab"><span
						class="glyphicon glyphicon-comment"></span>&nbsp;部门管理</a></li>
				<li id="rolemanageLi" class=""><a class="text-muted" onclick="showRoleInfo(1)" href="#rolemanage" data-toggle="tab"><span
						class="glyphicon glyphicon-list-alt"></span>&nbsp;角色权限管理</a></li>
			</ul>
		</div>

		<!-- 右 -->
		<div class="tab-content">
			<div class="tab-pane fade in active" id="usermanage">
				<jsp:include page="usermanage.jsp"></jsp:include>
			</div>
			<div class="tab-pane fade" id="deptmanage">
				<jsp:include page="deptmanage.jsp"></jsp:include>
			</div>
			<div class="tab-pane fade" id="rolemanage">
				<jsp:include page="rolemanage.jsp"></jsp:include>
			</div>
		</div>

	</div>
</body>

<script type="text/javascript">

	//页面加载完之后执行的操作
	$(window).load(function(){
		showUserInfo(1);
	});

	//显示员工信息
	showUserInfo = function(pagN){
		$.ajax({
			url:"usermanage",
			type:"get",
			data:"pageNum="+pagN,
			success:function(e){
				//添加员工信息到usermanage.jsp的表格中
				addUserInfo(e);
				//添加页码信息
				addpageInfo_usermanage(e,"#userInfo_page_Info");
				//添加分页导航标签
				addPageNav_usermanage(e,"#userInfo_page_nav");
			}
		});
	}

	addUserInfo = function(e){
		//清空table表格
		$("#userInfo_table tbody").empty();
		var userMyMessageList = e.myMessage.list.reverse();
		$.each(userMyMessageList,function(index,item){
			var checkBox = $("<td><input type='checkbox' class='check_item_user' /></td>");
			var loginId = $("<td></td>").append(item.loginid);
			var username = $("<td></td>").append(item.username);
			var sex = $("<td></td>").append(item.sex);
			var birthday = $("<td></td>").append(dateFormat(item.birthday));
			var tel = $("<td></td>").append(item.tel);
			var addr = $("<td></td>").append(item.addr);
			var deptname = $("<td></td>").append(item.departMent.deptname);
			var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm userInfo_edit_btn")
						.append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
			//为编辑按钮添加一个自定义的属性，来表示当前员工loginid
			editBtn.attr("userInfo-edit-loginid",item.loginid);
			var delBtn =  $("<button></button>").addClass("btn btn-danger btn-sm userInfo_delete_btn")
						.append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
			//为删除按钮添加一个自定义的属性来表示当前删除的员工id
			delBtn.attr("userInfo-del-loginid",item.loginid);
			//重置密码按钮
			var rePasswordBtn =  $("<button></button>").addClass("btn btn-danger btn-sm userInfo_rePassword_btn")
			.append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("密码重置");
			//为重置密码按钮添加一个自定义属性表示当前员工的登录id
			rePasswordBtn.attr("userInfo-rePassword-btn-loginid",item.loginid);
			var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn).append(" ").append(rePasswordBtn);			
			$("<tr ondblclick=''></tr>")
				.append(checkBox)
				.append(loginId)
				.append(username)
				.append(sex)
				.append(birthday)
				.append(tel)
				.append(addr)
				.append(deptname)
				.append(btnTd)
				.prependTo("#userInfo_table tbody");
		});
	}

	//显示部门信息
	showDeptInfo = function(pagN){
		$.ajax({
			url:"deptmanage",
			type:"get",
			data:"pageNum="+pagN,
			success:function(e){
				//添加员工信息到usermanage.jsp的表格中
				addDeptInfo(e);
				//添加页码信息
				addpageInfo_deptmanage(e,"#deptInfo_page_Info");
				//添加分页导航标签
				addPageNav_deptmanage(e,"#deptInfo_page_nav");
			}
		});
	}

	addDeptInfo = function(e){
		$("#deptInfo_table tbody").empty();
		var deptUserNum = e.deptUserNum
		var deptMyMessageList = e.myMessage.list.reverse();
		$.each(deptMyMessageList,function(index,item){
			var checkBox = $("<td><input type='checkbox' class='check_item_dept' /></td>");
			var id = $("<td></td>").append(item.id);
			var deptname = $("<td></td>").append(item.deptname);
			var depttel = $("<td></td>").append(item.depttel);
			//部门人数
			var num;
			for(var key in deptUserNum){
				if(key == item.id){
					num = $("<td></td>").append(deptUserNum[key]+"人");
				}
			}
			var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm deptInfo_edit_btn")
						.append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
			var delBtn =  $("<button></button>").addClass("btn btn-danger btn-sm deptInfo_delete_btn")
						.append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
			var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn);
			$("<tr ondblclick=''></tr>")
			.append(checkBox)
			.append(id)
			.append(deptname)
			.append(depttel)
			.append(num)
			.append(btnTd)
			.prependTo("#deptInfo_table tbody");
		});
	}

	//显示角色信息
	showRoleInfo = function(pagN){
		$.ajax({
			url:"rolepermissionmanage",
			type:"get",
			data:"pageNum="+pagN,
			success:function(e){
				//添加员工信息到usermanage.jsp的表格中
				addRoleInfo(e);
				//添加页码信息
				//addpageInfo_Rolemanage(e,"#RoleInfo_page_Info");
				//添加分页导航标签
				//addPageNav_Rolemanage(e,"#RoleInfo_page_nav");
			}
		});
	}

	addRoleInfo = function(e){
		$("#roleInfo_table tbody").empty();
		var roleMyMessageList = e.myMessage.list.reverse();
		$.each(roleMyMessageList,function(index,item){
			var id = $("<td></td>").append(item.id);
			var discrib = $("<td></td>").append(item.describ);
			var permissionPlusBtn = $("<button></button>").addClass("btn btn-primary btn-sm permissionPlusBtn")
				.append($("<span></span>").addClass("glyphicon glyphicon-plus"));
			//给这些按钮一个这个角色的id标识
			permissionPlusBtn.attr("permissionPlusBtn-id",item.id);
			var permissionMinusBtn = $("<button></button>").addClass("btn btn-danger btn-sm permissionMinusBtn")
				.append($("<span></span>").addClass("glyphicon glyphicon-minus"));
			permissionPlusBtn.attr("permissionPlusBtn-id",item.id);
			var permissionBtnTd = $("<td></td>").append(permissionPlusBtn).append(" ").append(permissionMinusBtn);
			var userPlusBtn = $("<button></button>").addClass("btn btn-primary btn-sm userPlusBtn")
				.append($("<span></span>").addClass("glyphicon glyphicon-plus"));
			userPlusBtn.attr("userPlusBtn-id",item.id);
			var userMinusBtn = $("<button></button>").addClass("btn btn-danger btn-sm userMinusBtn")
				.append($("<span></span>").addClass("glyphicon glyphicon-minus"));
			userMinusBtn.attr("userMinusBtn-id",item.id);
			var userBtnTd = $("<td></td>").append(userPlusBtn).append(" ").append(userMinusBtn);
			//checkBth未加
			var checkBtn = $("<button></button>").addClass("btn btn-primary btn-sm").append("查看");
			$("<tr ondblclick=''></tr>")
			.append(id)
			.append(discrib)
			.append(userBtnTd)
			.append(permissionBtnTd)
			.prependTo("#roleInfo_table tbody");
		});
	}

</script>

</html>