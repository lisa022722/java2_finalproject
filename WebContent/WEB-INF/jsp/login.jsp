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
	<title>登入 - BIOS選課系統</title>
</head>
<body>
	<div class="wrap">
		<div class="header">
			<p class="title">高雄大學</p>
			<HR color="#00DD77" size="1"> 
		</div>

		<div class="body">
			<p class="system">學生選課系統</p>
			<div class="accountbox">
				<div class="account">
				<form action = "checklogin" method = "post">
					帳號：<input class="box" type="text" name="s_id">
					</div>
					<div class="password">
					密碼：<input class="box" type="password" name="s_pwd">
					</div>

			<div class="loginbox">
				
					<button class="button" type="submit" >
						登入
					</button> 
				</form>
					
				
			</div>
			</div>
		</div>

		<div class="footer">
			<span class="copyright">@2018 copyright</span>
		</div>

	</div>
</body>
</html>