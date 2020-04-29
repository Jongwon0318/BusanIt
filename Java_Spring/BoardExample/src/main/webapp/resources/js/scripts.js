/*!
    * Start Bootstrap - Freelancer v6.0.0 (https://startbootstrap.com/themes/freelancer)
    * Copyright 2013-2020 Start Bootstrap
    * Licensed under MIT (https://github.com/BlackrockDigital/startbootstrap-freelancer/blob/master/LICENSE)
    */
(function($) {
    "use strict"; // Start of use strict
  
    // Smooth scrolling using jQuery easing
    $('a.js-scroll-trigger[href*="#"]:not([href="#"])').click(function() {
      if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') && location.hostname == this.hostname) {
        var target = $(this.hash);
        target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
        if (target.length) {
          $('html, body').animate({
            scrollTop: (target.offset().top - 71)
          }, 1000, "easeInOutExpo");
          return false;
        }
      }
    });
  
    // Scroll to top button appear
    $(document).scroll(function() {
      var scrollDistance = $(this).scrollTop();
      if (scrollDistance > 100) {
        $('.scroll-to-top').fadeIn();
      } else {
        $('.scroll-to-top').fadeOut();
      }
    });
  
    // Closes responsive menu when a scroll trigger link is clicked
    $('.js-scroll-trigger').click(function() {
      $('.navbar-collapse').collapse('hide');
    });
  
    // Activate scrollspy to add active class to navbar items on scroll
    $('body').scrollspy({
      target: '#mainNav',
      offset: 80
    });
  
    // Collapse Navbar
    var navbarCollapse = function() {
      if ($("#mainNav").offset().top > 100) {
        $("#mainNav").addClass("navbar-shrink");
      } else {
        $("#mainNav").removeClass("navbar-shrink");
      }
    };
    // Collapse now if page is not at top
    navbarCollapse();
    // Collapse the navbar when page is scrolled
    $(window).scroll(navbarCollapse);
  
    // Floating label headings for the contact form
    $(function() {
      $("body").on("input propertychange", ".floating-label-form-group", function(e) {
        $(this).toggleClass("floating-label-form-group-with-value", !!$(e.target).val());
      }).on("focus", ".floating-label-form-group", function() {
        $(this).addClass("floating-label-form-group-with-focus");
      }).on("blur", ".floating-label-form-group", function() {
        $(this).removeClass("floating-label-form-group-with-focus");
      });
    });
 })(jQuery); // End of use strict
    
function displayTime(timeValue) {
	var today = new Date();
	var gap = today.getTime() - timeValue;
	var dateObj = new Date(timeValue);
	var str = "";

	if (gap < (1000 * 60 * 60 * 24)) {
		var hh = dateObj.getHours();
		var mi = dateObj.getMinutes();
		var ss = dateObj.getSeconds();

	return [ (hh > 9 ? '' : '0') + hh, ':',
				(mi > 9 ? '' : '0') + mi, ':', (ss > 9 ? '' : '0') + ss ].join('');

	} else {
		var yy = dateObj.getFullYear();
		var mm = dateObj.getMonth() + 1; // getMonth() is zero-based
		var dd = dateObj.getDate();

		return [ yy, '/', (mm > 9 ? '' : '0') + mm, '/',
				(dd > 9 ? '' : '0') + dd ].join('');
		}
	};

function getList(pageNum,amount){
	
	$.ajax({
		url : "getList",
		type : "GET",
		data : {
			"pageNum" : pageNum,
			"amount" : amount
		},
		success : function(data) {
			$("#boardTable").empty();
			$("#boardTable").append("<thead><tr><th>번호</th><th>제목</th><th>작성자</th><th>작성일</th><th>수정일</th></tr></thead><tbody>");
			var htmlStr = "";
			for (i = 0; i < data.length; i++) {
				htmlStr+= "<tr>";
				htmlStr+="<td style='display:none;'>";
				htmlStr+="<input type='hidden' value='"+data[i].bno+"' id='hiddenBno'>";
				htmlStr+="</td>";
				htmlStr+= "	<td>"+ data[i].bno + "</td>";
				htmlStr+= "	<td>" + data[i].title+ "</td>";
				htmlStr+= "	<td>"	+ data[i].writer+ "</td>";
				htmlStr+= "	<td>"	+ displayTime(data[i].regdate)+ "</td>";
				htmlStr+= "	<td>"	+ displayTime(data[i].updateDate)+ "</td>";
				htmlStr+= "</tr>";
			}
			htmlStr += "</tbody>";
			
			$("#boardTable").append(htmlStr);
			//객체를 인식하기때문에 사용가능!!
		},
		error : function(e) {
			alert("error : " + e);
		}
	})
}

