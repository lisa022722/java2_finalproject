<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
				<tr>
	　				<td class="title_info">系所</td>
					<td class="title_info">編號</td>
					<td class="title_info">課程名稱</td>
					<td class="title_info">學分</td>
					<td class="title_info">年級</td>
					<td class="title_info">教師</td>
					<td class="title_info">上課教室</td>
					<td class="title_info">上課時間</td>
					<td class="title_info">先修、限修</td>
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