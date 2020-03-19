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
 * Servlet implementation class MemberUpdate
 */
@WebServlet("/member/memUpdate.go")
public class MemberUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		MemberDTO tmp=(MemberDTO)session.getAttribute("sessDto");
		if(tmp.getAdmin()==0) {
			MemberDTO mdto=new MemberDTO();
			mdto.setAdmin(Integer.parseInt(request.getParameter("admin")));
			mdto.setEmail(request.getParameter("email"));
			mdto.setName(request.getParameter("name"));
			mdto.setPhone(request.getParameter("phone"));
			mdto.setPwd(request.getParameter("pwd"));
			mdto.setUserid(request.getParameter("userid"));
			SMemberDAOImpl smdao=SMemberDAOImpl.getInstance();
			smdao.memUpdate(mdto);
			response.sendRedirect("logout.go");
		}else {
			MemberDTO mdto=new MemberDTO();
			mdto.setAdmin(Integer.parseInt(request.getParameter("admin")));
			mdto.setEmail(request.getParameter("email"));
			mdto.setName(request.getParameter("name"));
			mdto.setPhone(request.getParameter("phone"));
			mdto.setPwd(request.getParameter("pwd"));
			mdto.setUserid(request.getParameter("userid"));
			SMemberDAOImpl smdao=SMemberDAOImpl.getInstance();
			smdao.memUpdate(mdto);
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
