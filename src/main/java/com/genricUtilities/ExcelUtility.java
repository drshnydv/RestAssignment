package com.genricUtilities;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * its developed using Apache POi libraries , which used to handle Microsoft Excel sheet
 *
 */

public class ExcelUtility {
   /**
    *   its used to read the data from Excel-Workbook based on below 
    * @param sheetName
    * @param rowNum
    * @param celNum
    * @return String data
    * @throws Throwable
    */
	
	public String getExcelData(String sheetName , int rowNum , int celNum) throws Throwable  {
		FileInputStream fis = new FileInputStream(IConstants.EXCELPATH);
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(celNum).toString();
		return data;	
	}

}
