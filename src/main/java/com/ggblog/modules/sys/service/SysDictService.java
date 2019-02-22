package com.ggblog.modules.sys.service;

import org.springframework.stereotype.Service;

import com.ggblog.common.service.CrudService;
import com.ggblog.modules.sys.dao.SysDictDao;
import com.ggblog.modules.sys.domain.SysDict;

@Service
public class SysDictService extends CrudService<SysDictDao, SysDict> {
	
}
