package com.examAction;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdderServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int n1=Integer.parseInt(req.getParameter("num1"));
		int n2=Integer.parseInt(req.getParameter("num2"));
		int sum=n1+n2;
		//System.out.println("결과 : "+sum);
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		out.println("<html>");
			out.println("<head>");
				out.println("<title>"+"덧셈 프로그램"); 
				out.println("</title>");
			out.println("</head>");
			out.println("<body>");
				out.println("첫번째 수 : "+n1+"<br>");
				out.println("두번째 수 : "+n2+"<br>");
				out.println("<br><hr><br>");
				out.println("합계 : "+sum);
			out.println("</body>");
		out.println("</html>");
	}
}
