<%@ page pageEncoding="UTF-8" language="java"
	contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Project Three</title>
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v5.12.1/js/all.js"
	crossorigin="anonymous"></script>
<!-- Google fonts-->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css" />
<link
	href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic"
	rel="stylesheet" type="text/css" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="/resources/css/styles.css" rel="stylesheet" />
</head>
<body id="page-top">
	<!-- Navigation-->
	<nav
		class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top"
		id="mainNav">
		<div class="container">
			<a class="navbar-brand js-scroll-trigger" href="#page-top">Project
				3</a>
			<button
				class="navbar-toggler navbar-toggler-right text-uppercase font-weight-bold bg-primary text-white rounded"
				type="button" data-toggle="collapse" data-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				Menu <i class="fas fa-bars"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger"
						href="#portfolio">Portfolio</a></li>
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger"
						href="#about">About</a></li>
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger"
						href="#contact">Contact</a></li>
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger"
						href="#board">Board</a></li>
					<sec:authorize access="isAuthenticated()">
						<li class="nav-item mx-0 mx-lg-1"><a
							class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger"
							id="navLogout">Logout</a></li>
					</sec:authorize>
					
					<sec:authorize access="isAnonymous()">
						<li class="nav-item mx-0 mx-lg-1"><a
							class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger"
							id="navLogin">Login</a></li>
					</sec:authorize>
				</ul>
			</div>
		</div>
	</nav>
	<!-- Masthead-->
	<header class="masthead bg-primary text-white text-center">
		<div class="container d-flex align-items-center flex-column">
			<!-- Masthead Avatar Image-->
			<img class="masthead-avatar mb-5"
				src="/resources/assets/img/avataaars.svg" alt="" />
			<!-- Masthead Heading-->
			<h1 class="masthead-heading text-uppercase mb-0">Start Bootstrap</h1>
			<!-- Icon Divider-->
			<div class="divider-custom divider-light">
				<div class="divider-custom-line"></div>
				<div class="divider-custom-icon">
					<i class="fas fa-star"></i>
				</div>
				<div class="divider-custom-line"></div>
			</div>
			<!-- Masthead Subheading-->
			<p class="masthead-subheading font-weight-light mb-0">Graphic
				Artist - Web Designer - Illustrator</p>
		</div>
	</header>
	<!-- Portfolio Section-->
	<section class="page-section portfolio" id="portfolio">
		<div class="container">
			<!-- Portfolio Section Heading-->
			<h2
				class="page-section-heading text-center text-uppercase text-secondary mb-0">Portfolio</h2>
			<!-- Icon Divider-->
			<div class="divider-custom">
				<div class="divider-custom-line"></div>
				<div class="divider-custom-icon">
					<i class="fas fa-star"></i>
				</div>
				<div class="divider-custom-line"></div>
			</div>
			<!-- Portfolio Grid Items-->
			<div class="row">
				<!-- Portfolio Item 1-->
				<div class="col-md-6 col-lg-4 mb-5">
					<div class="portfolio-item mx-auto" data-toggle="modal"
						data-target="#portfolioModal1">
						<div
							class="portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100">
							<div
								class="portfolio-item-caption-content text-center text-white">
								<i class="fas fa-plus fa-3x"></i>
							</div>
						</div>
						<img class="img-fluid"
							src="/resources/assets/img/portfolio/cabin.png" alt="" />
					</div>
				</div>
				<!-- Portfolio Item 2-->
				<div class="col-md-6 col-lg-4 mb-5">
					<div class="portfolio-item mx-auto" data-toggle="modal"
						data-target="#portfolioModal2">
						<div
							class="portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100">
							<div
								class="portfolio-item-caption-content text-center text-white">
								<i class="fas fa-plus fa-3x"></i>
							</div>
						</div>
						<img class="img-fluid"
							src="/resources/assets/img/portfolio/cake.png" alt="" />
					</div>
				</div>
				<!-- Portfolio Item 3-->
				<div class="col-md-6 col-lg-4 mb-5">
					<div class="portfolio-item mx-auto" data-toggle="modal"
						data-target="#portfolioModal3">
						<div
							class="portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100">
							<div
								class="portfolio-item-caption-content text-center text-white">
								<i class="fas fa-plus fa-3x"></i>
							</div>
						</div>
						<img class="img-fluid"
							src="/resources/assets/img/portfolio/circus.png" alt="" />
					</div>
				</div>
				<!-- Portfolio Item 4-->
				<div class="col-md-6 col-lg-4 mb-5 mb-lg-0">
					<div class="portfolio-item mx-auto" data-toggle="modal"
						data-target="#portfolioModal4">
						<div
							class="portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100">
							<div
								class="portfolio-item-caption-content text-center text-white">
								<i class="fas fa-plus fa-3x"></i>
							</div>
						</div>
						<img class="img-fluid"
							src="/resources/assets/img/portfolio/game.png" alt="" />
					</div>
				</div>
				<!-- Portfolio Item 5-->
				<div class="col-md-6 col-lg-4 mb-5 mb-md-0">
					<div class="portfolio-item mx-auto" data-toggle="modal"
						data-target="#portfolioModal5">
						<div
							class="portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100">
							<div
								class="portfolio-item-caption-content text-center text-white">
								<i class="fas fa-plus fa-3x"></i>
							</div>
						</div>
						<img class="img-fluid"
							src="/resources/assets/img/portfolio/safe.png" alt="" />
					</div>
				</div>
				<!-- Portfolio Item 6-->
				<div class="col-md-6 col-lg-4">
					<div class="portfolio-item mx-auto" data-toggle="modal"
						data-target="#portfolioModal6">
						<div
							class="portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100">
							<div
								class="portfolio-item-caption-content text-center text-white">
								<i class="fas fa-plus fa-3x"></i>
							</div>
						</div>
						<img class="img-fluid"
							src="/resources/assets/img/portfolio/submarine.png" alt="" />
					</div>
				</div>
				<!-- Portfolio Item 7(BoardDetail)-->
				<div class="col-md-6 col-lg-4">
					<div class="portfolio-item mx-auto" data-toggle="modal"
						data-target="#portfolioModal7">
						<div  id="port7"
							class="portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100">
							<div
								class="portfolio-item-caption-content text-center text-white">
								<i class="fas fa-plus fa-3x"></i>
							</div>
						</div>
					</div>
				</div>
				<!-- Portfolio Item 8(Login)-->
				<div class="col-md-6 col-lg-4">
					<div class="portfolio-item mx-auto" data-toggle="modal"
						data-target="#portfolioModal8">
						<div  id="port8"
							class="portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100">
							<div
								class="portfolio-item-caption-content text-center text-white">
								<i class="fas fa-plus fa-3x"></i>
							</div>
						</div>
					</div>
				</div>
				<!-- Portfolio Item 9(Logout)-->
				<div class="col-md-6 col-lg-4">
					<div  class="portfolio-item mx-auto" data-toggle="modal"
						data-target="#portfolioModal9">
						<div id="port9"
							class="portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100">
							<div
								class="portfolio-item-caption-content text-center text-white">
								<i class="fas fa-plus fa-3x"></i>
							</div>
						</div>
					</div>
				</div>
				<!-- Portfolio Item 10(BoardRegister)-->
				<div class="col-md-6 col-lg-4">
					<div class="portfolio-item mx-auto" data-toggle="modal"
						data-target="#portfolioModal10">
						<div id="port10"
							class="portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100">
							<div
								class="portfolio-item-caption-content text-center text-white">
								<i class="fas fa-plus fa-3x"></i>
							</div>
						</div>
					</div>
				</div>
				
				<!-- Portfolio Item 11(MemberRegister)-->
				<div class="col-md-6 col-lg-4">
					<div class="portfolio-item mx-auto" data-toggle="modal"
						data-target="#portfolioModal11">
						<div id="port11"
							class="portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100">
							<div
								class="portfolio-item-caption-content text-center text-white">
								<i class="fas fa-plus fa-3x"></i>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- About Section-->
	<section class="page-section bg-primary text-white mb-0" id="about">
		<div class="container">
			<!-- About Section Heading-->
			<h2
				class="page-section-heading text-center text-uppercase text-white">About</h2>
			<!-- Icon Divider-->
			<div class="divider-custom divider-light">
				<div class="divider-custom-line"></div>
				<div class="divider-custom-icon">
					<i class="fas fa-star"></i>
				</div>
				<div class="divider-custom-line"></div>
			</div>
			<!-- About Section Content-->
			<div class="row">
				<div class="col-lg-4 ml-auto">
					<p class="lead">Freelancer is a free bootstrap theme created by
						Start Bootstrap. The download includes the complete source files
						including HTML, CSS, and JavaScript as well as optional SASS
						stylesheets for easy customization.</p>
				</div>
				<div class="col-lg-4 mr-auto">
					<p class="lead">You can create your own custom avatar for the
						masthead, change the icon in the dividers, and add your email
						address to the contact form to make it fully functional!</p>
				</div>
			</div>
			<!-- About Section Button-->
			<div class="text-center mt-4">
				<a class="btn btn-xl btn-outline-light"
					href="https://startbootstrap.com/themes/freelancer/"><i
					class="fas fa-download mr-2"></i>Free Download!</a>
			</div>
		</div>
	</section>
	<!-- Contact Section-->
	<section class="page-section" id="contact">
		<div class="container">
			<!-- Contact Section Heading-->
			<h2
				class="page-section-heading text-center text-uppercase text-secondary mb-0">Contact
				Me</h2>
			<!-- Icon Divider-->
			<div class="divider-custom">
				<div class="divider-custom-line"></div>
				<div class="divider-custom-icon">
					<i class="fas fa-star"></i>
				</div>
				<div class="divider-custom-line"></div>
			</div>
			<!-- Contact Section Form-->
			<div class="row">
				<div class="col-lg-8 mx-auto">
					<!-- To configure the contact form email address, go to mail/contact_me.php and update the email address in the PHP file on line 19.-->
					<form id="contactForm" name="sentMessage" novalidate="novalidate">
						<div class="control-group">
							<div
								class="form-group floating-label-form-group controls mb-0 pb-2">
								<label>Name</label><input class="form-control" id="name"
									type="text" placeholder="Name" required="required"
									data-validation-required-message="Please enter your name." />
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<div class="control-group">
							<div
								class="form-group floating-label-form-group controls mb-0 pb-2">
								<label>Email Address</label><input class="form-control"
									id="email" type="email" placeholder="Email Address"
									required="required"
									data-validation-required-message="Please enter your email address." />
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<div class="control-group">
							<div
								class="form-group floating-label-form-group controls mb-0 pb-2">
								<label>Phone Number</label><input class="form-control"
									id="phone" type="tel" placeholder="Phone Number"
									required="required"
									data-validation-required-message="Please enter your phone number." />
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<div class="control-group">
							<div
								class="form-group floating-label-form-group controls mb-0 pb-2">
								<label>Message</label>
								<textarea class="form-control" id="message" rows="5"
									placeholder="Message" required="required"
									data-validation-required-message="Please enter a message."></textarea>
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<br />
						<div id="success"></div>
						<div class="form-group">
							<button class="btn btn-primary btn-xl" id="sendMessageButton"
								type="submit">Send</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>
	<!-- Board Section-->
	<section class="page-section" id="board">
		<div class="container">
			<!-- Board Section Heading-->
			<h2
				class="page-section-heading text-center text-uppercase text-secondary mb-0">Board</h2>
			<!-- Icon Divider-->
			<div class="divider-custom">
				<div class="divider-custom-line"></div>
				<div class="divider-custom-icon">
					<i class="fas fa-star"></i>
				</div>
				<div class="divider-custom-line"></div>
			</div>
			<!-- Board Section Form-->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading mb-3">
							<sec:authorize access="isAuthenticated()">
							<button id="regBtn" type="button" class="btn btn-link ml-1 float-right">Register New Board</button>
							</sec:authorize>
						</div>
						
						<!-- /.panel-heading -->
						<div class="panel-body mt-3">
							<table id="boardTable" class="table table-bordered">
								<thead>
									<tr>
										<th>#번호</th>
										<th>제목</th>
										<th>작성자</th>
										<th>작성일</th>
										<th>수정일</th>
									</tr>
								</thead>
								<c:forEach items="${list }" var="board"  varStatus="idx">
									<!-- Toward BoardDetail -->
									<tr data-toggle="modal"	data-target="#portfolioModal7 ">
										<td style="display:none;">
											<input type="hidden" value="${board.bno }" id="hiddenBno">
										</td>
										<td><c:out value="${board.bno }"></c:out></td>
										<td>
											<c:out value="${board.title }"></c:out>
										</td>
										<td>
											<c:out value="${board.writer }"></c:out>
										</td>
										<td>
											<fmt:formatDate pattern="yyyy-MM-dd" value="${board.regdate }" />
										</td>
										<td>
											<fmt:formatDate pattern="yyyy-MM-dd" value="${board.updateDate }" />
										</td>
									</tr>
								</c:forEach>
							</table>
							<div class="float-right">
							<div class='row'>
								<div class="col-lg-12">
									<form id="searchForm" method='get'
										class="form-inline">
										<div class="form-group">
											<select name='type' class="form-control mr-1" id="searchType">
												<option value="T">제목</option>
												<option value="C">내용</option>
												<option value="W">작성자</option>
												<option value="TC">제목	또는 내용</option>
												<option value="TW">제목 또는 작성자</option>
												<option value="TWC">제목	또는 작성자 또는 내용</option>
											</select>
										</div>
										<div class="form-group mr-0">
											<input type="text" name="keyword" class="form-control" size="40" id="searchKeyword" placeholder="검색 키워드"/>
										</div>
										<input type="hidden" name="pageNum"
											value="${pageMaker.cri.pageNum }" /> <input type="hidden"
											name="amount" value="${pageMaker.cri.amount }" />
										&nbsp;&nbsp;
										<div class="form-group" id="searchGroup">
											<button id="searchBtn" class="btn btn-link form-control">Search</button>
											<button id='returnBtn' class='btn btn-link form-control ml-1' >Return</button>
										</div>
									</form>
								</div>
							</div>
							<div class='row'>
								<div class="col-lg-12">
									<div align="right">
										<ul class="pagination float-right mr-2">
											<c:if test="${pageMaker.prev }">
												<li class="paginate_button_board previous"><a
													href="${pageMaker.startPage-1 }" class="mr-1" style="font-size:20px;">Previous</a></li>
											</c:if>
											<c:forEach var="num" begin="${pageMaker.startPage }"
												end="${pageMaker.endPage }">
												<li class="paginate_button_board pageNum"><a href="${num }" class="mr-1" style="font-size:20px;" >${num }</a>
												</li>
											</c:forEach>
											<c:if test="${pageMaker.next }">
												<li class="paginate_button_board next"><a
													href="${pageMaker.endPage+1 }" class="mr-1" style="font-size:20px;">Next</a></li>
											</c:if>
										</ul>
									</div>
									
								</div>
								</div>
								<!-- end Pagination -->
							</div>
						</div>
					</div>
					<!-- /.panel-body -->
				</div>
				<!-- /.panel -->
			</div>
			<!-- /.row -->
		</div>
	</section>
	<!-- Footer-->
	<footer class="footer text-center">
		<div class="container">
			<div class="row">
				<!-- Footer Location-->
				<div class="col-lg-4 mb-5 mb-lg-0">
					<h4 class="text-uppercase mb-4">Location</h4>
					<p class="lead mb-0">
						2215 John Daniel Drive<br />Clark, MO 65243
					</p>
				</div>
				<!-- Footer Social Icons-->
				<div class="col-lg-4 mb-5 mb-lg-0">
					<h4 class="text-uppercase mb-4">Around the Web</h4>
					<a class="btn btn-outline-light btn-social mx-1" href="#"><i
						class="fab fa-fw fa-facebook-f"></i></a><a
						class="btn btn-outline-light btn-social mx-1" href="#"><i
						class="fab fa-fw fa-twitter"></i></a><a
						class="btn btn-outline-light btn-social mx-1" href="#"><i
						class="fab fa-fw fa-linkedin-in"></i></a><a
						class="btn btn-outline-light btn-social mx-1" href="#"><i
						class="fab fa-fw fa-dribbble"></i></a>
				</div>
				<!-- Footer About Text-->
				<div class="col-lg-4">
					<h4 class="text-uppercase mb-4">About Freelancer</h4>
					<p class="lead mb-0">
						Freelance is a free to use, MIT licensed Bootstrap theme created
						by <a href="http://startbootstrap.com">Start Bootstrap</a>.
					</p>
				</div>
			</div>
		</div>
	</footer>
	<!-- Copyright Section-->
	<section class="copyright py-4 text-center text-white">
		<div class="container">
			<small>Copyright © Your Website 2020</small>
		</div>
	</section>
	<!-- Scroll to Top Button (Only visible on small and extra-small screen sizes)-->
	<div class="scroll-to-top d-lg-none position-fixed">
		<a class="js-scroll-trigger d-block text-center text-white rounded"
			href="#page-top"><i class="fa fa-chevron-up"></i></a>
	</div>
	<!-- Portfolio Modals-->
	<!-- Portfolio Modal 1-->
	<div class="portfolio-modal modal fade" id="portfolioModal1"
		tabindex="-1" role="dialog" aria-labelledby="portfolioModal1Label"
		aria-hidden="true">
		<div class="modal-dialog modal-xl" role="document">
			<div class="modal-content">
				<button class="close" type="button" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true"><i class="fas fa-times"></i></span>
				</button>
				<div class="modal-body text-center">
					<div class="container">
						<div class="row justify-content-center">
							<div class="col-lg-8">
								<!-- Portfolio Modal - Title-->
								<h2
									class="portfolio-modal-title text-secondary text-uppercase mb-0">Log
									Cabin</h2>
								<!-- Icon Divider-->
								<div class="divider-custom">
									<div class="divider-custom-line"></div>
									<div class="divider-custom-icon">
										<i class="fas fa-star"></i>
									</div>
									<div class="divider-custom-line"></div>
								</div>
								<!-- Portfolio Modal - Image-->
								<img class="img-fluid rounded mb-5"
									src="/resources/assets/img/portfolio/cabin.png" alt="" />
								<!-- Portfolio Modal - Text-->
								<p class="mb-5">Lorem ipsum dolor sit amet, consectetur
									adipisicing elit. Mollitia neque assumenda ipsam nihil,
									molestias magnam, recusandae quos quis inventore quisquam velit
									asperiores, vitae? Reprehenderit soluta, eos quod consequuntur
									itaque. Nam.</p>
								<button class="btn btn-primary" href="#" data-dismiss="modal">
									<i class="fas fa-times fa-fw"></i>Close Window
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Portfolio Modal 2-->
	<div class="portfolio-modal modal fade" id="portfolioModal2"
		tabindex="-1" role="dialog" aria-labelledby="portfolioModal2Label"
		aria-hidden="true">
		<div class="modal-dialog modal-xl" role="document">
			<div class="modal-content">
				<button class="close" type="button" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true"><i class="fas fa-times"></i></span>
				</button>
				<div class="modal-body text-center">
					<div class="container">
						<div class="row justify-content-center">
							<div class="col-lg-8">
								<!-- Portfolio Modal - Title-->
								<h2
									class="portfolio-modal-title text-secondary text-uppercase mb-0">Tasty
									Cake</h2>
								<!-- Icon Divider-->
								<div class="divider-custom">
									<div class="divider-custom-line"></div>
									<div class="divider-custom-icon">
										<i class="fas fa-star"></i>
									</div>
									<div class="divider-custom-line"></div>
								</div>
								<!-- Portfolio Modal - Image-->
								<img class="img-fluid rounded mb-5"
									src="/resources/assets/img/portfolio/cake.png" alt="" />
								<!-- Portfolio Modal - Text-->
								<p class="mb-5">Lorem ipsum dolor sit amet, consectetur
									adipisicing elit. Mollitia neque assumenda ipsam nihil,
									molestias magnam, recusandae quos quis inventore quisquam velit
									asperiores, vitae? Reprehenderit soluta, eos quod consequuntur
									itaque. Nam.</p>
								<button class="btn btn-primary" href="#" data-dismiss="modal">
									<i class="fas fa-times fa-fw"></i>Close Window
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Portfolio Modal 3-->
	<div class="portfolio-modal modal fade" id="portfolioModal3"
		tabindex="-1" role="dialog" aria-labelledby="portfolioModal3Label"
		aria-hidden="true">
		<div class="modal-dialog modal-xl" role="document">
			<div class="modal-content">
				<button class="close" type="button" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true"><i class="fas fa-times"></i></span>
				</button>
				<div class="modal-body text-center">
					<div class="container">
						<div class="row justify-content-center">
							<div class="col-lg-8">
								<!-- Portfolio Modal - Title-->
								<h2
									class="portfolio-modal-title text-secondary text-uppercase mb-0">Circus
									Tent</h2>
								<!-- Icon Divider-->
								<div class="divider-custom">
									<div class="divider-custom-line"></div>
									<div class="divider-custom-icon">
										<i class="fas fa-star"></i>
									</div>
									<div class="divider-custom-line"></div>
								</div>
								<!-- Portfolio Modal - Image-->
								<img class="img-fluid rounded mb-5"
									src="/resources/assets/img/portfolio/circus.png" alt="" />
								<!-- Portfolio Modal - Text-->
								<p class="mb-5">Lorem ipsum dolor sit amet, consectetur
									adipisicing elit. Mollitia neque assumenda ipsam nihil,
									molestias magnam, recusandae quos quis inventore quisquam velit
									asperiores, vitae? Reprehenderit soluta, eos quod consequuntur
									itaque. Nam.</p>
								<button class="btn btn-primary" href="#" data-dismiss="modal">
									<i class="fas fa-times fa-fw"></i>Close Window
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Portfolio Modal 4-->
	<div class="portfolio-modal modal fade" id="portfolioModal4"
		tabindex="-1" role="dialog" aria-labelledby="portfolioModal4Label"
		aria-hidden="true">
		<div class="modal-dialog modal-xl" role="document">
			<div class="modal-content">
				<button class="close" type="button" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true"><i class="fas fa-times"></i></span>
				</button>
				<div class="modal-body text-center">
					<div class="container">
						<div class="row justify-content-center">
							<div class="col-lg-8">
								<!-- Portfolio Modal - Title-->
								<h2
									class="portfolio-modal-title text-secondary text-uppercase mb-0">Controller</h2>
								<!-- Icon Divider-->
								<div class="divider-custom">
									<div class="divider-custom-line"></div>
									<div class="divider-custom-icon">
										<i class="fas fa-star"></i>
									</div>
									<div class="divider-custom-line"></div>
								</div>
								<!-- Portfolio Modal - Image-->
								<img class="img-fluid rounded mb-5"
									src="/resources/assets/img/portfolio/game.png" alt="" />
								<!-- Portfolio Modal - Text-->
								<p class="mb-5">Lorem ipsum dolor sit amet, consectetur
									adipisicing elit. Mollitia neque assumenda ipsam nihil,
									molestias magnam, recusandae quos quis inventore quisquam velit
									asperiores, vitae? Reprehenderit soluta, eos quod consequuntur
									itaque. Nam.</p>
								<button class="btn btn-primary" href="#" data-dismiss="modal">
									<i class="fas fa-times fa-fw"></i>Close Window
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Portfolio Modal 5-->
	<div class="portfolio-modal modal fade" id="portfolioModal5"
		tabindex="-1" role="dialog" aria-labelledby="portfolioModal5Label"
		aria-hidden="true">
		<div class="modal-dialog modal-xl" role="document">
			<div class="modal-content">
				<button class="close" type="button" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true"><i class="fas fa-times"></i></span>
				</button>
				<div class="modal-body text-center">
					<div class="container">
						<div class="row justify-content-center">
							<div class="col-lg-8">
								<!-- Portfolio Modal - Title-->
								<h2
									class="portfolio-modal-title text-secondary text-uppercase mb-0">Locked
									Safe</h2>
								<!-- Icon Divider-->
								<div class="divider-custom">
									<div class="divider-custom-line"></div>
									<div class="divider-custom-icon">
										<i class="fas fa-star"></i>
									</div>
									<div class="divider-custom-line"></div>
								</div>
								<!-- Portfolio Modal - Image-->
								<img class="img-fluid rounded mb-5"
									src="/resources/assets/img/portfolio/safe.png" alt="" />
								<!-- Portfolio Modal - Text-->
								<p class="mb-5">Lorem ipsum dolor sit amet, consectetur
									adipisicing elit. Mollitia neque assumenda ipsam nihil,
									molestias magnam, recusandae quos quis inventore quisquam velit
									asperiores, vitae? Reprehenderit soluta, eos quod consequuntur
									itaque. Nam.</p>
								<button class="btn btn-primary" href="#" data-dismiss="modal">
									<i class="fas fa-times fa-fw"></i>Close Window
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Portfolio Modal 6-->
	<div class="portfolio-modal modal fade" id="portfolioModal6"
		tabindex="-1" role="dialog" aria-labelledby="portfolioModal6Label"
		aria-hidden="true">
		<div class="modal-dialog modal-xl" role="document">
			<div class="modal-content">
				<button class="close" type="button" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true"><i class="fas fa-times"></i></span>
				</button>
				<div class="modal-body text-center">
					<div class="container">
						<div class="row justify-content-center">
							<div class="col-lg-8">
								<!-- Portfolio Modal - Title-->
								<h2
									class="portfolio-modal-title text-secondary text-uppercase mb-0">Submarine</h2>
								<!-- Icon Divider-->
								<div class="divider-custom">
									<div class="divider-custom-line"></div>
									<div class="divider-custom-icon">
										<i class="fas fa-star"></i>
									</div>
									<div class="divider-custom-line"></div>
								</div>
								<!-- Portfolio Modal - Image-->
								<img class="img-fluid rounded mb-5"
									src="/resources/assets/img/portfolio/submarine.png" alt="" />
								<!-- Portfolio Modal - Text-->
								<p class="mb-5">Lorem ipsum dolor sit amet, consectetur
									adipisicing elit. Mollitia neque assumenda ipsam nihil,
									molestias magnam, recusandae quos quis inventore quisquam velit
									asperiores, vitae? Reprehenderit soluta, eos quod consequuntur
									itaque. Nam.</p>
								<button class="btn btn-primary" href="#" data-dismiss="modal">
									<i class="fas fa-times fa-fw"></i>Close Window
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal 7(BoardDetail)-->
	<div class="portfolio-modal modal fade" id="portfolioModal7"
		tabindex="-1" role="dialog" aria-labelledby="portfolioModal7Label"
		aria-hidden="true">
		<div class="modal-dialog modal-xl" role="document" >
			<div class="modal-content">
				<button class="close" type="button" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true"><i class="fas fa-times"></i></span>
				</button>
				<div class="modal-body d-flex justify-content-center"" >
					<div class="container">
						<div class="row justify-content-center">
							<div class="col-lg-8" id="boardDetail">
							
							</div>
						</div>
					</div>
				</div>
				<button id="close" class="btn btn-primary" href="#" data-dismiss="modal">
						<i class="fas fa-times fa-fw"></i>Close Window
				</button>
			</div>
		</div>
	</div>
	<!-- Modal 8(Login)-->
	<div class="portfolio-modal modal fade" id="portfolioModal8"
		tabindex="-1" role="dialog" aria-labelledby="portfolioModal8Label"
		aria-hidden="true">
		<div class="modal-dialog modal-xl" role="document" >
			<div class="modal-content">
				<button class="close" type="button" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true"><i class="fas fa-times"></i></span>
				</button>
				<div class="modal-body d-flex justify-content-center"" id="loginDetail">
					 <div class="panel-body">
                        <form role="form" method='post' action="/login">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="userid" name="username" type="text" autofocus>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Password" name="password" type="password" value="">
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input name="remember-me" type="checkbox" >Remember Me
                                    </label>
                                </div>
                                <!-- Change this to a button or input when using this as a form -->
                            </fieldset>
                           <div align="center">
                               <input type="submit" class="btn btn-success" value="로그인">
                               <input type="button" class="btn btn-danger" value="회원가입" id="register">
                            </div>
                            <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
                        </form>
                    </div>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal 9(Logout)-->
	<div class="portfolio-modal modal fade" id="portfolioModal9"
		tabindex="-1" role="dialog" aria-labelledby="portfolioModal9Label"
		aria-hidden="true">
		<div class="modal-dialog modal-xl" role="document" >
			<div class="modal-content">
				<button class="close" type="button" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true"><i class="fas fa-times"></i></span>
				</button>
				<div class="modal-body d-flex justify-content-center"" id="logoutDetail">
					 <div class="panel-body">
                        <form role="form" method='post' action="/logout">
                            <fieldset>
                                <!-- Change this to a button or input when using this as a form -->
                                <input type="submit" class="btn btn-success btn-block" value="로그아웃">
                            </fieldset>
                            <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
                        </form>
                    </div>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal 10(Board Register)-->
	<sec:authorize access="isAuthenticated()">
	<div class="portfolio-modal modal fade" id="portfolioModal10"
		tabindex="-1" role="dialog" aria-labelledby="portfolioModal10Label"
		aria-hidden="true">
		<div class="modal-dialog modal-xl" role="document">
			<div class="modal-content">
				<button class="close" type="button" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true"><i class="fas fa-times"></i></span>
				</button>
				<div class="modal-body text-center d-flex justify-content-center"" id="logoutDetail">
					 <div class="panel-body">
                            <form role="form" action="/register" method="post">
                            <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
                            	<div class="form-group">
                            		<label>Title</label> <input class="form-control" name="title">
                            	</div>
                            	<div class="form-group">
                            		<label>Text area</label>
                            		<textarea rows="3" class="form-control" name="content"></textarea>
                            	</div>
                            	<div class="form-group">
                            		<label>Writer</label> <input class="form-control" 
                            			name="writer" value='<sec:authentication property="principal.username"/>' readonly="readonly">
                            	</div>
                            	<button type="submit" class="btn btn-link ml-1">Submit Button</button>
                            	<button type="reset" class="btn btn-link ml-1">Reset Button</button>
                            </form>
                    </div>
				</div>
			</div>
		</div>
	</div>
	</sec:authorize>
	
	
	<!-- Modal 10(Member Register)-->
	<div class="portfolio-modal modal fade" id="portfolioModal11"
		tabindex="-1" role="dialog" aria-labelledby="portfolioModal11Label"
		aria-hidden="true">
		<div class="modal-dialog modal-xl" role="document">
			<div class="modal-content">
				<button class="close" type="button" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true"><i class="fas fa-times"></i></span>
				</button>
				<div class="container">
        <div class="row d-flex justify-content-center">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                	<br><br>
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
                            <input type="button" class="btn btn-danger" value="회원가입" id="goRegister">
                        </form>
                    </div>
                    <br><br>
                </div>
            </div>
        </div>
    </div>

			</div>
		</div>
	</div>
	
	<!-- Bootstrap core JS-->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
	<!-- Third party plugin JS-->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
	<!-- Contact form JS-->
	<script src="/resources/assets/mail/jqBootstrapValidation.js"></script>
	<script src="/resources/assets/mail/contact_me.js"></script>
	<!-- Core theme JS-->
	<script src="/resources/js/scripts.js"></script>
	<script type="text/javascript">
