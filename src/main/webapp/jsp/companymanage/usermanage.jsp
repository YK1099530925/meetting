<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工管理</title>
</head>
<body>

	<!-- 员工修改的模态框 -->
	<div class="modal fade" id="userInfoUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">员工修改</h4>
	      </div>
	      <div class="modal-body">
	        <form class="form-horizontal">
	        <div class="form-group">
			    <label class="col-sm-2 control-label">登录id</label>
			    <div class="col-sm-10">
			      <input type="text" name="loginid" class="form-control" id="loginid_update_input" placeholder="登录id" disabled>
			      <span class="help-block"></span>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-2 control-label">姓名</label>
			    <div class="col-sm-10">
			      <input type="text" name="username" class="form-control" id="username_update_input" placeholder="姓名">
			      <span class="help-block"></span>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-2 control-label">性别</label>
			    <div class="col-sm-10">
			      <label class="radio-inline">
					  <input type="radio" name="sex" id="sex1_update_input" value="男" checked="checked"> 男
					</label>
					<label class="radio-inline">
					  <input type="radio" name="sex" id="sex2_update_input" value="女"> 女
					</label>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-2 control-label">出生日期</label>
			    <div class="col-sm-10">
			      <input type="text" name="birthday" class="form-control" id="birthday_update_input" placeholder="出生日期">
			      <span class="help-block"></span>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-2 control-label">联系电话</label>
			    <div class="col-sm-10">
			      <input type="text" name="tel" class="form-control" id="tel_update_input" placeholder="联系电话">
			      <span class="help-block"></span>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-2 control-label">家庭地址</label>
			    <div class="col-sm-10">
			      <input type="text" name="addr" class="form-control" id="addr_update_input" placeholder="家庭地址">
			      <span class="help-block"></span>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-2 control-label">部门</label>
			    <div class="col-sm-4">
			    	<!-- 部门提交部门id即可 -->
			      <select class="form-control" name="deptid">
			      </select>
			    </div>
			  </div>
			</form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	        <button type="button" class="btn btn-primary" id="userInfo_update_btn">更新</button>
	      </div>
	    </div>
	  </div>
	</div>

	<!-- 员工添加的模态框 -->
	<div class="modal fade" id="userInfoAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">员工添加</h4>
	      </div>
	      <div class="modal-body">
	        <form class="form-horizontal">
	        <div class="form-group">
			    <label class="col-sm-2 control-label">登录id</label>
			    <div class="col-sm-10">
			      <input type="text" name="loginid" class="form-control" id="loginid_add_input" placeholder="登录id">
			      <span class="help-block"></span>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-2 control-label">姓名</label>
			    <div class="col-sm-10">
			      <input type="text" name="username" class="form-control" id="username_add_input" placeholder="姓名">
			      <span class="help-block"></span>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-2 control-label">性别</label>
			    <div class="col-sm-10">
			      <label class="radio-inline">
					  <input type="radio" name="sex" id="sex1_add_input" value="男" checked="checked"> 男
					</label>
					<label class="radio-inline">
					  <input type="radio" name="sex" id="sex2_add_input" value="女"> 女
					</label>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-2 control-label">出生日期</label>
			    <div class="col-sm-10">
			      <input type="text" name="birthday" class="form-control" id="birthday_add_input" placeholder="出生日期">
			      <span class="help-block"></span>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-2 control-label">联系电话</label>
			    <div class="col-sm-10">
			      <input type="text" name="tel" class="form-control" id="tel_add_input" placeholder="联系电话">
			      <span class="help-block"></span>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-2 control-label">家庭地址</label>
			    <div class="col-sm-10">
			      <input type="text" name="addr" class="form-control" id="addr_add_input" placeholder="家庭地址">
			      <span class="help-block"></span>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-2 control-label">部门</label>
			    <div class="col-sm-4">
			    	<!-- 部门提交部门id即可 -->
			      <select class="form-control" name="deptid">
			      </select>
			    </div>
			  </div>
			</form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	        <button type="button" class="btn btn-primary" id="userInfo_save_btn">保存</button>
	      </div>
	    </div>
	  </div>
	</div>

	<!-- 右 -->
	<div class="body-right" id="">
		<div class="panel panel-primary">
			<div class="panel-heading">员工管理</div>
			<div class="panel-body panel-body-my">
				<!-- 接收消息体 -->
				<div class="row">
					<div class="col-md-4">
						<button class="btn btn-primary" id="user_add_modal_btn">新增</button>
						<button class="btn btn-danger" id="user_delete_all_btn">删除</button>
					</div>
				</div>
				<table class="table table-hover" id="userInfo_table">
					<thead>
						<tr>
							<th><input type="checkbox" id="check_all_user" /></th>
							<th>登录ID</th>
							<th>姓名</th>
							<th>性别</th>
							<th>出生日期</th>
							<th>电话</th>
							<th>家庭住址</th>
							<th>部门</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>

					</tbody>
				</table>
				<div class="row">
					<div id="userInfo_page_Info" class="col-md-5 col-md-offset-4"></div>
					<div id="userInfo_page_nav" class="col-md-6 col-md-offset-4">
					</div>
				</div>
			</div>
		</div>
	</div>

</body>

