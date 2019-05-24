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

import com.sql.bean.MedicineBean;
import com.sql.bean.StaffBean;
import com.sql.dao.MedicineDao;
import com.sql.dao.StaffDao;
import com.sql.util.StringUtil;

/**
 * Servlet implementation class MedicineServlet
 */
@WebServlet("/MedicineServlet")
public class MedicineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MedicineServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		/*
		 * 每一个调用次 Servlet 的地方都需要传递一个method参数用来指明所要经进行的操作
		 */
		String method = request.getParameter("method");
		HttpSession session = request.getSession();
		// 根据method的值调用不同的方法执行不同的操作
		if ("update".equals(method)) {// 修改药品信息
			update(request, response);
		} else if ("delete".equals(method)) {// 删除药品信息
			delete(request, response);
		} else if ("add".equals(method)) {// 添加药品
			add(request, response);
		} else if ("list".equals(method)) {// 查看全部药品信息
			listMedicine(request, response);
		}
	}

	/**
	 * 删除一个药品，需要指定参数为药品的id
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(new Date().toString() + "\tMedicineServlet.delete()开始执行！");
		request.setCharacterEncoding("UTF-8");
		int id = StringUtil.StringToInt(request.getParameter("id"));
		System.out.println(new Date().toString() + "\tid = " + id);
		// id 为1的作为超级管理员是不可以删除的
		if (id > 1) {
			MedicineDao medicineDao = new MedicineDao();
			medicineDao.delete(id);
			// 响应重定向查看用户列表，状态status=3表示删除指定id的用户成功
			response.sendRedirect(request.getContextPath() + "/MedicineServlet?method=list&status=3");
		} else if (id == 1) {
			// 响应重定向显示用户列表，status=1表示没有操作权限
			response.sendRedirect(request.getContextPath() + "/MedicineServlet?method=list&status=1");
		} else {
			// 操作失败
			response.sendRedirect(request.getContextPath() + "/MedicineServlet?method=list&status=2");
		}
	}

	/**
	 * 添加药品信息
	 */
	private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(new Date().toString() + "\tMedicineServlet.add()开始执行");

		req.setCharacterEncoding("utf-8");

		MedicineDao medicineDao = new MedicineDao();

		String medicineName = req.getParameter("medicineName");
		int medicineId = StringUtil.StringToInt(req.getParameter("medicineId"));
		int type = StringUtil.StringToInt(req.getParameter("type"));
		int typee = 1;
		if ("中药".equals(type)) {
			typee = 0;
		}
		int inventory = StringUtil.StringToInt(req.getParameter("inventory"));
		String producer = req.getParameter("producer");
		float purchasingPrice = StringUtil.StringToFloat(req.getParameter("purchasingPrice"));
		float sellingPrice = StringUtil.StringToFloat(req.getParameter("sellingPrice"));

		// 创建一个药品对象并且设置用户的各个属性
		MedicineBean medicineBean = new MedicineBean();
		medicineBean.setMedicineName(medicineName);
		medicineBean.setMedicineId(medicineId);
		medicineBean.setType(typee);
		medicineBean.setInventory(inventory);
		medicineBean.setProducer(producer);
		medicineBean.setPurchasingPrice(purchasingPrice);
		medicineBean.setSellingPrice(sellingPrice);

		boolean flag = true;
		// 判断MedicineId是否存在
		flag = medicineDao.checkId(medicineId);

		if (flag) {// 添加成功
			medicineDao.add(medicineBean);
			resp.sendRedirect("MedicineServlet?method=list&status=2");
		}
		// 如果不存在
		else {
			resp.sendRedirect("addMedicine.jsp?status=2");
		}
	}

	/**
	 * 更新药品信息
	 */
	private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(new Date().toString() + "\tMedicineServlet.update()开始执行");

		req.setCharacterEncoding("utf-8");

		int id = StringUtil.StringToInt(req.getParameter("id"));
		MedicineDao medicineDao = new MedicineDao();
		System.out.println(id+"更新号");
		String medicineName = req.getParameter("medicinename");
		int medicineId = StringUtil.StringToInt(req.getParameter("medicineid"));
		String type = req.getParameter("medicinetype");
		int typee = 1;
		if ("中药".equals(type)) {
			typee = 0;
		}
		int inventory = StringUtil.StringToInt(req.getParameter("inventory"));
		String producer = req.getParameter("producer");
		float purchasingPrice = StringUtil.StringToFloat(req.getParameter("purchasingprice"));
		float sellingPrice = StringUtil.StringToFloat(req.getParameter("sellingprice"));

		// 创建一个药品对象并且设置用户的各个属性
		MedicineBean medicineBean = new MedicineBean();
		medicineBean.setMedicineName(medicineName);
		medicineBean.setMedicineId(medicineId);
		medicineBean.setType(typee);
		medicineBean.setInventory(inventory);
		medicineBean.setProducer(producer);
		medicineBean.setPurchasingPrice(purchasingPrice);
		medicineBean.setSellingPrice(sellingPrice);

		boolean flag = true;
		// 判断用户MedicineId是否存在
		flag = medicineDao.checkId(id);

		if (!flag) {// 修改成功
			System.out.println("开始更新");
			medicineDao.update(id,medicineBean);
			System.out.println("完成更新");
			resp.sendRedirect("MedicineServlet?method=list&status=2");
		}
	}

	/*
	 * 查看药品信息
	 */
	private void listMedicine(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub req.setCharacterEncoding("utf-8");

		MedicineDao medicineDao = new MedicineDao();
		List<MedicineBean> medicineBeans = medicineDao.getList();
		req.setAttribute("medicineBeans", medicineBeans);
		req.getRequestDispatcher("listMedicine.jsp").forward(req, resp);
	}
}
