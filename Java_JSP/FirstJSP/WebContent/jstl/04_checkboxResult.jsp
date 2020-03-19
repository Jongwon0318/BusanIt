<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%
  	request.setCharacterEncoding("utf-8");
  	String[] str=request.getParameterValues("item");
  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>04_checkboxResult</title>
</head>
<body>
	스크립트릿으로 처리
	<br><br>
	<%
		for(String s: str){
	%>
		관심악세사리 : <%=s %><br>
	<%
		}
	%>
	<br>
	<hr>
	<br>
	jstl으로 처리
	<br><br>
	<%
		String[] accrList={"신발","가방","벨트","모자","시계","쥬얼리"}; 
		pageContext.setAttribute("accrlist",accrList);
	%>
	<!-- jstl 사용 -->
	<!-- varStatus : 위치값(index) -->
	<!-- last,first,not -->
	<c:forEach items="${paramValues.item }" var="item" varStatus="st">
		${item }
		<c:if test="${not st.last }">
			,
		</c:if>
	</c:forEach>
	
	
	
	<!-- 틀린예시 <c:if test="${param.item.contains('신발') }">
		신발
	</c:if>
	<c:if test="${param.item.contains('가방') }">
		가방
	</c:if>
	<c:if test="${param.item.contains('벨트') }">
		벨트
	</c:if>
	<c:if test="${param.item.contains('모자') }">
		모자
	</c:if>
	<c:if test="${param.item.contains('시계') }">
		시계
	</c:if>
	<c:if test="${param.item.contains('쥬얼리') }">
		쥬얼리
	</c:if> -->
</body>
</html>