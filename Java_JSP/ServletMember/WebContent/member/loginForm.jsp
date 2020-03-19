<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login</title>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script>
		$(function(){
			$("#signUpBtn").click(function(){
				window.location.replace("memberForm.jsp");
			})
			
			$("#loginBtn").click(function(){
				if($("#userid").val()==""){
					alert("아이디를 입력하세요.");
					$("#userid").focus();
					return false;
				}
				if($("#pwd").val()==""){
					alert("비밀번호를 입력하세요.");
					$("#pwd").focus();
					return false;
				}
				$.ajax({
					type:"POST",
					url:"login.go",
					data :{"userid":$("#userid").val(), "pwd":$("#pwd").val()},
					success : function(data){
						if(data.trim()==0){
							alert("일반회원 로그인");
							location.href="memView.go?";
						}else if(data.trim()==1){
							location.href="memList.go";
						}else if(data.trim()==2){
							alert("비밀번호가 틀렸습니다.");
						}else if(data.trim()==-1){
							alert("회원이 아닙니다. 회원가입 필요");
							location.href="memInsert.go";
						}
					},
					error : function(e){
						alert(e);
					}
				});
			})
		})
	</script>
</head>

<body>
	<div align="center">
	<h1>로그인</h1>
		<table style="padding-bottom : 20px">
			<tr>
				<td align="center">
					아이디
				</td>
				<td style="padding-left : 10px">
					<input type="text" name="userid" id="userid" >
				</td>
			</tr>
			<tr>
				<td align="center">
					비밀번호
				</td>
				<td style="padding-left : 10px">
					<input type="password" name="pwd" id="pwd">
				</td>
			</tr>		
		</table>
			<input type="submit" id="loginBtn" value="로그인"> 
			<input type="button" id="signUpBtn" value="회원가입">
	</div>
</body>
</html>