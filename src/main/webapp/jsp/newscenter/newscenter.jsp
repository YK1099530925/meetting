<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新闻中心</title>
<style type="text/css">

.showNewsItem{
	position:absolute;
	width: 70%;
	height: 500px;
	margin-left:30px;
	margin-top:20px;
	background-color: white;
}
.newsPage{
	position:absolute;
	width: 50%;
	height: 40px;
	margin-left:300px;
	margin-top:530px;
}
.newsOthers{
	position:absolute;
	width: 20%;
	height: 560px;
	margin-left:75%;
	margin-top:20px;
	background-color: white;
}
.pad{
	margin-left: 20px;
}
.newsinfoItem{
	overflow: hidden;/* 属性规定当内容溢出元素框时发生的事情 */
	white-space: nowrap;/* 规定文本不进行换行 */
	text-overflow: ellipsis;/* text-overflow 属性规定当文本溢出包含元素时发生的事情。
	ellipsis 表示显示省略符号来代表被修剪的文本 */
	width: 60%;
}

.newsInfoContent {
	width: 60%;
	height:560px;
	margin-left: 5%;
	background-color: white;
}

.newsInfoContent1 {
	width: 90%;
	margin-top: 4%;
	margin-left: 5%;
	/* border: 1px solid black; */
}

.newsInfoContent0{
	text-align: center;
}
.hrLine{
	height: 1px;
	border: none;
	border-top: 1px dashed #CCCCCC;
}
.newsInfoContentright{
	position:absolute;
	width: 25%;
	height: 600px;
	margin-top: 4%;
	margin-left: 75%;
	border: 1px solid black;
}
</style>
</head>
<body style="background-color: #eeedeb;">

	<div id="newsItems" class="row">
		<!-- 左侧新闻的div -->
		<div id="showNewsItem" class="showNewsItem">
			<h2><a class="pad" href="#">标题</a></h2>
			<div class="newTime pad"><h6>时间</h6></div>
			<div class="pad newsinfoItem">内容</div>
			<br>
			<div class="pad">阅览(0) 评论(0)</div>
			<hr class="hrLine"/>
		</div>
		<!-- 底端的翻页标签 -->
		<div id="newsPage" class="newsPage">
		</div>
		<!-- 右侧其他信息的div -->
		<div id="newsOthers" class="newsOthers">
			
		</div>
	</div>
	
	<div id="newsInfoContent" class="newsInfoContent" style="display: none;">
		<!-- 显示标题 -->
		<div class="newsInfoContent0" id="newsInfoContent0">
   	 	</div>
   	 	<!-- 显示时间 -->
   	 	<div class="newsInfoContent0" id="newsInfoContent00">
   	 	</div>
   	 	<!-- 显示内容 -->
		<div class="newsInfoContent1" id="newsInfoContent1">
   	 	</div>
   	 	<hr class="hrLine"/>
   	 	<!-- 显示评论与返回 -->
   	 	<div class="newsInfoContent0">
   	 		<div class="form-group">
   	 			<div class="col-md-8" style="margin-left: 20px;">
	   	 			<input type="text" name="" class="form-control" id="" placeholder="评论">
	   	 		</div>
	   	 		<button class="btn btn-default col-md-2">发表评论</button>
   	 		</div>
   	 		<button id="returnNewsItems" class="btn btn-default">返回</button>
   	 	</div>
	</div>
	
</body>

<script type="text/javascript">

//页面加载完之后执行获取数据库新闻信息
$(window).load(function(){
	showNewsItem(1);
});
//获取新闻信息，将其显示在页面上
function showNewsItem(pageNum){
	$.ajax({
		url:"getNews",
		type:"get",
		data:{"pageNum":pageNum},
		success:function(e){
			//向显示新闻项添加新闻
			//清空新闻项
 			$("#showNewsItem").empty();
 			var count = 0; 
			var newsInfoList = e.myMessage.list;
			$.each(newsInfoList,function(index,item){
				//每页显示3条记录，因此只添加两条hr横线，count用作判断
				count++;
				var id = item.id;
				var title = item.title;
				var time = dateFormat(item.time);
				var views = item.views;
				var comment = item.comment;
				var newsinfo = item.newsinfo.replace(/[^\u4e00-\u9fa5]/gi," ");

				//创建一个a标签
				var a = document.createElement("a");
				var node = document.createTextNode(title);
				a.appendChild(node);
			    a.setAttribute("href","#");
			    a.setAttribute("onclick","showNews("+id+")");
			    a.setAttribute("class","pad");
				var htitle = $("<h2></h2>").append(a);
				var htime = $("<div class='newTime pad'><h6>时间 :" +time+ "</h6></div>");
				var hnewsinfo = $("<div class='pad newsinfoItem'></div>").append(newsinfo);
				var hcommentAndViews = $("<div class='pad'>阅览("+comment+") 评论("+views+")</div>");
				var br = $("<br>");
				var hr = $("<hr class='hrLine'/>");
				$("#showNewsItem").append(htitle).append(htime).append(hnewsinfo).append(br).append(hcommentAndViews);
				if(count != 3){
					$("#showNewsItem").append(hr);
				}
			});
			//添加导航
			addPageNav_news(e,"#newsPage"); 
		}
	});
}

//显示新闻详细信息
function showNews(id){
	$.ajax({
		url:"showNewsInfo",
		type:"get",
		data:{"id":id},
		success:function(e){
			document.getElementById("newsItems").style.display = "none";
			document.getElementById("newsInfoContent").style.display = "inline-block";
			var title = $("<h1>"+e.title+"</h1>");
			var time = $("<h5>发布时间："+dateFormat(e.time)+"</h5>");
			$("#newsInfoContent0").append(title);
			$("#newsInfoContent00").append(time);
			$("#newsInfoContent1")[0].innerHTML=e.newsinfo;
		}
	});
}

$("#returnNewsItems").click(function(){
	document.getElementById("newsItems").style.display = "inline";
	document.getElementById("newsInfoContent").style.display = "none";
	//清除内容
	$("#newsInfoContent0").empty();
	$("#newsInfoContent00").empty();
});

</script>

</html>