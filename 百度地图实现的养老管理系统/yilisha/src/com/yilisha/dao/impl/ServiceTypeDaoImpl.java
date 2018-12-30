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
import com.yilisha.dao.ServiceTypeDao;
import com.yilisha.model.ServiceType;

public class ServiceTypeDaoImpl extends BaseDaoImpl<ServiceType> implements ServiceTypeDao{

	public List<ServiceType> findByPagination(int currentPage, int pageSize,
			Map<String, Object> m) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = com.yilisha.util.DBUtils.createConn();
		String sql = " select * from servertype  where 1=1 ";
		
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
		
		List<ServiceType> serviceTypeList = new ArrayList<ServiceType>();
		while(rs.next()){
			ServiceType serviceType = new ServiceType();
			serviceType.setServiceId(rs.getInt("serviceId"));
			serviceType.setServiceName(rs.getString("serviceName"));
			serviceType.setServicePrice(rs.getDouble("servicePrice"));
			serviceType.setServiceDuration(rs.getDouble("servicePrice"));
			serviceTypeList.add(serviceType);
		}
		return serviceTypeList;
	}

	public int getTotal(Map<String, Object> m) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = com.yilisha.util.DBUtils.createConn();
		String sql = " select count(*) from servertype  where 1=1 ";
		
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

	public List<ServiceType> searchByName(String q) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = com.yilisha.util.DBUtils.createConn();
		String sql =" select * from servertype where name like '%" + q + "%'" ;
		PreparedStatement ps = com.yilisha.util.DBUtils.getPs(conn, sql);
		ResultSet rs = ps.executeQuery();
		List<ServiceType> serviceTypeList = new ArrayList<ServiceType>();
		System.out.println("sql=" + sql);
		while(rs.next()){
			ServiceType serviceType = new ServiceType();
			serviceType.setServiceId(rs.getInt("serviceId"));
			serviceType.setServiceName(rs.getString("serviceName"));
			serviceType.setServicePrice(rs.getDouble("servicePrice"));
			serviceType.setServiceDuration(rs.getDouble("servicePrice"));
			serviceTypeList.add(serviceType);
		}
		return serviceTypeList;
	}

}
