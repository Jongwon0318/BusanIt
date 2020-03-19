<%@page import="com.jquery.address.AddressVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.jquery.address.JAddressDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
	$(function(){
		$("#searchBtn").click(function(){
			$.ajax({
				type:"GET",
				url:"searchPro.jsp",
				data:{"field":$("#field").val(), "word":$("#word").val()},
				success:function(data){
					data=$.parseJSON(data);
					var htmlStr="";
						for(var i=0; i<data.length; i++){
						htmlStr+="<tr>";
						htmlStr+="<td align="+"center"+">"+data[i].num+"</td>";
						htmlStr+=" <td align="+"center"+">"+data[i].name+"</td>";
						htmlStr+=" <td align="+"center"+">"+data[i].zipcode+"</td>";
						htmlStr+=" <td align="+"center"+">"+data[i].addr+"</td>";		
						htmlStr+=" <td align="+"center"+">"+data[i].tel+"</td>";
						htmlStr+="</tr>";
					}
					htmlStr+="</table>";
					$("#body").html(htmlStr);
				},
				error:function(e){
					alert("error : "+e);
				}
			})
		})
	})


</script>
<%
	JAddressDAO jdao=JAddressDAO.getInstance();
	ArrayList<AddressVO> arr=jdao.getList();	
%>
</head>
<body>
<div align=right>
	<a href="insert.jsp">추가하기</a>
</div>
<div align=center>
	<table>
		<thead>
			<tr>
				<th align="center" width=50px>
					번호
				</th>
				<th align="center" width=70px>
					이름
				</th>
				<th align="center" width=80px>
					우편번호
				</th>
				<th align="center" width=600px>
					주소
				</th>
				<th align="center" width=100px>
					전화번호
				</th>
			</tr>
		</thead>
		<tbody id="body">
			<%
				for(int i=0; i<arr.size(); i++){ 
			%>
			<tr>
				<td align="center">
					<%=arr.get(i).getNum()%>
				</td>
				<td align="center">
					<%=arr.get(i).getName()%>
				</td>
				<td align="center">
					<%=arr.get(i).getZipcode()%>
				</td>
				<td align="center">
					<%=arr.get(i).getAddr()%>
				</td>
				<td align="center">
					<%=arr.get(i).getTel()%>
				</td>
			</tr>
			<%
				}
			%>	
		</tbody>
	</table>
	<br><br>
	<select name="field" id="field" >
		<option value="name">이름</option>
		<option value="tel">전화번호</option>
	</select>
	<input type="text" name="word" id="word">
	<input type="button" value="검색" id="searchBtn">
</div>
</body>
</html>