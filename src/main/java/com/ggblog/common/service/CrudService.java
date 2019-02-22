package com.ggblog.common.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ggblog.common.dao.CrudDao;
import com.ggblog.common.domain.BaseEntity;
import com.ggblog.common.domain.SysPage;
import com.ggblog.modules.sys.util.UserUtils;

import cn.hutool.core.util.IdUtil;

/**
 * Service模板
 * 
 * @author 44359
 *
 * @param <D>
 * @param <T>
 */
public abstract class CrudService<D extends CrudDao<T>, T extends BaseEntity<T>> {

	@Autowired
	protected D dao;

	/**
	 * 获取单条数据
	 * 
	 * @param entity
	 * @return
	 */
	public T get(T entity) {
		return dao.get(entity);
	}

	/**
	 * 获取单条数据
	 * 
	 * @param id
	 * @return
	 */
	public T get(String id) {
		return dao.get(id);
	}

	/**
	 * 获取对象集合
	 * 
	 * @return
	 */
	public List<T> findList(T entity) {
		return dao.findList(entity);
	}
	
	/**
	 * 获取对象个数
	 * 
	 * @return
	 */
	public int count(T entity) {
		return dao.count(entity);
	}
	/**
	 * 获取分页数据
	 * @param entity
	 * @return
	 */
	public SysPage<T> findPage(T entity) {
		int totalCount = dao.count(entity);
		int pageSize = entity.getLimit();
		int pageNum = (entity.getPage()-1)*pageSize;
		int totalPage = (totalCount-1+pageSize)/pageSize;
		boolean isNext = pageNum == 1;
		boolean isPrev = pageNum == totalPage?false:true;
		entity.setSysPage(new SysPage<>(pageNum, pageSize));
		List<T> list = dao.findList(entity);
		return new SysPage<T>(pageNum, totalCount, totalPage, pageSize, list, isNext, isPrev);
	}

	/**
	 * 插入单条数据
	 * 
	 * @param t
	 */
	public int insert(T entity) {
		entity.setId(IdUtil.simpleUUID());
		entity.setDelFlag("0");
		entity.setCreateBy(UserUtils.getUsername());
		entity.setCreateDate(new Date());
		entity.setUpdateBy(UserUtils.getUsername());
		entity.setUpdateDate(new Date());
		return dao.insert(entity);
	}

	/**
	 * 更新单条数据
	 * 
	 * @param entity
	 */
	public int update(T entity) {
		entity.setUpdateBy(UserUtils.getUsername());
		entity.setUpdateDate(new Date());
		return dao.update(entity);
	}

	/**
	 * 保存数据
	 * @param entity
	 * @return
	 */
	public int save(T entity) {
		if(entity.getId()!=null) {
			return update(entity);
		}else {
			return insert(entity);
		}
	}
	
	
	/**
	 * 删除单条数据
	 * 
	 * @param entity
	 */
	public int delete(String id) {
		return dao.delete(id);
	}
	/**
	 * 删除单条数据
	 * 
	 * @param entity
	 */
	public int delete(T entity) {
		return dao.delete(entity.getId());
	}
}
