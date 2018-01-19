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
	<title>Elective</title>
</head>
<body>
	<div class="wrap">
		<div class="header">
			<p class="electivetitle">我的課程一覽表</p>
			<HR  style="border:1px dashed #00DD77">
		</div>

		<div class="body">
		
			<br/>
			<button class="stu_button"><a href="cart">已收藏課程</a></button>
			<button class="stu_button"><a href="course">查詢課程</a></button>
			<button class="stu_button"><a href="elective">加選課程</a></button>
			<button class="stu_button"><a href="student">個人資料</a></button>
			<br/>

			<form action = "addtochoosegeneral" method = "post">
				<div class="elective">
					<div class="subtitle">選課</div>
					<div class="subtitle">已選學分：${myScore}</div>
					<div class="course_num">課程編號
					<select class="num" id = "department" onchange = "filter()">
					<option>全部系所</option>
					<c:forEach var="departmentName" items="${departments}" varStatus="status">
						<option>${departmentName}</option>
					</c:forEach>
					</select>
					
					
						<select class="num" id = "course_select" name = "c_id" style = "width:200px;">
						<option value = "none">請先選擇系所</option>
						</select>
						
						<button type = "submit">選課</button>
					
					</div>
				</div>
			</form>
			




			<table class="course_con" id = "courses_table">
	　			<tr>
	　				<td class="title_info">課程編號</td>
					<td class="title_info">課程名稱</td>
					<td class="title_info">學分數</td>
					<td class="title_info">上課時間</td>
					<td class="title_info">上課教室</td>
					<td class="title_info">退選</td>

				</tr>
				<c:forEach var="course" items="${courses}" varStatus="status">
					<tr>
						<td class="intro">${course.c_id}</td>						
						<td class="intro"><a href = "course_content?c_id=${course.c_id}">${course.c_name}</td>
						<td class="intro">${course.c_score}</td>
						<td class="intro">${courseSessions[status.index]}</td>
						<td class="intro">${course.c_class}</td>
						<td class="intro"><a href = "deleteFromChoose?c_id=${course.c_id}">退選</a></td>
					</tr>
				</c:forEach>				
			</table>	
		
		
			<button class="electivebutton">返回</button>	
			<button class="del_button"><a href="logout">登出</a></button>
			
		</div>

		<div class="footer">
			@2018 copyright
		</div>

	</div>
	
	<script>
	function filter() {
	    var xmlhttp = new XMLHttpRequest();
	    var target = document.getElementById("course_select");
	    var nowValue = document.getElementById("department").value;
	    console.log(nowValue);
	    xmlhttp.onreadystatechange = function () {
	        if (this.readyState == 4 && this.status == 200) {
	        	target.innerHTML = this.responseText;
	        }
	    };
	    xmlhttp.open("POST", "filtercourses", true);
	    xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	    xmlhttp.send("d_name=" + nowValue);
	}
	</script>
	
	<c:if test = "${result == 'repeated'}">
	<script type="text/javascript">
		alert("你選過這堂課囉！");
		window.location.replace("elective");
	</script>
	</c:if>
	<c:if test = "${result == 'rush'}">
	<script type="text/javascript">
		alert("衝堂了！");
		window.location.replace("elective");
	</script>
	</c:if>
	<c:if test = "${result == 'filled'}">
	<script type="text/javascript">
		alert("學分爆了！");
		window.location.replace("elective");
	</script>
	</c:if>
	
</body>
</html>