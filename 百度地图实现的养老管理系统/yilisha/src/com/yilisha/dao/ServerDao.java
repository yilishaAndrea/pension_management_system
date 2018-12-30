package com.yilisha.dao;

import java.util.List;
import java.util.Map;

import com.yilisha.base.BaseDao;
import com.yilisha.model.Server;
import com.yilisha.model.User;

public interface ServerDao extends BaseDao<Server>{
	List<Server> findByPagination(int currentPage, int pageSize , Map<String ,Object> m ) throws Exception;

	public int getTotal(Map<String ,Object> m) throws Exception ;

	List<Server> searchByServerName(String q) throws Exception;
	List<Server> searchByServerTel(String q) throws Exception;
	List<Server> searchByServerWorkplaceID(String q) throws Exception;	
	List<Server> getAllServerRecord()throws Exception;
}
