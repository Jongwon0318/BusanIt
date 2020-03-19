<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="formresult.jsp">
		이름 : <input type="text" name="name"><br> 
		
		나이 : <input	type="text" name="age"><br> 
		
		성별 : <input type="radio" value="남자" name="maleOrfemale"  checked>남자 
				  <input type="radio" value="여자" name="maleOrfemale">여자<br>
		 
		 관심분야<br> 
		 <input type="checkbox" name="fav" value="운동">운동 
		 <input type="checkbox" name="fav" value="게임">게임
		 <input type="checkbox" name="fav" value="등산">등산 
		 <input type="checkbox" name="fav" value="영화">영화 <br>
		 
		 직업 : 
		 <select name="job">
			<option value="">직업선택</option>
			<option value="학생">학생</option>
			<option value="회사원">회사원</option>
			<option value="기타">기타</option>
		</select> <br> 
		
		<input type="submit" value="전송">
		
	</form>
</body>
</html>