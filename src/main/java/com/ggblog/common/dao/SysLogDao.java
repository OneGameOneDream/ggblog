package com.ggblog.common.dao;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Mapper;

import com.ggblog.common.domain.SysLog;

@Mapper
@Resource
public interface SysLogDao extends CrudDao<SysLog>{
	/**
	 * 清空日志
	 */
	void empty();
}
