<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

	<div>
		<input type="hidden" id="bno" value="${boardDetail.bno }">
		<div class='form-group'>
			<label>Bno</label> 
			<input class='form-control' name='bno'	value='${boardDetail.bno }' readonly='readonly' >
		</div>
		<div class='form-group'>
			<label>Title</label> 
			<input class='form-control' name='title' value='${boardDetail.title }' readonly='readonly' id="title">
		</div>
		<div class='form-group'>
			<label>Text area</label>
			<textarea class='form-control' rows='3' name='content' readonly='readonly' id="content">${boardDetail.content }</textarea>
		</div>
		<div class='form-group'>
			<label>Writer</label> 
			<input class='form-control' name='writer' value='${boardDetail.writer }' readonly='readonly'>
		</div>
	</div>
	<sec:authentication property='principal' var='pinfo'/>
		<sec:authorize access='isAuthenticated()'>
		<script  type="text/javascript">
		$(function(){
			if(${pinfo.username eq boardDetail.writer }){
				$("#title").prop('readonly',false);
				$("#content").prop('readonly',false);
			}	
		})
		</script>
		<c:if test="${pinfo.username eq boardDetail.writer }">
		<div align="center">
		<button id="boardModify" class="btn btn-link mb-2 mr-2">Modify</button>
		<button id="boardRemove" class="btn btn-link mb-2">Remove</button>
		</div>
		</c:if>
		<br>
		<div class="input-group mb-3">
  			<div class="input-group-prepend">
				<input id="replyer" value='${pinfo.username}' type="text" class="btn btn-link mb-2" readonly="readonly">
  			</div>
  			<input id='replyContent' type='text' class='form-control' placeholder='Reply Content'  aria-describedby="replyer">
			<button id="replyRegister" type='button' class='btn btn-link mb-2 ' aria-describedby="replyer">Submit</button>
		</div>			  	
		<br>
	</sec:authorize>
	<ul class='list-group mb-3' id="reply">
			
	</ul>
	<!-- Core theme JS-->
	<script src="/resources/js/scripts.js"></script>
	<script type="text/javascript">
$(function(){
		var bno=$("#bno").val();
		
		getReplyList(bno,1);

		$(".paginate_button_reply a").on("click",	function(e) {
			e.preventDefault();
			var replyPageNum = $(this).attr("href");
			//alert(pageNum); 
			getReplyList(bno,replyPageNum);
		});

		$("#replyRegister").on("click",function(){
			
			var reply=$("#replyContent").val();
			var replyer=$("#replyer").val();
			
			$.ajax({
				url:"replyRegister",
				type:"GET",
				data:{"bno":bno,"reply":reply,"replyer":replyer},
				success:function(data){
					alert("댓글 등록 성공");
					$("#replyContent").val("");
					
					getReplyList(bno, data);
				},
				error:function(e){
					alert("error : "+error);
				}
			})
		}) 

		$("#boardModify").on("click",function(){

			var title=$("#title").val();
			var content=$("#content").val();
			
			$.ajax({
				url:"boardModify",
				type:"GET",
				data:{"bno":bno,"title":title,"content":content},
				success:function(data){
					alert("수정 성공");
					getDetail(bno);
					getList(1,5);
				},
				error:function(e){
					alert("error : "+e);
				}
			})
		})
})
</script>
