package com.ggblog.common.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ggblog.common.dao.SysLogDao;
import com.ggblog.common.domain.SysLog;
import com.ggblog.common.domain.SysPage;

/**
 * 日志Service
 * 
 * @author 44359
 *
 */
@Service
public class SysLogService extends CrudService<SysLogDao, SysLog> {

	/**
	 * 获取单条数据
	 * 
	 * @param entity
	 * @return
	 */
	public SysLog get(SysLog entity) {
		return super.get(entity);
	}

	/**
	 * 获取单条数据
	 * 
	 * @param id
	 * @return
	 */
	public SysLog get(String id) {
		return super.get(id);
	}

	/**
	 * 获取对象集合
	 * 
	 * @return
	 */
	public List<SysLog> findList(SysLog entity) {
		return super.findList(entity);
	}
	/**
	 * 获取分页数据
	 */
	public SysPage<SysLog> findPage(SysLog entity){
		return super.findPage(entity);
	}
	

	/**
	 * 插入单条数据
	 * 
	 * @param t
	 */
	public int insert(SysLog entity) {
		return super.insert(entity);
	}


	/**
	 * 删除单条数据
	 * 
	 * @param entity
	 */
	public int delete(String id) {
		return super.delete(id);
	}
	
	/**
	 * 清空日志
	 */
	public void empty() {
		 dao.empty();
	}
}
