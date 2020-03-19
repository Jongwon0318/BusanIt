package org.member.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.member.model.MemberDTO;
import org.member.model.SMemberDAOImpl;

/**
 * Servlet implementation class MemberDelete
 */
@WebServlet("/member/memDelete.go")
public class MemberDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println(request.getParameter("delid"));
		SMemberDAOImpl smdao=SMemberDAOImpl.getInstance();
		smdao.memDelete(request.getParameter("delid"));
		
		HttpSession session=request.getSession();
		MemberDTO tmp=(MemberDTO)session.getAttribute("sessDto");
		if(tmp.getAdmin()==0) {
			response.sendRedirect("login.go");
		}else {
			response.sendRedirect("memList.go");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
