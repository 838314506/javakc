package com.zhg.javakc.modules.test.dao;

import java.util.List;
import java.util.Map;

import com.zhg.javakc.base.dao.BaseDao;
import com.zhg.javakc.base.dao.MyBatisDao;
import com.zhg.javakc.modules.test.entity.EmpEntity;
import com.zhg.javakc.modules.test.entity.TestEntity;

/**
 * 测试模块数据层实现
 * @author zhou
 * @version 0.1
 */
@MyBatisDao
public interface TestDao extends BaseDao<TestEntity>{
	public List<EmpEntity> select(Map<String,Object> map);
}
