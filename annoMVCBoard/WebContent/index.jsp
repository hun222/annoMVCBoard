<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index Page</title>
</head>
<body>
	<c:set var="root" value="${pageContext.request.contextPath }"/>
	<a href="${root }/board/test.do">테스트</a>
	<br><br>
	
	<a href="${root }/board/write.do">글쓰기</a>
	<br><br>
	
	<a href="${root }/board/list.do">목록보기</a>
</body>
</html>