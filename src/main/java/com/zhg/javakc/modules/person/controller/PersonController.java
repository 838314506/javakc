package com.zhg.javakc.modules.person.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.zhg.javakc.base.page.Page;
import com.zhg.javakc.base.util.excel.ExportExcelToAll;
import com.zhg.javakc.modules.person.entity.PersonEntity;
import com.zhg.javakc.modules.person.service.PersonService;

/**
 * 干部人员管理controller
 * 
 * @author lzz
 *
 */
@Controller
@RequestMapping("/person")
public class PersonController {
	@Autowired
	private PersonService personService;
	/**
	 * 人员信息查询方法
	 * @param entity
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/query")
	//用于限制非法访问权限
	@RequiresPermissions("person:query")
	public String query(PersonEntity entity,ModelMap model, HttpServletRequest request,
			HttpServletResponse response) throws Exception 
	{
		model.put("page",personService.findPerson(new Page<PersonEntity>(request, response), entity));
		model.put("entity", entity);
		return "person/list";
	}
	/**
	 * 人员信息新增方法
	 * @param entity
	 * @return
	 */
	@RequestMapping("/create")
	@RequiresPermissions("person:create")
	public String create(PersonEntity entity) 
	{
		personService.save(entity);
		return "redirect:query.do";
	}
	/**
	 * 人员信息修改查询方法
	 * @param ids
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/load")
	@RequiresPermissions("person:update")
	public String load(@RequestParam("ids") String ids,ModelMap model) throws Exception 
	{
		PersonEntity entity = personService.get(ids);
		model.put("entity", entity);
		return "person/update";
	}
	/**
	 * 人员信息修改方法
	 * @param entity
	 * @return
	 */
	@RequestMapping("/update")
	@RequiresPermissions("person:update")
	public String update(PersonEntity entity) 
	{
		personService.update(entity);
		return "redirect:query.do";
	}
	/**
	 * 人员信息删除方法
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("person:delete")
	public String delete(@RequestParam("ids") String[] ids)
	{
		personService.delete(ids);
		return "redirect:query.do";
	}
	/**
	 * 表格导入方法
	 * @param ids
	 * @return
	 * @throws ParseException 
	 * @throws IOException 
	 */
	@RequestMapping("/download")
	@RequiresPermissions("person:download")
	public String download(@RequestParam("loadfile") CommonsMultipartFile loadfile,HttpServletRequest request,
			HttpServletResponse response) throws IOException, ParseException 
	{
		personService.create(loadfile,request);
		return "redirect:query.do";
	}
	/**
	 * 表格导出
	 * @param req
	 * @param resp
	 * @throws Exception
	 */
	@RequestMapping("/export")
	@RequiresPermissions("person:export")
	//记得设置权限
	public void export(HttpServletRequest req,
			HttpServletResponse resp) throws Exception 
	{
		personService.export(req, resp);
	}
	
}
