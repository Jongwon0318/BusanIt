<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>score</title>
<script>
function check(){
	if(document.getElementById("name").value.length==0 || !isNaN(document.getElementById("name").value)){
		alert("이름을 입력하세요");
		return;
	}else if(document.getElementById("kor").value.length==0 || isNaN(document.getElementById("kor").value)){
		alert("국어점수를 입력하세요");
		return;
	}else if(document.getElementById("math").value.length==0 || isNaN(document.getElementById("math").value)){
		alert("수학점수를 입력하세요");
		return;
	}else if(document.getElementById("eng").value.length==0 || isNaN(document.getElementById("eng").value)){
		alert("영어점수를 입력하세요");
		return;
	}
	//document.forms[0].submit();
	//frm.submit();
	document.getElementById("frm").submit();
}
</script>
</head>
<body>
	<form action="scoreresult.jsp" name="frm" id="frm">
		이름 : <input type="text" name="name" id="name"><br> 
		국어 : <input	type="text" name="kor" id="kor"><br>
	    수학 : <input type="text" name="math" id="math"><br>
	    영어 : <input type="text" name="eng" id="eng"><br>

		<input type="button" value="성적조회" onclick="check()">
		
		<!-- 버튼은 submit기능을 포함하고있고, input type="button"은 submit기능을 포함하고 있지 않음 -->
		<!-- <button>버튼성적조회</button> -->
		
		<input type="reset" value="취소">
	</form>
</body>
</html>