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
	<title>Index</title>
</head>
<body>
	<div class="wrap">
		<div class="header">
			<p class="title">高雄大學</p>
			<HR color="#00DD77" size="1"> 
		</div>

		<div class="body">
			<p class="classmate">
				歡迎${s_name}同學！
			</p>

			<button class="indexbutton"><a href="course">課程查詢</a></button>
			<br/>
			<button class="indexbutton"><a href="student">個人資料</a></button>
			<br/>
			<button class="indexbutton"><a href="elective">選課系統</a></button>
			<br/>
			<button class="indexbutton"><a href="login">登出</a></button>

		</div>

		<div class="footer">
			@2018 copyright
		</div>

	</div>
</body>
</html>