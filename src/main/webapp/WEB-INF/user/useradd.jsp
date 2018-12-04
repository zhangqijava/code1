<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link href="res/lecheng/css/admin.css" rel="stylesheet" type="text/css"/>
<link href="res/common/css/theme.css" rel="stylesheet" type="text/css"/>
<link href="res/common/css/jquery.validate.css" rel="stylesheet" type="text/css"/>
<link href="res/common/css/jquery.treeview.css" rel="stylesheet" type="text/css"/>
<link href="res/common/css/jquery.ui.css" rel="stylesheet" type="text/css"/>

<!-- <script src="/thirdparty/ckeditor/ckeditor.js" type="text/javascript"></script> -->
<!-- <script src="/thirdparty/My97DatePicker/WdatePicker.js" type="text/javascript"></script> -->
<script type="text/javascript" src="res/fckeditor/fckeditor.js"></script>
<script src="res/common/js/jquery.js" type="text/javascript"></script>
<script src="res/common/js/jquery.ext.js" type="text/javascript"></script>
<script src="res/common/js/jquery.form.js" type="text/javascript"></script>
<script src="res/common/js/lecheng.js" type="text/javascript"></script>
<script src="res/lecheng/js/admin.js" type="text/javascript"></script>
<!--引入jQuery  -->
<script type="text/javascript" language="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<!-- 引入时间控件 -->
<script type="text/javascript" language="text/javascript" src="js/DatePicker/WdatePicker.js"></script>
<link rel="stylesheet" href="res/css/style.css" />
<title>user-add</title>
	<!--添加表单验证  -->
	<script type="text/javascript">
	//用户名：数字+字母，结束之前不能全部都是数字，6-16
	var CHKLOGINNAME="^(?![0-9]+$)[a-zA-Z0-9]{6,16}$";
	//密码:数字+字母，结束之前不能全部都是数字和字母，6-16
	var CHKPASSWORD="^(?![0-9]+$)(?![a-zA-Z]+$)[a-zA-Z0-9]{6,16}$";
	//出生日期     yyyy-MM-dd  月份1-12     日期1-31
	var CHKDATE="^[0-9]{4}-0?[1-9]|1[0-2]-0?[1-9]|[1-2][0-9]|3[0-1]$";
	//邮箱xxxxxx@xxx.com,可以包含_      企业邮箱qwe@huewei.com.cn
	var CHKEMAIL="^[a-zA-Z0-9_]+@[a-z0-9]{2,5}(\\.[a-z]{2,3}){1,2}$";
	//真实姓名
	var CHKREALNAME="^[\u4e00-\u9fa5]{2,}$";
	//验证用户名
	//验证用户名
	/* function chkloginname(){
		//获取用户名
		var lgEle=document.getElementById("loginname");
		var loginname=lgEle.value;
		//定义匹配用户名的正则表达式
		var reg=new RegExp(CHKLOGINNAME);
		//获取用户名是否输入成功的元素对象
		var spanEle=document.getElementById("resultName");
		if(reg.test(loginname)){//表示输入正确
			spanEle.innerHTML="✔";
			spanEle.style.color="green";
			return true;
		}else{//输入失败
			spanEle.innerHTML="用户名必须包含数字和字母，并且不能低于六位";
			spanEle.style.color="red";
			//清空文本框
			lgEle.value="";
			//重新聚焦
			lgEle.focus();
			return false;
		}
	} */
		function chkloginname() {
			//获取用户名的值
			var loginname=$("#loginname").val();
			//定义正则
			var reg=new RegExp(CHKLOGINNAME);
			//判断
			if (reg.test(loginname)) {
				if (chkExistLoginname(loginname)) {
					
					return true;
				} else {
					return false;
				}
			} else {
				$("#resultName").html("×用户名必须包含数字和字母，并且不能低于六位");
				$("#resultName").css("color","red");
				//清空文本框，重新聚焦
				$("#loginname").val("");
				//重新聚焦
				//$("#loginname").focus();
				return false;
				
			}
		}
		//验证输入的用户名是否重复
		/*function chkExistLoginname(loginname) {
			var flag=false;
			$.ajax({
				//请求路径
				url:'chkuser.do',
				//请求方式
				type:'post',
				//设置请求参数
				data:'type=1&loginname='+loginname,
				//是否异步
				async:false,
				//预期服务器返回的类型
				dataType:'text',
				//响应成功调用回调函数
				success:function(flag){
					if(flag=='true'){
						$("#resultName").html("✔");
						$("#resultName").css("color","green");
						flag=true;
					}else{
						$("#resultName").html("×用户名已存在");
						$("#resultName").css("color","red");
						$("#loginname").val("");
						flag=false;
					}
				},
				error:function(){
					alert("数据请求失败");
				}
			});
			return flag;
		}
		//验证邮箱是否重复
		function chkExistEmail(email) {
			var flag=false;
			$.ajax({
				//获取请求路径
				url:'chkuser.do',
				//请求方式
				type:'post',
				//设置请求参数
				data:'type=2&email='+email,
				//是否异步
				async:false,
				//设置服务器预期响应的参数
				dataType:'text',
				//响应成功，调用回调函数
				success:function(flag){
					if(flag=='true'){
						$("#resultEmail").html("✔");
						$("#resultEmail").css("color","green");
						flag=true;
					}else{
						$("#resultEmail").html("×邮箱已存在");
						$("#resultEmail").css("color","red");
						$("#email").val("");
						flag=false;
					}
				},
				error:function(){
					alert("请求数据失败");
				}
			});
			return flag;
		}
		/* //验证密码
		function chkpassword() {
			//获取密码
			var pwdEle=document.getElementById("password");
			var password=pwdEle.value;
			//匹配密码正则表达式
			var reg=new RegExp(CHKPASSWORD);
			//获取密码是否输入成功的元素对象
			var spanEle=document.getElementById("resultpwd");
			//判断是否输入正确
			if (reg.test(password)) {
				spanEle.innerHTML="✔";
				spanEle.style.color="green";
				return true;
			} else {
				spanEle.innerHTML="密码必须包含数字和字母，并且不能低于六位";
				spanEle.style.color="red";
				//清空文本框
				pwdEle.value="";
				//重新聚焦
				pwdEle.focus();
				return false;
			}
		} */
		//验证密码
		//检查用户名是否重复
	function chkExistLoginname(loginname){
		var flag=false;
		$.ajax({
			//请求路径
			url:'chkuser.do',
			//请求方式
			type:'post',
			//请求参数
			data:'type=1&loginname='+loginname,
			//是否异步
			async:false,
			//预期服务器返回的数据类型
			dataType:'text',
			//响应成功调用回调函数
			success:function(flag){
				if(flag=='true'){//没有重复
					$("#resultName").html("✔");
					$("#resultName").css("color","green");
					flag=true;
				}else{
					$("#resultName").html("此用户名已存在");
					$("#resultName").css("color","red");
					flag=false;
				}
			},
			error:function(){
				alert('请求数据失败。。。');
			}
		});
		return flag;
	}
	
	//检查邮箱是否唯一
	function chkExistEmail(email){
		var flag=false;
		$.ajax({
			//请求路径
			url:'chkuser.do',
			//请求方式
			type:'post',
			//请求参数
			data:'type=2&email='+email,
			//是否异步
			async:false,
			//预期服务器返回的数据类型
			dataType:'text',
			//响应成功调用回调函数
			success:function(flag){
				if(flag=='true'){//没有重复
					$("#resultEmail").html("✔");
					$("#resultEmail").css("color","green");
					flag=true;
				}else{
					$("#resultEmail").html("此邮箱已存在");
					$("#resultEmail").css("color","red");
					flag=false;
				}
			},
			error:function(){
				alert('请求数据失败。。。');
			}
		});
		return flag;
	}
		function chkpassword() {
			//获取密码
			var password=$("#password").val();
			//获取正则
			var reg=new RegExp(CHKPASSWORD);
			//判断
			if (reg.test(password)) {
				$("#resultpwd").html("✔");
				$("#resultpwd").css("color","green");
				return true;
			} else {
				$("#resultpwd").html("×密码必须包含数字和字母，并且不能低于六位");
				$("#resultpwd").css("color","red");
				//清空文本框
				$("#password").val("");
				//重新聚焦
				//$("#password").focus();
				return false;
			}
		}
		//验证两次密码是否输入一致
		/* function chkrepwd() {
			//获取确认密码的节点
			var repwdEle=document.getElementById("repwd");
			//获取属性值
			var repwd=repwdEle.value;
			//获取第一次输入密码的值
			var password=document.getElementById("password").value;
			//获取2次密码是否输入成功的元素对象
			var spanEle=document.getElementById("resultRepwd");
			//判断两次密码是否输入一致
			if (repwd==password) {
				spanEle.innerHTML="✔";
				spanEle.style.color="green";
				return true;
			} else {
				spanEle.innerHTML="两次密码输入不一致，请重新输入";
				spanEle.style.color="red";
				return false;
			}
		} */
		//验证两次密码是否输入一致
		function chkrepwd() {
			//获取确认密码节点的值
			var repwd=$("#repwd").val();
			//获取第一次输入密码的值
			var password=$("#password").val();
			if (repwd==password) {
				$("#resultRepwd").html("✔");
				$("#resultRepwd").css("color","green");
				return true;
			} else {
				$("#resultRepwd").html("×两次密码输入不一致，请重新输入");
				$("#resultRepwd").css("color","red");
				//清空文本框
				$("#repwd").val("");
				return false;
			}
		}
		//验证真实姓名
		/* function chkrealname() {
			//获取真实姓名节点
			var rmEle=document.getElementById("realname");
			//获取属性值
			var realname=rmEle.value;
			//定义验证姓名正则
			var reg=new RegExp(CHKREALNAME);
			//获取验证不正确提示信息节点
			var spanEle=document.getElementById("resultRealname");
			//进行正则判断
			if (reg.test(realname)) {
				//输入格式正确
				spanEle.innerHTML="✔";
				spanEle.style.color="green";
				return true;
			} else {
				//输入格式不正确
				spanEle.innerHTML="姓名格式不正确，请重新输入";
				spanEle.style.color="red";
				return false;
			}
		} */
		//验证真实姓名
		function chkrealname() {
			var realname=$("#realname").val();
			//正则
			var reg=new RegExp(CHKREALNAME);
			//判断
			if (reg.test(realname)) {
				$("#resultRealname").html("✔");
				$("#resultRealname").css("color","green");
				return true;
			} else {
				$("#resultRealname").html("×姓名格式不正确，请重新输入");
				$("#resultRealname").css("color","red");
				//清空文本框
				$("#realname").val("");
				return false;
			}
		}
		/* //验证邮箱
		function chkemail() {
			//获取邮箱节点
			var emEle=document.getElementById("email");
			//获取属性值
			var email=emEle.value;
			//获取邮箱正则
			var reg=new RegExp(CHKEMAIL);
			//获取邮箱是否输入成功的元素对象
			var spanEle=document.getElementById("resultEmail");
			//进行正则匹配
			if (reg.test(email)) {
				//正则匹配成功
				spanEle.innerHTML="✔";
				spanEle.style.color="green";
				return true;
			} else {
				//没有匹配成功
				spanEle.innerHTML="邮箱格式不正确，请重新输入";
				spanEle.style.color="red";
				return false;
			}
			
		} */
		//验证邮箱
		function chkemail() {
			var email=$("#email").val();
			var reg=new RegExp(CHKEMAIL);
			if (reg.test(email)) {
				if (chkExistEmail(email)) {
					return true;
				} else {
					return false;
				}
			} else {
				$("#resultEmail").html("×邮箱格式不正确，请重新输入");
				$("#resultEmail").css("color","red");
				$("#email").val("");
				return false;
			}
		}
		//信息格式输入都正确，提交通过
		function chkAll() {
			
			if(chkloginname()&&chkpassword()&&chkrepwd()&&chkrealname()&&chkemail()==false){
			
				return true;
			}
			
			return false;
		}

	
	</script>

