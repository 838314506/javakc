package com.zhg.javakc.modules.person.service;

import java.io.IOException;
import java.text.ParseException;
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
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.zhg.javakc.base.page.Page;
import com.zhg.javakc.base.service.BaseService;
import com.zhg.javakc.base.util.CommonUtil;
import com.zhg.javakc.base.util.excel.ExportExcelToAll;
import com.zhg.javakc.modules.person.dao.PersonDao;
import com.zhg.javakc.modules.person.entity.PersonEntity;
import com.zhg.javakc.modules.person.util.PersonUtil;
import com.zhg.javakc.modules.system.user.entity.UserEntity;
/**
 * 干部人员管理逻辑层
 * @author lzz
 *
 */
@Service
@Transactional(readOnly=true)
public class PersonService extends BaseService<PersonDao,PersonEntity>{
	@Autowired
	private ExportExcelToAll<PersonEntity> eeta;
	
	/**
	 * 人员查询方法
	 * @param page
	 * @param entity
	 * @return
	 */
	public Page<PersonEntity> findPerson(Page<PersonEntity> page,PersonEntity entity)
	{
		//设置分页信息
		entity.setPage(page);
		//由于有继承关系在父类中已经对数据层进行了注入因此不需要再进行注入可直接使用
		page.setList(dao.findList(entity));
		return page;
	}
	/**
	 * 保存数据（插入）
	 * @param entity
	 */
	@Transactional(readOnly = false)
	public void save(PersonEntity entity) 
	{
		//利用commonutil工具生成uuid
		entity.setPid(CommonUtil.uuid());
		entity.setCreateDate(new Date());
		//由shiro提供，可以session中得到当前用户，好处可以不依赖于request环境
		entity.setCreateUser(CommonUtil.getUserEntity());
		dao.insert(entity);
	}
	/**
	 * 更新数据方法
	 */
	@Transactional(readOnly = false)
	public void update(PersonEntity entity) 
	{
		entity.setUpdateDate(new Date());
		entity.setUpdateUser(CommonUtil.getUserEntity());
		dao.update(entity);
	}
	/**
	 * 批量新增
	 * @throws ParseException 
	 * @throws IOException 
	 */
	@Transactional(readOnly = false)
	public void create(CommonsMultipartFile loadfile,HttpServletRequest request) throws IOException, ParseException
	{
		List<PersonEntity> list = PersonUtil.getExcel(loadfile, request);
		dao.insertToAll(list);
	}
	/**
	 * 表格导出
	 * @throws Exception 
	 */
	public void export(HttpServletRequest req,HttpServletResponse resp) throws Exception 
	{
		Map<String,Object> data = new HashMap<>();
		//封装表头
		data.put("title", new String[]{"序号","名称","证件","状态","职级","日期","供暖","物业","原因"}); 
		//将查询到的数据进行最终转换
		 data.put("list", PersonUtil.convert(req,this.findList(null)));
		//创建表格对象时应按照最低版本进行创建，考虑到低版本用户，否则用户打不开表格
		eeta.buildExcelDocument(data,new HSSFWorkbook(),req,resp);
	}
	
}
