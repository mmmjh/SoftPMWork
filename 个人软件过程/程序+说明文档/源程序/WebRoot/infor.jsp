<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@page import="com.sql.util.StringUtil"%>
 <%@page import="com.sql.bean.StaffBean"%>
<%@page import="com.sql.dao.StaffDao"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="http://www.jq22.com/jquery/bootstrap-3.3.4.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>		
</head>
<%
     int id = StringUtil.StringToInt(request.getParameter("id"));
	 StaffDao staffdao=new StaffDao();
	 StaffBean staff=staffdao.checkReg(id);
	 System.out.println(id+"姓名挑选");
	 String[] sourceStrArray=new String[10];
	 String unit=staff.getLoca();
	 if(!"".equals(unit)&&unit!=null)
	 	 {sourceStrArray = unit.split(",");}
	 else
	 	{
	 	for(int i=0;i<sourceStrArray.length;i++)
	 		sourceStrArray[i]="";
	 	}
	 String a="";
	 if(staff.getBorn()==null)
	   {
		 staff.setBorn(a);
	   }
	 if(staff.getEdu()==null)
	   {
		 staff.setEdu(a);
	   }
	 if(staff.getDegree1()==null)
	   {
		 staff.setDegree1(a);
	   }
	 if(staff.getMajor()==null)
	   {
		 staff.setMajor(a);
	   }
	 if(staff.getEmail()==null)
	   {
		 staff.setEmail(a);
	   }
	 if(staff.getNation()==null)
	   {
		 staff.setNation(a);
	   }
	 if(staff.getPict()==null)
	   {
		 staff.setPict(a);
	   }
	 
	 
	 
	
%>
<body style="background-color:#d8ecf5;">
<%String b="ima/"+staff.getPict();
System.out.println(b+"路径");
%>

<p>员工中心>员工信息>员工具体信息</p><hr/>
<form name="form1"  action="base.jsp"  method="post" >
<table style="margin-left:200px;margin-top:120px;" width="847" height="157" border="1" cellpadding="0" cellspacing="0">
  
  <tr>
    <td width="113" rowspan="3"><img src="<%=b%>" width="152" height="168"></td>
    <td width="51"><p align="center"style="margin-top:10px;">姓名 </p></td>
    <td width="91" colspan="2"><input readonly type="text" value="<%=staff.getStaffName() %>" style="text-align: center; border:0px;width:100%;height:52px;background-color:#d8ecf5" /></td>
    <td width="49"><p  align="center" style="margin-top:10px;">性别 </p></td>
    <td width="64"><input type="text" value="<%=staff.getSex()%>" readonly style="text-align: center;border:0px;width:100%;height:52px;background-color:#d8ecf5" /></td>
    <td width="64"><p align="center" style="margin-top:10px;">出生年月 </p></td>
    <td width="75" colspan="2"><input value="<%=staff.getBorn()%>" readonly type="text"  style=" text-align: center;border:0px;width:100%;height:52px;background-color:#d8ecf5" /></td>
    <td width="52" colspan="2"><p align="center" style="margin-top:10px">民族 </p></td>
    <td width="64"><input type="text" value="<%=staff.getNation()%>" readonly  style="text-align: center;border:0px;width:100%;height:52px;background-color:#d8ecf5" /></td>
  </tr>
  <tr>
    <td width="75" colspan="2"><p align="center" style="margin-top:10px">所学专业 </p></td>
    <td width="116" colspan="2"><input
      value="<%=staff.getMajor()%>" readonly type="text"  style="text-align: center;border:0px;width:100%;height:52px;background-color:#d8ecf5;text-align: center;" /></td>
    <td width="64"><p align="center" style="margin-top:10px;">学历 </p></td>
    <td width="104" colspan="2"><input value="<%=staff.getEdu()%>" readonly type="text"  style="text-align: center;border:0px;width:100%;height:52px;background-color:#d8ecf5" /></td>
    <td width="26" colspan="2"><p align="center" style="margin-top:10px;">学位 </p></td>
    <td width="125" colspan="2"><input type="text"  value="<%=staff.getDegree1()%>" readonly style="text-align: center;border:0px;width:100%;height:52px;background-color:#d8ecf5" /></td>
  </tr>
  <tr>
    <td width="75" colspan="2"><p align="center">所在地区 </p></td>
    <td width="116" colspan="2">
    
     <div data-toggle="distpicker">
        <div class="form-group">
          <label class="sr-only" for="province3">Province</label>
          <select disabled class="form-control" id="province3" data-province="<%=sourceStrArray[0]%>"></select>
        </div>
        <div class="form-group">
          <label class="sr-only" for="city3">City</label>
          <select disabled class="form-control" id="city3" data-city="<%=sourceStrArray[1]%>"></select>
        </div>
        <div class="form-group">
          <label class="sr-only" for="district3">District</label>
          <select disabled class="form-control" id="district3" data-district="<%=sourceStrArray[2]%>"></select>
        </div>
      </div>
    
	</td>
    <td width="64"><p align="center" style="margin-top:10px;">手机 </p></td>
    <td width="104" colspan="2"><input type="text" value="<%=staff.getCall()%>" readonly style="text-align: center;border:0px;width:100%;height:52px;background-color:#d8ecf5" /></td>
    <td width=26" colspan="2"><p align="center" style="margin-top:10px">E-mail</p></td>
    <td width="125" colspan="2"><input type="text" value="<%=staff.getEmail()%>" readonly style="text-align: center;border:0px;width:100%;height:52px;background-color:#d8ecf5" /></td>
  </tr>
</table>
</form>
</body>

	<script src="http://www.jq22.com/jquery/1.11.1/jquery.min.js"></script>
	<script src="http://www.jq22.com/jquery/bootstrap-3.3.4.js"></script>
	<script src="js/distpicker.data.js"></script>
	<script src="js/distpicker.js"></script>
	<script src="js/main.js"></script>
</html>