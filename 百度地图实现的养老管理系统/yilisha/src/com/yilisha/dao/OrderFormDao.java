package com.yilisha.dao;

import java.util.List;
import java.util.Map;

import com.yilisha.base.BaseDao;
import com.yilisha.model.OrderForm;
import com.yilisha.model.Server;

public interface OrderFormDao extends BaseDao<OrderForm>{
	List<OrderForm> findByPagination(int currentPage, int pageSize , Map<String ,Object> m ) throws Exception;

	public int getTotal(Map<String ,Object> m) throws Exception ;

	List<OrderForm> searchByName(String q) throws Exception;
	List<OrderForm> getAllOrderFormRecord()throws Exception;
	//List<OrderForm> updateOrderForm(String serverId,String orderNumber)throws Exception;
	public void updateOrderForm(String serverId,String orderNumber)throws Exception;
}
