package com.examAction;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PersonAction
 */
@WebServlet("/test/personAction") //web.xml 에서 servlet을 처리하는 과정을 담은 annotation ->web.xml을 수정하지 않아도 됨
public class PersonAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get에서만 작업하면 됨
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		String userid=request.getParameter("userid");
		String pwd=request.getParameter("pwd");
		String gender=request.getParameter("gender");
		String[] notice=request.getParameterValues("notice");
		String job=request.getParameter("job");
		
		Person p=new Person();
		p.setName(name);
		p.setPwd(pwd);
		p.setUserid(userid);
		p.setGender(gender);
		p.setNotice(notice);
		p.setJob(job);
		
		request.setAttribute("ps", p);
		
		RequestDispatcher rd=request.getRequestDispatcher("../exam/personResult.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response); //어차피 doGet메소드로 보내므로 어떤 방식으로 접근하느냐가 상관없음.
	}

}
