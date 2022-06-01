package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import pageObjects.LoginElements;

public class ReadXLSData {
	public static  Logger	log = LogManager.getLogger(LoginElements.class.getName());
		
	public String[][] getData(String xlsheetname) throws IOException
	{
		FileInputStream fi = new FileInputStream(System.getProperty("user.dir")+"\\resources\\data.xlsx");
	Workbook wb	= WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(xlsheetname);
		log.info("Sheet name is:"+ xlsheetname);
		int norows = sh.getLastRowNum();
		//System.out.println("Total Rows :"+norows);
		log.info("Total Rows :"+norows);
	Row row	= sh.getRow(0);
		
		  int nocols =  row.getLastCellNum();
		  log.info("Total Columns :"+nocols);
		  //System.out.println("Total Columns :"+nocols);
		  
		  DataFormatter dformat = new DataFormatter();
		  
		  String data[][] = new String[norows][nocols];
		  
		  for(int i=1;i<=norows;i++)
		  {
			  for(int j=0;j<nocols;j++)
			  {
				 data[i-1][j] = dformat.formatCellValue(sh.getRow(i).getCell(j));
				// System.out.println(data[i-1][j]);
				// log.info("Excel data :"+data[i-1][j]);
			  }
		  }
		  
		  return data;
	}

}

