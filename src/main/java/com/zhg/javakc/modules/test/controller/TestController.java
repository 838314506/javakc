package com.zhg.javakc.modules.test.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhg.javakc.base.page.Page;
import com.zhg.javakc.base.util.CommonUtil;
import com.zhg.javakc.base.util.excel.ExportExcel;
import com.zhg.javakc.base.util.file.DownloadFile;
import com.zhg.javakc.modules.test.entity.TestEntity;
import com.zhg.javakc.modules.test.service.TestService;

/**
 * 测试表现层实现
 * @author zhg
 * @version v0.1
 */
@Controller
@RequestMapping(value = "/test")
public class TestController {

	@Autowired
	private TestService testService;
	@Autowired
	private ExportExcel exportExcel;
	@Autowired
	private DownloadFile downloadFile;
	/**
	 * 测试ajax异步数据
	 * @param entity
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/ajax")
	@ResponseBody
	public Page<TestEntity> ajax(TestEntity entity, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		return testService.findTest(new Page<TestEntity>(request, response), entity);
	}
	
	/**
	 * 根据条件分页查询
	 * @param entity 查询条件
	 * @param model	 页面传参对象
	 * @param request 请求
	 * @param response 响应
	 * @return			展示数据列表页面
	 * @throws Exception 抛出异常
	 */
	@RequestMapping(value="/query")
	public String query(TestEntity entity, ModelMap model, 
			HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		model.put("page", testService.findTest(new Page<TestEntity>(request, response), entity));
		model.put("entity", entity);
		return "test/list";
	}
	
	/**
	 * 添加方法
	 * @param entity 实体对象
	 * @return
	 */
	@RequestMapping(value="/create")
	public String create(TestEntity entity, HttpServletRequest request)
	{
		entity.setTestId(CommonUtil.uuid());
		entity.setTestTime(new Timestamp(new Date().getTime()));
		
//		文件上传调用方法
//		try {
//			UploadFile.upload(request);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		testService.save(entity);
		return "redirect:/test/query.do";
	}
	
	/**
	 * 跳转到修改展示页面
	 * @param ids 当前对象主键ID
	 * @param model 页面传递参数对象
	 * @return
	 */
	@RequestMapping(value="/view")
	public String view(String ids, ModelMap model)
	{
		model.put("entity", testService.get(ids));
		return "test/update";
	}
	
	/**
	 * 修改方法
	 * @param entity 修改的实体类
	 * @return
	 */
	@RequestMapping(value="/update")
	public String update(TestEntity entity)
	{
		testService.update(entity);
		return "redirect:/test/query.do";
	}
	
	/**
	 * 批量删除对象
	 * @param ids 批量主键ID数组
	 * @return
	 */
	@RequestMapping(value="/delete")
	public String delete(String[] ids)
	{
		testService.delete(ids);
		return "redirect:/test/query.do";
	}
	
	/**
	 * excel文件导出
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value="/export")
	public void export(HttpServletRequest request, HttpServletResponse response)
		throws Exception
	{
		Workbook book = new HSSFWorkbook();
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("title", new String[]{"名称", "日期", "类型"});//设置导出excel标题栏
		data.put("data", testService.findList(new TestEntity()));//获取要导出的数据
		
		exportExcel.buildExcelDocument(data, book, request, response);
	}
	
	/**
	 * 下载导入模板
	 * @return
	 */
	@RequestMapping(value="/download")
	public void download(HttpServletRequest request, HttpServletResponse response)
	{
		//去除警告注解
		@SuppressWarnings("deprecation")
		String real = request.getRealPath("WEB-INF\\classes\\template");
		String name = "测试模块.xlsx";
		downloadFile.download(response, real+"\\"+name, name);
	}
	
	@RequestMapping(value="/highcharts")
	@ResponseBody
	public List<Map<String, Object>> highcharts()
	{
		return testService.highcharts();
	}
	
}
