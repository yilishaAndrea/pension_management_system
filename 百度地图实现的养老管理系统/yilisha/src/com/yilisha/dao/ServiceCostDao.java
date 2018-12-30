package com.yilisha.dao;

import java.util.List;
import java.util.Map;

import com.yilisha.base.BaseDao;
import com.yilisha.model.ServiceCost;

public interface ServiceCostDao extends BaseDao<ServiceCost>{
	List<ServiceCost> findByPagination(int currentPage, int pageSize , Map<String ,Object> m ) throws Exception;

	public int getTotal(Map<String ,Object> m) throws Exception ;

	List<ServiceCost> searchByName(String q) throws Exception;
}
