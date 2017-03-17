package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/LoginServlet")
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String codes = req.getSession().getAttribute("codes").toString();
		String mycode = req.getParameter("checkcode");
		resp.setCharacterEncoding("utf-8");
		
		PrintWriter out = resp.getWriter();
		if(mycode.toUpperCase().equals(codes)){
			out.println("验证码输入正确！");
		}else{
			out.println("验证码输入错误！");
		}
		out.flush();
		out.close();
	}

}
