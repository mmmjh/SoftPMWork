<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.sql.util.Pager"%>
<%@page import="com.sql.dao.StaffDao"%>
<%@page import="com.sql.bean.StaffBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>查看员工信息</title>
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
request.setCharacterEncoding("UTF-8");
	//筛选
	String content = request.getParameter("content");
	if(content == null || "".equals(content)){
		content = "";
	}
	//分页的条件
	int pageIndex = 1;
	int pageSize = 5;
	try{
		pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
	}catch(Exception e){
	}
	StaffDao userDao = new StaffDao();//这是增删改查类对象
	Pager pager = userDao.load(content, pageIndex, pageSize);
	//获得pager中保存的list集合
	 List<StaffBean> users = pager.getDatas();//集合  这和上面注释的users一样 只是区分页数
	//获取登录用户
	//StaffBean loginuser = (Student)session.getAttribute("loginUser");//接收从登陆页面传过来的对象 用session接收和传递
%>

	<div class="rightbox">
		<h2 class="mbx">员工中心 &gt; 员工信息 &nbsp;&nbsp;&nbsp;</h2>
		<div class="morebt">
			<div class="cztable">
	<table align="center" border="1" width="900">
		<tr>
			<form action="listStaff.jsp" method="post">
				<td colspan="10">
					请输入用户名 : &nbsp;
					<input type="text" name="content" size="70" /> &nbsp; <br>
					<input type="submit" style="margin-left:220px;width:214px;height:20px;" value="搜索" /></br>
				</td>
			</form>
		</tr>
		<tr>
			<td colspan="10">
				一共有<%=pager.getTotalRecord() %>条数据 , 每页显示<%=pager.getPageSize() %>条数据
				页码 : <%=pageIndex %> / <%=pager.getTotalPage() %>
			</td>
		</tr>
		<tr>
			<td align="center" width="115">序号</td>
						<td align="center">姓名</td>
						<td align="center">性别</td>
						<td align="center">员工编号</td>
						<td align="center">职位</td>
						<td align="center">年龄</td>
						<td align="center">电话</td>
						<td align="center">工龄</td>
						<td align="center">操作</td>
		</tr>
		<%
		int i1=1;
			for( StaffBean user : users ){
		%>
		<tr>
			<td> <%=i1 %></td>
			<td><a href="infor.jsp?id=<%=user.getId()%>"><%=user.getStaffName() %></a></td>
			<td> <%=user.getSex() %></td><%System.out.println(user.getSex()+"性别测试"); %>
			<td> <%=user.getStaffId() %></td>
			<td> <%=user.getDuty() %></td>
			<td> <%=user.getAge() %></td>
			<td> <%=user.getCall() %></td>
			<td> <%=user.getWorkingAge() %></td>
			<td><a href="updateStaff.jsp?id=<%=user.getId()%>">修改完善</a>
				<a href="StaffServlet?method=delete&id=<%= user.getId()%>">删除</a></td>
			
		</tr>
		<%
		i1++;
			}
		%>
		
		<!-- 设置分页的页码 -->
		<tr>
			<td colspan="10" align="center">
				<a href="listStaff.jsp?pageIndex=1&content=<%=content %>">首页</a>
				
				<!-- 如果是第一页的话 , 就不显示 上一页 -->
				<%
					if(pageIndex > 1){
				%>
					<a href="listStaff.jsp?pageIndex=<%=pageIndex-1 %>&content=<%=content %>">上一页</a>
				<%
					}
				%>
				<!-- 页码的显示 , 如果是当前页 , 就不加超链接, 只是显示就可以 , 其他都加上超链接 -->
				<%
					//先获得总页数,对他进行for循环遍历
					int totalPage = pager.getTotalPage();
					for(int i = 1 ; i <=totalPage ; i++){
						if(pageIndex == i){
				%>	
						<%=i %>
					<%
						}else{
					%>		
						<a href="listStaff.jsp?pageIndex=<%=i%>&content=<%=content %>"><%=i %></a>
				<%
						}
					}	
				%>	
				<%
					if( pageIndex < totalPage){
				%>
					<a href="listStaff.jsp?pageIndex=<%=pageIndex + 1 %>&content=<%=content %>">下一页</a>
				<%
					}
				%>
				<a href="listStaff.jsp?pageIndex=<%=totalPage%>&content=<%=content %>">尾页</a>
			</td>
		
		
		
		</tr>
	
	</table>
				<p>&nbsp;</p>
				<div align="center">
					<input type="button" id="button2" value="添加员工"
						onclick="javascript:window.location.href='addStaff.jsp'"
						class="input2" style="width:200px;margin-left:-200px"/>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
