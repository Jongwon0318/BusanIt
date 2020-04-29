<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../includes_admin/header.jsp" %>

     <!-- slider_area_start -->
    <div class="slider_area">
        <div class="slider_active owl-carousel">
            <div class="single_slider  d-flex align-items-center slider_bg_1 overlay">
                <div class="container">
                    <div class="row align-items-center">
                        <div class="col-xl-12 col-md-12">
                            <div class="slider_text text-center">
                                <h3>Movie Recommendation</h3>
                                <br>
                                <a href="#" class="boxed-btn3">확인하기</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="single_slider  d-flex align-items-center slider_bg_2 overlay">
                <div class="container">
                    <div class="row align-items-center">
                        <div class="col-xl-12 col-md-12">
                            <div class="slider_text text-center">
                                <h3>Movie</h3><br><h3>Ticketing</h3>
                                 <br>
                                <a href="#" class="boxed-btn3">예매하기</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="single_slider  d-flex align-items-center slider_bg_3 overlay">
                <div class="container">
                    <div class="row align-items-center">
                        <div class="col-xl-12 col-md-12">
                            <div class="slider_text text-center">
                                <h3>Actor</h3><h3><br>Q&A</h3>
                                <br><br>
                                <a href="#" class="boxed-btn3">알아보기</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
    <!-- slider_area_end -->

    <!-- where_togo_area_start  -->
    <div class="where_togo_area">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-lg-3">
                    <div class="form_area">
                        <h3>예매정보</h3>
                    </div>
                </div>
                <div class="col-lg-9">
                    <div class="search_wrap">
                        <form class="search_form" action="#">
                            <div class="input_field">
                                <select>
                                    <option data-display="영화">영화</option>
                                    <option value="1">1917</option>
                                    <option value="2">엽문 4: 더 파이널</option>
                                    <option value="3">나는 내일, 어제의 너와 만난다</option>
                                    <option value="4">주디</option>
                                </select>
                            </div>
                            <div class="input_field">
                                <input id="datepicker" placeholder="일시">
                            </div>
                            <div class="input_field">
                                <select>
                                    <option data-display="인원 수">인원 수</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                </select>
                            </div>
                            <div class="search_btn">
                                <button class="boxed-btn4 " type="submit">찾아보기</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- where_togo_area_end  -->
    
    <!-- popular_destination_area_start  -->
    <div class="popular_destination_area">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-6">
                    <div class="section_title text-center mb_70">
                        <h3>Box Office</h3>
                        <p>지금 가장 인기있는 영화는?</p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-4 col-md-6">
                    <div class="single_destination">
                        <div class="thumb">
                            <img src="/resources/img/destination/1.png" alt="">
                        </div>
                        <div class="content">
                            <p class="d-flex align-items-center">Italy <a href="travel_destination.html">  07 Places</a> </p>
                            
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6">
                    <div class="single_destination">
                        <div class="thumb">
                            <img src="/resources/img/destination/2.png" alt="">
                        </div>
                        <div class="content">
                            <p class="d-flex align-items-center">Brazil <a href="travel_destination.html">  03 Places</a> </p>
                            
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6">
                    <div class="single_destination">
                        <div class="thumb">
                            <img src="/resources/img/destination/3.png" alt="">
                        </div>
                        <div class="content">
                            <p class="d-flex align-items-center">America <a href="travel_destination.html">  10 Places</a> </p>
                            
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6">
                    <div class="single_destination">
                        <div class="thumb">
                            <img src="/resources/img/destination/4.png" alt="">
                        </div>
                        <div class="content">
                            <p class="d-flex align-items-center">Nepal <a href="travel_destination.html">  02 Places</a> </p>
                            
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6">
                    <div class="single_destination">
                        <div class="thumb">
                            <img src="/resources/img/destination/5.png" alt="">
                        </div>
                        <div class="content">
                            <p class="d-flex align-items-center">Maldives <a href="travel_destination.html">  02 Places</a> </p>
                            
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6">
                    <div class="single_destination">
                        <div class="thumb">
                            <img src="/resources/img/destination/6.png" alt="">
                        </div>
                        <div class="content">
                            <p class="d-flex align-items-center">Indonesia <a href="travel_destination.html">  05 Places</a> </p>
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- popular_destination_area_end  -->

    <!-- newletter_area_start  -->
    <div class="newletter_area overlay">
        <div class="container">
            <div class="row justify-content-center align-items-center">
                <div class="col-lg-10">
                    <div class="row align-items-center">
                        <div class="col-lg-5">
                            <div class="newsletter_text">
                                <h4>보고싶은 장르를 선택해보세요</h4>
                                <p>현재 상영중인 영화를 찾아드립니다.</p>
                            </div>
                        </div>
                        <div class="col-lg-7">
                            <div class="mail_form">
                                <div class="row no-gutters">
                                    <div class="col-lg-9 col-md-8">
                                        <div class="newsletter_field form-group">
                                            <select id="genre" class="select form-control" >
                                            	<option value="action">액션</option>
                                            	<option value="comedy">코미디</option>
                                            	<option value="romance">로맨스</option>
                                            	<option value="thriller">스릴러</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-lg-3 col-md-4">
                                        <div class="newsletter_btn">
                                            <button class="boxed-btn4 " type="submit">찾기</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- newletter_area_end  -->
	<br><br><br><br><br><br><br>
    <div class="row">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-6">
                    <div class="section_title text-center">
                        <h3>오늘의 추천영화</h3>
                        <p>1917</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
	<br>
    <div class="video_area video_bg overlay">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="video_wrap text-center">
                        <h3>Watch Video</h3>
                        <div class="video_icon">
                            <a class="popup-video video_play_button" href="https://youtu.be/YqNYrYUiMfg">
                                <i class="fa fa-play"></i>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <br>
    <div class="row">
                <div class="col-lg-12">
                    <div class="more_place_btn text-center">
                        <a class="boxed-btn4" href="#">예매하러 가기</a>
                    </div>
                </div>
    </div>
	<br><br><br>
    <!-- testimonial_area  -->
    <div class="testimonial_area">
        <div class="container">
            <div class="row">
                <div class="col-xl-12">
                    <div class="testmonial_active owl-carousel">
                        <div class="single_carousel">
                            <div class="row justify-content-center">
                                <div class="col-lg-8">
                                    <div class="single_testmonial text-center">
                                        <div class="author_thumb">
                                            <img src="/resources/img/testmonial/author.png" alt="">
                                        </div>
                                        <p>"재밌어요"</p>
                                        <div class="testmonial_author">
                                            <h3>- Micky Mouse</h3>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="single_carousel">
                            <div class="row justify-content-center">
                                <div class="col-lg-8">
                                    <div class="single_testmonial text-center">
                                        <div class="author_thumb">
                                            <img src="/resources/img/testmonial/author.png" alt="">
                                        </div>
                                        <p>"웅장해요"</p>
                                        <div class="testmonial_author">
                                            <h3>- Tom Mouse</h3>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="single_carousel">
                            <div class="row justify-content-center">
                                <div class="col-lg-8">
                                    <div class="single_testmonial text-center">
                                        <div class="author_thumb">
                                            <img src="/resources/img/testmonial/author.png" alt="">
                                        </div>
                                        <p>"눈물이 났습니다"</p>
                                        <div class="testmonial_author">
                                            <h3>- Jerry Mouse</h3>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- /testimonial_area  -->
    
<%@include file="../includes_admin/footer.jsp" %>
	</body>
</html>



   


  