<script type="text/javascript">

	//定义一个本页全局变量：usermanageThispage，作用：当修改和删除某个人的时候回到当前页

	function reset_form(ele){
		$(ele)[0].reset();
	}

	//点击新增按钮弹出模态框
	$("#user_add_modal_btn").click(function(){
		//清除表单样式与数据，将表单完全重置
		reset_form("#userInfoAddModal form");
		//将部门显示在下拉列表中
		getDepts("#userInfoAddModal select");
		
		//弹出模态框
		$("#userInfoAddModal").modal({
			backdrop:"static"
		});
	});

	function getDepts(ele){
		$(ele).empty();
		$.ajax({
			url:"getDepts",
			type:"GET",
			success:function(e){
				$.each(e.depts,function(){
					var optionEle = $("<option></option>").append(this.deptname).attr("value",this.id);
					optionEle.appendTo(ele);
				});
			}
		});
	}

	//保存新增员工的信息
	$("#userInfo_save_btn").click(function(){
		//校验表单

		//保存员工的信息
		$.ajax({
			url:"saveUserInfo",
			type:"POST",
			data:$("#userInfoAddModal form").serialize(),
			success:function(e){
				//alert(e);
				//1、关闭模态框
				$("#userInfoAddModal").modal('hide');
				//2、来到新添加的员工页
				showUserInfo(1);
			}
		});
		
	});

	function getUserInfo(loginid){
		$.ajax({
			url:"getUserInfo/"+loginid,
			type:"GET",
			success:function(e){
				//alert(e);
				$("#loginid_update_input").val(e.userInfo.loginid);
				$("#username_update_input").val(e.userInfo.username);
				$("#userInfoUpdateModal input[name=sex]").val([e.userInfo.sex]);
				$("#birthday_update_input").val(dateFormat(e.userInfo.birthday));
				$("#tel_update_input").val(e.userInfo.tel);
				$("#addr_update_input").val(e.userInfo.addr);
				$("#userInfoUpdateModal select").val([e.userInfo.deptid]);
			}
		});
	}

	//创建的编辑按钮绑定click事件
	$(document).on("click",".userInfo_edit_btn",function(){
		//查询出部门信息，并显示在部门列表
		getDepts("#userInfoUpdateModal select");
		//查询出此员工的信息，显示员工信息
		getUserInfo($(this).attr("userInfo-edit-loginid"));
		//把员工的loginid传递给模态框的更新按钮
		/*注：为什么一而再再而三的将loginid传递过去，因为loginid是不能被修改的，
		在模态框中应显示为disabled，所以提交之后后台接收不到，因此只能通过参数的方式提交*/
		$("#userInfo_update_btn").attr("userInfo-edit-loginid",$(this).attr("userInfo-edit-loginid"));
		//弹出模态框
		$("#userInfoUpdateModal").modal({
			backdrop:"static"
		});
	});

	//更新员工的信息
	$("#userInfo_update_btn").click(function(){
		//校验

		//保存员工数据
		$.ajax({
			url:"updateUserInfo/"+$(this).attr("userInfo-edit-loginid"),
			type:"PUT",
			data:$("#userInfoUpdateModal form").serialize(),
			success:function(e){
				//1、关闭模态框
				$("#userInfoUpdateModal").modal('hide');
				//2、来到新添加的员工页
				showUserInfo(1);
			}
		});
	});

	$("#check_all_user").click(function(){
		$(".check_item_user").prop("checked",$(this).prop("checked"));
	});
	$(document).on("click",".check_item_user",function(){
		var flag = $(".check_item_user:checked").length == $(".check_item_user").length;
		$("#check_all_user").prop("checked",flag);
	});

	//批量删除usernames
	$("#user_delete_all_btn").click(function(){
		var loginids = "";
		var usernames = "";
		$.each($(".check_item_user:checked"),function(){
			usernames += $(this).parents("tr").find("td:eq(2)").text()+"-";
			loginids += $(this).parents("tr").find("td:eq(1)").text()+"-";		
		});
		//去除多余的横线
		usernames = usernames.substring(0, usernames.length -1);
		loginids = loginids.substring(0, loginids.length - 1);
		if(confirm("确定删除一下会议？\n"+usernames)){
			$.ajax({
				url:"deleteUser/"+loginids,
				type:"DELETE",
				success:function(e){
					alert(e);
					//删除之后回到本页
					showUserInfo(1);
				}
			});
		}
	});

	//单个删除
	$(document).on("click",".userInfo_delete_btn",function(){
		var username = $(this).parents("tr").find("td:eq(2)").text();
		var loginid = $(this).attr("userInfo-del-loginid");
		if(confirm("确定删除一下会议？\n"+username)){
			$.ajax({
				url:"deleteUser/"+ loginid,
				type:"DELETE",
				success:function(e){
					alert(e);
					//删除之后回到本页
					showUserInfo(1);
				}
			});
		}
		
	});

	//密码重置
	$(document).on("click",".userInfo_rePassword_btn",function(){
		var loginid = $(this).attr("userInfo-rePassword-btn-loginid");
		$.ajax({
			url:"rePassword",
			type:"post",
			data:{"loginid":loginid},
			success:function(e){
				alert("密码已重置");
			}
		});
	});

</script>

</html>