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

public class ZestServlet extends HttpServlet {
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
		}
	}
	private void getList(HttpServletRequest request,
			HttpServletResponse response) {
		try {				
			String username = request.getParameter("name") == null?"":request.getParameter("name");
			String order     = request.getParameter("order")== null?"":request.getParameter("order");		
			String sort     = request.getParameter("sort")== null?"":request.getParameter("sort");			
			
			Map<String, Object> m = new HashMap<String, Object>();
			m.put("name", username);
			
			m.put("order", order);
			m.put("sort", sort);
			
//			List<Departments> ulist = this.udao.findByPagination(currentPage , pageSize , m);
//			int total = this.udao.getTotal(m);
			response.setContentType("text/html;charset=utf-8");
			//{"total":10 , "rows":[{},{}]}
			//String json = "{\"total\":"+total+" , \"rows\":"+JSONArray.fromObject(ulist).toString()+"}";
			//response.getWriter().write(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
