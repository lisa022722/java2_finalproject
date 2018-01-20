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
	<title>修課名單 - BIOS選課系統</title>
</head>
<body>
	<div class="wrap">
		<div class="header">
			<p class="electivetitle">選課名單</p>
			<HR  style="border:1px dashed #00DD77">
		</div>

		<div class="body">
		
			<button class="stu_button"><a href="cart">已收藏課程</a></button>
			<button class="stu_button"><a href="course">查詢課程</a></button>
			<button class="stu_button"><a href="elective">加選課程</a></button>
			<button class="stu_button"><a href="student">個人資料</a></button>
		
			<table class="course_con">
			
	　			<tr>
	　				<td class="title_info">學生姓名</td>
					<td class="title_info">科系</td>
					<td class="title_info">系級</td>
				</tr>
				<c:forEach var="student" items="${students}" varStatus="status">
				<tr>
					<td class="intro">${student.s_name}</td>
					<td class="intro">${student.s_department}</td>
					<td class="intro">${student.s_grade}</td>
				</tr>
				</c:forEach>
				
			</table>	
		
		
			<button class="courselist_button">返回</button>	
			
		</div>

		<div class="footer">
			@2018 copyright
		</div>

	</div>
</body>
</html>