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

import com.yilisha.dao.ServerDao;
import com.yilisha.dao.impl.ServerDaoImpl;
import com.yilisha.model.Server;
import com.yilisha.model.User;

public class ServerServlet extends HttpServlet {
	private ServerDao serverDao = new ServerDaoImpl();
	/**
	 * Constructor of the object.
	 */
	public ServerServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String method = request.getParameter("method");
		if("getList".equals(method)){
			getList(request , response);
		}else if("getAllServerRecord".equals(method)){
			getAllServerRecord(request , response);
		}else if("getSelectServerNameRecord".equals(method)){
			getSelectServerNameRecord(request , response);
		}else if("getSelectServerTelRecord".equals(method)){
			getSelectServerTelRecord(request , response);
		}
	}
	private void getSelectServerTelRecord(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String serverTel = request.getParameter("select_serverInfo");
			List<Server> serverList = this.serverDao.searchByServerTel(serverTel);
			//int total = this.serverDao.getTotal(m);
			response.setContentType("text/html;charset=utf-8");
			//{"total":10 , "rows":[{},{}]}
			String json = "{\"rows\":"+JSONArray.fromObject(serverList).toString()+"}";
			response.getWriter().write(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void getSelectServerNameRecord(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String serverName = request.getParameter("select_serverInfo");
			List<Server> serverList = this.serverDao.searchByServerName(serverName);
			//int total = this.serverDao.getTotal(m);
			response.setContentType("text/html;charset=utf-8");
			//{"total":10 , "rows":[{},{}]}
			String json = "{\"rows\":"+JSONArray.fromObject(serverList).toString()+"}";
			response.getWriter().write(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void getAllServerRecord(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			
			List<Server> serverList = this.serverDao.getAllServerRecord();
			//int total = this.serverDao.getTotal(m);
			response.setContentType("text/html;charset=utf-8");
			//{"total":10 , "rows":[{},{}]}
			String json = "{\"rows\":"+JSONArray.fromObject(serverList).toString()+"}";
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
			
			List<Server> serverList = this.serverDao.findByPagination(currentPage , pageSize , m);
			int total = this.serverDao.getTotal(m);
			response.setContentType("text/html;charset=utf-8");
			//{"total":10 , "rows":[{},{}]}
			String json = "{\"total\":"+total+" , \"rows\":"+JSONArray.fromObject(serverList).toString()+"}";
			response.getWriter().write(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
