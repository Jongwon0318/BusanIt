package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
//	<li><a class="active" href="/" >Home</a></li>
//    <li><a class="" href="/movies_admin">영화 검색 및 등록</a></li>
//    <li><a href="#">상영관<i class="ti-angle-down"></i></a>
//        <ul class="submenu">
//                <li><a href="/auditorium">상영관 추가 및 관리</a></li>
//                <li><a href="/timeTable_admin">상영시간표 관리</a></li>
//        </ul>
//    </li>
//    <li><a href="#">고객 <i class="ti-angle-down"></i></a>
//        <ul class="submenu">
//            <li><a href="/customer_admin">고객 관리</a></li>
//        </ul>
//    </li>
//    <li><a href="/about_admin">게시판</a></li>
//    
    @RequestMapping("/movies_admin")
    public String adminM() {
    	return "/admin/movies_admin";
    }
    
    @RequestMapping("/auditorium")
    public String auditorium() {
    	return "/admin/auditorium";
    }
    
    @RequestMapping("/timeTable_admin")
    public String timeT() {
    	return "/admin/timeTable_admin";
    }
    
    @RequestMapping("/customer_admin")
    public String cusT() {
    	return "/admin/customer_admin";
    }
    
    @RequestMapping("/about_admin")
    public String abAd() {
    	return "/admin/about_admin";
    }
    
}
