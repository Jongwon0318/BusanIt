package com.examAction;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BbsServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");		
		String name=req.getParameter("name");
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw=resp.getWriter();
		pw.println("<html>");
			pw.println("<head>");pw.println("<title>"+"BbsServlet");pw.println("</title>");pw.println("</head>");
			pw.println("<body>");
				pw.println("이름 : "+name+"<br>");
				pw.println("제목 : "+title+"<br><br><hr><br>");
				pw.println("내용 : "+content);
			pw.println("</body>");
		pw.println("</html>");
	}
}
