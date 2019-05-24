<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>登录界面</title>
<link href="./Wopop_files/style_log.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="./Wopop_files/style.css" />
<link rel="stylesheet" type="text/css" href="./Wopop_files/userpanel.css" />
<link rel="stylesheet" type="text/css" href="./Wopop_files/jquery.ui.all.css" />
<script>
function toregister()
{
	window.location.href="regist.jsp";
}
function validate() {
	var inputCode = document.getElementById("password").value;//获取输入框内验证码并转化为大写  
	var inputCode1 = document.getElementById("studentname").value;//获取输入框内验证码并转化为大写
	var inputCode2 = document.getElementById("yanzhengma").value;
	if(inputCode1=="") { //若输入的验证码长度为0 
	 alert("请输入用户名！"); //则弹出请输入验证码 
	 document.getElementById("password").value="";
	 return 0;
	} 
	else if(inputCode=="") { //若输入的验证码长度为0 
		 alert("请输入密码！"); //则弹出请输入验证码 		
		 document.getElementById("password").value="";
		 return 0;
		} 
	else if(inputCode2==""){
		 alert("请输入验证码！");
		 return 0;
	}
	else return 1;
}
function test() {
    top.Dialog.alert("如果丢失密码，请与0311-85813216电话联系！");
}
</script>
 
</head>
<body class="login" >
<div class="login_m">
<div class="login_logo" style="width:1000px;margin-left:-300px;margin-bottom:80px"><h1 >药&nbsp;&nbsp;店&nbsp;&nbsp;管&nbsp;&nbsp;理&nbsp;&nbsp;系&nbsp;&nbsp;统</h1></div>
<div class="login_boder">
<form action="LoginServlet?method=doGet"   onsubmit="return validate()==1" method="post" class="agile_form">
<div class="login_padding" id="login_model">
<%
	request.setCharacterEncoding("UTF-8");
	String error = (String)request.getAttribute("loginError");
	if(error == null)	error="";
%>
<input id="pd" type="hidden" value="<%=error %>" />
<h2>用户名</h2>
  <label>
       <input  type="text" name="username" id="username" class="txt_input" placeholder="请输入用户名" />
  </label>
  <h2>密&nbsp;&nbsp;码</h2>
  <label>
    <input type="password" name="password" id="password" class="txt_input"   placeholder="请输入密码" />
  </label>
  <img class="shuaxin" id="tu" src="yan/randCode.jsp" width="65" height="36" onclick="this.src='yan/randCode.jsp?s='+new Date().getTime();"  />
 	<h2 >验证码</h2>
  <label>
    <input type="text" name="yanzhengma" id="yanzhengma" class="txt_inputyanzheng"   placeholder="输入验证码" />
    </label>
	<p class="forgot"><a id="iforget"  href="javascript:void(0);" onclick="test()">忘记密码?</a></p>
	<p class="forgot1"><a id="iforget" href="regist.jsp">进行注册</a></p>
  	<div class="rem_sub">
    <label >
       <input type="submit" class="sub_button" name="button" id="button" value="登录" style="opacity: 0.7;" />
    </label>
  </div>
</div>
</form>
  </div>
</div>

<script type="text/javascript">
	window.onload=function(){
		var pd = document.getElementById("pd").value;
		if(pd == "") return;
		else alert(pd);
	}
</script>
</body>
</html>