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
import com.yilisha.dao.ServiceCostDao;
import com.yilisha.model.ServiceCost;

public class ServiceCostDaoImpl extends BaseDaoImpl<ServiceCost> implements ServiceCostDao{

	public List<ServiceCost> findByPagination(int currentPage, int pageSize,
			Map<String, Object> m) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = com.yilisha.util.DBUtils.createConn();
		String sql = " select * from servercost  where 1=1 ";
		
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
		
		List<ServiceCost> serviceContentList = new ArrayList<ServiceCost>();
		while(rs.next()){
			ServiceCost serviceCost = new ServiceCost();
			serviceCost.setServiceCostId(rs.getString("serviceCostId"));
			serviceCost.setServerId(rs.getString("serverId"));
			serviceCost.setServiceTime(rs.getDouble("serviceTime"));
			serviceCost.setServiceCost(rs.getDouble("serviceCost"));
			serviceContentList.add(serviceCost);
		}
		return serviceContentList;
	}

	public int getTotal(Map<String, Object> m) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = com.yilisha.util.DBUtils.createConn();
		String sql = " select count(*) from servercost  where 1=1 ";
		
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

	public List<ServiceCost> searchByName(String q) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = com.yilisha.util.DBUtils.createConn();
		String sql =" select * from servercost where name like '%" + q + "%'" ;
		PreparedStatement ps = com.yilisha.util.DBUtils.getPs(conn, sql);
		ResultSet rs = ps.executeQuery();
		List<ServiceCost> serviceContentList = new ArrayList<ServiceCost>();
		System.out.println("sql=" + sql);
		while(rs.next()){
			ServiceCost serviceCost = new ServiceCost();
			serviceCost.setServiceCostId(rs.getString("serviceCostId"));
			serviceCost.setServerId(rs.getString("serverId"));
			serviceCost.setServiceTime(rs.getDouble("serviceTime"));
			serviceCost.setServiceCost(rs.getDouble("serviceCost"));
			serviceContentList.add(serviceCost);
		}
		return serviceContentList;
	}

}
