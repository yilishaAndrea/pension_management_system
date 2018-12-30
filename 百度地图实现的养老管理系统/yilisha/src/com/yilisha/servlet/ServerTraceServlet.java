package com.yilisha.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsDateJsonValueProcessor;

import com.yilisha.dao.ServerTraceDao;
import com.yilisha.dao.impl.ServerTraceDaoImpl;
import com.yilisha.model.Server;
import com.yilisha.model.ServerTrace;

public class ServerTraceServlet extends HttpServlet {
	private ServerTraceDao serverTraceDao = new ServerTraceDaoImpl();
	/**
	 * Constructor of the object.
	 */
	public ServerTraceServlet() {
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
		}else if("getSelectServerTraceRecord".equals(method)){
			getSelectServerTraceRecord(request , response);
		}
	}
	
	private void getSelectServerTraceRecord(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			String serverID = request.getParameter("select_serverID");
			List<ServerTrace> serverTraceList = this.serverTraceDao.searchByServerID(serverID);
			//int total = this.serverDao.getTotal(m);
			response.setContentType("text/html;charset=utf-8");
			//{"total":10 , "rows":[{},{}]}
			//String json = "{\"rows\":"+JSONArray.fromObject(serverTraceList).toString()+"}";
			//response.getWriter().write(json);
			JsonConfig jsonConfig = new JsonConfig();
	        jsonConfig.registerJsonValueProcessor(Date.class , new JsDateJsonValueProcessor());
			String json = "{\"rows\":"+JSONArray.fromObject(serverTraceList,jsonConfig).toString()+"}";
			response.getWriter().write(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getList(HttpServletRequest request,
			HttpServletResponse response) {
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
			
			List<ServerTrace> serverTraceList = this.serverTraceDao.findByPagination(currentPage , pageSize , m);
			int total = this.serverTraceDao.getTotal(m);
			response.setContentType("text/html;charset=utf-8");
			//{"total":10 , "rows":[{},{}]}
			String json = "{\"total\":"+total+" , \"rows\":"+JSONArray.fromObject(serverTraceList).toString()+"}";
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
