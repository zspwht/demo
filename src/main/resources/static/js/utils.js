 function URL_Request(strName) {

		        var strHref = document.location.toString();
		        var intPos = strHref.indexOf("?");
		        var strRight = strHref.substr(intPos + 1); //==========获取到右边的参数部分
		        var arrTmp = strRight.split("&"); //=============以&分割成数组

		        for (var i = 0; i < arrTmp.length; i++) //===========循环数组
		        {
		            var dIntPos = arrTmp[i].indexOf("=");
		            var paraName = arrTmp[i].substr(0, dIntPos);
		            var paraData = arrTmp[i].substr(dIntPos + 1);
		            if (paraName.toUpperCase() == strName.toUpperCase()) {
		                return paraData;
		            }
		        }
		        return "";
		      }


 function timeFormat(time){
     var datetime = new Date();
     datetime.setTime(time);
     var year = datetime.getFullYear();
     var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
     var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
     var hour = datetime.getHours()< 10 ? "0" + datetime.getHours() : datetime.getHours();
     var minute = datetime.getMinutes()< 10 ? "0" + datetime.getMinutes() : datetime.getMinutes();
     var second = datetime.getSeconds()< 10 ? "0" + datetime.getSeconds() : datetime.getSeconds();
     return year + "-" + month + "-" + date;
 }

 function timeFormatHMS(time){
     var datetime = new Date();
     datetime.setTime(time);
     var year = datetime.getFullYear();
     var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
     var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
     var hour = datetime.getHours()< 10 ? "0" + datetime.getHours() : datetime.getHours();
     var minute = datetime.getMinutes()< 10 ? "0" + datetime.getMinutes() : datetime.getMinutes();
     var second = datetime.getSeconds()< 10 ? "0" + datetime.getSeconds() : datetime.getSeconds();
     return year + "-" + month + "-" + date + " "+hour+":"+minute+":"+second;
 }

 function timeFormatStr(time){
     var datetime = new Date();
     datetime.setTime(time);
     var year = datetime.getFullYear();
     var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
     var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
     var hour = datetime.getHours()< 10 ? "0" + datetime.getHours() : datetime.getHours();
     var minute = datetime.getMinutes()< 10 ? "0" + datetime.getMinutes() : datetime.getMinutes();
     var second = datetime.getSeconds()< 10 ? "0" + datetime.getSeconds() : datetime.getSeconds();
     return year + "年" + month + "月" + date+"日";
 }

 //两日期相差的天数
 function DateDiff(sDate1, sDate2) {
    //debugger;
     /*var aDate, oDate1, oDate2, iDays
     aDate = sDate1.split("-")
     oDate1 = new Date(aDate[0] + '-' + aDate[1] + '-' + aDate[2]).getTime()
     aDate = sDate2.split("-")
     oDate2 = new Date(aDate[0] + '-' + aDate[1] + '-' + aDate[2]).getTime()*/
     oDate1 = new Date(sDate1).getTime();
     oDate2 = new Date(sDate2).getTime();
     iDays = (oDate1 - oDate2)/ 1000 / 60 / 60 / 24    //把相差的毫秒数转换为天数
     return iDays
 }
