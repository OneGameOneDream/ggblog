package com.ggblog.common.dao;

import java.util.List;

/**
 * 模板Dao
 * 
 * @author 44359
 *
 * @param <T>
 */
public interface CrudDao<T> {

	/**
	 * 获取单条数据
	 * 
	 * @param entity
	 * @return
	 */
	T get(T entity);

	/**
	 * 获取单条数据
	 * 
	 * @param id
	 * @return
	 */
	T get(String id);

	/**
	 * 获取对象集合
	 * 
	 * @return
	 */
	List<T> findList(T entity);


	/**
	 * 插入单条数据
	 * 
	 * @param t
	 */
	int insert(T entity);

	/**
	 * 更新单条数据
	 * 
	 * @param entity
	 * @return
	 */
	int update(T entity);

	/**
	 * 删除单条数据
	 * 
	 * @param entity
	 */
	int delete(String id);

	/**
	 * 查询总数
	 * 
	 * @return
	 */
	int count(T entity);
}
