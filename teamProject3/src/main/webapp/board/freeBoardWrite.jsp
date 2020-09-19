<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/Write.do">
		<!-- 글번호를 input타입말고 다른방법으로  -->
		<table>
			<tr>
				<th>이름</th>
				<td><input type="text" name="member_name"></td>
			</tr>
			
			<tr>
				<th>제목</th>
				<td><input type="text" name="board_sub"></td>
			</tr>
			
			<tr>
				<th>내용</th>
				<td><textarea cols="70" rows="15" name="board_content"></textarea></td>
			</tr>
		</table>
		<div>
			<button>등록</button>
		</div>
	</form>
</body>
</html>