</head>
<body>
<div class="box-positon">
	<div class="rpos">当前位置: 用户管理 - 添加</div>
	<form class="ropt">
		<input type="submit" onclick="this.form.action='list.do';" value="返回列表" class="return-button"/>
	</form>
	<div class="clear"></div>
</div>
<div class="body-box" style="float:right">
	<form id="jvForm" action="useradd.do" method="post">
		<table cellspacing="1" cellpadding="2" width="100%" border="0" class="pn-ftable">
			<tbody>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						<span class="pn-frequired"></span>
						<span class="pn-frequired">${msg}</span>
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						<span class="pn-frequired">*</span>
						用户名:</td><td width="80%" class="pn-fcontent">
						<input type="text" class="required" name="loginname" id="loginname" maxlength="100" onblur="chkloginname()"/>
						<span id="resultName"></span>
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						<span class="pn-frequired">*</span>
						密码:</td><td width="80%" class="pn-fcontent">
						<input type="text" class="required" name="password" maxlength="100" id="password" onblur="chkpassword()"/>
						<span id="resultpwd"></span>
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						<span class="pn-frequired">*</span>
						确认密码:</td><td width="80%" class="pn-fcontent">
						<input type="text" class="required" name="repwd" maxlength="100" id="repwd" onblur="chkrepwd()"/>
						<span id="resultRepwd"></span>
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						<span class="pn-frequired">*</span>
						真实姓名:</td><td width="80%" class="pn-fcontent">
						<input type="text" class="required" name="realname" maxlength="100" id="realname" onblur="chkrealname()"/>
						<span id="resultRealname"></span>
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						性别:</td><td width="80%" class="pn-fcontent">
						<input type="radio" name="sex" value="男" checked="checked"/>男
						<input type="radio" name="sex" value="女"/>女
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						出生日期:</td><td width="80%" class="pn-fcontent">
						<input type="text" class="Wdate" name="birthday" maxlength="80" onclick="WdatePicker()"/>
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						部门:</td><td width="80%" class="pn-fcontent">
						<select name="dept">
							<c:forEach items="${depts}" var="dep">
								<option value="${dep.id}" name="id">${dep.dname}</option>
							</c:forEach>
					</select>
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						邮箱:</td><td width="80%" class="pn-fcontent">
						<input type="text" class="required" name="email" maxlength="80" id="email" onblur="chkemail()"/>
						<span id="resultEmail"></span>
					</td>
				</tr>
			</tbody>
			<tbody>
				<tr>
					<td class="pn-fbutton" colspan="2">
						<input type="submit" class="submit" value="提交"/> &nbsp; <input type="reset" class="reset" value="重置"/>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</div>
</body>
</html>