package com.zhg.javakc.modules.myorgtree.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhg.javakc.modules.myorgtree.entity.OrgEntity;
import com.zhg.javakc.modules.myorgtree.service.OrgService;

/**
 * 机构树表现层
 * @author lzz
 *
 */
@Controller
@RequestMapping("/org")
public class OrgController {
	@Autowired
	private OrgService orgService;
	
	/**
	 * 异步加载树中的数据
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/query")
	@ResponseBody
	public List<Map<String,Object>> query() throws Exception
	{
		return orgService.findAllOrg();
	}
	/**
	 * 添加树节点
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/create")
	public String create(OrgEntity entity) throws Exception
	{
		orgService.save(entity);
		return "myorg/list";
	}
	/**
	 * 修改查询树节点信息
	 * @param orgId
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/load")
	public String load(@RequestParam("orgId") String orgId,ModelMap model) throws Exception
	{
		model.put("entity", orgService.findOrg(orgId));
		return "myorg/update";
	}
	/**
	 * 修改节点信息
	 */
	@RequestMapping("/update")
	public String update(OrgEntity entity) throws Exception
	{
		orgService.update(entity);
		return "myorg/list";
	}
	/**
	 * 删除节点信息
	 */
	@RequestMapping("/delete")
	public String delete(OrgEntity entity) throws Exception
	{
		orgService.delete(entity);
		return "myorg/list";
	}
}
