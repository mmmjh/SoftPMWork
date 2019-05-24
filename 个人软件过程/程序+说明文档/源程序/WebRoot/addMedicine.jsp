<%@page import="com.sql.bean.MedicineBean"%>
<%@page import="com.sql.dao.MedicineDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>添加药品信息</title>
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
		<h2 class="mbx">药品中心 &gt; 药品信息 &nbsp;&nbsp;&nbsp;</h2>
		<div class="morebt">
			<div class="cztable">
				<form action="MedicineServlet?method=add" method="post">
					<table width="100%" cellpadding="0" cellspacing="0">
						<tr>
							<td align="center" width="115">药品名称</td>
							<td><input type="text" name="medicineName" id="medicineName"></td>
						</tr>
						<tr>
							<td align="right">类别</td>
							<td><input type="text" name="type" id="type"></td>
						</tr>
						<tr>
							<td align="right">药品编号</td>
							<td><input type="text" name="medicineId" id="medicineId"></td>
						</tr>
						<tr>
							<td align="right">库存</td>
							<td><input type="text" name="inventory" id="inventory"></td>
						</tr>
						<tr>
							<td align="right">生产商</td>
							<td><input type="text" name="producer" id="producer"></td>
						</tr>
						<tr>
							<td align="right">进价</td>
							<td><input type="text" name="purchasingPrice"
								id="purchasingPrice"></td>
						</tr>
						<tr>
							<td align="right">售价</td>
							<td><input type="text" name="sellingPrice" id="sellingPrice"></td>
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
