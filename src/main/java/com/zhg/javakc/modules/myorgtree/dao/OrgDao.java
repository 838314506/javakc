package com.zhg.javakc.modules.myorgtree.dao;

import java.util.List;
import java.util.Map;

import com.zhg.javakc.base.dao.BaseDao;
import com.zhg.javakc.base.dao.MyBatisDao;
import com.zhg.javakc.modules.myorgtree.entity.OrgEntity;

/**
 * 机构树组织结构
 * @author lzz
 *
 */
@MyBatisDao
public interface OrgDao extends BaseDao<OrgEntity>{
	public List<Map<String,Object>> findAllOrg();
	public OrgEntity findOrg(String id);
}
