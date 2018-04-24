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