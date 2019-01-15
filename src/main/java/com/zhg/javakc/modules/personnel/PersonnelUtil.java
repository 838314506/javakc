package com.zhg.javakc.modules.personnel;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.zhg.javakc.base.util.CommonUtil;
import com.zhg.javakc.base.util.excel.ImportExcelToAll;
import com.zhg.javakc.modules.personnel.entity.PersonnelEntity;
import com.zhg.javakc.modules.personnel.entity.TypeEntity;
/**
 * 人事处人员信息处理工具类
 * @author lzz
 *
 */
public final class PersonnelUtil {
	/**
	 * 导出信息工具
	 */
	public static List<String[]> convertor(HttpServletRequest req,List<PersonnelEntity> list)
	{
		List<String[]> result = new ArrayList<>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		for (int i = 0; i < list.size(); i++) {
			PersonnelEntity entity = list.get(i);
			String[] element = new String[8];
			element[0] = entity.getPename();//名称
			element[1] = entity.getIdcard();//证件
			Map<String, Object> map =(Map<String, Object>) CommonUtil.getDictionary(req, "person_grade");
			element[2] = (String)map.get(String.valueOf(entity.getGrade()));//职级
			element[3] = format.format(entity.getTime());//入职时间
			element[4] = entity.getState()==1?"在职":"休假";//状态
			element[5] = "";//单位
			element[6] = type(entity.getTe());//发放工资项
			element[7] = format.format(entity.getCreateDate());//创建时间
			result.add(element);
		}
		return result;
	}
	/**
	 * 人员补贴转换
	 * @param entity
	 * @return
	 */
	public static String type(TypeEntity entity)
	{
		StringBuffer type = new StringBuffer();
		type.append(entity.getHeating()==1?"供热，":"");
		type.append(entity.getEatate()==1?"物业，":"");
		type.append(entity.getCar()==1?"车补，":"");
		type.append(entity.getHi()==1?"医保，":"");
		type.append(entity.getEi()==1?"养老保险，":"");
		type.append(entity.getUnemp()==1?"失业保险，":"");
		type.append(entity.getOa()==1?"职业年金，":"");
		type.append(entity.getOibirth()==1?"工伤生育":"");
		return type.toString();
	}
	/**
	 * 模板下载
	 * @throws IOException 
	 */
	public static void down(HttpServletResponse resp,String path,String name) 
	{
		//清空响应流
		resp.reset();
		//设置响应格式
		resp.setContentType("application/octet-stream; charset=utf-8");
		File file = new File(path);
		OutputStream out = null;
		
		try {
			//解决文件的中文问题
//			name = new String(name.getBytes("UTF-8"),"ISO8859-1");
			name = URLEncoder.encode(name,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		resp.setHeader("Content-Disposition", "attachment; filename="+name);
		
		try {
			out = resp.getOutputStream();
			out.write(FileUtils.readFileToByteArray(file));
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 文件导入方法
	 * @throws IOException 
	 * @throws ParseException 
	 */
	public static Map<String,Object> getExcel(MultipartFile loadfile,HttpServletRequest req) throws IOException, ParseException 
	{
		List<PersonnelEntity> list = new ArrayList<>();
		List<TypeEntity> type = new ArrayList<>();
		Workbook workbook = null;
		String filename = loadfile.getOriginalFilename();
		InputStream input = loadfile.getInputStream();
		if(filename.endsWith(".xlsx"))
		{
			workbook = new XSSFWorkbook(input);
		}else {
			workbook = new HSSFWorkbook(input);
		}
		int sheets = workbook.getNumberOfSheets();
		for(int i = 0;i < sheets;i++) {
			Sheet sheet = workbook.getSheetAt(i);
			int rows = sheet.getPhysicalNumberOfRows();
			for(int j = 1;j < rows;j++) {
				Row row = sheet.getRow(j);
				PersonnelEntity entity = new PersonnelEntity();
				TypeEntity te = null;
				int cells = row.getPhysicalNumberOfCells();
				for(int k = 1;k < cells+1;k++) {
					Cell cell = row.getCell(k);
					String value = ImportExcelToAll.getValueByCell(cell);
					switch (k) {
					case 1 :
						entity.setPename(value);
						break;
					case 2 :
						entity.setIdcard(value);
						break;
					case 3 :
						entity.setGrade(CommonUtil.getGrade(value));
						break;
					case 4 :
						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
						entity.setTime(format.parse(value));
						break;
					case 5 :
						entity.setState(value == "在职"?1:2);
						break;
					case 6 :
						//单位
						break;
					default :
						te = getType(value);
						entity.setTe(te);
						break;
					}
				}
				entity.setPeid(CommonUtil.uuid());
				entity.setCreateDate(new Date());
				entity.setCreateUser(CommonUtil.getUserEntity());
				type.add(te);
				list.add(entity);
			}
		}
		Map<String,Object> map = new HashMap<>();
		map.put("list", list);
		map.put("type", type);
		return map;
	}
	/**
	 * 处理表格中关于补贴的方法
	 */
	public static TypeEntity getType(String value)
	{
		TypeEntity entity = new TypeEntity();
		entity.setTid(CommonUtil.uuid());
		String[] types = value.split("，");
		for (int i = 0; i < types.length; i++) {
			String type = types[i];
			if(type.equals( "物业")) { entity.setEatate(1); }
			if(type.equals("供暖")) { entity.setHeating(1); }
			if(type.equals("车补")) { entity.setCar(1); }
			if(type.equals("医保")) { entity.setHi(1); }
			if(type.equals("养老保险")) { entity.setEi(1); }
			if(type.equals("养老失业")) { entity.setUnemp(1); }
			if(type.equals("职业年金")) { entity.setOa(1); }
			if(type.equals("工伤生育")) { entity.setOibirth(1); }
		}
		return entity;
	}
}
