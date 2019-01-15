package com.zhg.javakc.modules.personnel.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.zhg.javakc.base.page.Page;
import com.zhg.javakc.base.service.BaseService;
import com.zhg.javakc.base.util.CommonUtil;
import com.zhg.javakc.base.util.excel.ExportExcelToAll;
import com.zhg.javakc.modules.personnel.PersonnelUtil;
import com.zhg.javakc.modules.personnel.dao.PersonnelDao;
import com.zhg.javakc.modules.personnel.entity.PersonnelEntity;
import com.zhg.javakc.modules.personnel.entity.TypeEntity;
/**
 * 人事处人员管理逻辑层
 * @author lzz
 *
 */
@Service
@Transactional(readOnly = true)
public class PersonnelService extends BaseService<PersonnelDao, PersonnelEntity>{
	@Autowired
	private ExportExcelToAll<PersonnelEntity> eeta;
	/**
	 * 人员信息添加方法
	 */
	@Transactional(readOnly = false)
	//在这里先向补贴类型表中插入数据，然后再向人事处人员信息表中插入数据，经测试spring中管理的事务在这里两条DML语句绑定在一个事务中
	public void save(PersonnelEntity entity) {
		entity.setPeid(CommonUtil.uuid());
		entity.setCreateDate(new Date());
		entity.setCreateUser(CommonUtil.getUserEntity());
		entity.getTe().setTid(CommonUtil.uuid());
		dao.insertType(entity.getTe());
		dao.insert(entity);
	}
	
	/**
	 * 人员信息展示方法
	 */
	public Page<PersonnelEntity> findPersonnel(Page<PersonnelEntity> page,PersonnelEntity entity)
	{
		entity.setPage(page);
		page.setList(dao.findList(entity));
		return page;
	}
	
	/**
	 * 人员信息修改方法
	 */
	@Transactional(readOnly = false)
	public void update(PersonnelEntity entity)
	{
		entity.setUpdateUser(CommonUtil.getUserEntity());
		entity.setUpdateDate(new Date());
		dao.update(entity);
		dao.updateType(entity);
	}
	/**
	 * 人员信息导出方法逻辑层
	 * @throws Exception 
	 */
	public void export(HttpServletRequest req,HttpServletResponse resp) throws Exception
	{
		Map<String,Object> data = new HashMap<>();
		String[] title =  new String[] 
				{"序号","名称","证件","职级","入职时间","状态","单位","发放工资项","创建日期"};
		data.put("title",title);
		data.put("list",PersonnelUtil.convertor(req,dao.findList(null)));
		eeta.buildExcelDocument(data, new HSSFWorkbook(), req, resp);
	}
	/**
	 * 表格信息导入
	 * @throws ParseException 
	 * @throws IOException 
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public void create(MultipartFile loadfile,HttpServletRequest req) throws IOException, ParseException
	{
		Map<String, Object> map = PersonnelUtil.getExcel(loadfile, req);
		dao.insertToAllType((List<TypeEntity>)map.get("type"));
		dao.insertToAll((List<PersonnelEntity>)map.get("list"));
	}
}
