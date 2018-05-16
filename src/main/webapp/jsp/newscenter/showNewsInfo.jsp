<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
	pageContext.setAttribute("Path", request.getContextPath());
%>
<link rel="stylesheet" href="${Path }/js/editormd/css/editormd.css" />
<link rel="stylesheet" href="${Path }/js/editormd/css/editormd.preview.css" />
<title>新闻中心</title>
<style type="text/css">

.content {
	width: 95%;
	margin-left: 20px;
}

</style>
</head>
<body>
	
    <div class="content" id="content">
    </div>
    <div>
    	<button class="btn btn-default" id="showNewsInfo">显示</button>
    </div>

<script src="${Path }/js/jquery-1.12.4.min.js"></script>
<script src="${Path }/js/editormd/lib/marked.min.js"></script>
<script src="${Path }/js/editormd/lib/prettify.min.js"></script>
<script src="${Path }/js/editormd/editormd.js"></script>
<script type="text/javascript">

    $("#showNewsInfo").click(function(){
        $.ajax({
            url:"showNewsInfo",
            type:"get",
            data:{},
            success:function(e){
            	$("#content")[0].innerHTML=e.newsinfo;
            	/* 在此遇见的问题，使用$("#xxx").text(e.newsinfo);是将信息直接用作文本放进这个标签，而
            	        使用 $("#content")[0].innerHTML=e.newsinfo;是将其作为html格式放入*/
            }
        });
    });
</script>

</body>
</html>