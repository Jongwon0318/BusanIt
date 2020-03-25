<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Detail</title>
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous"></head>
</head>
<body>
	<div class="container">
		<br>
		<h1>상세보기</h1>
		<br><br>
		<table class="table">
			<tr>
				<th>
					NO
				</th>
				<td>
					${detail.num }
				</td>
				<th>
					DATE
				</th>
				<td>
					${detail.regdate }					
				</td>
				<th>
					HIT
				</th>
				<td>
					${detail.hitcount }
				</td>
			</tr>
			<tr>
				<th>
					TITLE
				</th>
				<td colspan="3">
					${detail.title }
				</td>
				<th>
					WRITER
				</th>
				<td>
					${detail.writer }
				</td>
			</tr>
			<tr>
				<th>
					CONTENT
				</th>
				<td colspan="5">
					${detail.content }
				</td>
			</tr>
		</table>
		<br>
		<div align="right">
			<input class="btn btn-dark" type="button" value="Edit" id="edit">
			<input class="btn btn-dark" type="button" value="Delete" id="delete">
			<input class="btn btn-dark" type="button" value="List" id="list">
		</div>
		<br>
		<hr>
		<div align="center">
			<form>
				<input type="text" id="commentWriter" name="commentWriter" class="form-control-sm" size=30 placeholder="작성자(이름)">&nbsp;
				<input type="text" id="commentContent" name="commentContent" class="form-control-sm" size=90 placeholder="내용">&nbsp;
				<input type="password" id="commentPassword" name="commentPassword" class="form-control-sm" size=20 placeholder="비밀번호">&nbsp;
				<input type="button" id="addComment" class="btn-m btn-dark" value="Comment">
			</form>
			<br><br>
			<table class="table text-center" id="commentTable">
				<tr>
					<th>번호</th>
					<th>작성자</th>
					<th>내용</th>
					<th>작성일</th>
					<th>삭제</th>
				</tr>
				<c:forEach items="${commentList }" var="comment">
					<tr>
						<td>${comment.cnum_1 }</td>
						<td>${comment.writer }</td>
						<td>${comment.content }</td>
						<td>${comment.regdate }</td>
						<td>
						<input type="button" id="commentDelete" value="삭제" class="btn btn-dark">
						<input type="hidden" id="commentNum" value="${comment.cnum }">
						<input type="hidden" id="boardNum" value="${detail.num }">
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<input type="hidden" id="num" value="${detail.num }">
</body>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js" integrity="sha384-6khuMg9gaYr5AxOqhkVIODVIvm9ynTT5J4V1cfthmT+emCG6yVmEZsRHdxlotUnm" crossorigin="anonymous"></script>	
<script>
	$("#list").click(function(){
		location.href="list";
	})
	
	$("#edit").click(function(){
		location.href="update?num=${detail.num }";
	})
	
	$("#delete").click(function(){
		window.open("delete","Delete","width=500,height=200");
	})
	
	$("#commentTable").on('click','#commentDelete',function(){
		var curRow=$(this).closest("tr");
		var selectedCnum=curRow.find("#commentNum").val();
		var deleteWindow=window.open("commentDelete?cnum="+selectedCnum+"&&bnum=${detail.num }","CommentDelete","width=700,height=200");
	})
	
	$("#addComment").click(function(){
		var bnum=${detail.num };
		var writer=$("#commentWriter").val();
		var content=$("#commentContent").val();
		var password=$("#commentPassword").val();
		$.ajax({
			url:"addComment",
			type:"POST",
			data:{"bnum":bnum,"writer":writer,"content":content,"password":password,"bnum":bnum},
			success:function(data){
				$("#commentTable").empty();
				$("#commentTable").append("<tr><th>번호</th><th>작성자</th><th>내용</th><th>작성일</th><th>삭제</th></tr>")
				var htmlStr="";
				for(i=0; i<data.length; i++){
					htmlStr+="<tr>";
					htmlStr+="<td>"+data[i].cnum_1+"</td>";
					htmlStr+="<td>"+data[i].writer+"</td>";
					htmlStr+="<td>"+data[i].content+"</td>";
					htmlStr+="<td>"+data[i].regdate+"</td>";
					htmlStr+="<td>";
					htmlStr+="<input type='button' id='commentDelete' value='삭제' class='btn btn-dark'>";
					htmlStr+="<input type='hidden' id='commentNum' value="+data[i].cnum_1+">";
					htmlStr+="<input type='hidden' id='boardNum' value="+${detail.num }+">";
					htmlStr+="</td>";
					htmlStr+="</tr>";
				}
				$("#commentTable").append(htmlStr);
				$("#commentWriter").val("");
				$("#commentContent").val("");
				$("#commentPassword").val(""); 
			},
			beforeSend:nullCheck,
			error:function(e){
				alert("error:"+e)
			}
		})
	})
	
	function nullCheck(){
		if(!$("#commentWriter").val()){
			alert("댓글작성자를 입력하세요");
			return false;
		}
		if(!$("#commentContent").val()){
			alert("댓글내용을 입력하세요");
			return false;
		}
		if(!$("#commentPassword").val()){
			alert("댓글 비밀번호를 입력하세요");
			return false;
		}
		return true;
	}
</script>
</html>