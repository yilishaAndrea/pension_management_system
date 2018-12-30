package com.yilisha.dao;
import java.util.List;
import java.util.Map;
import com.yilisha.base.BaseDao;
import com.yilisha.model.User;

public interface UserDao extends BaseDao<User>{
	List<User> findByPagination(int currentPage, int pageSize , Map<String ,Object> m ) throws Exception;

	public int getTotal(Map<String ,Object> m) throws Exception ;
	List<User> searchByUserName(String q) throws Exception;
	List<User> searchByUserTel(String q) throws Exception;
	List<User> searchByUserAge(String q) throws Exception;
	List<User> searchByUserAdress(String q) throws Exception;
	List<User> getAllUserRecord() throws Exception;
}