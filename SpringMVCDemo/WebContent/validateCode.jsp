<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<script type="text/javascript" src="jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
$(function() {
	
        $('#kaptchaImage').click(function () {
            $("#kaptcha").attr('src', 'kaptcha.jpg?' + Math.floor(Math.random()*100) );
        })
 
   
});
</script>
<body>

1231
<form action="kaptcha.action" method="post">
<input type="text" name="checkCode">
<img src="kaptcha.jpg" id="kaptcha">
<input type="button"  id="kaptchaImage"  value="刷新">
<input type="submit" value="提交">
</form>
</body>
</html>