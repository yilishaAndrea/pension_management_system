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
import com.yilisha.dao.OrderFormDao;
import com.yilisha.model.*;

public class OrderFormDaoImpl extends BaseDaoImpl<OrderForm> implements OrderFormDao{
	
	@Override
	public void update(OrderForm obj) throws Exception {
		// TODO Auto-generated method stub
		super.update(obj);
	}

	@Override
	public void delete(int id) throws Exception {
		// TODO Auto-generated method stub
		super.delete(id);
	}

	@Override
	public void save(OrderForm obj) throws Exception {
		// TODO Auto-generated method stub
		super.save(obj);
	}
	
	public List<OrderForm> getAllOrderFormRecord() throws Exception {
		// TODO Auto-generated method stub
		Connection conn = com.yilisha.util.DBUtils.createConn();
		String sql = " select * from orderform where 1=1 ";
		PreparedStatement ps = com.yilisha.util.DBUtils.getPs(conn, sql);
		ResultSet rs = ps.executeQuery();
		List<OrderForm> orderFormList = new ArrayList<OrderForm>();
		System.out.println("sql=" + sql);
		while(rs.next()){
			OrderForm orderForm = new OrderForm();
			orderForm.setOrderNumber(rs.getString("orderNumber"));
			orderForm.setUserId(rs.getString("userId"));
			orderForm.setServiceContent(rs.getString("serviceContent"));
			orderForm.setServiceTypeId(rs.getInt("serviceTypeId"));
			orderForm.setServerId(rs.getString("serverId"));
			orderForm.setServiceStatus(rs.getInt("serviceStatus"));
			orderFormList.add(orderForm);
		}
		return orderFormList;
	}
	
	public List<OrderForm> findByPagination(int currentPage, int pageSize,
			Map<String, Object> m) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = com.yilisha.util.DBUtils.createConn();
		String sql = " select * from orderform  where 1=1 ";
		
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
		
		List<OrderForm> orderFormList = new ArrayList<OrderForm>();
		while(rs.next()){
			OrderForm orderForm = new OrderForm();
			orderForm.setOrderNumber(rs.getString("orderNumber"));
			orderForm.setUserId(rs.getString("userId"));
			orderForm.setServiceContent(rs.getString("serviceContent"));
			orderForm.setServiceTypeId(rs.getInt("serviceTypeId"));
			orderForm.setServerId(rs.getString("serverId"));
			orderForm.setServiceStatus(rs.getInt("serviceStatus"));
			orderFormList.add(orderForm);
		}
		return orderFormList;
	}

	public int getTotal(Map<String, Object> m) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = com.yilisha.util.DBUtils.createConn();
		String sql = " select count(*) from orderform  where 1=1 ";
		
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
	
	public List<OrderForm> searchByName(String q) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = com.yilisha.util.DBUtils.createConn();
		String sql =" select * from orderform where name like '%" + q + "%'" ;
		PreparedStatement ps = com.yilisha.util.DBUtils.getPs(conn, sql);
		ResultSet rs = ps.executeQuery();
		List<OrderForm> orderFormList = new ArrayList<OrderForm>();
		System.out.println("sql=" + sql);
		while(rs.next()){
			OrderForm orderForm = new OrderForm();
			orderForm.setOrderNumber(rs.getString("orderNumber"));
			orderForm.setUserId(rs.getString("userId"));
			orderForm.setServerId(rs.getString("serverId"));
			orderForm.setServiceContent(rs.getString("serviceContent"));
			orderForm.setServiceTypeId(rs.getInt("serviceTypeId"));
			orderForm.setServiceStatus(rs.getInt("serviceStatus"));
			orderFormList.add(orderForm);
		}
		return orderFormList;
	}

//	public List<OrderForm> updateOrderForm(String serverId,String orderNumber) throws Exception {
//		// TODO Auto-generated method stub
//		Connection conn = com.yilisha.util.DBUtils.createConn();
//		String sql = " UPDATE orderform SET serverId = "+serverId+" WHERE orderNumber = "+ orderNumber;
//		PreparedStatement ps = com.yilisha.util.DBUtils.getPs(conn, sql);
//		ResultSet rs = ps.executeQuery();
//		List<OrderForm> orderFormList = new ArrayList<OrderForm>();
//		System.out.println("sql=" + sql);
//		while(rs.next()){
//			OrderForm orderForm = new OrderForm();
//			orderForm.setOrderNumber(rs.getString("orderNumber"));
//			orderForm.setUserId(rs.getString("userId"));
//			orderForm.setServiceContent(rs.getString("serviceContent"));
//			orderForm.setServiceTypeId(rs.getInt("serviceTypeId"));
//			orderForm.setServiceStatus(rs.getInt("serviceStatus"));
//			orderFormList.add(orderForm);
//		}
//		return orderFormList;
//	}
	public void updateOrderForm(String serverId,String orderNumber) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = com.yilisha.util.DBUtils.createConn();
		String sql = " UPDATE orderform SET serverId = "+serverId+","+"serviceStatus=1"+" WHERE orderNumber = "+ orderNumber;
		PreparedStatement ps = com.yilisha.util.DBUtils.getPs(conn, sql);
		//Ö´ÐÐupdate
		int rs = ps.executeUpdate();
		System.out.println("sql=" + sql);
	}
}
