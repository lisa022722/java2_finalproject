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
	<title>Course_content</title>
</head>
<body>
	<div class="wrap">
		<div class="header">
			<p class="coursetitle">高雄大學課程內容</p>
			<HR  style="border:1px dashed #00DD77">
		</div>

		<div class="body">


			<br/>
			<button class="stu_button"><a href="cart">已收藏課程</a></button>
			<button class="stu_button"><a href="course">查詢課程</a></button>
			<button class="stu_button"><a href="elective">加選課程</a></button>
			<button class="stu_button"><a href="student">個人資料</a></button>


			<br/>

			<span class="word">我想要...</span>
			<button class="directbutton"><a href="javascript:addToChoose('${course.c_id}')">直接選課</a></button>
			<button class="directbutton"><a href="javascript:addToCollection('${course.c_id}')">加入代選清單</a></button>
			

			

			<table class="course_con">
	　			<tr>
	　				<td class="title_info">課程中文名稱</td>
					<td class="intro">${course.c_name}</td>
				</tr>
				<tr>
					<td class="title_info">教室</td>
					<td class="intro">${course.c_class}</td>
				</tr>
				<tr>
					<td class="title_info">課程編號</td>
					<td class="intro">${course.c_id}</td>
				</tr>
				<tr>
					<td class="title_info">授課老師</td>
					<td class="intro">${course.c_teacher}</td>
				</tr>
				<tr>
					<td class="title_info">修習類別</td>
					<td class="intro">${course.c_classify}</td>
				</tr>
				<tr>
					<td class="title_info">限修人數</td>
					<td class="intro">${course.c_limit}</td>
				</tr>
			</table>	
		
	　			<div class="course_intro">
				<table class="course_con2">
					<tr>
						<td class="intro_con">教學目標</td>
						<td class="intro">${course.c_target}</td>
					</tr>
					<tr>
						<td class="intro_con">課程內容大綱</td>
						<td class="intro">${course.c_content}</td>
					</tr>
					<tr>
						<td class="intro_con">教科書/參考書</td>
						<td class="intro">${course.c_books}</td>
					</tr>
					<tr>
						<td class="intro_con">備註</td>
						<td class="intro">${course.c_ps}</td>
					</tr>
				</table>
				</div>
				
				<button class="coursebutton"><a href="studentlist?c_id=${course.c_id}">當前修課名單</a></button>
				<button class="coursebutton">返回</button>	
				<button class="del_button"><a href="login">登出</a></button>
			
		</div>

		<div class="footer">
			@2018 copyright
		</div>

	</div>
	
	<script>
	function addToCollection(c_id) {
	    var xmlhttp = new XMLHttpRequest();
	    xmlhttp.onreadystatechange = function () {
	        if (this.readyState == 4 && this.status == 200) {
	        	var text = this.responseText;
	        	text = text.replace(/\r\n|\n/g,"");
	        	text = text.replace(/\s+/g, "");
	            alert(text);
	        }
	    };
	    xmlhttp.open("POST", "addtocollection", true);
	    xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	    xmlhttp.send("c_id=" + c_id);
	}
	
	function addToChoose(c_id) {
	    var xmlhttp = new XMLHttpRequest();
	    xmlhttp.onreadystatechange = function () {
	        if (this.readyState == 4 && this.status == 200) {
	        	var text = this.responseText;
	        	text = text.replace(/\r\n|\n/g,"");
	        	text = text.replace(/\s+/g, "");
	            alert(text);
	        }
	    };
	    xmlhttp.open("POST", "addtochoose", true);
	    xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	    xmlhttp.send("c_id=" + c_id);
	}
	</script>
</body>
</html>