package com.yilisha.dao;

import java.util.List;
import java.util.Map;

import com.yilisha.base.BaseDao;
import com.yilisha.model.ServiceType;

public interface ServiceTypeDao extends BaseDao<ServiceType>{
	List<ServiceType> findByPagination(int currentPage, int pageSize , Map<String ,Object> m ) throws Exception;

	public int getTotal(Map<String ,Object> m) throws Exception ;

	List<ServiceType> searchByName(String q) throws Exception;
}