function getSearchList(pageNum,amount,type,keyword){
	$.ajax({
		url : "getList",
		type : "GET",
		data : {
			"pageNum" : 1,
			"amount" : 5,
			"type" : type,
			"keyword" : keyword
		},
		success : function(data) {
			$("#boardTable").empty();
			$(".pagination").hide();
			$("#boardTable")
					.append(
							"<thead><tr><th>번호</th><th>제목</th><th>작성자</th><th>작성일</th><th>수정일</th></tr></thead><tbody>");
			var htmlStr = "";
			for (i = 0; i < data.length; i++) {
				htmlStr+= "<tr>";
				htmlStr+="<td style='display:none;'>";
				htmlStr+="<input type='hidden' value='"+data[i].bno+"' id='hiddenBno'>";
				htmlStr+="</td>";
				htmlStr+= "	<td>"+ data[i].bno + "</td>";
				htmlStr+= "	<td>" + data[i].title+ "</td>";
				htmlStr+= "	<td>"	+ data[i].writer+ "</td>";
				htmlStr+= "	<td>"	+ displayTime(data[i].regdate)+ "</td>";
				htmlStr+= "	<td>"	+ displayTime(data[i].updateDate)+ "</td>";
				htmlStr+= "</tr>";
			}
			htmlStr += "</tbody>";
			
			$("#boardTable").append(htmlStr);			
			
			$("#returnBtn").show();
		},
		error : function(e) {
			alert("error : " + e);
		}
	});
}

function getDetail(bno){
	$.ajax({
		url:"getBoardDetail",
		type:"GET",
		data : {"bno":bno},
		success:function(data){
			//$("#boardDetail").empty();
			$("#boardDetail").html(data);
		},
		error:function(e){
			alert("error : "+e);
		}
	});
}

function getReplyList(bno,pageNum){
	$.ajax({
		url:"getReplyList",
		type:"GET",
		data:{"bno":bno, "pageNum":pageNum},
		success:function(data){
			$("#reply").empty();
			htmlStr="";
			for(var i=0; i<data[0].length; i++){
				htmlStr+="<li class='list-group-item clearfix' data-rno='"+data[0][i].rno+"'>";
				htmlStr+="<strong class='primary-font float-left'>"
									+ data[0][i].replyer
									+ "</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
				htmlStr+= "	<span>"
									+ data[0][i].reply
									+ "</span>";
				htmlStr+= "	<small class='float-right text-muted'>"
									+ displayTime(data[0][i].replyDate)
									+ "</small></li>";
			}
			
			htmlStr+= "<div class='row'><div class='col-lg-12'>";
			htmlStr+= "	<div align='right'>";
			htmlStr+= "		<ul class='pagination float-right mr-2'>";
			
			if(data[1].prev){
				htmlStr+= "				<li class='paginate_button_reply previous'>";
				htmlStr+= "					<a href='"+data[1].prev+"' class='mr-1' style='font-size:20px;'>Previous</a>";
				htmlStr+= "				</li>";
			}
			
			for(var i=data[1].startPage; i<=data[1].endPage; i++ ){
				htmlStr+= "				<li class='paginate_button_reply pageNum'>" 
				htmlStr+= "					<a href='"+i+"' class='mr-1' style='font-size:20px;' >"+i+"</a>";
				htmlStr+= "				</li>";
			}
			
			if(data[1].next){
				htmlStr+= "				<li class='paginate_button_reply next'>";
				htmlStr+= "					<a href='"+(data[1].endPage+1)+"' class='mr-1' style='font-size:20px;'>Next</a>";
				htmlStr+= "				</li>";
				htmlStr+= "		</ul>";
			}
			
			htmlStr+= "	</div>";
			htmlStr+= "</div></div>";
			
			$("#reply").html(htmlStr);
			
			$(".paginate_button_reply a").on("click",	function(e) {
				e.preventDefault();
				var pageNum = $(this).attr("href");
				getReplyList($("#bno").val(),pageNum);
			});
			
		},
		error:function(e){
			alert("error : "+e);
		}
	});
}


  