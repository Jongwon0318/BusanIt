<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>intro</title>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script>
		$(document).ready(function(){
			$("#btn").click(function(){
				if($("#name").val()==""){
					alert("이름을 입력하세요");
					return false;
				}
				if($("#year").val()=="" || $("#month").val()=="" || $("#day").val()==""){
					alert("생년월일을 입력하세요");
					return false;
				}
				if($(".solarlunar:checked").length==0){
					alert("양력/음력을 선택하세요");
					return false;
				}
				if($("#addr").val()==""){
					alert("주소를 입력하세요");
					return false;
				}
				if($(".tel").val()==""){
					alert("전화번호를 입력하세요");
					return false;
				}
				if($("input:checkbox[name='avail']:checked").length==0){
					alert("사용가능한 프로그램을 선택하세요");
					return false;
				}
				/*
				if($("input:radio[name='birthRadio']:checked").length==0){
					alert("양력/음력을 선택하세요");
					return false;
				}
				*/
				$("#form").submit();
			});
		});
	</script>
</head>
<body>
	<!-- method=post, get -->
	<form action="IntroPro2.jsp" name="form" id="form" method="post">
		<table border="3">
			<tr>
				<th width=100px>
					성명 
				</th>
				<th>
					<input type="text" name="name" id="name">
				</th>
				<th>
					성별 
				</th>
				<th>
					<input type="radio" name="gender" value="남자" checked> 남
					<input type="radio" name="gender" value="여자"> 여
				</th>
			</tr>
			<tr>
				<th>
					생년월일
				</th>
				<th colspan="3">
					<input type="text"  class="birth" name="year" id="year">년
					<input type="text" class="birth"  name="month" id="month">월
					<input type="text"  class="birth" name="day" id="day">일
					<input type="radio"  class="solarlunar" name="birthRadio" id="solar" value="양력">양력
					<input type="radio"  class="solarlunar" name="birthRadio" id="lunar" value="음력">음력
				</th>
			</tr>
			<tr>
				<th>
					주소
				</th>
				<th colspan="3">
					<input type="text" name="addr" id="addr">
				</th>
			</tr>
			<tr>
				<th>
					전화번호
				</th>
				<th colspan="3">
					<input type="text" class="tel" name="tel1" id="tel1">-
					<input type="text" class="tel" name="tel2" id="tel2">-
					<input type="text" class="tel" name="tel3" id="tel3">
				</th>
			</tr>
			<tr>
				<th id="info" colspan="4">
				사용가능한 프로그램 선택하기
				</th>
			</tr>
			<tr>
				<th colspan="4">
				<!-- ol, li 사용해서 다시 써볼것 -->
					<ol type="A" >
						<li> 
							<input type="checkbox" class="avail" name="avail" value="한글"> 한글 
						</li>
						<li> 
							<input type="checkbox" class="avail" name="avail" value="포토샵"> 포토샵 
						</li>
						<li> 
							<input type="checkbox" class="avail" name="avail" value="매크로 미디어 디렉터"> 매크로 미디어 디렉터 
						</li>
						<li> 
							<input type="checkbox" class="avail" name="avail" value="드림위버"> 드림위버 
						</li>
						<li> 
							<input type="checkbox" class="avail" name="avail" value="3DMAX"> 3D MAX 
						</li>
					</ol>
				</th>
			</tr>
			<tr>
				<th id="info" colspan="4">
					가고싶은 여행지를 모두 선택하세요.
				</th>
			</tr>
			<tr>
				<th colspan="4">
					<select size="3" name="play" multiple>
						<option value="설악산" selected>설악산</option>
						<option value="경포대">경포대</option>
						<option value="토발">토발</option>
						<option value="남한산성">남한산성</option>
					</select>
				</th>
			</tr>
			<tr>
				<th id="info" colspan="4">
					미래의 꿈은 어떠한가요
				</th>
			</tr>
			<tr>
				<th colspan="4">
					<textarea rows="5" cols="50" name="memo" id="memo">
						미래의 꿈은 희망입니다.
					</textarea>
				</th>
			</tr>
			<tr>
				<th colspan="4">
					<input type="button" value="전송" id="btn">
					<input type="reset" value="다시쓰기">
				</th>
			</tr>
		</table>
	</form>
</body>
</html>