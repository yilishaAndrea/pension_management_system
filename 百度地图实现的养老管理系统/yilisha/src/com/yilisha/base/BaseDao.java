package com.yilisha.base;

import java.util.List;

public interface BaseDao<Entity> {
	void save(Entity obj) throws Exception ; //保存一条数据
	void update (Entity obj) throws Exception; //更新一条数据
	void delete(int id) throws Exception; //通过id删除一条数据
	List<Entity> findAll() throws Exception;//查出全部数据放到list列表中返回
	Entity findById( int id) throws Exception;//通过id查询一条数据
	Entity findById( String id) throws Exception;//通过id查询一条数据
}
