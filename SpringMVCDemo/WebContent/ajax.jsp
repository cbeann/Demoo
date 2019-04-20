<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript">

   




	$(function() {
		
		
		$('#submitbt').click(function() {
			var Username = $("#username").val();
			$.post("ajaxStr.action", {
				username : Username,
			}, function(data) {
				//从后台传过来的数据    
				alert(data);
			});
		});
		

		
		$('#ajaxlist').click(function() {
			$.post("ajaxList.action", {
				username : '123'//这是地方是参数
			}, function(data) {
				//从后台传过来的数据 字符串[{"id":1,"name":"张三"},{"id":2,"name":"李四"},{"id":3,"name":"王五"}]				
				//开始解析List<Student>
			     for(i=0;i<data.length;i++){
			    	 var str="<li value="+data[i].id+">"+data[i].id+data[i].name+"</li>";
			    	 $("#listStudent").append(str);
			     }
			});

		});
		
		
		
		$('#ajaxMap').click(function() {
			$.post("ajaxMap.action", {
				username : '123'//这是地方是参数
			}, function(data) {
				//从后台传过来的数据 字符串{"teacher":"李四","student":"张三"}			
				//开始解析Map<String>
			   
			    	 var str="<li value="+1+">"+data.student+"</li>";
			    	 $("#mapString").append(str);
			    	 var str="<li value="+1+">"+data.teacher+"</li>";
			    	 $("#mapString").append(str);
			    
			});

		});
		

	});
</script>
<body>
	<h1>返回字符串，不需要解析的</h1>
	<form action="" method="post">
		username<input type="text" name="username" id="username" /> <input
			type="button" value="Ajax" id="submitbt">
	</form>
	<br />
	<h1>返回ListStudent</h1>
	<button id="ajaxlist">获取List</button>
	<ul  id="listStudent">
		<li>如下</li>
	</ul>
	
	
	<h1>返回Map</h1>
	<button id="ajaxMap">获取Map</button>
	<ul  id="mapString">
		<li>如下</li>
	</ul>




</body>
</html>