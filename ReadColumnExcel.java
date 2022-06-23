package week6.day2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadColumnExcel {

	public static String[][] readData(String fName) throws IOException {
		// Step1:Path of the excel file
		File file = new File("./data/"+fName+".xls");
		FileInputStream fis = new FileInputStream(file);

		HSSFWorkbook wb = new HSSFWorkbook(fis);
		
		//Step2:Look for the specific sheet
		HSSFSheet ws = wb.getSheet("Sheet1");
		
		//to get no. of rows.This excludes the header
		int rowCount = ws.getLastRowNum();
		
		//Get the physical number of rows.
		int physicalNumberOfRows = ws.getPhysicalNumberOfRows();
		
		/*for(int i=1;i<rowCount;i++) {
			String data = ws.getRow(i).getCell(0).getStringCellValue();
			System.out.println(data);
		}*/
		//To get the no. of cell
		int cellCount = ws.getRow(0).getLastCellNum();
		
		String[][] data = new String[rowCount][cellCount];
		
		//Printing the whole table
		for(int i=1;i<=rowCount;i++) {
			for(int j=0;j<cellCount;j++ ) {
				data[i-1][j] = ws.getRow(i).getCell(j).getStringCellValue();
			System.out.println(data);
			}
		}
		
		//step3:get intto the respective row.
		//HSSFRow row = ws.getRow(1);
		
		//step4:get into the respective column
		//HSSFCell cell = row.getCell(0);
		//step5:read the data
		//String data = cell.getStringCellValue();
		//System.out.println(data);
		
		//close the Excel file
		wb.close();
		return data;
	}

}
