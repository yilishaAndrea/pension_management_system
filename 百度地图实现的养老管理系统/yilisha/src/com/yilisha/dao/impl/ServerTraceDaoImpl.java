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
import com.yilisha.dao.ServerTraceDao;
import com.yilisha.model.ServerTrace;

public class ServerTraceDaoImpl extends BaseDaoImpl<ServerTrace> implements ServerTraceDao{
	public List<ServerTrace> searchByServerID(String q) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = com.yilisha.util.DBUtils.createConn();
		String sql =" select * from servertrace where serverID like '%" + q + "%'" ;
		PreparedStatement ps = com.yilisha.util.DBUtils.getPs(conn, sql);
		ResultSet rs = ps.executeQuery();
		List<ServerTrace> serverTraceList = new ArrayList<ServerTrace>();
		System.out.println("sql=" + sql);
		while(rs.next()){
			ServerTrace serverTrace = new ServerTrace();
			serverTrace.setID(rs.getInt("ID"));
			serverTrace.setServerID(rs.getString("serverID"));
			//ps.setDate(3, new java.sql.Date(obj.getFinishTime().getTime()));	
			serverTrace.setDate(rs.getDate("date"));
			serverTrace.setTime(rs.getTime("time"));
			serverTrace.setServerCoordinateX(rs.getDouble("serverCoordinateX"));
			serverTrace.setServerCoordinateY(rs.getDouble("serverCoordinateY"));
			serverTraceList.add(serverTrace);
		}
		return serverTraceList;
	}
	public List<ServerTrace> findByPagination(int currentPage, int pageSize,
			Map<String, Object> m) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = com.yilisha.util.DBUtils.createConn();
		String sql = " select * from servertrace  where 1=1 ";
		
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
		
		List<ServerTrace> serverTraceList = new ArrayList<ServerTrace>();
		while(rs.next()){
			ServerTrace serverTrace = new ServerTrace();
			serverTrace.setID(rs.getInt("ID"));
			serverTrace.setServerID(rs.getString("serverID"));
			serverTrace.setDate(rs.getDate("date"));
			serverTrace.setTime(rs.getTime("time"));
			serverTrace.setServerCoordinateX(rs.getDouble("serverCoordinateX"));
			serverTrace.setServerCoordinateY(rs.getDouble("serverCoordinateY"));
			serverTraceList.add(serverTrace);
		}
		return serverTraceList;
	}

	public int getTotal(Map<String, Object> m) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = com.yilisha.util.DBUtils.createConn();
		String sql = " select count(*) from servertrace  where 1=1 ";
		
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

	public List<ServerTrace> searchByName(String q) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = com.yilisha.util.DBUtils.createConn();
		String sql =" select * from servertrace where name like '%" + q + "%'" ;
		PreparedStatement ps = com.yilisha.util.DBUtils.getPs(conn, sql);
		ResultSet rs = ps.executeQuery();
		List<ServerTrace> serverTraceList = new ArrayList<ServerTrace>();
		System.out.println("sql=" + sql);
		while(rs.next()){
			ServerTrace serverTrace = new ServerTrace();
			serverTrace.setID(rs.getInt("ID"));
			serverTrace.setServerID(rs.getString("serverID"));
			serverTrace.setDate(rs.getDate("date"));
			serverTrace.setTime(rs.getTime("time"));
			serverTrace.setServerCoordinateX(rs.getDouble("serverCoordinateX"));
			serverTrace.setServerCoordinateY(rs.getDouble("serverCoordinateY"));
			serverTraceList.add(serverTrace);
		}
		return serverTraceList;
	}

	

}
