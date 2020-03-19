package org.member.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.member.model.MemberDTO;
import org.member.model.SMemberDAOImpl;

/**
 * Servlet implementation class MemberAdminDelete
 */
@WebServlet("/member/memAdminDelete.go")
public class MemberAdminDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberAdminDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userid=request.getParameter("userid");
		SMemberDAOImpl smdao = SMemberDAOImpl.getInstance();
		smdao.memDelete(userid);
		ArrayList<MemberDTO> arr =smdao.memList();
		JSONArray jarr=new JSONArray();
		for(MemberDTO mdto: arr) {
			JSONObject obj=new JSONObject();
			obj.put("name", mdto.getName());
			obj.put("userid", mdto.getUserid());
			obj.put("phone", mdto.getPhone());
			obj.put("email", mdto.getEmail());
			//���׿����ڸ� ����غ���!
			//String adminStr=mdto.getAdmin()==1?"������":"�Ϲ�ȸ��";
			String adminStr="";
			if(mdto.getAdmin()==1) {
				adminStr="������";
			}else{
				adminStr="�Ϲ�ȸ��";
			}
			obj.put("admin", adminStr);
			jarr.add(obj);
		}
		response.setContentType("test/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println(jarr.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
