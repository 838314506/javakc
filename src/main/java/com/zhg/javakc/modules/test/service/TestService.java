package com.zhg.javakc.modules.test.service;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhg.javakc.base.page.Page;
import com.zhg.javakc.base.service.BaseService;
import com.zhg.javakc.modules.test.dao.TestDao;
import com.zhg.javakc.modules.test.entity.EmpEntity;
import com.zhg.javakc.modules.test.entity.TestEntity;

/**
 * 测试模块逻辑层实现
 * @author zhou
 * @version 0.1
 */
@Service
@Transactional(readOnly = true)
public class TestService extends BaseService<TestDao, TestEntity>{
	
	@Autowired
	private TestDao testDao;
	
	public Page<TestEntity> findTest(Page<TestEntity> page, TestEntity entity) {
		// 设置分页参数
		entity.setPage(page);
		// 执行分页查询
		page.setList(testDao.findList(entity));
		return page;
	}
	
	/**
	 * 查询数据
	 * @return
	 */
	public List<Map<String, Object>> highcharts()
	{
//		城市 降雨量 年度 月份
//		城市 降雨量 年度 月份
//		城市 降雨量 年度 月份
//		城市 降雨量 年度 月份
//		城市 降雨量 年度 月份
//		城市 降雨量 年度 月份
//		城市 降雨量 年度 月份
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		Map<String, Object> city1 = new HashMap<String, Object>();
		city1.put("name", "北京");
		city1.put("data", new double[] {10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21});
		
		Map<String, Object> city2 = new HashMap<String, Object>();
		city2.put("name", "海上");
		city2.put("data", new double[] {20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31});
		
		Map<String, Object> city3 = new HashMap<String, Object>();
		city3.put("name", "广州");
		city3.put("data", new double[] {30, 31, 32, 33, 14, 15, 16, 17, 18, 19, 20, 21});
		
		list.add(city1);
		list.add(city2);
		list.add(city3);
		
		return list;
	}
	
	/**
	 * 员工测试方法
	 */
	@SuppressWarnings("unchecked")
	public List<EmpEntity> select(Map<String,Object> map)
	{
		testDao.select(map);
		return (List<EmpEntity>)map.get("result");
	}
}
