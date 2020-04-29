<%@page import="org.springframework.http.converter.json.Jackson2ObjectMapperBuilder"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@ page import="kr.or.kobis.kobisopenapi.consumer.rest.KobisOpenAPIRestService" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Collection" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	//파라미터 설정
	
	//조회일자
	String targetDt=request.getParameter("targetDt")==null?"20200419":request.getParameter("targetDt");
	
	//결과row수
	String itemPerPage=request.getParameter("itemPerPage")==null?"10":request.getParameter("itemPerPage");
	
	//"Y" : 다양성영화 "N" : 상업영화(dafault:전체)
	String multiMovieYn=request.getParameter("multziMovieYn")==null?"":request.getParameter("multiMovieYn");
	
	//"K" : 한국영화 "F" : 외국영화(dafault:전체)
	String repNationCd=request.getParameter("repNationCd")==null?"":request.getParameter("repNationCd");
	
	//"0105000000" 로서 조회된 지역코드
	String wideAreaCd = request.getParameter("wideAreaCd")==null?"":request.getParameter("wideAreaCd");
	
	//발급키
	String key="ea8a9cc5005b59a9057f281bb62f6cb5";
	
	//KOBIS 오픈 API REST CLIENT를 통해 호출
	KobisOpenAPIRestService service=new KobisOpenAPIRestService(key);
	
	//일일 박스오피스 서비스 호출(boolean isJson, String targetDt, String itemPerPage, String multiMovieYn, String repNationCd, String wdieAreaCd)
	String dailyResponse=service.getDailyBoxOffice(true,targetDt,itemPerPage,multiMovieYn,repNationCd,wideAreaCd);
	
	//Json 라이브러리를 통해 Handling
	Jackson2ObjectMapperBuilder builder=new Jackson2ObjectMapperBuilder();
	
	ObjectMapper mapper=builder.json().build();
	
	HashMap<String,Object> dailyResult=mapper.readValue(dailyResponse, HashMap.class);
	
	request.setAttribute("dailyResult", dailyResult);
	
	//KOBIS 오픈 API Rest Client를 통해 코드 서비스 호출(boolean isJson, String comCode)
	String codeResponse=service.getComCodeList(true,"0105000000");
	HashMap<String,Object> codeResult=mapper.readValue(codeResponse, HashMap.class);
	request.setAttribute("codeResult", codeResult);
%>
<body>
	<table border="1">
		<tr>
			<td>순위</td>
			<td>영화명</td>
			<td>개봉일</td>
			<td>매출액</td>
			<td>매출액점유율</td>
			<td>매출액증감(전일대비)</td>
			<td>누적매출액</td>
			<td>관객수</td>
			<td>관객수증감(전일대비)</td>
			<td>누적관객수</td>
			<td>스크린수</td>
			<td>상영횟수</td>
		</tr>
		<c:if test="${not empty dailyResult.boxOfficeResult.dailyBoxOfficeList }">
		<c:forEach items="${dailyResult.boxOfficeResult.dailyBoxOfficeList }" var="boxoffice">
			<tr>
				<td>${boxoffice.rank }</td>
				<td>${boxoffice.movieNm }</td>
				<td>${boxoffice.openDt }</td>
				<td>${boxoffice.salesAmt }</td>
				<td>${boxoffice.salesShare }</td>
				<td>${boxoffice.salesInten }</td>
				<td>${boxoffice.salesAcc }</td>
				<td>${boxoffice.audiCnt }</td>
				<td>${boxoffice.audiInten }</td>
				<td>${boxoffice.audiAcc }</td>
				<td>${boxoffice.scrnCnt }</td>
				<td>${boxoffice.showCnt }</td>
			</tr>
		</c:forEach>
		</c:if>
	</table>
</body>
</html>