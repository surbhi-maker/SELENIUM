package Class36;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcel2 {
	
	@Test
	public void readData() throws IOException{	
		//D:\Users\SKourav\copy\Training_Prac1\TestData
		
//		File src= new File(System.getProperty("user.dir")+"/TestData/Data.xlsx");
		FileInputStream fis = new FileInputStream(new File(System.getProperty("user.dir")+"/TestData/Data.xlsx"));
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sh1=workbook.getSheet("Login");
		XSSFRow r1 = sh1.getRow(0);
		XSSFCell c1 = r1.getCell(1);
		
		System.out.println(c1.getStringCellValue());
		
		System.out.println(workbook.getSheet("Login").getRow(1).getCell(1).getNumericCellValue());
		System.out.println(workbook.getSheet("UserDetails").getRow(1).getCell(1).getStringCellValue());
		
		workbook.close();
	}
}
