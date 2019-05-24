package com.sql.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import com.sql.util.Pager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sql.util.Constants;
import com.sql.bean.StaffBean;
import com.sql.dao.StaffDao;
import com.sql.util.StringUtil;

/**
 * Servlet implementation class StaffServlet
 */
@WebServlet("/StaffServlet")
public class StaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StaffServlet() {
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
		if ("update".equals(method)) {// 修改个人信息
			update(request, response);
		} else if ("delete".equals(method)) {// 删除个人信息
			delete(request, response);
		} else if ("add".equals(method)) {// 添加员工
			add(request, response);
		} else if ("list".equals(method)) {// 查看全部员工信息
			listStaff(request, response);
		}
		
			
	}

	/**
	 * 删除一个用户，需要指定参数为用户的id
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	System.out.println(new Date().toString() + "\tStaffServlet.delete()开始执行！");
		request.setCharacterEncoding("UTF-8");
		int id = StringUtil.StringToInt(request.getParameter("id"));
		//System.out.println(new Date().toString() + "\tid = " + id);
		// id 为1的作为超级管理员是不可以删除的
		if (id > 1) {
			StaffDao staffDao = new StaffDao();
			staffDao.delete(id);
			// 响应重定向查看用户列表，状态status=3表示删除指定id的用户成功
			response.sendRedirect(request.getContextPath() + "/StaffServlet?method=list");
		} else if (id == 1) {
			// 响应重定向显示用户列表，status=1表示没有操作权限
			response.sendRedirect(request.getContextPath() + "/StaffServlet?method=list");
		} else {
			// 操作失败
			response.sendRedirect(request.getContextPath() + "/StaffServlet?method=list");
		}
	}

	/**
	 * 添加用户信息
	 */
	private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println(new Date().toString() + "\tStaffServlet.add()开始执行");

		req.setCharacterEncoding("utf-8");

		StaffDao staffDao = new StaffDao();

		String staffName = req.getParameter("staffName");
		int staffId = StringUtil.StringToInt(req.getParameter("staffId"));
		String sex = req.getParameter("sex");
	
		int age = StringUtil.StringToInt(req.getParameter("age"));
		String call = req.getParameter("call");
		String duty = req.getParameter("duty");
		/*int dutyy = 1;
		if ("经理".equals(duty)) {
			dutyy = 0;
		}*/
		float workingAge = StringUtil.StringToFloat(req.getParameter("workingAge"));

		// 创建一个用户对象并且设置用户的各个属性
		StaffBean staffBean = new StaffBean();
		staffBean.setStaffName(staffName);
		staffBean.setStaffId(staffId);
		staffBean.setSex(sex);
		staffBean.setAge(age);
		staffBean.setDuty(duty);
		staffBean.setCall(call);
		staffBean.setWorkingAge(workingAge);

		boolean flag = true;
		// 判断用户staffId是否存在
		flag = staffDao.checkStaffId(staffId);

		if (flag) {// 添加成功
			staffDao.add(staffBean);
			resp.sendRedirect("StaffServlet?method=list");
		}
		// 如果不存在
		else {
			resp.sendRedirect("addUser.jsp");
		}
	}

	/**
	 * 更新用户信息
	 */
	private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println(new Date().toString() + "\tStaffServlet.update()开始执行");

		req.setCharacterEncoding("utf-8");

		int id = StringUtil.StringToInt(req.getParameter("id"));
		StaffDao staffDao = new StaffDao();
		StaffBean staff=new StaffBean();
		staff=staffDao.checkReg(id);
		String staffName = req.getParameter("staffName");
		int staffId = StringUtil.StringToInt(req.getParameter("staffId"));
		String sex = req.getParameter("sex");
		int age = StringUtil.StringToInt(req.getParameter("age"));
		String call = req.getParameter("call");
		String duty = req.getParameter("duty");
		
		String nation = req.getParameter("nation");
		String born = req.getParameter("born");
		String edu = req.getParameter("edu");
		String major = req.getParameter("major");
		String province3 = req.getParameter("province3");
		String city3 = req.getParameter("city3");
		String district3 = req.getParameter("district3");
		System.out.println(city3);
		String loca=province3+","+city3+","+district3+"";
		String degree1 = req.getParameter("degree1");
		String pict = req.getParameter("cover");
		if(pict.equals("")||pict==null)
			pict=staff.getPict();
		System.out.println(pict+"图片");
		String email = req.getParameter("email");
		
	/*	int dutyy = 1;
		if ("经理".equals(duty)) {
			dutyy = 0;
		}*/
		float workingAge = StringUtil.StringToFloat(req.getParameter("workingAge"));

		// 创建一个用户对象并且设置用户的各个属性
		StaffBean staffBean = new StaffBean();
		staffBean.setStaffName(staffName);
		staffBean.setStaffId(staffId);
		staffBean.setSex(sex);
		staffBean.setAge(age);
		staffBean.setDuty(duty);
		staffBean.setCall(call);
		staffBean.setWorkingAge(workingAge);
		//System.out.println("88888======" + staffBean.getWorkingAge());
		
		staffBean.setNation(nation);
		staffBean.setBorn(born);
		staffBean.setEdu(edu);
		staffBean.setDegree1(degree1);
		staffBean.setMajor(major);
		staffBean.setEmail(email);
		staffBean.setLoca(loca);
		staffBean.setPict(pict);

		staffDao.update(id, staffBean);
		resp.sendRedirect("StaffServlet?method=list");
	}

	/*
	 * 查看员工信息
	 */
	private void listStaff(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub req.setCharacterEncoding("utf-8");

		StaffDao staffDao = new StaffDao();
		// int currentPage =
		// StringUtil.StringToInt(req.getParameter("currentPage"));
		// int countSize = adminDao.getCount();
		// PagingBean pagingBean = new PagingBean(countSize, currentPage,
		// Constants.PAGE_SIZE_1);
		List<StaffBean> staffBeans = staffDao.getList();
		// pagingBean.setPrefixUrl(req.getContextPath() +
		// "/admin/adminServlet?method=list");
		// pagingBean.setAnd(true);
		req.setAttribute("staffBeans", staffBeans);
		// req.setAttribute("pagingBean", pagingBean);
		req.getRequestDispatcher("listStaff.jsp").forward(req, resp);
	}
	 
	 
	
	
	
	
}
