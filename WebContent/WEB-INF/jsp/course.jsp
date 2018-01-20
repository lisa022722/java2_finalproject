<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<link type="text/css" rel="stylesheet" href="<c:url value='/css/style.css'/>"> 
	<meta charset="UTF-8">
	<title>課程查詢 - BIOS選課系統</title>
</head>
<body>
	<div class="wrap">
		<div class="header">
			<p class="electivetitle">高雄大學課程</p>
			<HR  style="border:1px dashed #00DD77">
		</div>

		<div class="body">

		<br/>
			<button class="stu_button"><a href="cart">已收藏課程</a></button>
			<button class="stu_button"><a href="course">查詢課程</a></button>
			<button class="stu_button"><a href="elective">加選課程</a></button>
			<button class="stu_button"><a href="student">個人資料</a></button>
		<br/>


					<select class="num" id = "department" onchange = "filter()" style = "width:200px;">
					<option>全部系所</option>
					<c:forEach var="departmentName" items="${departments}" varStatus="status">
						<option>${departmentName}</option>
					</c:forEach>
					</select>

			<table class="course_con" id = "courses_table">
			
			
	　			<tr>
	　				<td class="title_info">系所</td>
					<td class="title_info">編號</td>
					<td class="title_info">課程名稱</td>
					<td class="title_info">學分</td>
					<td class="title_info">年級</td>
					<td class="title_info">教師</td>
					<td class="title_info">上課教室</td>
					<td class="title_info">上課時間</td>
					<td class="title_info">必修/選修</td>
	　			</tr>
	
			
				<c:forEach var="course" items="${courses}" varStatus="status">
					<tr class="course_con">
					<td class="info">${course.c_dep}</td>
					<td class="info">${course.c_id}</td>
					<td class="info"><a href = "course_content?c_id=${course.c_id}">${course.c_name}</a></td>
					<td class="info">${course.c_score}</td>
					<td class="info">${course.c_grade}</td>
					<td class="info">${course.c_teacher}</td>
					<td class="info">${course.c_class}</td>
					<td class="info">${courseSessions[status.index]}</td>
					<td class="info">${course.c_classify}</td>
				</tr>
				</c:forEach>
			
				
			</table>


			<button class="del_button"><a href="logout">登出</a></button>


		</div>

		<div class="footer">
			@2018 copyright
		</div>

	</div>
	
	<script>
	function filter() {
	    var xmlhttp = new XMLHttpRequest();
	    var target = document.getElementById("courses_table");
	    var nowValue = document.getElementById("department").value;
	    console.log(nowValue);
	    xmlhttp.onreadystatechange = function () {
	        if (this.readyState == 4 && this.status == 200) {
	        	target.innerHTML = this.responseText;
	        }
	    };
	    xmlhttp.open("POST", "filtercourses_list", true);
	    xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	    xmlhttp.send("d_name=" + nowValue);
	}
	</script>
</body>
</html>