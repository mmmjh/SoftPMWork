<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>查看药品信息</title>
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
		<h2 class="mbx">药品中心 &gt; 药品信息 &nbsp;&nbsp;&nbsp;</h2>
		<div class="morebt">
			<div class="cztable">
				<table width="100%" cellpadding="0" cellspacing="0">
					<tr>
						<td align="right" width="115">药名</td>
						<td align="right">类别</td>
						<td align="right">药品编号</td>
						<td align="right">库存</td>
						<td align="right">生产商</td>
						<td align="right">进价</td>
						<td align="right">售价</td>
						<td align="right">操作</td>
					</tr>
					<!-- forEach遍历出medicineBeans -->
					<c:forEach items="${medicineBeans}" var="item" varStatus="status">
						<tr>
							<td>${item.medicineName}</td>
							<td><c:if test="${item.type==1}">西药</c:if> <c:if
									test="${item.type==0}">中药</c:if></td>
							<td>${item.medicineId}</td>
							<td>${item.inventory}</td>
							<td>${item.producer}</td>
							<td>${item.purchasingPrice}</td>
							<td>${item.sellingPrice}</td>
							<td><a href="updateMedicine.jsp?method=update&id=${item.id}">修改</a>
								<a href="MedicineServlet?method=delete&id=${item.id}">删除</a></td>
						</tr>
					</c:forEach>
				</table>
				<p>&nbsp;</p>
				<div align="center">
					<input type="button" id="button2" value="添加药品"
						onclick="javascript:window.location.href='addMedicine.jsp'"
						class="input2" />
				</div>
			</div>
		</div>
	</div>
</body>
</html>
