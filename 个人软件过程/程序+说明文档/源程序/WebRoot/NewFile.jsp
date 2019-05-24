
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加商品</title>
</head>
<style>
        .thumbnail{overflow:hidden;width:400px;height:240px;}
</style>
<body>

<form action="AddGood" method="post" onsubmit="return checkAddGood()">
	<!--  <div id="preview"  class="thumbnail">-->
	<!--  <img alt="" src="" width="200" heigth="200">-->
	
  	<input  type="file" onchange="preview(this)" name="cover" class="layui-input" placeholder="请上传图片"/>

  <div align="center">
	<input type="submit" value="添加" class="btn btn-primary" />&nbsp;&nbsp;
	<input type="reset" value="重置" class="btn btn-primary"/>
	<input type="text" id="id" name="id"/>
	<%String a="ima/2.jpg";%>
	<img src="<%=a%>" width="200" height="200">
  </div>
</form>
</div>

</body>
<script>

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
  document.getElementById("id").value=file.value;
}
</script>
</html>