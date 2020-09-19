<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberInsertOutput.jsp</title>
</head>
<body>
	
<form action="${pageContext.request.contextPath}/member/login.do">
	${cnt}이 등록됨
	<button>로그인이동</button>
</form>
</body>
</html>