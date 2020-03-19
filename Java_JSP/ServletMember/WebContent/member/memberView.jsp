<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>MemberView</title>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script>
		check=function(){
			if($("#pwd").val()==""){
				alert("비밀번호를 입력하세요11");
				$("#pwd").focus();
				return false;
			}
			if($("#pwd").val()!=$("#pwd_check").val()){
				alert("비밀번호가 일치하지 않습니다.11");
				$("#pwd_check").focus();
				return false;
			}
		}
		
	</script>
</head>
<body>
	<div align="right">
		${sessDto.name } 회원님 반갑습니다.
		<a href="logout.go">로그아웃</a>
		<a href="memDelete.go?delid=${sessDto.userid }">회원탈퇴</a>
	</div>
	<div align="center">
		<h2>회원정보변경</h2>
		<form id="frm" method="post" action="memUpdate.go">
		<table>
			<tr>
				<td width=100px align=center>
					이름
				</td>
				<c:if test="${sessDto.admin ==0 }">
				<td>
					<input type="text" name="name" id="name" width=100px value="${sessDto.name }">
				</td>
				</c:if>
				<c:if test="${sessDto.admin ==1 }">
				<td>
					<input type="text" name="name" id="name" width=100px value="${mdto.name }">
				</td>
				</c:if>
			</tr>
			<tr>
				<td width=100px align=center>
					아이디
				</td>
				<c:if test="${sessDto.admin ==0 }">
				<td>
					<input type="hidden" name="userid" id="userid" value="${sessDto.userid }">
					<input type="text" name="vid" id="vid" width=100px disabled value="${sessDto.userid }">
				</td>
				</c:if>
				<c:if test="${sessDto.admin ==1 }">
				<td>
					<input type="hidden" name="userid" id="userid" value="${mdto.userid }">
					<input type="text" name="vid" id="vid" width=100px disabled value="${mdto.userid }">
				</td>
				</c:if>
			</tr>
			<tr>
				<td width=100px align=center>
					암호
				</td>
				
				<c:if test="${sessDto.admin ==0 }">
				<td>
					<input type="password" name="pwd" id="pwd" width=100px value="${sessDto.pwd }">
				</td>
				</c:if>
				<c:if test="${sessDto.admin ==1 }">
				<td>
					<input type="password" name="pwd" id="pwd" width=100px value="${mdto.pwd }">
				</td>
				</c:if>
			</tr>
			<tr>
				<td width=100px align=center>
					암호확인
				</td>
				<c:if test="${sessDto.admin ==0 }">
				<td>
					<input type="password" name="pwd_check" id="pwd_check" width=100px value="${sessDto.pwd }">
				</td>
				</c:if>
				<c:if test="${sessDto.admin ==1 }">
				<td>
					<input type="password" name="pwd_check" id="pwd_check" width=100px value="${mdto.pwd }">
				</td>
				</c:if>
			</tr>
			<tr>
				<td width=100px align=center>
					이메일
				</td>
				
				<c:if test="${sessDto.admin ==0 }">
				<td>
					<input type="email" name="email" id="email" width=100px value="${sessDto.email }">
				</td>
				</c:if>
				<c:if test="${sessDto.admin ==1 }">
				<td>
					<input type="email" name="email" id="email" width=100px value="${mdto.email }">
				</td>
				</c:if>
			</tr>
			<tr>
				<td width=100px align=center>
					전화번호
				</td>
				<c:if test="${sessDto.admin ==0 }">
				<td>
					<input type="text" name="phone" id="phone" width=100px value="${sessDto.phone }">
				</td>
				</c:if>
				<c:if test="${sessDto.admin ==1 }">
				<td>
					<input type="text" name="phone" id="phone" width=100px value="${mdto.phone }">
				</td>
				</c:if>
			</tr>
			<tr>
				<td width=100px align=center>
					등급
				</td>
				<c:if test="${sessDto.admin ==0 }">
				<td>
					<c:if test="${sessDto.admin==0 }">
					<input type="radio" name="admin" value="0"  checked="checked">일반회원
					<input type="radio" name="admin" value="1" >관리자
					</c:if>
					<c:if test="${sessDto.admin==1 }">
					<input type="radio" name="admin" value="0" >일반회원
					<input type="radio" name="admin" value="1"  checked="checked">관리자
					</c:if>
				</td>
				</c:if>
				<c:if test="${sessDto.admin ==1 }">
				<td>
					<c:if test="${mdto.admin==0 }">
					<input type="radio" name="admin" value="0"  checked="checked">일반회원
					<input type="radio" name="admin" value="1" >관리자
					</c:if>
					<c:if test="${mdto.admin==1 }">
					<input type="radio" name="admin" value="0" >일반회원
					<input type="radio" name="admin" value="1"  checked="checked">관리자
					</c:if>
				</td>
				</c:if>
			</tr>
			<tr>
				<td>
				</td>
				<td height="50px">
					&nbsp;&nbsp;&nbsp;
					<input type="button" value="이전으로" id="goBack" >&nbsp;&nbsp;
					<input type="submit" value="수정" id="send" onclick="check()" >&nbsp;&nbsp;
					<input type="reset" value="로그아웃" >
				</td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>