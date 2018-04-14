function addpageInfo_deptmanage(e,page_Info){
		$(page_Info).empty();
		$(page_Info).append("当前第 "+e.myMessage.pageNum+" 页,总共 "
				+e.myMessage.pages+" 页,总共 "
				+e.myMessage.total+" 记录");
	}
	function addPageNav_deptmanage(e,page_nav){
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
				showDeptInfo(e.myMessage.pageNum - 1);
			});
			firstPageLi.click(function(){
				showDeptInfo(1);
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
				showDeptInfo(e.myMessage.pageNum + 1);
			});
			lastPageLi.click(function(){
				showDeptInfo(e.myMessage.pages);
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
				showDeptInfo(itemNav);
			});
			ul.append(numLi);
		}); 
		ul.append(nextPageLi).append(lastPageLi);

		var navEle = $("<nav></nav>").append(ul);
		navEle.appendTo(page_nav);
	}