package com.yilisha.base;

import java.util.List;

public interface BaseDao<Entity> {
	void save(Entity obj) throws Exception ; //����һ������
	void update (Entity obj) throws Exception; //����һ������
	void delete(int id) throws Exception; //ͨ��idɾ��һ������
	List<Entity> findAll() throws Exception;//���ȫ�����ݷŵ�list�б��з���
	Entity findById( int id) throws Exception;//ͨ��id��ѯһ������
	Entity findById( String id) throws Exception;//ͨ��id��ѯһ������
}
