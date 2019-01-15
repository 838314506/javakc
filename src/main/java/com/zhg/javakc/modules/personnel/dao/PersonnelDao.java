package com.zhg.javakc.modules.personnel.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zhg.javakc.base.dao.BaseDao;
import com.zhg.javakc.base.dao.MyBatisDao;
import com.zhg.javakc.modules.personnel.entity.PersonnelEntity;
import com.zhg.javakc.modules.personnel.entity.TypeEntity;
/**
 * 人事处人员管理数据层
 * @author lzz
 *
 */
@MyBatisDao
public interface PersonnelDao extends BaseDao<PersonnelEntity>{
	public void insertType(TypeEntity entity);
	public void updateType(PersonnelEntity entity);
	public void insertToAll(List<PersonnelEntity> list);
	public void insertToAllType(List<TypeEntity> list);
}
