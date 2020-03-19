package org.member.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.member.model.MemberDTO;
import org.member.model.SMemberDAOImpl;

/**
 * Servlet implementation class MemberInsert
 */
@WebServlet("/member/memInsert.go")
public class MemberInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		

		MemberDTO mdto=new MemberDTO();
		mdto.setUserid((String)session.getAttribute("userid"));
		mdto.setPwd((String)session.getAttribute("pwd"));
		
		request.setAttribute("mdto", mdto);
		
		RequestDispatcher rd=request.getRequestDispatcher("memberForm.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		MemberDTO mdto=new MemberDTO();
		
		String name=request.getParameter("name");
		String userid=request.getParameter("userid");
		String pwd=request.getParameter("pwd");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		int admin=Integer.parseInt(request.getParameter("admin"));
		
		mdto.setName(name);
		mdto.setUserid(userid);
		mdto.setPwd(pwd);
		mdto.setEmail(email);
		mdto.setPhone(phone);
		mdto.setAdmin(admin);
		
		HttpSession session = request.getSession();
		session.removeAttribute("userid");
		session.removeAttribute("pwd");
		
		SMemberDAOImpl smdao=SMemberDAOImpl.getInstance();
		smdao.memInsert(mdto);
		response.sendRedirect("loginForm.jsp");	
	}

}
