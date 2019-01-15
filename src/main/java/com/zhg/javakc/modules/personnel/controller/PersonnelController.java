package com.zhg.javakc.modules.personnel.controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.zhg.javakc.base.page.Page;
import com.zhg.javakc.base.util.file.DownloadFile;
import com.zhg.javakc.modules.personnel.PersonnelUtil;
import com.zhg.javakc.modules.personnel.entity.PersonnelEntity;
import com.zhg.javakc.modules.personnel.entity.TypeEntity;
import com.zhg.javakc.modules.personnel.service.PersonnelService;
/**
 * 人事处人员管理controller
 * @author lzz
 *
 */
@Controller
@RequestMapping("/personnel")
public class PersonnelController {
	@Autowired
	private PersonnelService personnelService;
	/**
	 * 人员查询方法
	 */
	@RequestMapping("/query")
	@RequiresPermissions("personnel:query")
	public String query(PersonnelEntity entity,ModelMap model,HttpServletRequest req,HttpServletResponse resp) throws Exception
	{
		model.put("page",personnelService.findPersonnel(new Page<PersonnelEntity>(req,resp),entity));
		model.put("entity", entity);
		return "personnel/list";
	}
	/**
	 * 人员添加方法
	 */
	@RequestMapping("/create")
	@RequiresPermissions("personnel:create")
	public String create(PersonnelEntity entity,TypeEntity te) throws Exception
	{
		entity.setTe(te);
		personnelService.save(entity);
		return "redirect:query.do";
	}
	/**
	 * 人员信息修改查询方法
	 */
	@RequestMapping("/load")
	@RequiresPermissions("personnel:update")
	public String load(@RequestParam("ids") String ids,ModelMap model) throws Exception
	{
		model.put("entity", personnelService.get(ids));
		return "personnel/update";
	}
	/**
	 * 人员信息修改方法
	 */
	@RequestMapping("/update")
	@RequiresPermissions("personnel:update")
	public String update(PersonnelEntity entity,TypeEntity te) throws Exception
	{
		entity.setTe(te);
		personnelService.update(entity);
		return "redirect:query.do";
	}
	/**
	 * 人员信息删除方法
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("personnel:delete")
	public String delete(@RequestParam("ids") String[] ids) throws Exception
	{
		personnelService.delete(ids);
		return "redirect:query.do";
	}
	/**
	 * 人员信息导出方法
	 */
	@RequestMapping("/export")
	@RequiresPermissions("personnel:export")
	public void export(HttpServletRequest req,HttpServletResponse resp) throws Exception
	{
		personnelService.export(req,resp);
	}
	/**
	 * 模板下载
	 */
	@RequestMapping("/download")
	@RequiresPermissions("personnel:import")
	public void download(HttpServletRequest req,HttpServletResponse resp) throws Exception
	{
		@SuppressWarnings("deprecation")
		String path = req.getRealPath("WEB-INF\\classes\\template");
		System.out.println(path);
		String name = "人事处测试模块";
		PersonnelUtil.down(resp,path+"\\"+name,name);
	}
	/**
	 * 文件导入
	 */
	@RequestMapping("/import")
	@RequiresPermissions("personnel:import")
	public String importFile(@RequestParam("loadfile") MultipartFile loadfile,HttpServletRequest req) throws Exception
	{
		personnelService.create(loadfile,req);
		return "redirect:query.do";
	}
}
