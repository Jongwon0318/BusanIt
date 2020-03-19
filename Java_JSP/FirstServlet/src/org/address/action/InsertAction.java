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
@WebServlet("/address/insert.do") //�߿�!!!
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
	
//		������ �ϴ� ������� addrInsertPro.jsp�� ���� ������ ��ũ��Ʈ�� �ȿ� SAddressDAO.java�� �޼ҵ带 �ҷ����� ���.
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
