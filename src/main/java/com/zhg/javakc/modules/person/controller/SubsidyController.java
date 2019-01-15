package com.zhg.javakc.modules.person.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zhg.javakc.base.page.Page;
import com.zhg.javakc.modules.person.entity.PersonEntity;
import com.zhg.javakc.modules.person.entity.SubsidyEntity;
import com.zhg.javakc.modules.person.service.SubsidyService;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

/**
 * 干部人员管理controller
 * 
 * @author lzz
 *
 */
@Controller
@RequestMapping("/subsidy")
public class SubsidyController {
	@Autowired
	private SubsidyService subsidyService;
	/**
	 * 物业人员信息查询方法
	 * @param entity
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/query/{type}")
	//用于限制非法访问权限
	@RequiresPermissions("subsidy:query")
	public String queryEatate(@PathVariable("type") String type,SubsidyEntity entity,PersonEntity entity2,ModelMap model,
			HttpServletRequest request,HttpServletResponse response) throws Exception 
	{	
		if(type.equals("1")) {
			entity.setType(1);
		}else {
			entity.setType(2);
		}
		entity.setPe(entity2);
		Page<SubsidyEntity> page = subsidyService.findInfo(new Page<SubsidyEntity>(request, response), entity);
		model.put("page",page);
		model.put("pagestring",page.toString());
		model.put("count", page.getCount());
		model.put("entity", entity);
		model.put("sum", subsidyService.sum(entity));
		return "subsidy/list";
	}
	/**
	 * 人员修改查询方法
	 * @param ids
	 * @param model
	 * @return
	 */
	@RequestMapping("/load")
	@RequiresPermissions("subsidy:update")
	public String load(@RequestParam("ids") String ids,ModelMap model) throws Exception
	{
		model.put("entity",subsidyService.get(ids));
		return "subsidy/update";
	}
	/**
	 * 人员修改方法
	 * @param entity
	 * @return
	 */
	@RequestMapping("/update")
	@RequiresPermissions("subsidy:update")
	public String update(SubsidyEntity entity) throws Exception
	{
		subsidyService.update(entity);
		if(entity.getType()==2) {
			return "redirect:query/2.do";
		}
		return "redirect:query/1.do";
	}
	/**
	 * 查询添加对象
	 * @param entity
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/createsubsidy")
	@RequiresPermissions("subsidy:create")
	public String createsubsidy(SubsidyEntity entity, ModelMap model) throws Exception
	{
		model.put("list", subsidyService.findPerson(entity));
		return "subsidy/create-subsidy";
	}
	/**
	 * 删除一条或多条数据
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("subsidy:delete")
	public String delete(String[] ids,String type) throws Exception
	{
		subsidyService.delete(ids);
		if(Integer.valueOf(type)==2) {
			return "redirect:query/2.do";
		}
		return "redirect:query/1.do";
	}
	/**
	 * 添加人员方法
	 */
	@RequestMapping("/create")
	@RequiresPermissions("subsidy:create")
	public String create(SubsidyEntity entity,PersonEntity entity2) throws Exception
	{
		entity.setPe(entity2);
		subsidyService.save(entity);
		if(entity.getType()==2) {
			return "redirect:query/2.do";
		}
		return "redirect:query/1.do";
	}
	/**
	 * 表格导出
	 */
	@RequestMapping("/export")
	@RequiresPermissions("subsidy:export")
	public void export(SubsidyEntity entity,HttpServletRequest req,HttpServletResponse resp) throws Exception
	{
		subsidyService.export(entity,req,resp);
	}
	/**
	 * 汇总统计
	 */
	@RequestMapping("/tabulate")
//	@RequiresPermissions("subsidy:export")
	public String tabulate( ModelMap model,SubsidyEntity entity,HttpServletRequest req,HttpServletResponse resp) throws Exception
	{
		if(entity.getType() == 2) 
		{
			entity.setType(2);
		}else {
			entity.setType(1);
		}
		Page<SubsidyEntity> page = subsidyService.findInfo(new Page<SubsidyEntity>(req, resp), entity);
		model.put("count",page.getCount());
		model.put("entity", entity);
		model.put("sum", subsidyService.sum(entity));
		return "subsidy/tabulate";
	}
	
	@RequestMapping("/exportword")
	public void exportword(SubsidyEntity entity,HttpServletRequest req,HttpServletResponse resp) throws IOException
	{
		if(entity.getType() == 2) 
		{
			entity.setType(2);
		}else {
			entity.setType(1);
		}
		Page<SubsidyEntity> page = subsidyService.findInfo(new Page<SubsidyEntity>(req, resp), entity);
		Map<String,Object> data = new HashMap<>();
		data.put("year", entity.getMonth());
		data.put("month", entity.getMonth());
		data.put("day", entity.getMonth());
		data.put("type", entity.getType());
		data.put("date", entity.getMonth());
		data.put("count", page.getCount());
		data.put("sum",  subsidyService.sum(entity));
		String path = req.getContextPath();
//		createDoc(data,path+"\\src\\main\\resources\\template\\import.ftl","C:\\Users\\lzz\\Desktop\\import.ftl");
	}
	/**
	 * 导出word文档未实现
	 * @param data
	 * @param downloadType
	 * @param savePath
	 */
	public static void createDoc(Map<String,Object> data,String downloadType,String savePath)
	{
		Configuration conf = new Configuration();
		conf.setDefaultEncoding("utf-8");
		//加载需要装填的的模板
		Template template = null;
		conf.setClassForTemplateLoading(conf.getClass(), "import.ftl");
		//设置异常处理器
		conf.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
		try {
			template = conf.getTemplate(downloadType);
			File outFile = new File(savePath);
			Writer out = null;
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile),"utf-8"));
			template.process(data, out);
			out.close();
		} catch (IOException | TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
