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
import com.yilisha.dao.UserDao;
import com.yilisha.model.User;
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{
	public List<User> getAllUserRecord() throws Exception {
		// TODO Auto-generated method stub
		Connection conn = com.yilisha.util.DBUtils.createConn();
		String sql = " select * from user where 1=1 ";
		PreparedStatement ps = com.yilisha.util.DBUtils.getPs(conn, sql);
		ResultSet rs = ps.executeQuery();
		List<User> userList = new ArrayList<User>();
		System.out.println("sql=" + sql);
		while(rs.next()){
			User user = new User();
			user.setUserID(rs.getString("userID"));
			user.setUserName(rs.getString("userName"));
			user.setUserGender(rs.getString("userGender"));
			user.setUserAge(rs.getInt("userAge"));
			user.setUserTel(rs.getString("userTel"));
			user.setUserCoordinateX(rs.getDouble("userCoordinateX"));
			user.setUserCoordinateY(rs.getDouble("userCoordinateY"));
			user.setInsuredTypeID(rs.getInt("insuredTypeID"));
			user.setUserAddress(rs.getString("userAddress"));
			user.setUserStatus(rs.getInt("userStatus"));
			userList.add(user);
		}
		return userList;
	}

	public List<User> findByPagination(int currentPage, int pageSize,
			Map<String, Object> m) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = com.yilisha.util.DBUtils.createConn();
		String sql = " select * from user where 1=1 ";
		
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
		
		List<User> userList = new ArrayList<User>();
		while(rs.next()){
			User user = new User();
			user.setUserID(rs.getString("userID"));
			user.setUserName(rs.getString("userName"));
			user.setUserGender(rs.getString("userGender"));
			user.setUserAge(rs.getInt("userAge"));
			user.setUserTel(rs.getString("userTel"));
			user.setUserCoordinateX(rs.getDouble("userCoordinateX"));
			user.setUserCoordinateY(rs.getDouble("userCoordinateY"));
			user.setInsuredTypeID(rs.getInt("insuredTypeID"));
			user.setUserAddress(rs.getString("userAddress"));
			user.setUserStatus(rs.getInt("userStatus"));
			userList.add(user);
		}
		return userList;
	}

	public int getTotal(Map<String, Object> m) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = com.yilisha.util.DBUtils.createConn();
		String sql = " select count(*) from user  where 1=1 ";
		
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
	//查询用户名
	public List<User> searchByUserName(String q) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = com.yilisha.util.DBUtils.createConn();
		String sql =" select * from user where userName like '%" + q + "%'" ;
		PreparedStatement ps = com.yilisha.util.DBUtils.getPs(conn, sql);
		ResultSet rs = ps.executeQuery();
		List<User> userList = new ArrayList<User>();
		System.out.println("sql=" + sql);
		while(rs.next()){
			User user = new User();
			user.setUserID(rs.getString("userID"));
			user.setUserName(rs.getString("userName"));
			user.setUserGender(rs.getString("userGender"));
			user.setUserAge(rs.getInt("userAge"));
			user.setUserTel(rs.getString("userTel"));
			user.setUserCoordinateX(rs.getDouble("userCoordinateX"));
			user.setUserCoordinateY(rs.getDouble("userCoordinateY"));
			user.setInsuredTypeID(rs.getInt("insuredTypeID"));
			user.setUserAddress(rs.getString("userAddress"));
			user.setUserStatus(rs.getInt("userStatus"));
			userList.add(user);
		}
		return userList;
	}
	//查询用户电话
	public List<User> searchByUserTel(String q) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = com.yilisha.util.DBUtils.createConn();
		String sql =" select * from user where userTel like '%" + q + "%'" ;
		PreparedStatement ps = com.yilisha.util.DBUtils.getPs(conn, sql);
		ResultSet rs = ps.executeQuery();
		List<User> userList = new ArrayList<User>();
		System.out.println("sql=" + sql);
		while(rs.next()){
			User user = new User();
			user.setUserID(rs.getString("userID"));
			user.setUserName(rs.getString("userName"));
			user.setUserGender(rs.getString("userGender"));
			user.setUserAge(rs.getInt("userAge"));
			user.setUserTel(rs.getString("userTel"));
			user.setUserCoordinateX(rs.getDouble("userCoordinateX"));
			user.setUserCoordinateY(rs.getDouble("userCoordinateY"));
			user.setInsuredTypeID(rs.getInt("insuredTypeID"));
			user.setUserAddress(rs.getString("userAddress"));
			user.setUserStatus(rs.getInt("userStatus"));
			userList.add(user);
		}
		return userList;
	}
	//查询年龄
	public List<User> searchByUserAge(String q) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = com.yilisha.util.DBUtils.createConn();
		String sql =" select * from user where userAge like '%" + q + "%'" ;
		PreparedStatement ps = com.yilisha.util.DBUtils.getPs(conn, sql);
		ResultSet rs = ps.executeQuery();
		List<User> userList = new ArrayList<User>();
		System.out.println("sql=" + sql);
		while(rs.next()){
			User user = new User();
			user.setUserID(rs.getString("userID"));
			user.setUserName(rs.getString("userName"));
			user.setUserGender(rs.getString("userGender"));
			user.setUserAge(rs.getInt("userAge"));
			user.setUserTel(rs.getString("userTel"));
			user.setUserCoordinateX(rs.getDouble("userCoordinateX"));
			user.setUserCoordinateY(rs.getDouble("userCoordinateY"));
			user.setInsuredTypeID(rs.getInt("insuredTypeID"));
			user.setUserAddress(rs.getString("userAddress"));
			user.setUserStatus(rs.getInt("userStatus"));
			userList.add(user);
		}
		return userList;
	}
	//查询地址
	public List<User> searchByUserAdress(String q) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = com.yilisha.util.DBUtils.createConn();
		String sql =" select * from user where userAddress like '%" + q + "%'" ;
		PreparedStatement ps = com.yilisha.util.DBUtils.getPs(conn, sql);
		ResultSet rs = ps.executeQuery();
		List<User> userList = new ArrayList<User>();
		System.out.println("sql=" + sql);
		while(rs.next()){
			User user = new User();
			user.setUserID(rs.getString("userID"));
			user.setUserName(rs.getString("userName"));
			user.setUserGender(rs.getString("userGender"));
			user.setUserAge(rs.getInt("userAge"));
			user.setUserTel(rs.getString("userTel"));
			user.setUserCoordinateX(rs.getDouble("userCoordinateX"));
			user.setUserCoordinateY(rs.getDouble("userCoordinateY"));
			user.setInsuredTypeID(rs.getInt("insuredTypeID"));
			user.setUserAddress(rs.getString("userAddress"));
			user.setUserStatus(rs.getInt("userStatus"));
			userList.add(user);
		}
		return userList;
	}

}
