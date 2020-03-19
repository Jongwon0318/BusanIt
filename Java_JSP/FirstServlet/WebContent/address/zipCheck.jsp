<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>zipCheck</title>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script>
		$(function(){
			$("#send").click(function(){
				if($("#dong").val()==""){
					alert("동이름을 입력하세요");
					$("#dong").focus();
					return false;
				}
				$.post("zip.do",
					{"dong":$("#dong").val()},
					function(data){
						data=$.parseJSON(data);
						var htmlStr="";
						for(var i=0; i<data.length; i++){
							htmlStr+="<table>";
							htmlStr+="<tr>";
							htmlStr+="<td>"+data[i].zipcode+"</td>";
							htmlStr+="<td>"+data[i].sido+"</td>";
							htmlStr+="<td>"+data[i].gugun+"</td>";
							htmlStr+="<td>"+data[i].dong+"</td>";
							htmlStr+="<td>"+data[i].bunji+"</td>";
							htmlStr+="</tr>";
							htmlStr+="</table>";
						}
						$("#area").html(htmlStr);
					}
				)//post
			})//send
			
			$("#area").on("click","tr",function(){
				var zipcode = $("td:eq(0)",this).text();
				var address = $("td:eq(1)",this).text()+" "
						    			 +$("td:eq(2)",this).text()+" "
										 +$("td:eq(3)",this).text()+" "
										 +$("td:eq(4)",this).text();
				$(opener.document).find("#zip").val(zipcode);
				$(opener.document).find("#addr").val(address);
				self.close();
			})//area
			
		})
	</script>
</head>
<body>
	<form action="zipCheck.jsp" name="frm">
		<table>
			<tr>
				<th>
					동이름입력 : <br>
				</th>
				<td>
					<input type="text" name="dong" id="dong"> 
					<input type="button" value="검색" id="send" >
				</td>
			</tr>
			<tr>
				<td colspan="2">*검색 후,아래 우편번호를 클릭하면 자동으로 입력됩니다.</td>
			</tr>
		</table>
		<div id="area">
		
		</div>
	</form>
</body>
</html>