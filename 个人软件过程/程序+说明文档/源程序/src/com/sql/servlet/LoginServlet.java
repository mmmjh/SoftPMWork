package com.sql.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.sql.bean.UserBean;
import com.sql.dao.UserDao;
import com.sql.dao.UserDao;
import com.sql.util.StringUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		/*
		 * 每一个调用次 Servlet 的地方都需要传递一个method参数用来指明所要经进行的操作
		 */
		String method = request.getParameter("method");
		HttpSession session = request.getSession();
		// 根据method的值调用不同的方法执行不同的操作
		if ("doGet".equals(method)) {// 修改个人信息
			doGet(request, response);
		}
	}

	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("查找开始执行");

		req.setCharacterEncoding("utf-8");

		//int id = StringUtil.StringToInt(req.getParameter("id"));
		String username = req.getParameter("username");
		System.out.println(username);
		HttpSession session1 = req.getSession();//设置session对象
		session1.setAttribute("name", username);
		String password = req.getParameter("password");
		String yanzhengma = req.getParameter("yanzhengma");
		HttpSession session = req.getSession();//设置session对象
		String randc = (String)session.getAttribute("rand");
        
		if(randc!=null&&!randc.equals(yanzhengma))
		{
			req.setAttribute("loginError", "验证码错误");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
		UserDao userdao=new UserDao();
		int flag = 1;
		// 判断用户是否存在以及密码是否正确
	
		try {
			flag = userdao.checkuser(username,password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(flag<=0)
		{
			req.setAttribute("loginError", "用户不存在！请先注册！");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
		 if(flag==1)
			{resp.sendRedirect("main.jsp?status=2");}
		if(flag==2)
		{
			req.setAttribute("loginError", "密码不正确！");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
