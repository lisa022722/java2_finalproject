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
	<title>Course_list</title>
</head>
<body>
	<div class="wrap">
		<div class="header">
			<p class="electivetitle">我的課程一覽表</p>
			<HR  style="border:1px dashed #00DD77">
		</div>

		<div class="body">
			<button class="stu_button"><a href="cart">已收藏課程</a></button>
			<button class="stu_button"><a href="course">查詢課程</a></button>
			<button class="stu_button"><a href="elective">加選課程</a></button>
			<button class="stu_button"><a href="student">個人資料</a></button>
		
			<table class="course_con">
	　			<tr>
	　				<td class="title_info">課程編號</td>
					<td class="title_info">上課時間</td>
					<td class="title_info">上課教室</td>
				</tr>
				<tr>
					<td class="intro">01</td>
					<td class="intro">Sat 9:00~12:00</td>
					<td class="intro">L-108</td>
				</tr>
				<tr>
					<td class="intro">內容</td>
					<td class="intro">內容</td>
					<td class="intro">內容</td>
				</tr>
				<tr>
					<td class="intro">內容</td>
					<td class="intro">內容</td>
					<td class="intro">內容</td>
				</tr>
				<tr>
					<td class="intro">內容</td>
					<td class="intro">內容</td>
					<td class="intro">內容</td>
				</tr>
				<tr>
					<td class="intro">內容</td>
					<td class="intro">內容</td>
					<td class="intro">內容</td>
				</tr>
				<tr>
					<td class="intro">內容</td>
					<td class="intro">內容</td>
					<td class="intro">內容</td>
				</tr>
				<tr>
					<td class="intro">內容</td>
					<td class="intro">內容</td>
					<td class="intro">內容</td>
				</tr>
				<tr>
					<td class="intro">內容</td>
					<td class="intro">內容</td>
					<td class="intro">內容</td>
				</tr>
				<tr>
					<td class="intro">內容</td>
					<td class="intro">內容</td>
					<td class="intro">內容</td>
				</tr>
				<tr>
					<td class="intro">內容</td>
					<td class="intro">內容</td>
					<td class="intro">內容</td>
				</tr>
				<tr>
					<td class="intro">內容</td>
					<td class="intro">內容</td>
					<td class="intro">內容</td>
				</tr>
				<tr>
					<td class="intro">內容</td>
					<td class="intro">內容</td>
					<td class="intro">內容</td>
				</tr>
				<tr>
					<td class="intro">內容</td>
					<td class="intro">內容</td>
					<td class="intro">內容</td>
				</tr>
			</table>	
		
		
			<button class="del_button">返回</button>	
			
		</div>

		<div class="footer">
			@2018 copyright
		</div>

	</div>
</body>
</html>