<%@page import="com.sql.bean.StaffBean"%>
<%@page import="com.sql.dao.StaffDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>修改员工信息</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
</head>

<body>
	<div class="rightbox">
		<h2 class="mbx">员工中心 &gt; 员工信息 &nbsp;&nbsp;&nbsp;</h2>
		<div class="morebt">
			<div class="cztable">
				<form action="StaffServlet?method=add" method="post">
					<table width="100%" cellpadding="0" cellspacing="0">
						<tr>
							<td align="right" width="115">姓名</td>
							<td><input type="text" name="staffName" id="staffName"></td>
						</tr>
						<tr>
							<td align="right">性别</td>
							<td><input type="text" name="sex" id="sex"></td>
						</tr>
						<tr>
							<td align="right">员工编号</td>
							<td><input type="text" name="staffId" id="staffId"></td>
						</tr>
						<tr>
							<td align="right">职位</td>
							<td><input type="text" name="duty" id="duty"></td>
						</tr>
						<tr>
							<td align="right">年龄</td>
							<td><input type="text" name="age" id="age"></td>
						</tr>
						<tr>
							<td align="right">电话</td>
							<td><input type="text" name="call" id="call"></td>
						</tr>
						<tr>
							<td align="right">工龄</td>
							<td><input type="text" name="workingAge" id="workingAge"></td>
						</tr>
					</table>
					<p>&nbsp;</p>
					<div align="center">
						<input type="submit" id="button" value="提交" />
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
