<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>zipCheck</title>
	<style>
	table td:hover{
	cursor:pointer;
	}
	</style>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script>
		
		$(function(){
			$("#send").click(function(){
				zipSend();
			})//button clicked
			$("#dong").keydown(function(e){
				if(e.keyCode==13){
					zipSend();
				}
			})
			
			$("#area").on("click","tr",function(){
				var address= $("td:eq(1)",this).text()+" "+
										  $("td:eq(2)",this).text()+" "+
										  $("td:eq(3)",this).text()+" "+
										  $("td:eq(4)",this).text()
				$(opener.document).find("#zipcode").val($("td:eq(0)",this).text());
				$(opener.document).find("#addr").val(address);
				self.close();
			})
		})//document
		
		function zipSend(){
			$.get("zipCheckPro.jsp",
					{"dong":$("#dong").val()},
					function(data){
						data=$.parseJSON(data);
						var htmlStr="";
						htmlStr+="<table>";
						htmlStr+="<tr><th colspan="+"5"+">*검색 후,아래 우편번호를 클릭하면 자동으로 입력됩니다.</th></tr>";
						for(var i=0; i<data.length; i++){
							htmlStr+="<tr>";
							htmlStr+="<td>"+data[i].zipcode+"</td>";
							htmlStr+=" <td>"+data[i].sido+"</td>";
							htmlStr+=" <td>"+data[i].gugun+"</td>";
							htmlStr+=" <td>"+data[i].dong+"</td>";		
							htmlStr+=" <td>"+data[i].bunji+"</td>";
							htmlStr+="</tr>";
						}
						htmlStr+="</table>";
						$("#area").html(htmlStr);
					})//get
		}
		
	</script>
</head>
<body>
	<table>
		<tr>
			<th>
				동 이름 입력
			</th>
			<td>
				<input type="text" name="dong" id="dong">
				<input type="button" id="send" value="검색">
			</td>
		</tr>
	</table>
	<div id="area"></div>
</body>
</html>