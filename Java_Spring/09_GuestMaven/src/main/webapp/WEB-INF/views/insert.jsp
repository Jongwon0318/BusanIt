<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
</head>

<body>
	<form action="gInsert" method="post">
		<label for="name">글쓴이</label>
		<input type="text" name="name" id="name"><br>
		<label for="content">내용</label>
		<input type="text" name="content" id="content" size="150"><br>
		평가
		<input type="radio" name="grade" value="아주잘함(excellent)">아주잘함(excellent)
		<input type="radio" name="grade" value="잘함(good)">잘함(good)
		<input type="radio" name="grade" value="보통(normal)">보통(normal)
		<input type="radio" name="grade" value="노력(fail)">노력(fail) <br>
		<input type="button" id="submit" value="입력">
	</form>
	<br>
	<hr>
	<div id="result" align="center"></div>
</body>

<script>
	$(function(){
		$("#submit").click(sendIt);
		getData();
	})

	function getData(){
		$.get("gList", function(retData){
			$("#result").html(retData);			
		})
	}

	function sendIt(){
		var name = $("#name").val();
		var content = $("#content").val();
		var grade = $("input:radio[name=grade]:checked").val();
		var postString = "name="+name+"&content="+content+"&grade="+grade;
		$.ajax({
			type:"post",
			url:"gInsert",
			data:postString,
			success:function(retData){
				$("#result").html(retData)
				$("#name").val("");
				$("#content").val("");
				$("input:radio[name=grade]").prop("checked", false);
			},
			beforeSend : showRequest,
			error : function(e) {
				alert("error : " + e);
			}
		});

		function showRequest() {
			if(!$("#name").val()) {
				alert("글쓴이를 입력하세요");
				$("#name").focus();
				return false;
			}
			if(!$("#content").val()) {
				alert("내용을 입력하세요");
				$("#content").focus();
				return false;
			}
			// $("input:radio[name=grade]:checked").length==0
			// !$("input:radio[name=grade]:checked").val()
			// 셋 다 사용 가능
			if(!$("input:radio[name=grade]").is(":checked")) {
				alert("등급을 선택하세요");
				return false;
			}
			return true;
		}
	}
</script>
</html>