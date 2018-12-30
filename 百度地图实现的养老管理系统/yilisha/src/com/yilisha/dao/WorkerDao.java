package com.yilisha.dao;

import java.util.List;
import java.util.Map;

import com.yilisha.base.BaseDao;
import com.yilisha.model.Worker;

public interface WorkerDao extends BaseDao<Worker>{
	List<Worker> findByPagination(int currentPage, int pageSize , Map<String ,Object> m ) throws Exception;

	public int getTotal(Map<String ,Object> m) throws Exception ;

	List<Worker> searchByName(String q) throws Exception;
}