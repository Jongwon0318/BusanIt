package org.address.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.address.SAddressDAO;
import org.address.ZipcodeDTO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class ZipAction
 */
@WebServlet("/address/zip.do")
public class ZipAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZipAction() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher("zipCheck.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String dong=request.getParameter("dong");
		SAddressDAO sdao=SAddressDAO.getInstance();
		ArrayList<ZipcodeDTO> arr= sdao.zipSearch(dong);
		JSONArray jarr=new JSONArray();
		for(ZipcodeDTO zdto : arr) {
			JSONObject obj=new JSONObject();
			obj.put("zipcode", zdto.getZipcode());
			obj.put("sido",zdto.getSido());
			obj.put("gugun", zdto.getGugun());
			obj.put("dong", zdto.getDong());
			obj.put("bunji", zdto.getBunji());
			jarr.add(obj);
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(jarr.toString());
	}

}
