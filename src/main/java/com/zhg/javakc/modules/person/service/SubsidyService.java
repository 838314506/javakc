package com.zhg.javakc.modules.person.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zhg.javakc.base.page.Page;
import com.zhg.javakc.base.service.BaseService;
import com.zhg.javakc.base.util.CommonUtil;
import com.zhg.javakc.base.util.excel.ExportExcelToAll;
import com.zhg.javakc.modules.person.dao.SubsidyDao;
import com.zhg.javakc.modules.person.entity.SubsidyEntity;
/**
 * 干部人员管理逻辑层
 * @author lzz
 *
 */
@Service
@Transactional(readOnly=true)
public class SubsidyService extends BaseService<SubsidyDao,SubsidyEntity>{
	@Autowired
	private ExportExcelToAll<SubsidyEntity> eeta;
	
	/**
	 * 列表展示
	 * @param page
	 * @param entity
	 * @return
	 */
	public Page<SubsidyEntity> findInfo(Page<SubsidyEntity> page,SubsidyEntity entity)
	{
		entity.setPage(page);
		page.setList(dao.findList(entity));
		return page;
	}
	/**
	 * 更新数据方法
	 */
	@Transactional(readOnly = false,propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED)
	public void update(SubsidyEntity entity) 
	{
		entity.setUpdateDate(new Date());
		entity.setUpdateUser(CommonUtil.getUserEntity());
		dao.update(entity);
	}
	/**
	 * 查询某一项目的人员
	 * @param entity
	 * @return
	 */
	public List<SubsidyEntity> findPerson(SubsidyEntity entity)
	{
		return dao.findAllList(entity);
	}
	
	/**
	 * 保存一项补贴信息
	 * @param entity
	 */
	@Transactional(readOnly = false,propagation = Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
	public void save(SubsidyEntity entity) 
	{
		entity.setSid(CommonUtil.uuid());
		entity.setMonth(new Date());
		entity.setCreateDate(new Date());
		entity.setCreateUser(CommonUtil.getUserEntity());
		entity.setNewRecord(true);
		dao.insert(entity);
	}
	
	/**
	 * 查询总金额
	 */
	public BigDecimal sum(SubsidyEntity entity) 
	{
		return dao.sum(entity);
	}
	/**
	 * 表格导出
	 * @throws Exception 
	 */
	public void export(SubsidyEntity entity,HttpServletRequest req,HttpServletResponse resp) throws Exception
	{
		Map<String,Object> map = new HashMap<>();
		String[] title = new String[] {"序号","姓名","身份证","职级","金额","单位","月份",};
		map.put("title", title);
		map.put("list",this.convert(dao.findList(entity), req));
		eeta.buildExcelDocument(map, new HSSFWorkbook(), req, resp);
	}
	/**
	 * 转换查询结果方法
	 * @param list
	 * @param req
	 * @return
	 */
	public static List<String[]> convert(List<SubsidyEntity> list,HttpServletRequest req)
	{
		List<String[]> result = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			SubsidyEntity entity = list.get(i);
			String[] element = new String[7];
			element[0] = entity.getPe().getPname();
			element[1] = entity.getPe().getIdcard();
			Map<String, Object> map = CommonUtil.getDictionary(req, "person_grade");
			element[2] = (String) map.get(String.valueOf(entity.getPe().getGrade()));
			element[3] = String.valueOf(entity.getAmount());
			element[4] = "";
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			element[5] = format.format(entity.getMonth());
			result.add(element);
		}
		return result;
	}
}
