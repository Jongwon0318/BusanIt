<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PersonView</title>
</head>
<body>
	<form action="personUpdate.sp">
	<table>
		<tr>
			<th>
				ID
			</th>
			<th>
				PASSWORD
			</th>
			<th>
				NAME
			</th>
			<th>
				JOB
			</th>
			<th>
				GENDER
			</th>
		</tr>
		<tr>
			<th>
				<input type="text" value=${user.id } disabled="disabled">
				<input type="hidden" value=${user.id } name="id">
			</th>
			<th>
				<input type="text" value=${user.password } name="password">
			</th>
			<th>
				<input type="text" value=${user.name } name="name">
			</th>
			<th>
				<select name="job" id="job">
							<option value="회사원" 
								<c:if test="${user.job eq '회사원'}">selected</c:if>>회사원</option>
							<option value="학생" 
								<c:if test="${user.job eq '학생'}">selected</c:if>>학생</option>
							<option value="기타" 
								<c:if test="${user.job eq '기타'}">selected</c:if>>기타</option>
				</select>
			</th>
			<th>
				<label for="man">남</label>
				<input type="radio" name="gender" id="man" value="남" 
					<c:if test="${user.gender eq '남'}">checked</c:if>>
				<label for="woman">여</label>
				<input type="radio" name="gender" id="woman" value="여" 
					<c:if test="${user.gender eq '여'}">checked</c:if>>
			</th>
		</tr>
	</table>
	<input type="submit" value="수정하기">
	<input type="button" value="리스트로 돌아가기" onclick="location.href='personList.sp'">
	</form>
</body>
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
<script>
	//성별 	
	if("${user.gender}"=="남"){
		${"input:radio[value='남']"}.prop("checked",true);
	}else{
		${"input:radio[value='여']"}.prop("checked",true);
	}
	//직업
	${"#job option"}.each(function(){
			if($(this).val()=="${user.job}"){
				$(this).prop("selected",true);
			}
		})
</script>
</html>