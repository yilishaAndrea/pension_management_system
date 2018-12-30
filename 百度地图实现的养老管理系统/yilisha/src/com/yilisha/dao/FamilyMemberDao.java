package com.yilisha.dao;
import java.util.List;
import java.util.Map;
import com.yilisha.base.BaseDao;
import com.yilisha.model.*;

public interface FamilyMemberDao extends BaseDao<FamilyMember>{
	List<FamilyMember> findByPagination(int currentPage, int pageSize , Map<String ,Object> m ) throws Exception;

	public int getTotal(Map<String ,Object> m) throws Exception ;

	List<FamilyMember> searchByName(String q) throws Exception;
}
