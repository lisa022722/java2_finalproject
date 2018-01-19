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
	<title>Student</title>
</head>
<body>
	<div class="wrap">
		<div class="header">
			<p class="title">高雄大學</p>
			<HR color="#00DD77" size="1"> 
		</div>

		<div class="body">

		<br/>
			<button class="stu_button"><a href="cart">已收藏課程</a></button>
			<button class="stu_button"><a href="course">查詢課程</a></button>
			<button class="stu_button"><a href="elective">加選課程</a></button>
			<button class="stu_button"><a href="student">個人資料</a></button>
		<br/>

			<img class="stu_pic" src="${ me.s_picture }" >

			<form action = "studentresult" method = "post">
			<div class="profile">
				<p class="content">姓名：${ me.s_name }</p>
				<p class="content">科系：${ me.s_department }</p>
				<p class="content">系級：${ me.s_grade }級</p>
				<p class="content">信箱：
				<input class="inputbox" type="text" name="email" value="${ me.s_email }">
				</p>
				<p class="content">電話：
				<input class="inputbox" type="text" name="phone" value = "${ me.s_phone }">
				</p>
				<button class="change" type = "submit">確認修改</button>
				<button class="change" onclick = "location.href='logout'">登出</button>
			</div>
			</form>
		</div>

		<div class="footer">
			@2018 copyright
		</div>

	</div>
</body>
</html>