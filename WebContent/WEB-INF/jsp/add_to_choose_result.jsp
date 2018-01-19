<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:if test = "${result == 'success'}">
	成功選課！
</c:if>
<c:if test = "${result == 'repeated'}">
	你選過這堂課囉！
</c:if>
<c:if test = "${result == 'failed'}">
	選課失敗！
</c:if>
<c:if test = "${result == 'rush'}">
	衝堂了！
</c:if>

<c:if test = "${result == 'filled'}">
	學分爆了！
</c:if>