package com.test.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String data="servlet에서 저장한 데이터";
		req.setAttribute("data", data);
		RequestDispatcher rd=req.getRequestDispatcher("result.jsp");
		rd.forward(req, resp);
	}
}
