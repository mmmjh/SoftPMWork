<%@page import="com.sql.bean.MedicineBean"%>
<%@page import="com.sql.dao.MedicineDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>修改药品信息</title>
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
		MedicineDao medicineDao = new MedicineDao();
		MedicineBean medicineBean = new MedicineBean();
		medicineBean = medicineDao.checkReg(id);
	%>
	<div class="rightbox">
		<h2 class="mbx">药品中心 &gt; 药品信息 &nbsp;&nbsp;&nbsp;</h2>
		<div class="morebt">
			<div class="cztable">
				<form action="MedicineServlet?method=update&id=<%=medicineBean.getId()%>"
					method="post">
					<table width="100%" cellpadding="0" cellspacing="0">
						<tr>
							<td align="right" width="115">药品名称</td>
							<td><input type="text" name="medicinename" id="medicinename"
								value="<%=medicineBean.getMedicineName()%>"></td>
						</tr>
						<tr>
							<td align="right">药品编号</td>
							<td><input type="text" name="medicineid" id="medicineid"
								value="<%=medicineBean.getMedicineId()%>"></td>
						</tr>
						<tr>
							<td align="right">药品类别</td>
							<td><input type="text" name="medicinetype" id="medicietype"
								value="<%=medicineBean.getType()%>"></td>
						</tr>
						<tr>
							<td align="right">库存</td>
							<td><input type="text" name="inventory" id="inventory"
								value="<%=medicineBean.getInventory()%>"></td>
								<%System.out.println(medicineBean.getInventory()); %>
						</tr>
						<tr>
							<td align="right">生产商</td>
							<td><input type="text" name="producer" id="producer"
								value="<%=medicineBean.getProducer()%>"></td>
						</tr>
						<tr>
							<td align="right">进价</td>
							<td><input type="text" name="purchasingprice" id="purchasingprice"
								value="<%=medicineBean.getPurchasingPrice()%>"></td>
						</tr>
						<tr>
							<td align="right">售价</td>
							<td><input type="text" name="sellingprice" id="sellingprice"
								value="<%=medicineBean.getSellingPrice()%>"></td>
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
