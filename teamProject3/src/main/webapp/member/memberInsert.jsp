<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>memberInsert.jsp</title>
<script>
function inputCheck() {
	//필수체크 입력
	if(frm.member_id.value == "") {
		window.alert("아이디를 입력하세요");
		frm.member_id.focus();
		return false;
	}
	if(frm.member_pass.value == "") {
		alert("비밀번호를 입력하세요");
		frm.member_pass.focus();
		return false;
	}
	if(frm.member_pass.value != frm.member_passCheck.value) {
		alert("비밀번호가 일치하지 않습니다");
		frm.member_pass.focus();
		return false;
	}
	if(frm.member_tel.value == "") {
		window.alert("전화번호를 입력하세요");
		frm.member_tel.focus();
		return false;
	}
	if(frm.member_name.value == "") {
		window.alert("이름을 입력하세요");
		frm.member_name.focus();
		return false;
	}
	if(frm.member_birth.value == "") {
		window.alert("생년월일을 입력하세요");
		frm.member_birth.focus();
		return false;
	}
	
	//job(select 태그) 선택되었는지 확인
	if(frm.member_type.value == "") {
	//if(frm.job.selectedIndex > 0) {}
		alert("job선택");
		frm.job.focus();
		return false;
	}
		
	/*var gender =
		document.querySelectorAll("[name='gender']:checked").length;
	if(gender == 0) {
		alert("성별 적어도 하나는 선택");
		return false;
	}
	return true;*/
		
}


//전화번호에서 숫자만 받기
function onlyNumber(event){
    event = event || window.event;
    var keyID = (event.which) ? event.which : event.keyCode;
    if ( (keyID >= 48 && keyID <= 57) || (keyID >= 96 && keyID <= 105) || keyID == 8 || keyID == 46 
    		|| keyID == 37 || keyID == 39 || keyID == 9 || keyID ==116 ) 
        return;
    else
        return false;
}
    
//전화번호에서 한글 못받게 하기 (코드만들기)

}

</script>

<!-- 주소api -->
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<script type="text/javascript" src="/teamProject3/api/addressApi.js"></script>

</head>
<body>${ooooo }====
<h3>회원등록</h3>
<div class="regist">
	<form method="post" name="frm" id="frm" 
		  action="Insert.do" 
		  onsubmit="return inputCheck()">
	<div>
		<label>아이디</label>
		<input type="text" name="member_id">
	</div>
	<div>
		<label>비밀번호</label>
		<input type="password" name="member_pass">
	</div>
	<div>
		<label>비밀번호 확인</label>
		<input type="password" name="member_passCheck">
	</div>
	<div>
		<label>이름</label>
		<input type="text" name="member_name">
	</div>
	<div>
		<label>성별</label>
		<input type="radio" name="member_gender" value="male" checked>남
		<input type="radio" name="member_gender" value="female">여
	</div>
	<div>
		<label>생년월일</label>
		<input type="date" name="member_birth">
	</div>
	<div>
		<label>전화번호</label>
		<input type="text" name="member_tel" onkeydown='return onlyNumber(event)'>
	</div>
	<div>
		<label>주소</label><br>
		<input type="text" name="member_postcode" id="sample4_postcode" placeholder="우편번호">
		<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
		<input type="text" name="member_roadAddress" id="sample4_roadAddress" placeholder="도로명주소">
		<input type="text" name="member_jibunAddress" id="sample4_jibunAddress" placeholder="지번주소">
		<span id="guide" style="color:#999;display:none"></span>
		<input type="text" name="member_detailAddress" id="sample4_detailAddress" placeholder="상세주소">
		<input type="text" name="member_extraAddress" id="sample4_extraAddress" placeholder="참고항목">
	</div>
	<div>
		<label>채식타입</label>
		<select name="member_type" id="member_type" length="4">
			<option value="">선택</option>
			<option value="vegan">비건(Vegan)</option>
			<option value="lacto">락토(Lacto)</option>
			<option value="ovo">오보(Ovo)</option>
			<option value="lacto_ovo">락토오보(Lacto-Ovo)</option>
			<option value="pesco">페스코(Pesco)</option>
			<option value="Pollo">폴로(Pollo)</option>
			<option value="flexitarian">플렉시테리언(Flexitarian)</option>
		</select>	
	</div>
	<div>
		<button type="reset" name="reset">초기화</button>
		<button>등록</button>
		<!-- <button type="button" name="submit" onclick="inputCheck()">등록</button> -->
	</div>
	</form>
</div>
</body>
</html>