package com.guestbook.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guestbook.model.GuestDAO;
import com.guestbook.model.GuestDTO;

/**
 * Servlet implementation class GuestList
 */
@WebServlet("/guestbook/list.gb")
public class GuestList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//int pageNum=Integer.parseInt(request.getParameter("pageNum"));
		GuestDAO gdao=GuestDAO.getInstance();
		ArrayList<GuestDTO> arr=gdao.guestList();
		request.setAttribute("lists", arr); 
		int count = gdao.guestCount(); //게시물 수
		request.setAttribute("count", count);
		response.setCharacterEncoding("utf-8");
		RequestDispatcher rd=request.getRequestDispatcher("listResult.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
