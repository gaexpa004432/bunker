<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
</script>
<title>주소 입력 샘플</title>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="/teamProject3/api/addressApi.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
// 이미지 정보들을 담을 배열
var sel_files = [];


$(document).ready(function() {
    $("#input_imgs").on("change", handleImgFileSelect);
}); 

function fileUploadAction() {
    console.log("fileUploadAction");
    $("#input_imgs").trigger('click');
} 

function handleImgFileSelect(e) {

    // 이미지 정보들을 초기화
    sel_files = [];
    $(".imgs_wrap").empty();

    var files = e.target.files;
    var filesArr = Array.prototype.slice.call(files);

    var index = 0;
    filesArr.forEach(function(f) {
        if(!f.type.match("image.*")) {
            alert("확장자는 이미지 확장자만 가능합니다.");
            return;
        }

        sel_files.push(f);

        var reader = new FileReader();
        reader.onload = function(e) {
            var html = "<a href=\"javascript:void(0);\" onclick=\"deleteImageAction("+index+")\" id=\"img_id_"+index+"\"><img src=\"" + e.target.result + "\" data-file='"+f.name+"' class='selProductFile' title='Click to remove' style='width:100px; height:100px;'></a>";
            $(".imgs_wrap").append(html);
            index++;

        }
        reader.readAsDataURL(f);
        
    });
}



function deleteImageAction(index) {
    console.log("index : "+index);
    console.log("sel length : "+sel_files.length);
    console.log($("#input_imgs").val());
    sel_files.splice(index, 1);

    var img_id = "#img_id_"+index;
    $(img_id).remove(); 
}

function fileUploadAction() {
    console.log("fileUploadAction");
    $("#input_imgs").trigger('click');
}

function submitAction() {
    console.log("업로드 파일 갯수 : "+sel_files.length);
    var data = new FormData();

    for(var i=0, len=sel_files.length; i<len; i++) {
        var name = "image_"+i;
        data.append(name, sel_files[i]);
    }
    data.append("image_count", sel_files.length);
    
    if(sel_files.length < 1) {
        alert("한개이상의 파일을 선택해주세요.");
        return;
    }           

    var xhr = new XMLHttpRequest();
    xhr.open("POST","./study01_af.php");
    xhr.onload = function(e) {
        if(this.status == 200) {
            console.log("Result : "+e.currentTarget.responseText);
        }
    }

    xhr.send(data);

}
</script>
</head>
<body>
<form name="form" id="form" method="post" align="center" enctype='multipart/form-data' action="/teamProject3/restaurantWrite.do">

<div><input name="res_name" style="width:300px" placeholder="식당명 입력"></div><br>

	<div><input name="res_tel" style="width:300px" placeholder="전화번호 등록"> </div><br>
	
	<div>
		<input type="text" id="sample4_postcode" placeholder="우편번호" style="width:200px">
		<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
		<input type="text" id="sample4_roadAddress" name="res_si" placeholder="도로명주소" style="width:150px">
		<input type="text" id="sample4_jibunAddress" name="res_gu" placeholder="지번주소" style="width:150px">
		<span id="guide" style="color:#999;display:none"></span>
		<input type="text" id="sample4_detailAddress"  placeholder="상세주소" hidden>
		<input type="text" id="sample4_extraAddress" placeholder="참고항목" hidden>
		
	</div>
	
	<div>
		<input type="file" id="input_imgs" name="res_picture" multiple/>
	</div>
	<div>
		<div class="imgs_wrap">
			<img id="img" />
		</div>
	</div>
	<div>
	<br>
	<textarea cols="100" rows="50" name="res_content"></textarea>
	</div>
	
	<div>
		<button>등록</button>
	</div>
	
</form>
</body>
</html>