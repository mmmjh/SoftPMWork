package com.sql.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sql.bean.OrderBean;
import com.sql.dao.OrderDao;
import com.sql.util.StringUtil;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderServlet() {
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
		if ("update".equals(method)) {// 修改订单信息
			update(request, response);
		} else if ("delete".equals(method)) {// 删除订单信息
			delete(request, response);
		} else if ("add".equals(method)) {// 添加订单
			add(request, response);
		} else if ("list".equals(method)) {// 查看全部订单信息
			listOrder(request, response);
		}
	}

	/**
	 * 添加订单信息
	 */
	private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(new Date().toString() + "\tOrderServlet.add()开始执行");

		req.setCharacterEncoding("utf-8");

		OrderDao orderDao = new OrderDao();

		int orderId = StringUtil.StringToInt(req.getParameter("orderId"));
		int staffId = StringUtil.StringToInt(req.getParameter("staffId"));
		float money = StringUtil.StringToFloat(req.getParameter("money"));
		String createDate = req.getParameter("createDate");
		String paytype = req.getParameter("paytype");
		int paytypee = 0;
		if ("信用卡".equals(paytype)) {
			paytypee = 1;
		} else if ("网上缴费".equals(paytype)) {
			paytypee = 2;
		}

		// 创建一个订单对象并且设置用户的各个属性
		OrderBean orderBean = new OrderBean();
		orderBean.setOrderId(orderId);
		orderBean.setStaffId(staffId);
		orderBean.setMoney(money);
		orderBean.setCreateDate(createDate);
		orderBean.setPaytype(paytypee);

		boolean flag = true;
		// 判断用户orderId是否存在
		flag = orderDao.checkId(orderId);

		if (flag) {// 添加成功
			orderDao.add(orderBean);
			System.out.println("开始添加");
			resp.sendRedirect("OrderServlet?method=list&status=2");
		}
		// 如果不存在
		else {
			resp.sendRedirect("addOrder.jsp?status=2");
		}
	}

	/**
	 * 删除一个订单，需要指定参数为订单的id
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(new Date().toString() + "\tOrderServlet.delete()开始执行！");
		request.setCharacterEncoding("UTF-8");
		int id = StringUtil.StringToInt(request.getParameter("id"));
		System.out.println(new Date().toString() + "\tid = " + id);
		// id 为1的作为超级管理员是不可以删除的
		
			OrderDao orderDao = new OrderDao();
			orderDao.delete(id);
			// 响应重定向查看用户列表，状态status=3表示删除指定id的用户成功
		
	}

	/**
	 * 更新订单信息
	 */
	private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(new Date().toString() + "\tOrderServlet.update()开始执行");

		req.setCharacterEncoding("utf-8");

		int id = StringUtil.StringToInt(req.getParameter("id"));
		
		OrderDao orderDao = new OrderDao();
		int orderId = StringUtil.StringToInt(req.getParameter("orderId"));
		int staffId = StringUtil.StringToInt(req.getParameter("staffId"));
		float money = StringUtil.StringToFloat(req.getParameter("money"));
		String createDate = req.getParameter("createDate");
		int paytype = StringUtil.StringToInt(req.getParameter("paytype"));
	/*	int paytypee = 0;
		if ("信用卡".equals(paytype)) {
			paytypee = 1;
		} else if ("网上缴费".equals(paytype)) {
			paytypee = 2;
		}*/
		System.out.println(id+"出错了！");

		// 创建一个订单对象并且设置用户的各个属性
		OrderBean orderBean = new OrderBean();
		orderBean.setOrderId(orderId);
		orderBean.setStaffId(staffId);
		orderBean.setMoney(money);
		orderBean.setCreateDate(createDate);
		orderBean.setPaytype(paytype);
		boolean flag = true;
		// 判断用户orderId是否存在
		flag = orderDao.checkId(id);
		if (!flag) {// 修改成功
		//	System.out.println("开始更新！");
			orderDao.update(id,orderBean);
			resp.sendRedirect("OrderServlet?method=list&status=2");
		}
	}

	/*
	 * 查看药品信息
	 */
	private void listOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub req.setCharacterEncoding("utf-8");

		OrderDao orderDao = new OrderDao();
		List<OrderBean> orderBeans = orderDao.getList();
		req.setAttribute("orderBeans", orderBeans);
		req.getRequestDispatcher("listOrder.jsp").forward(req, resp);
	}
}
