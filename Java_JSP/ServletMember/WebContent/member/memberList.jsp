<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>MemberList</title>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
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
	<script>
		function del(userid){
			$.getJSON("memAdminDelete.go?userid="+userid,function(d){
				var htmlStr="";
				$.each(d,function(key,val){
					htmlStr+="<tr>";
					htmlStr+="<td>"+val.name+"</td>";
					htmlStr+="<td><a href='memView.go?userid=val.userid'>val.userid</a></td>";
					htmlStr+="<td>"+val.phone+"</td>";
					htmlStr+="<td>"+val.email+"</td>";
					htmlStr+="<td>"+val.admin+"</td>";
					htmlStr+="<td><a onclick=del('val.userid')>삭제</a></td></tr>";
				})	
				$("table tbody").html(htmlStr);
			})
		}
	</script>
</head>
<body>
	<div align="right">
		 <a href="memView.go?userid=${sessDto.userid }"> ${sessDto.name }</a> 관리자 님  반갑습니다.
		<a href="logout.go">로그아웃</a>
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
			<c:forEach items="${marr }" var="vr"  varStatus="st">
			<tr>
				<td align="center">
					${vr.name }
				</td>
				<td align="center" width=100px>
					<a href="memView.go?userid=${vr.userid }">${vr.userid }</a>
				</td>
				<td align="center" width=120px>
					${vr.phone }
				</td>
				<td align="center" width=160px>
					${vr.email }
				</td>
				<td align="center">
					${vr.admin }
				</td>
				<td id="lastTd" align="center" width="80px" >
					<!-- <a href="memDelete.go?delid=${vr.userid }">삭제</a> -->
					<a onclick="del('${vr.userid}')">삭제</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</body>
</html>