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
import com.yilisha.dao.ServerDao;
import com.yilisha.model.FamilyMember;
import com.yilisha.model.Server;
import com.yilisha.model.User;

public class ServerDaoImpl extends BaseDaoImpl<Server> implements ServerDao{
	
	public List<Server> getAllServerRecord() throws Exception {
		// TODO Auto-generated method stub
		Connection conn = com.yilisha.util.DBUtils.createConn();
		String sql = " select * from server where 1=1 ";
		PreparedStatement ps = com.yilisha.util.DBUtils.getPs(conn, sql);
		ResultSet rs = ps.executeQuery();
		List<Server> serverList = new ArrayList<Server>();
		System.out.println("sql=" + sql);
		while(rs.next()){
			Server server = new Server();
			server.setServerID(rs.getString("serverID"));
			server.setServerName(rs.getString("serverName"));
			server.setServerWorkplaceID(rs.getInt("serverWorkplaceID"));
			server.setServerTel(rs.getString("serverTel"));
			server.setServerCoordinateX(rs.getDouble("serverCoordinateX"));
			server.setServerCoordinateY(rs.getDouble("serverCoordinateY"));
			server.setServerStatus(rs.getInt("serverStatus"));
			serverList.add(server);
		}
		return serverList;
	}
	public List<Server> findByPagination(int currentPage, int pageSize,
			Map<String, Object> m) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = com.yilisha.util.DBUtils.createConn();
		String sql = " select * from server  where 1=1 ";
		
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
		
		List<Server> serverList = new ArrayList<Server>();
		while(rs.next()){
			Server server = new Server();
			server.setServerID(rs.getString("serverID"));
			server.setServerName(rs.getString("serverName"));
			server.setServerWorkplaceID(rs.getInt("serverWorkplaceID"));
			server.setServerTel(rs.getString("serverTel"));
			server.setServerCoordinateX(rs.getDouble("serverCoordinateX"));
			server.setServerCoordinateY(rs.getDouble("serverCoordinateY"));
			server.setServerStatus(rs.getInt("serverStatus"));
			serverList.add(server);
		}
		return serverList;
	}

	public int getTotal(Map<String, Object> m) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = com.yilisha.util.DBUtils.createConn();
		String sql = " select count(*) from server  where 1=1 ";
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

	public List<Server> searchByServerName(String q) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = com.yilisha.util.DBUtils.createConn();
		String sql =" select * from server where serverName like '%" + q + "%'" ;
		PreparedStatement ps = com.yilisha.util.DBUtils.getPs(conn, sql);
		ResultSet rs = ps.executeQuery();
		List<Server> serverList = new ArrayList<Server>();
		System.out.println("sql=" + sql);
		while(rs.next()){
			Server server = new Server();
			server.setServerID(rs.getString("serverID"));
			server.setServerName(rs.getString("serverName"));
			server.setServerWorkplaceID(rs.getInt("serverWorkplaceID"));
			server.setServerTel(rs.getString("serverTel"));
			server.setServerCoordinateX(rs.getDouble("serverCoordinateX"));
			server.setServerCoordinateY(rs.getDouble("serverCoordinateY"));
			server.setServerStatus(rs.getInt("serverStatus"));
			serverList.add(server);
		}
		return serverList;
	}
	public List<Server> searchByServerTel(String q) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = com.yilisha.util.DBUtils.createConn();
		String sql =" select * from server where serverTel like '%" + q + "%'" ;
		PreparedStatement ps = com.yilisha.util.DBUtils.getPs(conn, sql);
		ResultSet rs = ps.executeQuery();
		List<Server> serverList = new ArrayList<Server>();
		System.out.println("sql=" + sql);
		while(rs.next()){
			Server server = new Server();
			server.setServerID(rs.getString("serverID"));
			server.setServerName(rs.getString("serverName"));
			server.setServerWorkplaceID(rs.getInt("serverWorkplaceID"));
			server.setServerTel(rs.getString("serverTel"));
			server.setServerCoordinateX(rs.getDouble("serverCoordinateX"));
			server.setServerCoordinateY(rs.getDouble("serverCoordinateY"));
			server.setServerStatus(rs.getInt("serverStatus"));
			serverList.add(server);
		}
		return serverList;
	}
	public List<Server> searchByServerWorkplaceID(String q) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = com.yilisha.util.DBUtils.createConn();
		String sql =" select * from server where serverWorkplaceID like '%" + q + "%'" ;
		PreparedStatement ps = com.yilisha.util.DBUtils.getPs(conn, sql);
		ResultSet rs = ps.executeQuery();
		List<Server> serverList = new ArrayList<Server>();
		System.out.println("sql=" + sql);
		while(rs.next()){
			Server server = new Server();
			server.setServerID(rs.getString("serverID"));
			server.setServerName(rs.getString("serverName"));
			server.setServerWorkplaceID(rs.getInt("serverWorkplaceID"));
			server.setServerTel(rs.getString("serverTel"));
			server.setServerCoordinateX(rs.getDouble("serverCoordinateX"));
			server.setServerCoordinateY(rs.getDouble("serverCoordinateY"));
			server.setServerStatus(rs.getInt("serverStatus"));
			serverList.add(server);
		}
		return serverList;
	}

	

}
