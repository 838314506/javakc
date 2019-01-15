package com.zhg.javakc.modules.personnel_subsidy.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zhg.javakc.base.page.Page;
import com.zhg.javakc.base.util.CommonUtil;
import com.zhg.javakc.modules.personnel.entity.PersonnelEntity;
import com.zhg.javakc.modules.personnel_subsidy.Service.P_SubsidyService;
import com.zhg.javakc.modules.personnel_subsidy.entity.P_SubsidyEntity;

/**
 * 人事处人员补贴controller
 * @author lzz
 *
 */
@Controller
@RequestMapping("/personnel_subsidy")
public class P_SubsidyController {
	@Autowired
	private P_SubsidyService pss;

	/**
	 * 人员查询方法
	 */
	@RequestMapping("/query/{type}")
	public String query(@PathVariable("type") String type,ModelMap model,
			P_SubsidyEntity entity,PersonnelEntity pe,HttpServletRequest req,HttpServletResponse resp) throws Exception
	{
		if(type.equals("1")) { entity.setType(1); }
		if(type.equals("2")) { entity.setType(2); }
		if(type.equals("3")) { entity.setType(3); }
		if(type.equals("4")) { entity.setType(4); }
		if(type.equals("5")) { entity.setType(5); }
		if(type.equals("6")) { entity.setType(6); }
		if(type.equals("7")) { entity.setType(7); }
		if(type.equals("8")) { entity.setType(8); }
		model.put("page", pss.findInfo(new Page<P_SubsidyEntity>(req,resp),entity));
		model.put("entity", entity);
		return "p_subsidy/list";
	}
	/**
	 * 人员补贴新增方法
	 */
	@RequestMapping("/create")
	public String create(P_SubsidyEntity entity,PersonnelEntity pe) throws Exception
	{
		entity.setPe(pe);
		pss.save(entity);
		return "redirect:query/"+entity.getType()+".do";
	}
	/**
	 * 
	 */
	@RequestMapping("/createsubsidy")
//	@RequiresPermissions("subsidy:create")
	public String createsubsidy(P_SubsidyEntity entity, ModelMap model) throws Exception
	{
		model.put("list", pss.findPerson(entity));
		return "p_subsidy/create-subsidy";
	}
	/**
	 * 人员信息修改查询方法
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/load")
	public String load(@RequestParam("ids") String ids, ModelMap model) throws Exception
	{
		model.put("entity", pss.get(ids));
		return "p_subsidy/update";
	}
	
	/**
	 * 人员信息修改方法
	 */
	@RequestMapping("/update")
	public String update(P_SubsidyEntity entity) throws Exception
	{
		pss.update(entity);
		return "redirect:query/"+entity.getType()+".do";
	}
	/**
	 * 人员信息删除方法
	 */
	@RequestMapping("/delete")
	public String delete(@RequestParam("ids") String[] ids,P_SubsidyEntity entity) throws Exception
	{
		pss.delete(ids);
		return "redirect:query/"+entity.getType()+".do";
	}
}
