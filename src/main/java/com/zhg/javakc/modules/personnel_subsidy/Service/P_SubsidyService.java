package com.zhg.javakc.modules.personnel_subsidy.Service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhg.javakc.base.page.Page;
import com.zhg.javakc.base.service.BaseService;
import com.zhg.javakc.base.util.CommonUtil;
import com.zhg.javakc.modules.person.entity.SubsidyEntity;
import com.zhg.javakc.modules.personnel_subsidy.dao.P_SubsidyDao;
import com.zhg.javakc.modules.personnel_subsidy.entity.P_SubsidyEntity;

/**
 * 人事处人员补贴逻辑层
 * @author lzz
 *
 */
@Service
@Transactional(readOnly=true)
public class P_SubsidyService extends BaseService<P_SubsidyDao, P_SubsidyEntity>{
	/**
	 * 从人员表中查询人员
	 */
	public List< P_SubsidyEntity> findPerson(P_SubsidyEntity entity)
	{
		return dao.findAllList(entity);
	}
	/**
	 * 向人员补贴表中插入一条数据
	 */
	@Transactional(readOnly=false)
	public void save(P_SubsidyEntity entity)
	{
		entity.setSid(CommonUtil.uuid());
		entity.setMonth(new Date());
		entity.setCreateDate(new Date());
		entity.setCreateUser(CommonUtil.getUserEntity());
		dao.insert(entity);
	}
	/**
	 * 人员补贴展示列表
	 */
	public Page<P_SubsidyEntity> findInfo(Page<P_SubsidyEntity> page,P_SubsidyEntity entity)
	{
		entity.setPage(page);
		page.setList(dao.findList(entity));
		return page;
	}
	/**
	 * 人员信息修改方法
	 */
	@Transactional(readOnly=false)
	public void update(P_SubsidyEntity entity)
	{
		entity.setUpdateDate(new Date());
		entity.setCreateUser(CommonUtil.getUserEntity());
		dao.update(entity);
	}
	
}
