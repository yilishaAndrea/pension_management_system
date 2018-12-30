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

import com.yilisha.dao.ServerWorkspaceDao;
import com.yilisha.dao.impl.ServerWorkspaceDaoImpl;
import com.yilisha.model.Server;
import com.yilisha.model.ServerWorkspace;

public class ServerWorkspaceServlet extends HttpServlet {
	private ServerWorkspaceDao serverWorkspaceDao = new ServerWorkspaceDaoImpl();
	/**
	 * Constructor of the object.
	 */
	public ServerWorkspaceServlet() {
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
		}else if("getAllServerWorkplaceRecord".equals(method)){
			getAllServerWorkplaceRecord(request , response);
		}else if("getSelectServerWaorkplaceNameRecord".equals(method)){
			getSelectServerWaorkplaceNameRecord(request , response);
		}
	}
	private void getSelectServerWaorkplaceNameRecord(HttpServletRequest request,
			HttpServletResponse response){
		try {
			String serverWorkplaceName = request.getParameter("select_placeInfo");
			List<ServerWorkspace> serverWorkspaceList = this.serverWorkspaceDao.searchByName(serverWorkplaceName);
			//int total = this.serverDao.getTotal(m);
			response.setContentType("text/html;charset=utf-8");
			//{"total":10 , "rows":[{},{}]}
			String json = "{\"rows\":"+JSONArray.fromObject(serverWorkspaceList).toString()+"}";
			response.getWriter().write(json);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	private void getAllServerWorkplaceRecord(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			
			List<ServerWorkspace> serverWorkspaceList = this.serverWorkspaceDao.getAllServerWorkplaceRecord();
			//int total = this.serverDao.getTotal(m);
			response.setContentType("text/html;charset=utf-8");
			//{"total":10 , "rows":[{},{}]}
			String json = "{\"rows\":"+JSONArray.fromObject(serverWorkspaceList).toString()+"}";
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
			
			List<ServerWorkspace> serverWorkspaceList = this.serverWorkspaceDao.findByPagination(currentPage , pageSize , m);
			int total = this.serverWorkspaceDao.getTotal(m);
			response.setContentType("text/html;charset=utf-8");
			//{"total":10 , "rows":[{},{}]}
			String json = "{\"total\":"+total+" , \"rows\":"+JSONArray.fromObject(serverWorkspaceList).toString()+"}";
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
