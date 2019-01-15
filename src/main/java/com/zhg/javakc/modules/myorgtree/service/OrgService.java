package com.zhg.javakc.modules.myorgtree.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhg.javakc.base.service.BaseService;
import com.zhg.javakc.base.util.CommonUtil;
import com.zhg.javakc.modules.myorgtree.dao.OrgDao;
import com.zhg.javakc.modules.myorgtree.entity.OrgEntity;

import oracle.jdbc.oracore.OracleType;

/**
 * 机构组织树逻辑层
 * @author lzz
 *
 */
@Service
@Transactional(readOnly=true)
public class OrgService extends BaseService<OrgDao, OrgEntity>{
	/**
	 * 机构树查询方法
	 */
	public List<Map<String,Object>> findAllOrg()
	{
		return dao.findAllOrg();
	}
	/**
	 * 机构树添加方法
	 */
	@Transactional(readOnly=false)
	public void save(OrgEntity entity)
	{
		entity.setOrgId(CommonUtil.uuid());
		entity.setCreateDate(new Date());
		entity.setCreateUser(CommonUtil.getUserEntity());
		dao.insert(entity);
	}
	/**
	 * 机构树修改查询方法
	 */
	public OrgEntity findOrg(String id)
	{
		return dao.findOrg(id);
	}
	/**
	 * 机构树修改方法
	 */
	@Transactional(readOnly=false)
	public void update(OrgEntity entity)
	{
		entity.setUpdateDate(new Date());
		entity.setUpdateUser(CommonUtil.getUserEntity());
		dao.update(entity);
	}
}
