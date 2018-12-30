package com.yilisha.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.yilisha.base.BaseDaoImpl;
import com.yilisha.dao.ServiceContentDao;
import com.yilisha.model.ServiceContent;

public class ServiceContentDaoImpl extends BaseDaoImpl<ServiceContent> implements ServiceContentDao{

	public List<ServiceContent> findByPagination(int currentPage, int pageSize,
			Map<String, Object> m) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = com.yilisha.util.DBUtils.createConn();
		String sql = " select * from servicecontent where 1=1 ";
		
		Set<Entry<String, Object>> set = m.entrySet();
		Iterator io = set.iterator();
		while (io.hasNext()) {
			Map.Entry<String, Object> me = (Map.Entry<String, Object>) io.next();
			if("name".equals(me.getKey()) && !"".equals(me.getValue())){
				sql += " and " + me.getKey() + " like '%"+ me.getValue()  +"%'" ;
			}
			
			if("sort".equals(me.getKey()) && !"".equals(me.getValue())){
				sql += " order by " + me.getValue() ;
			}
			if("order".equals(me.getKey()) && !"".equals(me.getValue())){
				sql += " " + me.getValue();
			}			
		}
		sql = sql +" limit " + (currentPage-1)*pageSize +" , "  + pageSize ;
		PreparedStatement ps = com.yilisha.util.DBUtils.getPs(conn, sql);
		ResultSet rs = ps.executeQuery();
		
		List<ServiceContent> serviceContentList = new ArrayList<ServiceContent>();
		while(rs.next()){
			ServiceContent serviceContent = new ServiceContent();
			serviceContent.setOrderNumber(rs.getString("orderNumber"));
			serviceContent.setServerID(rs.getString("serverID"));
			serviceContent.setStartDate(rs.getString("startDate"));
			serviceContent.setStartTime(rs.getString("startTime"));
			serviceContent.setStopTime(rs.getString("stopTime"));
			serviceContent.setServiceId(rs.getInt("serviceId"));
			serviceContent.setServiceThing(rs.getString("serviceThing"));
			serviceContent.setUserID(rs.getString("userID"));
			serviceContentList.add(serviceContent);
		}
		return serviceContentList;
	}

	public int getTotal(Map<String, Object> m) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = com.yilisha.util.DBUtils.createConn();
		String sql = " select count(*) from servicecontent  where 1=1 ";
		
		Set<Entry<String, Object>> set = m.entrySet();
		Iterator io = set.iterator();
		while (io.hasNext()) {
			Map.Entry<String, Object> me = (Map.Entry<String, Object>) io.next();
			if("name".equals(me.getKey()) && !"".equals(me.getValue())){
				sql += " and " + me.getKey() + " like '%"+ me.getValue()  +"%'" ;
			}
			
			if("sort".equals(me.getKey()) && !"".equals(me.getValue())){
				sql += " order by " + me.getValue() ;
			}
			if("order".equals(me.getKey()) && !"".equals(me.getValue())){
				sql += " " + me.getValue();
			}			
		}		
		PreparedStatement ps = com.yilisha.util.DBUtils.getPs(conn, sql);
		ResultSet rs = ps.executeQuery();		
		int count = 0 ;
		if(rs.next()){
			
			count = rs.getInt(1);
		}
		return count;
	}

	public List<ServiceContent> searchByName(String q) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = com.yilisha.util.DBUtils.createConn();
		String sql =" select * from servicecontent where name like '%" + q + "%'" ;
		PreparedStatement ps = com.yilisha.util.DBUtils.getPs(conn, sql);
		ResultSet rs = ps.executeQuery();
		List<ServiceContent> serviceContentList = new ArrayList<ServiceContent>();
		System.out.println("sql=" + sql);
		while(rs.next()){
			ServiceContent serviceContent = new ServiceContent();
			serviceContent.setOrderNumber(rs.getString("orderNumber"));
			serviceContent.setServerID(rs.getString("serverID"));
			serviceContent.setStartDate(rs.getString("startDate"));
			serviceContent.setStartTime(rs.getString("startTime"));
			serviceContent.setStopTime(rs.getString("stopTime"));
			serviceContent.setServiceId(rs.getInt("serviceId"));
			serviceContent.setServiceThing(rs.getString("serviceThing"));
			serviceContent.setUserID(rs.getString("userID"));
			serviceContentList.add(serviceContent);
		}
		return serviceContentList;
	}

}
