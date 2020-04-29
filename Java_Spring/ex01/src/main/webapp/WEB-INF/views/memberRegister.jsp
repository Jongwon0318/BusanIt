<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Member Register</title>

    <!-- Bootstrap Core CSS -->
    <link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="/resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/resources/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
	&nbsp;&nbsp;&nbsp;<h1>Member Register</h1>

    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Register</h3>
                    </div>
                    <div class="panel-body">
                        <form method='post' action="/memberRegister" id="form">
                            <fieldset>
                            	<div class="form-group">
                                	<label>Name</label>
                                	<c:if test='${username=="" }'>
                                    <input class="form-control" placeholder="username" name="username" type="text" autofocus id="username">
                                    </c:if>
                                    <c:if test='${username!="" }'>
                                    <input class="form-control" placeholder="username" name="username" type="text" autofocus id="username" value="${username }">
                                    </c:if>
                                </div>
                                <div class="form-group">
                                	<label>ID</label>
                                    <input class="form-control" placeholder="userid" name="userid" type="text" id="userid">
                                </div>
                                <div class="form-group">
                                	<label>Password</label>
                                	<c:if test='${userpw=="" }'>
                                    	<input class="form-control" placeholder="Password" name="userpw" type="password" value="" id="userpw">
                                    </c:if>
                                    <c:if test='${userpw!="" }'>
                                    	<input class="form-control" placeholder="Password" name="userpw" type="password"id="userpw" value="${userpw }">
                                    </c:if>
                                </div>
                                <div class="form-group">
                                	<label>Confirm Password</label>
                                	<c:if test='${userpw=="" }'>
                                    	<input class="form-control" placeholder="Confirm Password" type="password" value="" id="confirm">
                                    </c:if>
                                    <c:if test='${userpw!="" }'>
                                    	<input class="form-control" placeholder="Confirm Password" type="password"  id="confirm" value=${userpw }>
                                    </c:if>                                    
                                </div>
                                <!-- Change this to a button or input when using this as a form -->
                            </fieldset>
                            <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
                            <input type="hidden" id="check" value="${idCheck }">
                            <input type="button" class="btn btn-danger" value="회원가입">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- jQuery -->
    <script src="/resources/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="/resources/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="/resources/dist/js/sb-admin-2.js"></script>
    
    <script>
		$(function(){
			if($("#check").val() != ""){
				alert("중복된 아이디입니다.");
			}
		})
    	
		$(".btn-danger").on("click",function(e){
			if($("#username").val()=="" || $("#userid").val()=="" || $("#userpw").val()=="" || $("#confirm").val()==""){
				alert("값을 모두 입력해주십시오");
				return false;
			}

			if($("#userpw").val()!=$("#confirm").val()){
				alert("비밀번호가 다릅니다.");
				return false;
			}
			
			$("#form").submit();
		})
    </script>
</body>
</html>