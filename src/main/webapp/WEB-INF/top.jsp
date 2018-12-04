<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="images/skin.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
		//获取当前时间
		function gettime() {
			//日期函数
			var date=new Date();
			//年
			var year=date.getFullYear();
			//月
			var month=date.getMonth()+1;
			//日
			var d=date.getDate();
			//时
			var hour=date.getHours();
			if(hour<10){
				hour="0"+hour;
			}
			//分
			var minute=date.getMinutes();
			if (minute<10) {
				minute="0"+minute;
			}
			//秒
			var second=date.getSeconds();
			if (second<10) {
				second="0"+second;
			}
			document.getElementById("currentTime").innerHTML=year+"年"+month+"月"+d+"日     "+hour+":"+minute+":"+second;
		
		}
		//经过指定的毫秒数重复执行代码
		window.setInterval(gettime, 1000);
</script>
</head>
<body leftmargin="0" topmargin="0">
<table width="100%" height="64" border="0" cellpadding="0" cellspacing="0" class="admin_topbg">
  <tr>
    <td width="61%" height="64"><img src="images/logo.gif" width="262" height="64"></td>
    <td width="39%" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="74%" height="38" class="admin_txt"><b>${userbean.realname }</b> &nbsp;&nbsp;&nbsp;&nbsp;<span id="currentTime"></span>&nbsp;&nbsp;&nbsp;&nbsp;感谢登录使用！</td>
        <td width="22%"><a href="/admin/login.do" target="parent"><img src="images/out.gif" alt="安全退出" width="46" height="20" border="0"></a></td>
        <td width="4%">&nbsp;</td>
      </tr>
      <tr>
        <td height="19" colspan="3">&nbsp;</td>
        </tr>
    </table></td>
  </tr>
</table>
</body>
</html>