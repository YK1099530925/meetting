<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>markdown编辑页面</title>
<%
	pageContext.setAttribute("Path", request.getContextPath());
%>

<style type="text/css">
#editor_submit_button{
                display:block;
                margin-left: 42%;
                margin-top: 2em;
                margin-bottom: 2em;
            }
</style>

</head>
<body>
	
	<br>
	<div class="input-group  col-md-5 col-md-offset-1">
		<span class="input-group-addon">新闻标题：</span> <input type="text" id="newstitle"
			 class="form-control" placeholder="newstitle" value="">
	</div>
	<br>
	
	<div class="editormd" id="test-editormd">
	  <textarea class="editormd-markdown-textarea" id="markdown-code" name="test-editormd-markdown-doc"></textarea>
	  <!-- 第二个隐藏文本域，用来构造生成的HTML代码，方便表单POST提交，这里的name可以任意取，后台接受时以这个name键为准 -->
	  <textarea class="editormd-html-textarea" id="html-code" name="text"></textarea>
	</div>
	
	 <button class="btn btn-default" id="editor_submit_button">确认提交</button>
</body>

<script type="text/javascript">

$(function() {
    editormd("test-editormd", {
        width   : "90%",
        height  : 640,
        syncScrolling : "single",
        //你的lib目录的路径，我这边用JSP做测试的
        path    : "${Path }/js/editormd/lib/",
        //这个配置在simple.html中并没有，但是为了能够提交表单，使用这个配置可以让构造出来的HTML代码直接在第二个隐藏的textarea域中，方便post提交表单。
        saveHTMLToTextarea : true
    });
});

$("#editor_submit_button").click(function () {
	var title = $("#newstitle")[0].value;
	var news = $("#html-code").val();
	//alert(title);
	//alert($("#html-code").val());
	//alert($("#markdown-code").val());
	//判断标题是否卫康
	if(title == ""){
		alert("标题不能为空");
		return;
	}
	//判断内容是否为空
	if(news == ""){
		alert("内容不能为空");
		return;
	}
       $.ajax({
        type: "post",
        url: "releaseNews",
        data: {
            "newsInfo":$("#html-code").val(),
            "title":title
        },
        success: function (e) {
            alert("新闻发布成功");
        },
        error:function (e) {
            alert("发布失败" + e);
        }
    }); 
});
</script>
</html>