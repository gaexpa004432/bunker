<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="jquery-ui.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="jquery-ui.js"></script>
<script>
$(function(){
	$("#msg").dialog({
			autoOpen: false,
	        height: 400,
	        width: 350,
	        modal: true,
})	
$("tr").on("click",function(){
	       
	var no = $(this).children().eq(3).text();
	var id = $(this).children().eq(1).text();
	var sub = $(this).children().eq(0).text();
	var val = $(this).children().eq(2).text();
	$("#msg").dialog("open");
	console.log($(this).children().eq(3).text());
	$("#frm").html("<br>글번호 : ").append($("<input>").val(no).attr("readonly","readonly").attr("name","board_no"))
	.append($("<label>").html("<br><br>작성자 : ")).append($("<input>").val(id).attr("readonly","readonly")).append($("<label>").html("<br><br> 제목  :&nbsp; &nbsp; "))
	.append($("<input>").val(sub).attr("name","board_sub")).append($("<label>").html("<br><br> 내용 : &nbsp; ")).append($("<textarea>").attr("rows","4").attr("cols","23").val(val).attr("name","board_content"))
	.append($("<p>")).append($("<button>").text("수정"))
	    });
	
	
	
})
</script>
</head>
    
<body align="center">
	<table id="list" border="1" align="center">
		<thead>
			<tr>
				<th>제목</td>
				<th>id</td>
				<th>내용</td>
				<th>글번호</td>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${list}" var="board">
		<!-- 컨트롤러에서 보내준 리스트가 board로 이름만 바뀜 -->
		<!--db에서 들고온 리스트를 컨트롤러를 거쳐서 jsp페이지로 받아옴 -->

		<tr>
			<td><a href="#">${board.board_sub}</a></td>
			<td>${board.member_id}</td>
			<td>${board.board_content}</td>
			<td>${board.board_no}</td>
			<td><a href="freeBoardDelete.do?board_no=${board.board_no}">삭제</a></td>
			<!-- ?뒤가 파라미터 -->
			
			</tr>
			</c:forEach>
			</tbody>
		</tbody>	
	</table>
	<div id="msg">
	<form id="frm" action="${pageContext.request.contextPath}/freeBoardUpdate.do" align="center">
</form>
</div>
</body>
</html>