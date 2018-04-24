<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<!-- 右 -->
		<div class="body-right">
			<h3 class="text-success">文件上传测试</h3>
			<input id="uploadFileInput" type="file">
			<a id="checkFilename" class="btn btn-default btn-sm">查看</a>
			<a id = "submitUploadFil" class="btn btn-default btn-sm">设置</a>
			<a id="downloadFile" class="btn btn-default btn-sm" download>文件下载</a>
		</div>
</body>
<script type="text/javascript">

$("#checkFilename").click(function(){
	var filename = document.getElementById("uploadFileInput").value;
	alert(filename);
});

$(document).on('change', '#uploadFileInput', function () {
	function getObjectURL(file) {  
        var url = null;  
        if (window.createObjcectURL != undefined) {  
            url = window.createOjcectURL(file);  
        } else if (window.URL != undefined) {  
            url = window.URL.createObjectURL(file);  
        } else if (window.webkitURL != undefined) {  
            url = window.webkitURL.createObjectURL(file);  
        }  
        return url;  
    }  
	//获得文件的真实路劲（因为浏览器会隐藏真实路劲，使用fakepath代替中间路劲，因此需要获取文件的真实路劲）
    var objURL = getObjectURL(this.files[0]);
    //alert(objURL);
    
    document.getElementById("downloadFile").href=objURL;
});

$("#submitUploadFil").click(function(){
	var filename = document.getElementById("uploadFileInput").value;
	/* $.ajax({
		url:"uploadFile",
		type:"POST",
		data:{"filename":filename},
		success:function(e){
			alert("上传成功");
		}
	}); */

	//设置标签的显示名字
	/* var filename = "会议资料";
	document.getElementById("filenameLabel").innerText = filename; */
	
});

</script>

</html>