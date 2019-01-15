package com.zhg.javakc.modules.person.util;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.zhg.javakc.base.util.CommonUtil;
import com.zhg.javakc.base.util.excel.ImportExcelToAll;
import com.zhg.javakc.modules.person.entity.PersonEntity;
import com.zhg.javakc.modules.system.user.entity.UserEntity;

public class PersonUtil {
	public static List<PersonEntity> getExcel(CommonsMultipartFile loadfile,HttpServletRequest request) throws IOException, ParseException 
	{
		List<PersonEntity> list = new ArrayList<>();
		// 1.获取文件
		InputStream input = loadfile.getInputStream();
		Workbook workbook = null;
		if (loadfile.getOriginalFilename().endsWith(".xlsx")) {
			workbook = new XSSFWorkbook(input);
		} else {
			workbook = new HSSFWorkbook(input);
		}
		// 2.将文件以流的形式读到以后进行解析
		int sheetNumber = workbook.getNumberOfSheets();
		for (int i = 0; i < sheetNumber; i++) {
			Sheet sheet = workbook.getSheetAt(i);
			int rowNum = sheet.getPhysicalNumberOfRows();
			for (int j = 1; j < rowNum; j++) {
				Row row = sheet.getRow(j);
				int cellNum = row.getPhysicalNumberOfCells();
				PersonEntity entity = new PersonEntity();
				for (int k = 1; k < cellNum; k++) {
					Cell cell = row.getCell(k);
					String value = ImportExcelToAll.getValueByCell(cell);
					if(k == 1) {
						entity.setPname(value);
					}
					if(k == 2) {
						entity.setIdcard(value);
					}
					if(k == 3) {
						entity.setState(value == "离休"?1:2);
					}
					if(k == 4) {
						entity.setGrade(CommonUtil.getGrade(value));
					}
					if(k == 5) {
						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
						Date date = format.parse(value);
						entity.setTime(date);
					}
					if(k == 6) {
						double d = Double.valueOf(value);
						int heating=(int)d;
						entity.setHeating(heating);
					}
					if(k == 7) {
						double d = Double.valueOf(value);
						int eatate=(int)d;
						entity.setEatate(eatate);
					}
					if(k == 8) {
						entity.setRemarks(value);
					}
				}
				entity.setPid(CommonUtil.uuid());
				entity.setCreateDate(new Date());
				entity.setCreateUser(CommonUtil.getUserEntity());
				list.add(entity);
			}
		}
		return list;
	}
	/**
	 * 查询对象转换方法
	 * @param list
	 * @return
	 */
	public static List<String[]> convert(HttpServletRequest req,List<PersonEntity> list)
	{
		List<String[]> result = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			PersonEntity entity = list.get(i);
			String[] en = new String[8];
			en[0] = entity.getPname();
			en[1] = entity.getIdcard();
			en[2] = (entity.getState()==1?"离休":"退休");
			//得到数据字典处理状态和职级
			Map<String,Object> map1 = (Map<String, Object>)CommonUtil.getDictionary(req, "person_grade");
			en[3] = (String) map1.get(String.valueOf(entity.getGrade()));
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
			en[4] = format.format(entity.getTime());
			en[5] = String.valueOf(entity.getHeating());
			en[6] = String.valueOf(entity.getEatate());
			en[7] = entity.getRemarks();
			result.add(en);
		}
		return result;
	}
	
}

