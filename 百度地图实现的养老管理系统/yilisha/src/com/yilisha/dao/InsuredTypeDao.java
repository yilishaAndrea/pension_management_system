package com.yilisha.dao;

import java.util.List;
import java.util.Map;

import com.yilisha.base.BaseDao;
import com.yilisha.model.InsuredType;

public interface InsuredTypeDao extends BaseDao<InsuredType>{
	List<InsuredType> findByPagination(int currentPage, int pageSize , Map<String ,Object> m ) throws Exception;

	public int getTotal(Map<String ,Object> m) throws Exception ;

	List<InsuredType> searchByName(String q) throws Exception;
}
