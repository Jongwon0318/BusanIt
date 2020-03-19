<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>IDC</title>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script>
		$(function(){
			$("#idCheckBtn").click(function(){
				if($("#userid").val()==""){
					alert("아이디를 입력하세요");
					$("#userid").focus();
					return false;
				}
				$.ajax({
					type:"post",
					url:"idCheck.go",
					data:{"userid":$("#userid").val()},
					success : function(data){
						if(data==1){
							alert("중복된 아이디입니다.");
							$("#userid").focus();
							return false;
						}else{
							alert("사용가능한 아이디입니다.");
							$(opener.document).find("#userid").val($("#userId").val());
							$(opener.document).find("#userid1").val($("#userId").val());
							$(opener.document).find("#pwd").focus();
							self.close();
						}
					},
					error :function(e){
						alert("error:"+e)
					}
			})		
			})
		})
	
	</script>
</head>
<body>
	<form>
		<h3>아이디 중복확인</h3>
		아이디 <input type="text" name="userId" id="userId">
		<input type="button" value="사용" id="idCheckBtn">
	</form>
</body>
</html>