<%@page import="com.sql.bean.StaffBean"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学生信息管理平台</title>
<link href="Style/StudentStyle.css" rel="stylesheet" type="text/css" />
<link href="Script/jBox/Skins/Blue/jbox.css" rel="stylesheet"
	type="text/css" />
<link href="Style/ks.css" rel="stylesheet" type="text/css" />
<script src="Script/jBox/jquery-1.4.2.min.js" type="text/javascript"></script>
<script src="Script/jBox/jquery.jBox-2.3.min.js" type="text/javascript"></script>
<script src="Script/jBox/i18n/jquery.jBox-zh-CN.js"
	type="text/javascript"></script>
<script src="Script/Common.js" type="text/javascript"></script>
<script src="Script/Data.js" type="text/javascript"></script>
<script type="text/javascript">
	$().ready(function() {
		setStudMsgHeadTabCheck();
		showUnreadSysMsgCount();
	});
</script>

<script type="text/javascript">
	function submitMail() {
		var mtitle = "联系方式有修改";
		var html = "<div style='padding:10px;'><div style='width:65px; height:120px; float:left;'>修改的地方：</div><div style='width:250px; height:120px; float:left;'><textarea id='objeCont' name='objeCont' style='width:250px; height:105px;'></textarea></div></div>";

		var submit = function(v, h, f) {
			if (f.objeCont == '' || f.objeCont.length > 80) {
				$.jBox.tip("请您输入有修改的地方，且不超过80个字！", 'error', {
					focusId : "objeCont"
				}); // 关闭设置 objeCont 为焦点
				return false;
			}

			StudentCompain.insertCompain('', mtitle, 5, f.objeCont, function(data) {
				var obj = $.parseJSON(data);
				var resultObj = false;
				if (obj.ok) {
					$.jBox.tip("成功提交联系方式的修改邮件！");
				}
			});
		};

		$.jBox(html, {
			title : "联系方式修改的邮件",
			submit : submit
		});
	}
</script>
</head>
<body>

	<%-- <%
		StaffBean staffBean = (StaffBean)request.getParameter("staffBean");
	%> --%>
	<div class="rightbox">
		<h2 class="mbx">员工中心 &gt; 员工信息&gt; "${staffBean.staffName}"
			&nbsp;&nbsp;&nbsp;</h2>
		<div class="morebt">
			<div class="cztable">
				<table width="100%" cellpadding="0" cellspacing="0">
					<tr>
						<td align="right" width="115">姓名：</td>
						<td align="center" width="150">邹智&nbsp;</td>
						<td rowspan="9"><div align="center">
								<img id="pic_face" height="160" width="120"
									src="images/Student/photo.jpg"
									style="padding:2px 2px 5px; border:1px #ddd solid;">
							</div>&nbsp;</td>
					</tr>
					<tr>
						<td align="right">性别：</td>
						<td>${staffBean.sex}</td>
					</tr>
					<tr>
						<td align="right">年龄：</td>
						<td>男&nbsp;</td>
					</tr>
					<tr>
						<td align="right">员工编号：</td>
						<td>自考&nbsp;</td>
					</tr>
					<tr>
						<td align="right">职位：</td>
						<td>经济法学&nbsp;</td>
					</tr>
					<tr>
						<td align="right">工龄：</td>
						<td>专本同读&nbsp;</td>
					</tr>
					<tr>
						<td align="right">联系电话：</td>
						<td>专本同读&nbsp;</td>
					</tr>
				</table>
				<p>&nbsp;</p>
				<div align="center">
					<input type="button" id="button2" value="修改" onclick="submitMail()"
						class="input2" />
				</div>
			</div>
		</div>
	</div>
</body>
</html>
