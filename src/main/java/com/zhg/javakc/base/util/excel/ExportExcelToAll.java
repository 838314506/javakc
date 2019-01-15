package com.zhg.javakc.base.util.excel;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

/**
 * 文件导出工具类
 * 
 * @author lzz
 *
 * @param <T>
 */
//此注解用于标识该类为一个组件，可作为表现层，逻辑层或数据层
@Component
public class ExportExcelToAll<T> extends AbstractXlsxView {

	@Override
	public void buildExcelDocument(Map<String, Object> data, Workbook workbook,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		response.reset();
		response.setContentType("APPLICATION/vnd.ms-excel");
		response.setHeader("Content-Disposition",
				"attachment;filename=\"" + getFileName() + ".xls" + "\"");

		// 设置字体
		HSSFFont font = (HSSFFont) workbook.createFont();
		font.setFontHeightInPoints((short) 10); // 字体高度
		// font.setColor(HSSFFont.COLOR_RED); //字体颜色
		font.setFontName("黑体"); // 字体
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); // 宽度

		// 设置单元格类型样式
		HSSFCellStyle cellStyle = (HSSFCellStyle) workbook.createCellStyle();
		cellStyle.setFont(font);
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 水平布局：居中
		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);// 带边框
		cellStyle.setWrapText(true);
		cellStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);// 行底色
		cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

		HSSFCellStyle cellStyle2 = (HSSFCellStyle) workbook.createCellStyle();
		cellStyle2.setAlignment(HSSFCellStyle.ALIGN_LEFT); // 水平布局：居左
		cellStyle2.setWrapText(true);

		List<String[]> list = (List<String[]>) data.get("list");
		int max = (int)Math.ceil(list.size()*1.0/10);//最大页数
		int other = list.size()%10;//最后几条
		// 向表单元中创建表格标题行
		for(int h = 0 ; h < max ; h++) {
			// 首先创建一个表单元
			HSSFSheet sheet = (HSSFSheet) workbook.createSheet("sheet"+h);
			
			HSSFRow headerRow = sheet.createRow((short) 0);
			String[] array = (String[]) data.get("title");
			for (int i = 0; i < array.length; i++) {
				headerRow.createCell(i).setCellValue(array[i]);
			}
		// 向表格中添加数据,并设置第个单元中只显示10行
			int rownum = 1;
			int end = (h+1)*10;
			if(h == (max-1)) {
				end = list.size();
			}
			for (int i = h*10; i < end; i++) {
				HSSFRow row = sheet.createRow(rownum++);
				String[] elements = list.get(i);
				row.createCell(0).setCellValue(rownum-1);
				for (int j = 0; j < elements.length; j++) {
					row.createCell(j+1).setCellValue(elements[j]);
				}
			}
		}
		OutputStream os = response.getOutputStream();
		workbook.write(os);
		os.flush();
		os.close();

	}
	
	/**
	 * 向用户返回文件时显示的文件名方法
	 * @return
	 */
	protected String getFileName() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		return format.format(date);
	}

}