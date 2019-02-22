package com.ggblog.modules.sys.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ggblog.common.dao.CrudDao;
import com.ggblog.modules.sys.domain.SysDict;
/**
 * 系统字典Dao
 * @author 44359
 *
 */
@Mapper
public interface SysDictDao extends CrudDao<SysDict> {
	
}
