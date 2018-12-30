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
import com.yilisha.dao.ServerWorkspaceDao;
import com.yilisha.model.Server;
import com.yilisha.model.ServerWorkspace;

public class ServerWorkspaceDaoImpl extends BaseDaoImpl<ServerWorkspace> implements ServerWorkspaceDao{
	public List<ServerWorkspace> getAllServerWorkplaceRecord() throws Exception {
		// TODO Auto-generated method stub
		Connection conn = com.yilisha.util.DBUtils.createConn();
		String sql = " select * from serverworkspace where 1=1 ";
		PreparedStatement ps = com.yilisha.util.DBUtils.getPs(conn, sql);
		ResultSet rs = ps.executeQuery();
		List<ServerWorkspace> serverWorkspaceList = new ArrayList<ServerWorkspace>();
		System.out.println("sql=" + sql);
		while(rs.next()){
			ServerWorkspace serverWorkspace = new ServerWorkspace();
			serverWorkspace.setServerWorkplaceID(rs.getInt("serverWorkplaceID"));
			serverWorkspace.setServerWorkplaceName(rs.getString("serverWorkplaceName"));
			serverWorkspace.setServerWorkplaceCoordinateX(rs.getDouble("serverWorkplaceCoordinateX"));
			serverWorkspace.setServerWorkplaceCoordinateY(rs.getDouble("serverWorkplaceCoordinateY"));
			serverWorkspace.setServerWorkplaceAddress(rs.getString("serverWorkplaceAddress"));
			serverWorkspaceList.add(serverWorkspace);
		}
		return serverWorkspaceList;
	}
	public List<ServerWorkspace> findByPagination(int currentPage, int pageSize,
			Map<String, Object> m) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = com.yilisha.util.DBUtils.createConn();
		String sql = " select * from serverworkspace  where 1=1 ";
		
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
		
		List<ServerWorkspace> serverWorkspaceList = new ArrayList<ServerWorkspace>();
		while(rs.next()){
			ServerWorkspace serverWorkspace = new ServerWorkspace();
			serverWorkspace.setServerWorkplaceID(rs.getInt("serverWorkplaceID"));
			serverWorkspace.setServerWorkplaceName(rs.getString("serverWorkplaceName"));
			serverWorkspace.setServerWorkplaceCoordinateX(rs.getDouble("serverWorkplaceCoordinateX"));
			serverWorkspace.setServerWorkplaceCoordinateY(rs.getDouble("serverWorkplaceCoordinateY"));
			serverWorkspace.setServerWorkplaceAddress(rs.getString("serverWorkplaceAddress"));
			serverWorkspaceList.add(serverWorkspace);
		}
		return serverWorkspaceList;
	}

	public int getTotal(Map<String, Object> m) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = com.yilisha.util.DBUtils.createConn();
		String sql = " select count(*) from serverworkspace  where 1=1 ";
		
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

	public List<ServerWorkspace> searchByName(String q) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = com.yilisha.util.DBUtils.createConn();
		String sql =" select * from serverworkspace where serverWorkplaceName like '%" + q + "%'" ;
		PreparedStatement ps = com.yilisha.util.DBUtils.getPs(conn, sql);
		ResultSet rs = ps.executeQuery();
		List<ServerWorkspace> serverWorkspaceList = new ArrayList<ServerWorkspace>();
		System.out.println("sql=" + sql);
		while(rs.next()){
			ServerWorkspace serverWorkspace = new ServerWorkspace();
			serverWorkspace.setServerWorkplaceID(rs.getInt("serverWorkplaceID"));
			serverWorkspace.setServerWorkplaceName(rs.getString("serverWorkplaceName"));
			serverWorkspace.setServerWorkplaceCoordinateX(rs.getDouble("serverWorkplaceCoordinateX"));
			serverWorkspace.setServerWorkplaceCoordinateY(rs.getDouble("serverWorkplaceCoordinateY"));
			serverWorkspace.setServerWorkplaceAddress(rs.getString("serverWorkplaceAddress"));
			serverWorkspaceList.add(serverWorkspace);
		}
		return serverWorkspaceList;
	}

}
