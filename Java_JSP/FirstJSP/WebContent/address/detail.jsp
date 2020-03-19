<%@page import="com.address.Address"%>
<%@page import="com.address.AddressDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<%
 int num =Integer.parseInt(request.getParameter("num"));
AddressDAO dao = AddressDAO.getInstance();
Address a = dao.addrDetail(num);  //num 에 해당하는  Address객체 정보
%>
<script>
	function zipfinder2() {
		window.open("detailZipCheck.jsp", "", "width=800 height=800");
	}
	function del() {
		if (confirm("정말 삭제할까요?")) {
			location.href = "deletePro.jsp?num=" + <%=num%>;
		}
	}
</script>
</head>
<body>
<form action="updatePro.jsp" method="post">
<input type="hidden" name="num" value="<%=a.getNum() %>">
<table border=1>
		<tr>
				<td>이름</td>
				<td><input type="text" name="name" value="<%=a.getName() %>"></td>
		</tr>
		<tr>
				<td>우편번호</td>
				<td><input type="text" name="zipcode" size=7 value="<%=a.getZipcode()%>"  id="detailZip">
						<input type="button" value="검색" onclick="zipfinder2()" >
				</td>
		</tr>
		<tr>
				<td>주소</td>
				<td><input type="text" name="addr" size=50 value="<%=a.getAddr()  %>"  id="detailAddr"></td>
		</tr>
		<tr>
				<td>전화번호</td>
				<td><input type="text" name="tel" value="<%=a.getTel()%>"></td>
		</tr>
		<tr>
		<td colspan="2">
				<input type="submit" value="수정">
				<input type="button" value="삭제"  onclick="del()">
		</td>
		</tr>
</table>
</form>
</body>
</html>