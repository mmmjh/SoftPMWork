<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>查看订单信息</title>
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
				<table width="100%" cellpadding="0" cellspacing="0">
					<tr>
						<td align="right" width="115">订单编号</td>
						<td align="right">售货员编号</td>
						<td align="right">总金额</td>
						<td align="right">日期</td>
						<td align="right">缴费类型</td>
						<td align="right">操作</td>
					</tr>
					<!-- forEach遍历出orderBeans -->
					<c:forEach items="${orderBeans}" var="item" varStatus="status">
						<tr>
							<td>${item.orderId}</td>
							<td>${item.staffId}</td>
							<td>${item.money}</td>
							<td>${item.createDate}</td>
							<td><c:if test="${item.paytype==0}">现金</c:if> <c:if
									test="${item.paytype==1}">信用卡</c:if> <c:if
									test="${item.paytype==2}">网上缴费</c:if></td>
							<td style="text-align: center">
								<a href="updateorder.jsp?method=update&id=${item.id}">修改</a>
								<a href="OrderServlet?method=delete&id=${item.id}">删除</a>
								<a href="OrderServlet?method=delete&id=${item.id}">处理</a></td>
						</tr>
					</c:forEach>
				</table>
				<p>&nbsp;</p>
				<div align="center">
					<input type="button" id="button2" value="添加订单"
						onclick="javascript:window.location.href='addOrder.jsp'"
						class="input2" />
				</div>
			</div>
		</div>
	</div>
</body>
</html>
