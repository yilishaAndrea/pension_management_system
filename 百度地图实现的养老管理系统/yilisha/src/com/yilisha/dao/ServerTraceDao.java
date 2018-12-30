package com.yilisha.dao;

import java.util.List;
import java.util.Map;

import com.yilisha.base.BaseDao;
import com.yilisha.model.ServerTrace;

public interface ServerTraceDao extends BaseDao<ServerTrace>{
	List<ServerTrace> findByPagination(int currentPage, int pageSize , Map<String ,Object> m ) throws Exception;

	public int getTotal(Map<String ,Object> m) throws Exception ;

	List<ServerTrace> searchByName(String q) throws Exception;
	List<ServerTrace> searchByServerID(String q) throws Exception;
}
