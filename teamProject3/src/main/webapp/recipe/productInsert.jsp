<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>productInsert</title>
<script>

	function input() {
<<<<<<< HEAD
		if(frm.product_number.value == "") {
			window.alert("상품번호 입력하세요");
			frm.product_number.focus();
			return false;
		}
		
		if(frm.product_name.value == "") {
			window.alert("상품이름 입력하세요");
			frm.product_name.focus();
			return false;
		}
		
		if(frm.product_price.value == "") {
			window.alert("상품가격 입력하세요");
			frm.product_price.focus();
			return false;
		}
		
		if(frm.product_unit.value == "") {
			window.alert("상품단위 입력하세요");
			frm.product_unit.focus();
			return false;
		}
		
		if(frm.product_status.value == "") {
			window.alert("상품주문상태 입력하세요");
			frm.product_status.focus();
			return false;
		}
		
		if(frm.seller_code.value == "") {
			window.alert("소상공인번호 입력하세요");
			frm.seller_code.focus();
			return false;
		}
		
		return true;
	}
	
</script>

</head>
<body>
	<h1>재료 등록</h1>

	<form method="post" action="/teamProject3/save_product.do">
		<div>
			<label for="product_number">상품번호</label> 
			<input type="text" name="product_number" id="product_number">
		</div>
	
		<div>
			<label for="product_name">상품이름</label> 
			<input type="text" name="product_name" id="product_name">
		</div>
		
		<div>
			<label for="product_price">상품가격</label> 
			<input type="text" name="product_price" id="product_price">
		</div>
		
		<div>
			<label for="product_unit">상품단위</label> 
			<input type="text" name="product_unit" id="product_unit">
		</div>
		
		<div>
			<label for="product_status">상품주문상태</label> 
			<input type="text" name="product_status" id="product_status">
		</div>
=======
	/* 	if(frm.product_number.value == "") {
			window.alert("상품번호 입력하세요");
			frm.product_number.focus();
			return false;
		} */
		
		if(frm.product_name.value == "") {
			window.alert("상품이름 입력하세요");
			frm.product_name.focus();
			return false;
		}
		
		if(frm.product_price.value == "") {
			window.alert("상품가격 입력하세요");
			frm.product_price.focus();
			return false;
		}
		
		if(frm.product_unit.value == "") {
			window.alert("상품단위 입력하세요");
			frm.product_unit.focus();
			return false;
		}
		
		/* if(frm.product_status.value == "") {
			window.alert("상품주문상태 입력하세요");
			frm.product_status.focus();
			return false;
		} */
		
		if(frm.seller_code.value == "") {
			window.alert("소상공인번호 입력하세요");
			frm.seller_code.focus();
			return false;
		}
		
		return true;
	}
	
</script>

</head>
<body>
	<h1>재료 등록</h1>

	<form method="post" action="/teamProject3/save_product.do">
<!-- 		<div>
			<label for="product_number">상품번호</label> 
			<input type="text" name="product_number" id="product_number">
		</div> -->
	
		<div>
			<label for="product_name">상품이름</label> 
			<input type="text" name="product_name" id="product_name">
		</div>
		
		<div>
			<label for="product_price">상품가격</label> 
			<input type="text" name="product_price" id="product_price">
		</div>
		
		<div>
			<label for="product_unit">상품단위</label> 
			<input type="text" name="product_unit" id="product_unit">
		</div>
		
	<!-- 	<div>
			<label for="product_status">상품주문상태</label> 
			<input type="text" name="product_status" id="product_status">
		</div> -->
>>>>>>> branch 'master' of https://github.com/gaexpa004432/gitrepo
		
		<div>
			<label for="seller_code">소상공인번호</label> 
			<input type="text" name="seller_code" id="seller_code">
		</div>
		
		<br>
		<button>등록</button>		
	</form>
</body>
</html>