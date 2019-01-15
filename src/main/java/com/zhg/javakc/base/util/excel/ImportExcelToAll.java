package com.zhg.javakc.base.util.excel;

import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
/**
 * 表格导入工具类
 * @author lzz
 *
 */
public class ImportExcelToAll {
	/**
	 * 处理单元格类型方法
	 * @param cell
	 * @return
	 */
	public static String getValueByCell(Cell cell) {
		String value = "";
		if(cell == null) {
			return value;
		}
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_NUMERIC:
			if (	
					cell.getCellStyle().getDataFormatString().equals("yyyy/mm/dd")
					|| 
					cell.getCellStyle().getDataFormatString().equals("m/d/yy")
					|| 
					cell.getCellStyle().getDataFormatString().equals("mm/dd/yy")
			   ) 
			{
				value = new SimpleDateFormat().format(cell.getDateCellValue());
			} else {
				value = String.valueOf(cell.getNumericCellValue());
			}
			break;
		case Cell.CELL_TYPE_STRING:
			value = cell.getStringCellValue();
			break;
		case Cell.CELL_TYPE_BOOLEAN:
			value = String.valueOf(cell.getBooleanCellValue());
			break;
		case Cell.CELL_TYPE_BLANK:
			value = "";
			break;
		}
		return value;
		}
	
}
