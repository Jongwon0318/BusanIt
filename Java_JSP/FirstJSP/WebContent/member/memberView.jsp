<%@page import="com.member.MemberVO"%>
<%@page import="com.member.MemberDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<%
		request.setCharacterEncoding("utf-8");
		String userid=(String)session.getAttribute("userid");
		MemberDAOImpl mdao=MemberDAOImpl.getInstance();
		MemberVO vo=mdao.memberView(userid);
	%>
</head>
<body>
	<div align="right">
		<%=userid %>님 반갑습니다.
		<a href="logout.jsp">로그아웃</a>
		<a href="deletePro.jsp?userid=<%=userid %>">회원탈퇴</a>
		<a href="../board/list.jsp">게시글보기</a>
	</div>
	<div align="center">
		<h2>회원정보변경</h2>
		<form id="frm" method="post" action="updatePro.jsp">
		<table>
			<tr>
				<td width=100px align=center>
					이름
				</td>
				<td>
					<input type="text" name="name" id="name" width=100px value="<%=vo.getName()%>">
				</td>
			</tr>
			<tr>
				<td width=100px align=center>
					아이디
				</td>
				<td>
					<input type="hidden" name="userid" id="userid" value="<%=vo.getUserid()%>">
					<input type="text" name="vid" id="vid" width=100px disabled value="<%=vo.getUserid()%>">
				</td>
			</tr>
			<tr>
				<td width=100px align=center>
					암호
				</td>
				<td>
					<input type="password" name="pwd" id="pwd" width=100px value="">
				</td>
			</tr>
			<tr>
				<td width=100px align=center>
					암호확인
				</td>
				<td>
					<input type="password" name="pwd_check" id="pwd_check" width=100px value="">
				</td>
			</tr>
			<tr>
				<td width=100px align=center>
					이메일
				</td>
				<td>
					<input type="email" name="email" id="email" width=100px value="<%=vo.getEmail()%>">
				</td>
			</tr>
			<tr>
				<td width=100px align=center>
					전화번호
				</td>
				<td>
					<input type="text" name="phone" id="phone" width=100px value="<%=vo.getPhone()%>">
				</td>
			</tr>
			<tr>
				<td width=100px align=center>
					등급
				</td>
				<td>
					<input type="radio" name="admin" value="0" >일반회원
					<input type="radio" name="admin" value="1" >관리자
					<script>
						if(<%=vo.getAdmin()%>==0){ //일반사용자
							$("input:radio[value='0']").prop("checked",true);
						}else{ //관리자
							$("input:radio[value='1']").prop("checked",true);
						}
					</script>
				</td>
			</tr>
			<tr>
				<td>
				</td>
				<td height="50px">
					&nbsp;&nbsp;&nbsp;
					<input type="button" value="수정" id="send" onclick="check()" >&nbsp;&nbsp;
					<input type="reset" value="취소" >
				</td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>