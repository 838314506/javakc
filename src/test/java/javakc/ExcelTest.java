package javakc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTest {
	public static void main(String[] args) throws IOException {
		String[][] excel = getExcel("C:\\Users\\lzz\\Desktop\\import.xlsx");
		for (int i = 0; i < excel.length; i++) {
			for (int j = 0; j < excel[i].length; j++) {
				System.out.print(excel[i][j]);
			}
			System.out.println();
		}
	}

	public static String[][] getExcel(String path) throws IOException{
				String[][] excel = null;
				//1.获取文件
					//1.1得到文件
				File excelFile = new File(path);
					//1.2将文件转换为流
				InputStream input = new FileInputStream(excelFile);
					//1.3通过apache-poi这个工具来处理得到的表格文档，apache-poi专业处理office的工具，没有之一，最强大的部分就是表格
				Workbook workbook = null;
				if(excelFile.getName().endsWith(".xlsx")) {
					workbook = new XSSFWorkbook(input);
				}else {
					workbook = new HSSFWorkbook(input);
				}
				//2.将文件以流的形式读到以后进行解析
					//2.1首先得到sheet数量
				int sheetNumber = workbook.getNumberOfSheets();
				for(int i = 0 ; i < sheetNumber;i++) {
					//2.1.1得到每一个sheet对象
					Sheet sheet = workbook.getSheetAt(i);
					System.out.println(sheetNumber);
					//2.1.2通过sheet对象得到行数
					int rowNum = sheet.getPhysicalNumberOfRows();
					Row row2 = sheet.getRow(0);
					int cellNum = row2.getPhysicalNumberOfCells();
					
					excel = new String[rowNum-1][cellNum];
					
					for(int j = 1 ; j < rowNum;j++) {
						//2.1.3通过row对象得到列数
						Row row = sheet.getRow(j);
						for(int k = 0;k < cellNum;k++) {
							Cell cell = row.getCell(k);
							System.out.println(getValueByCell(cell));
							excel[j-1][k] = getValueByCell(cell);
						}
					}
				}
			return excel;
	}
	public static String getValueByCell(Cell cell) {
		String value="";
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_NUMERIC:
			if(
					cell.getCellStyle().getDataFormatString().equals("yyyy/mm/dd")
					||
					cell.getCellStyle().getDataFormatString().equals("m/d/yy")
					||
					cell.getCellStyle().getDataFormatString().equals("mm/dd/yy")
			  ) 
			{
				value=new SimpleDateFormat().format(cell.getDateCellValue());
			}else {
				value=String.valueOf(cell.getNumericCellValue());
			}
			break;
		case Cell.CELL_TYPE_STRING:
			value=cell.getStringCellValue();
			break;
		case Cell.CELL_TYPE_BOOLEAN:
			value=String.valueOf(cell.getBooleanCellValue());
			break;
		case Cell.CELL_TYPE_BLANK:
			value="";
			break;
		}
		return value;
	}
}
