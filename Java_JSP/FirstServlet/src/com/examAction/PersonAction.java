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
@WebServlet("/test/personAction") //web.xml ���� servlet�� ó���ϴ� ������ ���� annotation ->web.xml�� �������� �ʾƵ� ��
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
		//get������ �۾��ϸ� ��
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
		doGet(request, response); //������ doGet�޼ҵ�� �����Ƿ� � ������� �����ϴ��İ� �������.
	}

}
