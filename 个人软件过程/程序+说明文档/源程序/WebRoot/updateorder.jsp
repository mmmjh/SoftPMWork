<%@page import="com.sql.bean.OrderBean"%>
<%@page import="com.sql.dao.OrderDao"%>
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
	<%
		int id = Integer.parseInt(request.getParameter("id"));
		OrderDao orderDao = new OrderDao();
		OrderBean orderBean = new OrderBean();
		orderBean = orderDao.checkReg(id); //查找对应编号的信息
	%>
	<div class="rightbox">
		<h2 class="mbx">订单中心 &gt; 订单信息 &nbsp;&nbsp;&nbsp;</h2>
		<div class="morebt">
			<div class="cztable">
				<form action="OrderServlet?method=update&id=<%=orderBean.getId()%>"
					method="post">
					<table width="100%" cellpadding="0" cellspacing="0">
						<tr>
							<td align="right" width="115">订单编号</td>
							<td><input type="text" name="orderId" id="orderId"
								value="<%=orderBean.getOrderId()%>"></td>
						</tr>
						<tr>
							<td align="right">员工编号</td>
							<td><input type="text" name="staffId" id="staffId"
								value="<%=orderBean.getStaffId()%>"></td>
						</tr>
						<tr>
							<td align="right">总金额</td>
							<td><input type="text" name="money" id="money"
								value="<%=orderBean.getMoney()%>"></td>
						</tr>
						<tr>
							<td align="right">产生日期</td>
							<td><input type="text" name="createDate" id="createDate"
								value="<%=orderBean.getCreateDate()%>"></td>
						</tr>
						<tr>
							<td align="right">缴费类型</td>
							<td><input type="text" name="paytype" id="paytype"
								value="<%=orderBean.getPaytype()%>"></td>
						</tr>
					</table>

					<p>&nbsp;</p>
					<div align="center">
						<input type="submit" value="提交" class="input2" />
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
