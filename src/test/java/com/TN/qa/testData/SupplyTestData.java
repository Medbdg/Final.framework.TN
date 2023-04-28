package com.TN.qa.testData;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;


public class SupplyTestData {
	
    
	@DataProvider(name = "TNdataProviderSupply")
    public static Object [][] dataSupplyFrom2DimenalObjectArray() {
    	
    	Object[][] data = {{"med.boudguig@gmail.com", "Medbdg0707@"}};
    	
    	return data;
}
	@DataProvider(name = "TNExceldataWithDataProvider")
		
	public static Object[][] excelSheetDataSupply() throws Exception {
        Object[][] data = SupplyTestData.getTNtestDataFromExcelSheet("Login");
        return data;
	}

    public static Object[][] getTNtestDataFromExcelSheet(String LoginSheet) throws Exception {
    	
    	FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\com\\TN\\qa\\testData\\LoginSheet.xlsx");
        try (XSSFWorkbook workbook = new XSSFWorkbook (ip)) {
			XSSFSheet Sheet = workbook.getSheet(LoginSheet);
			int rows = Sheet.getLastRowNum();
			int cols = Sheet.getRow(0).getLastCellNum();
    
			Object [][] data = new Object [rows][cols];
			for(int i=0; i<rows; i++) {
			XSSFRow row = Sheet.getRow(i+1);
			for(int j=0; j<cols; j++) {
			XSSFCell cell = row.getCell(j);
			 CellType Cellype = cell.getCellType();
			
			switch(Cellype) {
			
			case STRING:
			data[i][j] = cell.getStringCellValue();
			    break;
			    
			case NUMERIC:
				data[i][j] = Integer.toString((int)cell.getNumericCellValue());
				break;
				
			case BOOLEAN: 
				data[i][j] = cell.getBooleanCellValue();
				break;
			default:
				break;
			}}}
			return data;
		}
     
}}
