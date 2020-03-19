<%@page import="com.address.ZipCodeBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.address.AddressDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>zipCheck2</title>
<style>
a:link {
	text-decoration: none;
	color: #000
}

a:hover {
	text-decoration: none;
	color: #000
}

a:visited {
	text-decoration: none;
	color: #000
}
</style>
</head>
<%
	request.setCharacterEncoding("utf-8");
	String dong = request.getParameter("dong1");
	AddressDAO dao = AddressDAO.getInstance();
	ArrayList<ZipCodeBean> zarr = dao.zipfinder(dong);
%>
<script>
	function dongCheck() {
		if (document.getElementById("dong1").value == "") {
			alert("동이름을 입력하세요");
			return;
		}
		frm.submit();
	}

	function send(zip, sido, gugun, d, bunji) {
		var address = sido + " " + gugun + " " + d + " " + bunji; 
		opener.document.getElementById("detailZip").value = zip;
		opener.document.getElementById("detailAddr").value = address;
		self.close();
	}
</script>
<body>
	<form action="detailZipCheck.jsp" name="frm">
		<table>
			<tr>
				<th>동이름입력 : <br>
				</th>
				<td><input type="text" name="dong1" id="dong1"> <input
					type="button" value="검색" onclick="dongCheck()"></td>
			</tr>
			<%
				if (zarr.isEmpty()) {
			%>
			<tr>
				<td>검색된 결과가 없습니다.</td>
			</tr>
			<%
				} else {
			%>
			<tr>
				<td colspan="2">*검색 후,아래 우편번호를 클릭하면 자동으로 입력됩니다.</td>
			</tr>
			<%
				for (ZipCodeBean z : zarr) {
						String zip = z.getZipcode();
						String sido = z.getSido();
						String bunji = z.getBunji();
						String gugun = z.getGugun();
						String d = z.getDong();
			%>
			<tr>
				<td colspan="2"><a
					href="javascript:send('<%=zip%>','<%=sido%>','<%=gugun%>','<%=d%>','<%=bunji%>')"><%=zip + " "%><%=sido + " "%><%=gugun + " "%><%=d + " "%><%=bunji%></a></td>
			</tr>
			<%
				}
				}
			%>
		</table>
	</form>
</body>
</html>