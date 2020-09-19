<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>식당 추천</title>
</head>
<body>
<%--  <c:set var="i" value="0" />
 <c:set var="j" value="4" />
 <table border=1>
  <c:choose>
   <c:when test="true">
   <!-- ${couponkey != null && fn:length(couponkey) > 0 }  -->
    <c:forEach items="${couponkey}" var="couponlist">
     <c:if test="{i%j == 0}">
      <tr>
     </c:if>
     <td>${couponlist.coupon_name}</td>
    <c:if test="${i%j == j-1}">
     </tr>
    </c:if> 
   <c:set var="i" value="${i+1}" />
    </c:forEach>
   </c:when>
  <c:otherwise>
   <tr>
    <td>존재하지 않습니다.</td>
   </tr>
  </c:otherwise>
  </c:choose> 
  
  
 </table>--%>
<%--  <form name="searchFrm">		
	<input type="hidden" name="p" value="1">
	<input name="" value="">
	<button>검색</button>
</form>


 <my:paging paging="${paging}" jsfunc="gopage" />
<script>
	function gopage(p) {			// 검색 function
		searchFrm.p.value = p;		// 페이지번호 받아와서 submit에 넘김
		searchFrm.submit();
		
		// location.href="deptSelectAll?p=" + p;	// 이동되는 주소가 달라서 여러사람이 쓰기위해서는 매개값 p로 해줌
	}
</script> --%>
<c:forEach items=" " var="array">
${ array.res_no }
</c:forEach>
</body>

</html>