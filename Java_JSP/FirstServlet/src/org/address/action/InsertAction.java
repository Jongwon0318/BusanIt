package org.address.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.address.AddressDTO;
import org.address.SAddressDAO;

/**
 * Servlet implementation class InsertAction
 */
@WebServlet("/address/insert.do") //중요!!!
public class InsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertAction() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		String zipcode=request.getParameter("zip");
		String addr=request.getParameter("addr");
		String tel=request.getParameter("tel");
		
		AddressDTO adto=new AddressDTO();
		adto.setName(name);
		adto.setZipcode(zipcode);
		adto.setAddr(addr);
		adto.setTel(tel);
	
//		예전에 하던 방식으로 addrInsertPro.jsp로 값을 보내서 스크립트릿 안에 SAddressDAO.java의 메소드를 불러오는 방식.
//		request.setAttribute("adto", adto);
//		RequestDispatcher rd=request.getRequestDispatcher("../address/addrInsertPro.jsp");
//		rd.forward(request, response);
		
		SAddressDAO sadao=SAddressDAO.getInstance();
		sadao.addrInsert(adto);
		response.sendRedirect("list.do");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
