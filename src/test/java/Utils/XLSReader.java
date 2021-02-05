package Utils;

import java.awt.Font;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSReader 
{
	public String path;
	public FileInputStream fis=null;
	public XSSFWorkbook workbook=null;
	public XSSFSheet sheet=null;
	public XSSFRow row=null;
	public XSSFCell cell=null;
	public FileOutputStream fos=null;

	public XLSReader(String path)
	{
		this.path=path;
		try 
		{
			fis = new FileInputStream(path);
			workbook=new XSSFWorkbook(fis);
			sheet=workbook.getSheetAt(0);

		} 
		catch (IOException e) 
		{
			System.out.println(e.getMessage());
		}
	}

	public int getRowCount(String sheetname)
	{
		int index=workbook.getSheetIndex(sheetname);
		if(index==-1)
		{
			return 0;
		}
		else
		{
			sheet=workbook.getSheetAt(index);
			int num = sheet.getLastRowNum()+1;
			return num;
		}
	}

	public String getCellData(String sheetname, int rownum,int colnum)
	{
		if(rownum<=0)
		{
			return "";
		}
		int index=workbook.getSheetIndex(sheetname);
		if(index==-1)
		{
			return "";
		}
		sheet=workbook.getSheetAt(index);
		row=sheet.getRow(rownum-1);
		if(row==null)
			return"";

		cell=row.getCell(colnum-1);
		if(cell==null)
			return"";

		if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC)
		{
			String celltext =String.valueOf(cell.getNumericCellValue());
			return celltext;
		}
		else
			return cell.getStringCellValue();
	}

	public String getCellData(String sheetname, int rownum,String colname)
	{
		if(rownum<=0)
			return"";

		int index=workbook.getSheetIndex(sheetname);
		if(index==-1)
			return"";

		sheet=workbook.getSheetAt(index);
		int colnum=-1;
		row = sheet.getRow(0);
		for(int i=0;i<row.getLastCellNum();i++)
		{
			if(row.getCell(i).getStringCellValue().trim().equals(colname.trim()))
			{
				colnum=i;
			}
		}

		if(colnum==-1)
			return"";

		row=sheet.getRow(rownum-1);
		if(row==null)
			return"";

		cell=row.getCell(colnum);
		if(cell==null)
			return"";

		if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC)
		{
			String celltext =String.valueOf(cell.getNumericCellValue());
			return celltext;
		}
		else
			return cell.getStringCellValue();
	}

	public boolean setCellData(String sheetname,int rownum,String colname,String value)
	{

		try 
		{
			fis=new FileInputStream(path);
			workbook=new XSSFWorkbook(fis);
			int colnum=-1;

			if(rownum<=0)
				return false;

			int index=workbook.getSheetIndex(sheetname);
			if(index==-1)
				return false;

			sheet=workbook.getSheetAt(index);
			row=sheet.getRow(0);

			for(int i=0;i<row.getLastCellNum();i++)
			{
				if(row.getCell(i).getStringCellValue().trim().equals(colname.trim()))
				{
					colnum=i;
				}
			}
			if(colnum==-1)
				return  false;

			sheet=workbook.getSheetAt(index);
			row=sheet.getRow(rownum-1);
			if(row==null)
				return false;

			cell=row.getCell(colnum);
			if(cell==null)
			{
				cell=row.createCell(colnum);
			}

			cell.setCellValue(value);

			XSSFCellStyle style = workbook.createCellStyle();
			//org.apache.poi.ss.usermodel.Font font= (org.apache.poi.ss.usermodel.Font) new Font("Noto Sans CJK JP DemiLight", Font.CENTER_BASELINE, 10);
			//style.setFont(font);
			style.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			style.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			style.setBorderRight(XSSFCellStyle.BORDER_THIN);
			style.setBorderTop(XSSFCellStyle.BORDER_THIN);
				
			cell.setCellStyle(style);
			
			fos=new FileOutputStream(path);
			workbook.write(fos);
			fos.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public int getColumnCount(String sheetname)
	{
		if(isSheetExist(sheetname)==false)
		{
			return -1;
		}

		sheet=workbook.getSheet(sheetname);
		row=sheet.getRow(0);

		if(row==null)
			return -1;

		return row.getLastCellNum();

	}

	public boolean isSheetExist(String sheetname)
	{
		int index = workbook.getSheetIndex(sheetname);
		if(index==-1)
		{
			return false;
		}
		else
			return true;
	}
	public int getCellRowNum(String sheetName,String colName,String cellValue)
	{

		for(int i=2;i<=getRowCount(sheetName);i++)
		{
			if(getCellData(sheetName,i,colName).equalsIgnoreCase(cellValue)){
				return i;
			}
		}
		return -1;

	}

	public boolean addColumn(String sheetName, String colName)
	{
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			int index = workbook.getSheetIndex(sheetName);
			if(index==-1)
				return false;

			XSSFCellStyle style = workbook.createCellStyle();
			style.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			style.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			style.setBorderRight(XSSFCellStyle.BORDER_THIN);
			style.setBorderTop(XSSFCellStyle.BORDER_THIN);
			//style.setFillForegroundColor(XSSFColor.class.index);
			//style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			sheet=workbook.getSheetAt(index);
			row = sheet.getRow(0);
			if (row == null)
				row = sheet.createRow(0);
			if(row.getLastCellNum() == -1)
				cell = row.createCell(0);
			else
				cell = row.createCell(row.getLastCellNum());

			cell.setCellValue(colName);
			cell.setCellStyle(style);

			fos = new FileOutputStream(path);
			workbook.write(fos);
			fos.close();	
		} 
		catch (IOException e) 
		{	
			e.printStackTrace();
		}
		return false; 


	}

}