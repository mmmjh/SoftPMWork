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
	<%
		int id = Integer.parseInt(request.getParameter("id"));
	    System.out.println(id+"序号");
		StaffDao staffDao = new StaffDao();
		StaffBean staffBean = new StaffBean();
		staffBean = staffDao.checkReg(id);
		 String[] sourceStrArray=new String[10];
		 String unit=staffBean.getLoca();
		 if(!"".equals(unit)&&unit!=null)
		 	 {sourceStrArray = unit.split(",");}
		 else
		 	{
			 sourceStrArray[0]="";
			 sourceStrArray[1]="";
			 sourceStrArray[2]="";
		 	for(int i=3;i<sourceStrArray.length;i++)
		 		sourceStrArray[i]="";
		 	}
		 String a="";
		 if(staffBean.getBorn()==null)
		   {
			 staffBean.setBorn(a);
		   }
		 if(staffBean.getEdu()==null)
		   {
			 staffBean.setEdu(a);
		   }
		 if(staffBean.getDegree1()==null)
		   {
			 staffBean.setDegree1(a);
		   }
		 if(staffBean.getMajor()==null)
		   {
			 staffBean.setMajor(a);
		   }
		 if(staffBean.getEmail()==null)
		   {
			 staffBean.setEmail(a);
		   }
		 if(staffBean.getNation()==null)
		   {
			 staffBean.setNation(a);
		   }
		 if(staffBean.getPict()==null)
		   {
			 staffBean.setPict(a);
		   }
		 
		 
			 
	%>
	<div class="rightbox">
		<h2 class="mbx">员工中心 &gt; 员工信息 &nbsp;&nbsp;&nbsp;</h2>
		<div class="morebt">
			<div class="cztable">
				<form action="StaffServlet?method=update&id=<%=staffBean.getId()%>"
					method="post">
					<table width="900" cellpadding="0" cellspacing="0">
						<tr>
							<td align="right" width="75">姓名</td>
							<td><input type="text" name="staffName" id="staffName"
								value="<%=staffBean.getStaffName()%>"></td>
								<td width="75">民族</td>
								<td><input  name="nation" id="nation" 
								value="<%=staffBean.getNation()%>" type="text"/></td>
						</tr>
						<tr>
							<td align="right">性别</td>
							<td><input type="text" name="sex" id="sex"
								value="<%=staffBean.getSex()%>"></td>
								<td width="75">出生年月</td>
								<td><input value="<%=staffBean.getBorn()%>"
								 name="born" id="born" type="text"/></td>
						</tr>
						<tr>
							<td align="right">员工编号</td>
							<td><input type="text" name="staffId" id="staffId"
								value="<%=staffBean.getStaffId()%>"></td>
								<td width="75">所学专业</td>
								<td><input value="<%=staffBean.getMajor()%>"
								 name="major" id="major" type="text"/></td>
						</tr>
						<tr>
							<td align="right">职位</td>
							<td><input type="text" name="duty" id="duty"
								value="<%=staffBean.getDuty()%>"></td>
								<%System.out.println(staffBean.getDuty()); %>
								<td width="75">学历</td>
								<td><input value="<%=staffBean.getEdu()%>" 
								name="edu" id="edu" type="text"/></td>
						</tr>
						<tr>
							<td align="right">年龄</td>
							<td><input type="text" name="age" id="age"
								value="<%=staffBean.getAge()%>"></td>
								<td width="75">学位</td>
								<td><input value="<%=staffBean.getDegree1()%>"
								 name="degree1" id="degree1" type="text"/></td>
						</tr>
						<tr>
							<td align="right">电话</td>
							<td><input type="text" name="call" id="call"
								value="<%=staffBean.getCall()%>"></td>
								<td width="75">所在地区</td>
								<td>
								<div data-toggle="distpicker">
							        <div class="form-group">
							             <select  class="form-control" name="province3" id="province3" data-province="<%=sourceStrArray[0]%>"></select>
							        </div>
							        <div class="form-group">
							          <select  class="form-control" name="city3" id="city3" data-city="<%=sourceStrArray[1]%>"></select>
							        </div>
							        <div class="form-group">
							          <select  class="form-control" name="district3" id="district3" data-district="<%=sourceStrArray[2]%>"></select>
							        </div>
							      </div>
   								 </td>
						</tr>
						<tr>
							<td align="right">工龄</td>
							<td><input type="text" name="workingAge" id="workingAge"
								value="<%=staffBean.getWorkingAge()%>"></td>
								<td width="75">E-mail</td>
								<td><input value="<%=staffBean.getEmail()%>"
								 name="email" id="email" type="text"/></td>
						</tr>
						<tr >
							
								<td width="45">照片</td>
								<td colspan="3">
								<input type="file" onchange="preview(this)" 
								name="cover" id="cover" class="layui-input" />
								<input id="id11" name="id11" type="text" value="<%=staffBean.getPict()%>"/> 
								
								 </td>
						</tr>
					</table>

					<p>&nbsp;</p>
					<div align="center">
						<input type="submit" value="提交" class="input2" style="width:200px;margin-left:300px" />
						<!--  <input type="button" name="confirmAlter" value="确认修改" 
						onclick="changeInfo()"/>-->
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
<script>
function changeInfo(){
	//alert(document.getElementById("id11").value);
	alert(document.getElementById("city3").value);
}
function preview(file) {
  var prevDiv = document.getElementById('preview');
  if (file.files && file.files[0]) {
    var reader = new FileReader();
    reader.onload = function(evt) {
      prevDiv.innerHTML = '<img src="' + evt.target.result + '" />'; 
      
      $(function(){
          /* 图片不完全按比例自动缩小 by zwwooooo */
              $('#content div.preview img').each(function(){
                  var x = 200; //填入目标图片宽度
                  var y = 200; //填入目标图片高度
                  var w=$(this).width(), h=$(this).height();//获取图片宽度、高度
                  if (w > x) { //图片宽度大于目标宽度时
                      var w_original=w, h_original=h;
                      h = h * (x / w); //根据目标宽度按比例算出高度
                      w = x; //宽度等于预定宽度
                      if (h < y) { //如果按比例缩小后的高度小于预定高度时
                          w = w_original * (y / h_original); //按目标高度重新计算宽度
                          h = y; //高度等于预定高度
                      }
                  }
                  $(this).attr({width:w,height:h});
              });
      });
      
    }
    reader.readAsDataURL(file.files[0]);
  } else {
    prevDiv.innerHTML = '<div class="img" style="filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src=\'' + file.value + '\'"></div>';
  
  }
  document.getElementById("id11").value=file.value;

 // document.getElementById("id2").value= document.getElementById("cover").value;
}
</script>
<script src="http://www.jq22.com/jquery/1.11.1/jquery.min.js"></script>
	<script src="http://www.jq22.com/jquery/bootstrap-3.3.4.js"></script>
	<script src="js/distpicker.data.js"></script>
	<script src="js/distpicker.js"></script>
	<script src="js/main.js"></script>
</html>
