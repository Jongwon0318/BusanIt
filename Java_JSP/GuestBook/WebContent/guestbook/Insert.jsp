<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert</title>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script>
		$(function(){
			$("#submit").click(sendIt);
			getData(1);
		})
		
		function sendIt(){
			var name=$("#name").val();
			var content =$("#content").val();
			var grade=$("input:radio[name=grade]:checked").val();
			var postString="name="+name+"&content="+content+"&grade="+grade;
			$.ajax({	
				type:"post",
				url:"create.gb",
				//{"name" : %("#name").val() .... }
				data:postString,
				success: function(d){
					$("#results").html(d);
					$("#name").val("");
					$("#content").val("");
					$("#name").focus();
				},
				beforeSend:showRequest ,
				error: function(e){
					alert("error:"+e);
				}
				
			})	
		}
		
		function getData(pageNum){
			$.get("list.gb",
					{"pageNum":pageNum},
					function(data){
						$("#results").html(data);
					})
		}
		
		function showRequest(){
			if(!$("#name").val()){
				alert("글쓴이를 입력하세요.");
				$("#name").focus();
				return false;
			}
			if(!$("#content").val()){
				alert("내용을 입력하세요.");
				$("#content").focus();
				return false;
			}
			if($("input:radio[name=grade]:checked").length==0){
				alert("평가를 해주세요");
				return false;
			}
		}
		
		//글자 수 표시하기
		function textCount(obj,target){
			var len=obj.value.length;
			//var len=$("#"+obj.id).val().length;
			if(obj.size<len){
				alert("글자 수 초과");
				var val=obj.val();
				obj.val(val.toString(1,20));
				return false;
			}
			$("#"+target).text(len);
		}
		
		//상세보기
		function fview(num){
			$.get("view.gb",
					{"num":num},
					function(d){
						$("#views").html(d);
					})
		}
	</script>
</head>
<body>
	<form method="post" action="create.gb">
		<table>
			<tr>
				<th>
					글쓴이
				</th>
				<td>
					<input type="text" size=20 style="width:150px" id="name" name="name" onkeyup="textCount(this,'nameCount')"> *20글자 이내
					(<span id="nameCount" style="color:red" >0</span>)
				</td>
			</tr>
			<tr>
				<th>
					내 용
				</th>
				<td>
					<input type="text"  size=70 style="width:580px" id="content" name="content" onkeyup="textCount(this,'contentCount')"> *70글자이내
					(<span id="contentCount" style="color:red" >0</span>)
				</td>
			</tr>
			<tr>
				<th>
					평가
				</th>
				<td>
					<input type="radio"  id="grade" name="grade" value="excellent">아주잘함(excellent)
					<input type="radio" id="grade" name="grade" value="good">잘함(good)
					<input type="radio" id="grade" name="grade" value="normal">보통(normal)
					<input type="radio" id="grade" name="grade" value="fail">노력(fail)
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit"  value="submit 전송">
					<input type="button"  id="submit" value="ajax버튼 입력">
				</td>
			</tr>
		</table>
	</form>
	<br>
	<hr>
	<br>
	<div align="center" id="results">
	
	</div>
	<br>
	<hr>
	<br>
	<div id="views">
	
	</div>
</body>
</html>