<%@page import="com.member.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.member.MemberDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>MemberList</title>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="member.js"></script>
	<style>
		#lastTd{
			cursor:pointer;
			color:red;
		}
		#lastTd:hover{
			cursor:pointer;
			text-decoration:underline;
		}
	</style>
	<%
		request.setCharacterEncoding("utf-8");
		String userid=(String)session.getAttribute("userid");
		MemberDAOImpl mdao=MemberDAOImpl.getInstance();
		ArrayList<MemberVO> arr=mdao.memberLIst();
		MemberVO vo=mdao.memberView(userid);
	%>
</head>
<body>
	<div align="right">
		 <a href="memberView.jsp"><%=userid %> 관리자 님</a> 반갑습니다.
		<a href="logout.jsp">로그아웃</a>
		<a href="../board/list.jsp">게시글보기</a>
	</div>
	<br><br>
	<div align="center">
	<table>
		<thead>
			<tr>
				<th align="center">
					이름
				</th>
				<th align="center">
					아이디
				</th>
				<th align="center">
					전화번호
				</th>
				<th align="center">
					이메일
				</th>
				<th>
					구분
				</th>
				<th align="center">
					삭제
				</th>			
			</tr>
		</thead>
		<tbody>
		<%for(int i=0; i<arr.size(); i++){ %>
		<%String mode=arr.get(i).getAdmin()==0?"일반사용자":"관리자"; %>
			<tr>
				<td align="center">
					<%=arr.get(i).getName()%>
				</td>
				<td align="center" width=100px>
					<%=arr.get(i).getUserid()%>
				</td>
				<td align="center" width=120px>
					<%=arr.get(i).getPhone() %>
				</td>
				<td align="center" width=160px>
					<%=arr.get(i).getEmail() %>
				</td>
				<td align="center">
					<%=mode %>
				</td>
				<td id="lastTd" align="center" width=80px onclick="del('<%=arr.get(i).getUserid()%>')">
					삭제
				</td>
			</tr>
		<%} %>
		</tbody>
	</table>
	</div>
</body>
</html>