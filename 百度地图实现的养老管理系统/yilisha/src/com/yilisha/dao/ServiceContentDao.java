package com.yilisha.dao;

import java.util.List;
import java.util.Map;

import com.yilisha.base.BaseDao;
import com.yilisha.model.ServiceContent;

public interface ServiceContentDao extends BaseDao<ServiceContent>{
	List<ServiceContent> findByPagination(int currentPage, int pageSize , Map<String ,Object> m ) throws Exception;

	public int getTotal(Map<String ,Object> m) throws Exception ;

	List<ServiceContent> searchByName(String q) throws Exception;
}
