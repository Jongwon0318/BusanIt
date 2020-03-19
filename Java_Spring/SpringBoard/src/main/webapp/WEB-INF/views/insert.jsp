<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert</title>
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous"></head>
<body>
	<div class="container">
		<br>
		<h1>
			글쓰기
		</h1>
		<br><br>
		<form id="frm" method="post" action="insert">
			<table class="table table-striped">
				<tr>
					<td width=200px align=center>
						TITLE
					</td>
					<td>
						<input type="text" name="title" id="title" size=40>
					</td>
				</tr>
				<tr>
					<td width=200px align=center>
						WRITER
					</td>
					<td>
						<input type="text" name="writer" id="writer" size=40>
					</td>
				</tr>
				<tr>
					<td width=100px align=center>
						CONTENT
					</td>
					<td>
						<textarea rows="15" cols="100" id="content" name="content"></textarea>
					</td>
				</tr>
				<tr>
					<td width=200px align=center>
						PASS
					</td>
					<td>
						<input type="password" name="password" id="password" size=40 >
					</td>
				</tr>
			</table>
			<div align="center">
				<input type="button" id="submit" value="글쓰기" class="btn btn-dark">
				<input type="button" id="list" value="목록으로" class="btn btn-dark">
			</div>
		</form>
	</div>
</body>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js" integrity="sha384-6khuMg9gaYr5AxOqhkVIODVIvm9ynTT5J4V1cfthmT+emCG6yVmEZsRHdxlotUnm" crossorigin="anonymous"></script>	
<script>

	$("#submit").click(function(){
		var title = $("#title").val();
		var writer = $("#writer").val();
		var content = $("#content").val();
		var password = $("#password").val();
		var postString="title="+title+"&writer="+writer+"&content="+content+"&password="+password; 
		$.ajax({
			url:"insert",
			type:"POST",
			data:postString,
			success:function(retData){
				alert("추가 성공");
				location.href="list";
			},
			beforeSend:nullCheck,
			error:function(e){
				alert("error:"+e);
			}
		})
	})
	
	$("#list").click(function(){
		location.href="list";
	})
	
	function nullCheck(){
		if(!$("#title").val()){
			alert("제목을 입력하세요");
			return false;
		}
		if(!$("#writer").val()){
			alert("글쓴이를 입력하세요");
			return false;
		}
		if(!$("#content").val()){
			alert("내용을 입력하세요");
			return false;
		}
		if(!$("#password").val()){
			alert("비밀번호를 입력하세요");
			return false;
		}
		return true;
	}
</script>
</html>