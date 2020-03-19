<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Delete</title>
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous"></head>
</head>
<body>
	<div class="container">
		<h1>Password Check</h1>
		<br>
		<input type="text" id="password" name="password">
		<input class="btn btn-dark" type="button" value="Submit" id="submit">
	</div>
</body>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js" integrity="sha384-6khuMg9gaYr5AxOqhkVIODVIvm9ynTT5J4V1cfthmT+emCG6yVmEZsRHdxlotUnm" crossorigin="anonymous"></script>	
<script>
	$("#submit").click(function(){
		var password=$("#password").val();
		var num=opener.document.getElementById("num").value;
		passCheck(num,password);
	})
	
	function passCheck(num,password){
		$.ajax({
			url:"passCheck",
			type:"POST",
			data:{"num":num,"password":password},
			success:function(retData){
				if(retData=='true'){
					deleteBoard(num);
				}else{
					alert("비밀번호 오류")
				}
			},
			error:function(e){
				alert("error:"+e);
			}	
		})
	}
	
	function deleteBoard(num){
		$.ajax({
			url:"delete",
			type:"POST",
			data:{"num":num},
			success:function(retData){
				alert("삭제 성공");
				window.opener.location.href="list";
				window.close();
			},
			error:function(e){
				alert("error :"+e);
			}
		})
	}
	
</script>
</html>