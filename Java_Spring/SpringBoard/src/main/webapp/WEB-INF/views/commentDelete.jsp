<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>CommentDelete</title>
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous"></head>
</head>
<body>
	<div class="container">
		<h1>Comment Password Check</h1>
		<br>
		<input type="text" id="commentPassword" name="commentPassword">
		<input class="btn btn-dark" type="button" value="Submit" id="submit">
		<input type="hidden" id="cnum"  value="<c:out  value='${cnum }' />">
		<input type="hidden" id="bnum" value="${bnum }">
	</div>
</body>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js" integrity="sha384-6khuMg9gaYr5AxOqhkVIODVIvm9ynTT5J4V1cfthmT+emCG6yVmEZsRHdxlotUnm" crossorigin="anonymous"></script>	
<script>
	$("#submit").click(function(){
		var password=$("#commentPassword").val();
		var cnum=$("#cnum").val();
		var bnum=$("#bnum").val();
		commentPassCheck(cnum,bnum,password);
	})
	
	function commentPassCheck(cnum,bnum,password){
		$.ajax({
			url:"commentPassCheck",
			type:"POST",
			data:{"cnum":cnum,"password":password},
			success:function(retData){
				if(retData=='true'){
					commentDelete(cnum,bnum);
				}else{
					alert("비밀번호 오류")
				}
			},
			error:function(e){
				alert("error:"+e);
			}
		})
	}

	function commentDelete(cnum,bnum){
		$.ajax({
			url:"commentDelete",
			type:"POST",
			data:{"cnum":cnum},
			success:function(retData){
				alert("삭제 성공");
				window.opener.location.href="detail?num="+bnum;
				window.close();
			},
			error:function(e){
				alert("error :"+e);
			}
		})
	}
	
</script>
</html>