package com.examAction;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PersonServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String name=req.getParameter("name");
		String userid=req.getParameter("userid");
		String pwd=req.getParameter("pwd");
		String gender=req.getParameter("gender");
		String[] notice=req.getParameterValues("notice");
		String job=req.getParameter("job");
		
//		req.setAttribute("name", name);
//		req.setAttribute("userid", userid);
//		req.setAttribute("pwd", pwd);
//		req.setAttribute("gender", gender);
//		req.setAttribute("notice", notice);
//		req.setAttribute("job", job);
		
		Person p=new Person();
		p.setName(name);
		p.setUserid(userid);
		p.setPwd(pwd);
		p.setGender(gender);
		p.setNotice(notice);
		p.setJob(job);
		
		req.setAttribute("ps", p);		
		
		RequestDispatcher rd=req.getRequestDispatcher("personResult.jsp");
		rd.forward(req, resp);
	}
}
