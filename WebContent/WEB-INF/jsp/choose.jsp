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
	<title>收藏清單 - BIOS選課系統</title>
</head>
<body>
	<div class="wrap">
		<div class="header">
			<p class="choosetitle">收藏清單</p>
			<HR color="#00DD77" size="1"> 
		</div>

		<div class="body">
		

			<button class="stu_button"><a href="cart">已收藏課程</a></button>
			<button class="stu_button"><a href="course">查詢課程</a></button>
			<button class="stu_button"><a href="elective">加選課程</a></button>
			<button class="stu_button"><a href="student">個人資料</a></button>


			<p class="listin">已加入收藏清單的課程</p>


			<table class="course_con">
	　			<tr>
	　				<td class="title_info">課程編號</td>
					<td class="title_info">課程名稱</td>
					<td class="title_info">上課節次</td>
					<td class="title_info">上課教室</td>
					<td class="title_info">移除</td>
				</tr>
				<c:forEach var="course" items="${myCartCourses}" varStatus="status">
					<tr>
						<td class="intro">${course.c_id}</td>
						<td class="intro"><a href = "course_content?c_id=${course.c_id}">${course.c_name}</a></td>
						<td class="intro">${myCartCourseSessions[status.index]}</td>
						<td class="intro">${course.c_class}</td>
						<td class="intro"><a href = "deleteFromCart?c_id=${course.c_id}">移除</a></td>
					</tr>
				</c:forEach>
			</table>	


			<br/>
			<button class="indexbutton"><a href="elective">繼續選課</a></button>
			<button class="indexbutton"><a href="logout">登出</a></button>

		</div>

		<div class="footer">
			@2018 copyright
		</div>

	</div>
</body>
</html>