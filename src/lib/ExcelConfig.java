package lib;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelConfig 
{

	XSSFWorkbook wb   = null;
	XSSFSheet   sheet = null;
	XSSFRow     row   =  null;
	Cell        cell  = null;
	Object[][]  Eobj;
	int        rowNUM = 0;
	int        TotalRow = 0;
	int        colNUM   = 0;
	
	
	public ExcelConfig(String Xpath)
	{
		try 
		{
			File src = new File(Xpath);
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
			
			if((src.isFile() & src.exists()))
			{
				System.out.println("File Exists!!");
			}
			
			else
			{
				System.out.println("File doesn't Exists!..Quitting the Program!");
				System.exit(0);
			}
			
		} 
		
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		
	
	}
	
	public Object[][] GetdataFromExcel(int sheetIndex) throws Exception
	{
	   sheet = wb.getSheetAt(sheetIndex);
	   TotalRow = sheet.getLastRowNum();
	   System.out.println(TotalRow);
	   Eobj = new Object[TotalRow+1][2];
	   
	 
	   Iterator<Row> rowIter = sheet.iterator();
	   
	   while(rowIter.hasNext())
	   {
		   row  = (XSSFRow) rowIter.next();
		   Iterator<Cell> cIter = row.iterator();
		   
		   while(cIter.hasNext())
		   {
			   cell = cIter.next();
			   
			   switch(cell.getCellType())
			   {
			       case Cell.CELL_TYPE_STRING:
			    	   Eobj[rowNUM][colNUM] = cell.getStringCellValue();
			    	   break;			    	   
			   }
			   colNUM++;
		   }
		   rowNUM++;
	   }
	   
	   wb.close();
	   return Eobj;
	}
	
}
