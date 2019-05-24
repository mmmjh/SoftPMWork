<%@page import="com.sql.bean.OrderBean"%>
<%@page import="com.sql.dao.OrderDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>添加订单信息</title>
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
		<h2 class="mbx">订单中心 &gt; 订单信息 &nbsp;&nbsp;&nbsp;</h2>
		<div class="morebt">
			<div class="cztable">
				<form action="OrderServlet?method=add" method="post">
					<table width="100%" cellpadding="0" cellspacing="0">
						<tr>
							<td align="right" width="115">订单编号</td>
							<td><input type="text" name="orderId" id="orderId"></td>
						</tr>
						<tr>
							<td align="right">售货员编号</td>
							<td><input type="text" name="staffId" id="staffId"></td>
						</tr>
						<tr>
							<td align="right">总金额</td>
							<td><input type="text" name="money" id="money"></td>
						</tr>
						<tr>
							<td align="right">产生日期</td>
							<td><input type="text" name="createDate" id="createDate"></td>
						</tr>
						<tr>
							<td align="right">缴费方式</td>
							<td><lable>
								<center>
									<select name="paytype" id="paytype">
										<option>现金</option>
										<option>信用卡</option>
										<option>网上缴费</option>
									</select>
								</center>
								</lable></td>
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
