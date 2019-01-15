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

public class ExcelParse {
	
	public static void main(String[] args) throws IOException {
		//1.获取Excel文档
		String path = "C:\\Users\\thinkpad\\Desktop\\work.xlsx";
		File file = new File(path);
		
		String[][] arr = getData(file);
		for(String[] arr1:arr)
		{
			for(String str:arr1)
			{
				System.out.print(str+"     ");
			}
			System.out.println();
		}
	}
	
	public static String[][] getData(File file) throws IOException
	{
		String[][] arr = null;
		//1.获取excel文档
		InputStream input = new FileInputStream(file);
		Workbook wookbook = null;
		if( file.getName().endsWith("xls")  )
		{
			wookbook = new HSSFWorkbook(input);
		}
		else if( file.getName().endsWith("xlsx")  )
		{
			wookbook = new XSSFWorkbook(input);
		}
		//2.获取Sheet
		int sheetNum = wookbook.getNumberOfSheets();
		for(int i=0;i<sheetNum;i++)
		{
			Sheet sheet = wookbook.getSheetAt(i);
			//3.获取Row
			int rowsNum = sheet.getPhysicalNumberOfRows();
			int cellsNum = sheet.getRow(0).getPhysicalNumberOfCells();
			//声明二维数组
			arr = new String[rowsNum-1][cellsNum];
			for(int j=1;j<rowsNum;j++)
			{
				Row row = sheet.getRow(j);
				for(int k=0;k<cellsNum;k++)
				{
					Cell cell = row.getCell(k);
					int a = j-1;
					arr[a][k] = getValueByCellType(cell);
				}
			}
		}
		return arr;
	}
	
	/**
	 * 根据单元内数据类型进行判断， 返回相应的值
	 * @param cell
	 * @return
	 */
	public static String getValueByCellType(Cell cell)
	{
		String cellValue = "";
		switch(cell.getCellType())
		{
			case Cell.CELL_TYPE_NUMERIC://数字类型 包含（2018-03-07日期     100.00数字）
				if(
						cell.getCellStyle().getDataFormatString().equals("yyyy/mm/dd")
						||
						cell.getCellStyle().getDataFormatString().equals("m/d/yy")
						||
						cell.getCellStyle().getDataFormatString().equals("mm/dd/yy")
					)
				{
					cellValue = new SimpleDateFormat("yyyy/MM/dd").format( cell.getDateCellValue() );
				}
				else
				{
					cellValue = String.valueOf( cell.getNumericCellValue() );
				}
				break;
			case Cell.CELL_TYPE_STRING:
				cellValue = cell.getStringCellValue();
				break;
			case Cell.CELL_TYPE_BOOLEAN:
				cellValue = String.valueOf( cell.getBooleanCellValue() );
				break;
			case Cell.CELL_TYPE_BLANK:
				cellValue = "";
				break;
		}
		return cellValue;
	}
	
	
}
