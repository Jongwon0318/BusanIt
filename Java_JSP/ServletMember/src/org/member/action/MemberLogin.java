package org.member.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.member.model.MemberDTO;
import org.member.model.SMemberDAOImpl;

/**
 * Servlet implementation class MemberLogin
 */
@WebServlet("/member/login.go")
public class MemberLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("loginForm.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String userid=request.getParameter("userid");
		String pwd=request.getParameter("pwd");
		SMemberDAOImpl smdao=SMemberDAOImpl.getInstance();
		MemberDTO mdto=smdao.loginCheck(userid,pwd);
		HttpSession session=request.getSession();
		int flag=-1; //회원이 아니다
		if(mdto!=null) {//회원이다
			flag=mdto.getAdmin(); //0,1,2
			if(flag ==0 || flag==1) {
				session.setAttribute("sessDto", mdto);
			}
		}else { //회원이 아니다
			session.setAttribute("userid", userid);
			session.setAttribute("pwd", pwd);
		}
		response.setContentType("utf-8");
		PrintWriter out=response.getWriter();
		out.println(flag);
	}

}
