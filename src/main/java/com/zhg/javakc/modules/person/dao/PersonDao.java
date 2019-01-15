package com.zhg.javakc.modules.person.dao;

import java.util.List;

import com.zhg.javakc.base.dao.BaseDao;
import com.zhg.javakc.base.dao.MyBatisDao;
import com.zhg.javakc.modules.person.entity.PersonEntity;
/**
 * 干部人员管理数据层接口
 * @author lzz
 *
 */
@MyBatisDao
public interface PersonDao extends BaseDao<PersonEntity> {
	public void insertToAll(List<PersonEntity> entity);
}
