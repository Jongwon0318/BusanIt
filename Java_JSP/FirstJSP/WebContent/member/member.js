var exp=/^[0-9]{3}-[0-9]{4}-[0-9]{4}$/;
var email=/^[0-9a-zA-Z]@[0-9a-zA-Z].[0-9a-zA-Z]/;
$(function(){
	
	$("#loginBtn").click(function(){
		if($("#userid1").val()==""){
			alert("아이디를 입력하세요");
			$("#userid").focus();
			return false;
		}
		if($("#pwd1").val()==""){
			alert("비밀번호를 입력하세요");
			$("#pwd").focus();
			return false;
		}
		
		$.ajax({
			type:"post",
			url:"loginPro.jsp",
			data:{"userid":$("#userid1").val(), "pwd":$("#pwd1").val()},
			success:function(data){
				if(data.trim()==-1){
					alert("아이디가 잘못 입력되었습니다.");
					$("#userid1").focus();
				}else if(data.trim()==2){
					alert("비밀번호가 잘못 입력되었습니다.");
					$("#pwd1").focus();
				}else if(data.trim()==0){ //일반사용자
					alert("일반사용자 로그인");
				 	location.href="memberView.jsp";
				}else{ //관리자
					alert("관리자 로그인");
					location.href="memberList.jsp";						
				}
			},
			error:function(e){
				alert("error : "+e);
			}
		})
	})
	
	$("#send").click(function(){
		if($("#name").val()==""){
			alert("이름을 입력하세요");
			$("#name").focus();
			return false;
		}
		
		if($("#userid").val()==""){
			alert("아이디를 입력하세요");
			$("#userid").focus();
			return false;
		}
		
		if($("#pwd").val()==""){
			alert("암호를 입력하세요");
			$("#pwd").focus();
			return false;
		}
		
		if($("#pwd_check").val()==""){
			alert("암호확인을 입력하세요")
			$("#pwd_check").focus();
			return false;
		}
		
		if($("#pwd").val()!=$("#pwd_check").val()){
			alert("비밀번호가 일치하지 않습니다.");
			$("#pwd_check").focus();
			return false;
		}
		
		if(!$("#phone").val().match(exp)){
			alert("전화번호를 000-0000-0000 형식으로 입력하세요.");
			$("#phone").focus();
			return false;
		}
		
		if(!$("#email").val().match(email)){
			alert("이메일을 ~@~.~ 형식으로 입력하세요.");
			$("#email").focus();
			return false;
		}
		
		$("#frm").submit();
	})
	
	//중복체크버튼
	$("#idBtn").click(function(){
		window.open("idCheck.jsp","","width=800 height=500");
	})
	
	//아이디 중복확인 체크(DB)
	$("#idCheckBtn").click(function(){
		if($("#userId").val()==""){
			alert("아이디를 입력하세요");
			$("#userId").focus();
			return false;
		}
		$.ajax({
			type:"POST",
			url:"idCheckPro.jsp",
			data : {"userId":$("#userId").val()},
			success:function(data){
				if(data.trim()=="yes"){
					alert("사용가능한 아이디입니다.");
					$(opener.document).find("#userid").val($("#userId").val());
					$(opener.document).find("#vid").val($("#userId").val());
					$(opener.document).find("#pwd").focus();
					self.close();
				}else{
					alert("중복된 아이디입니다.");
					$("#userId").focus();
				}
			},
			error:function(e){
				alert("error:"+e)
			}
		})
	})
	
	//로그인화면에서 회원가입화면으로
	$("#signUpBtn").click(function(){
		window.location.replace("memberForm.jsp");
	})
	
	//회원가입화면에서 로그인화면으로
	$("#back").click(function(){
		window.location.replace("loginForm.jsp");
	})
	
})

function del(userid){
		//load
		$("table tbody").load("memberDeletePro.jsp?userid="+userid,
				function(data){
					data=$.parseJSON(data);
					var htmlStr="";
					for(var i=0; i<data.length; i++){
						htmlStr+="<tr>";
						htmlStr+="<td align=center>"+data[i].name+"</td>";
						htmlStr+="<td align=center width=100px>"+data[i].userid+"</td>";
						htmlStr+="<td align=center width=120px>"+data[i].phone+"</td>";
						htmlStr+="<td align=center width=160px>"+data[i].email+"</td>";
						htmlStr+="<td align=center>"+data[i].admin+"</td>";
						htmlStr+="<td align=center  id="+"lastTd"+" width=80px onclick=del('"+data[i].userid+"')"+">"+"삭제"+"</td>";
						htmlStr+="</tr>";
					}
					$("table tbody").html(htmlStr);
		})
	}






