package com.yilisha.dao;

import java.util.List;
import java.util.Map;

import com.yilisha.base.BaseDao;
import com.yilisha.model.Server;
import com.yilisha.model.ServerWorkspace;

public interface ServerWorkspaceDao extends BaseDao<ServerWorkspace>{
	List<ServerWorkspace> findByPagination(int currentPage, int pageSize , Map<String ,Object> m ) throws Exception;

	public int getTotal(Map<String ,Object> m) throws Exception ;

	List<ServerWorkspace> searchByName(String q) throws Exception;
	
	List<ServerWorkspace> getAllServerWorkplaceRecord()throws Exception;
}
