package com.yilisha.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.yilisha.dao.UserDao;
import com.yilisha.dao.impl.UserDaoImpl;
import com.yilisha.model.User;

public class UserServlet extends HttpServlet {
	private UserDao userdao = new UserDaoImpl();
	public UserServlet() {
		super();
	}
	public void destroy() {
		super.destroy(); 
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String method = request.getParameter("method");
		if("getList".equals(method)){
			getList(request , response);
		}else if("getAllUserRecord".equals(method)){
			getAllUserRecord(request , response);
		}else if("getSelectUserNameRecord".equals(method)){
			getSelectUserNameRecord(request , response);
		}else if("getSelectUserTelRecord".equals(method)){
			getSelectUserTelRecord(request , response);
		}else if("getSelectUserAddressRecord".equals(method)){
			getSelectUserAddressRecord(request , response);
		}
	}
	private void getSelectUserAddressRecord(HttpServletRequest request,
			HttpServletResponse response) {
		try {	
			String userAddress = request.getParameter("select_userInfo");
			List<User> userlist = this.userdao.searchByUserAdress(userAddress);
			//int total = this.userdao.getTotal(m);
			response.setContentType("text/html;charset=utf-8");
			//{"total":10 , "rows":[{},{}]}
			String json = "{\"rows\":"+JSONArray.fromObject(userlist).toString()+"}";
			response.getWriter().write(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void getSelectUserTelRecord(HttpServletRequest request,
			HttpServletResponse response) {
		try {	
			String userTel = request.getParameter("select_userInfo");
			List<User> userlist = this.userdao.searchByUserTel(userTel);
			//int total = this.userdao.getTotal(m);
			response.setContentType("text/html;charset=utf-8");
			//{"total":10 , "rows":[{},{}]}
			String json = "{\"rows\":"+JSONArray.fromObject(userlist).toString()+"}";
			response.getWriter().write(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void getSelectUserNameRecord(HttpServletRequest request,
			HttpServletResponse response) {
		try {	
			String userName = request.getParameter("select_userInfo");
			List<User> userlist = this.userdao.searchByUserName(userName);
			//int total = this.userdao.getTotal(m);
			response.setContentType("text/html;charset=utf-8");
			//{"total":10 , "rows":[{},{}]}
			String json = "{\"rows\":"+JSONArray.fromObject(userlist).toString()+"}";
			response.getWriter().write(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void getAllUserRecord(HttpServletRequest request,
			HttpServletResponse response) {
		try {			
			List<User> userlist = this.userdao.getAllUserRecord();
			response.setContentType("text/html;charset=utf-8");
			String json = "{\"rows\":"+JSONArray.fromObject(userlist).toString()+"}";
			response.getWriter().write(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void getList(HttpServletRequest request,
			HttpServletResponse response){
		try {
			
			System.out.println("getList............");
			int currentPage = Integer.parseInt(request.getParameter("page") == null ? "1" : request.getParameter("page"));
			int pageSize    = Integer.parseInt(request.getParameter("rows") == null ? "10" : request.getParameter("rows"));
			
			String username = request.getParameter("name") == null?"":request.getParameter("name");
			String order     = request.getParameter("order")== null?"":request.getParameter("order");		
			String sort     = request.getParameter("sort")== null?"":request.getParameter("sort");			
			
			Map<String, Object> m = new HashMap<String, Object>();
			m.put("name", username);
			m.put("order", order);
			m.put("sort", sort);
			
			List<User> userlist = this.userdao.findByPagination(currentPage , pageSize , m);
			int total = this.userdao.getTotal(m);
			response.setContentType("text/html;charset=utf-8");
			//{"total":10 , "rows":[{},{}]}
			String json = "{\"total\":"+total+" , \"rows\":"+JSONArray.fromObject(userlist).toString()+"}";
			response.getWriter().write(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
