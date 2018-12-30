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
import com.yilisha.dao.FamilyMemberDao;
import com.yilisha.model.*;

public class FamilyMemberDaoImpl extends BaseDaoImpl<FamilyMember> implements FamilyMemberDao{

	public List<FamilyMember> findByPagination(int currentPage, int pageSize,
			Map<String, Object> m) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = com.yilisha.util.DBUtils.createConn();
		String sql = " select * from familymember  where 1=1 ";
		
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
		
		List<FamilyMember> familyMemberList = new ArrayList<FamilyMember>();
		while(rs.next()){
			FamilyMember familyMember = new FamilyMember();
			familyMember.setMemberID(rs.getString("memberID"));
			familyMember.setMemberName(rs.getString("memberName"));
			familyMember.setRelation(rs.getString("relation"));
			familyMember.setMemberTel(rs.getString("memberTel"));
			familyMember.setAddress(rs.getString("address"));
			familyMember.setRelationMemberID(rs.getString("relationMemberID"));
			familyMemberList.add(familyMember);
		}
		return familyMemberList;
	}

	public int getTotal(Map<String, Object> m) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = com.yilisha.util.DBUtils.createConn();
		String sql = " select count(*) from familymember  where 1=1 ";
		
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

	public List<FamilyMember> searchByName(String q) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = com.yilisha.util.DBUtils.createConn();
		String sql =" select * from familymember where name like '%" + q + "%'" ;
		PreparedStatement ps = com.yilisha.util.DBUtils.getPs(conn, sql);
		ResultSet rs = ps.executeQuery();
		List<FamilyMember> familyMemberList = new ArrayList<FamilyMember>();
		System.out.println("sql=" + sql);
		while(rs.next()){
			FamilyMember familyMember = new FamilyMember();
			familyMember.setMemberID(rs.getNString("memberID"));
			familyMember.setMemberName(rs.getString("memberName"));
			familyMember.setRelation(rs.getString("relation"));
			familyMember.setMemberTel(rs.getString("memberTel"));
			familyMember.setAddress(rs.getString("address"));
			familyMember.setRelationMemberID(rs.getString("relationMemberID"));
			familyMemberList.add(familyMember);
		}		
		return familyMemberList;
	}

	public void delete(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public List<FamilyMember> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public FamilyMember findById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(FamilyMember obj) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void update(FamilyMember obj) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