$(document).on("click",'#boardTable tr',function(e){
	$("#boardDetail").empty();
	var bno=$(this).find("#hiddenBno").val();
	//alert(bno); 있음
	getDetail(bno);
	$("#port7").trigger("click");
});
	
$(function(){
	$("#returnBtn").hide();
	$("#searchBtn").on("click",function(e){
		e.preventDefault();
		var type =$("#searchType").val();
		var keyword =$("#searchKeyword").val();

		getSearchList(1,5,type,keyword);
	});

	$("#register").on("click",function(e){
		$("#port8").trigger("click");
		$("#port11").trigger("click");
	});
	
	$("#returnBtn").on("click",function(e){
		e.preventDefault();
		$("#searchKeyword").val("");
		$("#returnBtn").hide();

		var pageNum = 1;
		var amount = 5;
		
		getList(pageNum,amount);

		$(".pagination").show();
	});

	$(".paginate_button_board a").on("click",	function(e) {
		e.preventDefault();
		var pageNum = $(this).attr("href");
		//alert(pageNum); 
		var amount = 5;
		//alert(amount); 있음

		getList(pageNum,amount);		
	});

	
	$("#navLogin").on("click",function(e){
		$("#port8").trigger("click");
	})
	
	$("#navLogout").on("click",function(e){
		$("#port9").trigger("click");
	})
	
	$("#regBtn").on("click",function(e){
		$("#port10").trigger("click");
	})
})

$(function(){
			if($("#check").val() != ""){
				alert("중복된 아이디입니다.");
			}
		})
    	
		$("#goRegister").on("click",function(e){
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
