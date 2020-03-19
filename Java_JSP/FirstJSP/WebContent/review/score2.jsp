<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>score2</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
	$(document).ready(function(){
		$("#btn").click(function(){
			if($("#kor").val()=="0" || !$.isNumeric($("#name").val())){
				alert("국어점수를 입력하세요");
				return;
			}
			$("#frm").submit();
		})
	});
</script>
</head>
<body>
<form action="scoreresult1.jsp" name="frm" id="frm">
		이름 : <input type="text" name="name" id="name"><br> 
		국어 : <input	type="text" name="kor" id="kor" value=0><br>
	    수학 : <input type="text" name="math" id="math" value=0><br>
	    영어 : <input type="text" name="eng" id="eng" value=0><br>
		<input type="button" value="성적조회"  id="btn">
		
		<!-- 버튼은 submit기능을 포함하고있고, input type="button"은 submit기능을 포함하고 있지 않음 -->
		<!-- <button>버튼성적조회</button> -->
		
		<input type="reset" value="취소">
	</form>
</body>
</html>