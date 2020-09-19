<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% request.setCharacterEncoding("UTF-8");
	String product_number = request.getParameter("product_number");
	String product_name = request.getParameter("product_name");
	String product_price = request.getParameter("product_price");
	String product_unit = request.getParameter("product_unit");
	String product_status = request.getParameter("product_status");
	String seller_code = request.getParameter("seller_code");
	
	%>
</body>
</html>