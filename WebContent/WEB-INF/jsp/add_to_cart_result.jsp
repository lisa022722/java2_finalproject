<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:if test = "${result == 'success'}">
	成功加入待選清單！
</c:if>
<c:if test = "${result == 'repeated'}">
	重複加入囉！
</c:if>
<c:if test = "${result == 'failed'}">
	加入待選清單失敗！
</c:if>