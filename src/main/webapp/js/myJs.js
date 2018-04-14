/* 将日期格式化 */
	dateFormat = function(date){
		var y = date.year;
		var m = date.month + 1;
		var d = date.date;
		//判断是2000年前还是后
		if(y >= 50){
			y = 1900 + y;
		}else{
			y = 2000 + y;
		}
		var birthday = y + "-" + m + "-" + d;
		return birthday;
	}
	
	/* ******************添加页面翻页导航****************** */
	//需要的json串的格式：e.myMessage，myMessage中有page的属性，和每页的信息详情
	//添加页码信息
	function addpageInfo(e,page_Info){
		$(page_Info).empty();
		$(page_Info).append("当前第 "+e.myMessage.pageNum+" 页,总共 "
				+e.myMessage.pages+" 页,总共 "
				+e.myMessage.total+" 记录");
	}
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
	/* ********************************************************* */