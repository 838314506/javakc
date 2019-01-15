package com.zhg.javakc.modules.person.dao;

import java.math.BigDecimal;
import java.util.List;

import com.zhg.javakc.base.dao.BaseDao;
import com.zhg.javakc.base.dao.MyBatisDao;
import com.zhg.javakc.modules.person.entity.SubsidyEntity;
/**
 * 干部人员管理数据层接口
 * @author lzz
 *
 */
@MyBatisDao
public interface SubsidyDao extends BaseDao<SubsidyEntity> {
	public BigDecimal sum(SubsidyEntity entity);
}
