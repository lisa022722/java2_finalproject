<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<meta charset="UTF-8">
	<title>Login_error</title>
</head>
<body>
	<div class="wrap">
		<div class="header">
			<p class="title">高雄大學</p>
			<HR color="#00DD77" size="1">
		</div>

		<div class="body">
			<p class="pwerror">密碼錯誤！</p>
			<br/>
			<Br/>
			<br/>
			<br/>
			<p class="back">三秒後自動回登入頁</p>
		</div>

		<div class="footer">
			@2018 copyright
		</div>

	</div>
	<script type="text/javascript">
		window.setTimeout(function(){
	
	        window.location.href = "login";
	
	    }, 3000);
	</script>
	 
</body>
</html>