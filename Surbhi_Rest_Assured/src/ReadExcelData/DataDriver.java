package ReadExcelData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class DataDriver {
	
	@Test
	public ArrayList<String> dataDriver(String testCaseName, String sheetName) throws IOException {
			
		ArrayList<String> a = new ArrayList<String>();
		//Step 1  D:\Users\SKourav\copy\Surbhi_Rest_Assured ==System.getProperty("user.dir")
		//D:\Users\SKourav\copy\Surbhi_Rest_Assured\resource\ExcelToRead.xlsx
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\resource\\ExcelToRead.xlsx");
		//Desktop\ExcelToRead.xlsx
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheets = workbook.getNumberOfSheets();  //All Sheet in the workbook
		
			for(int i =0 ; i<sheets;i++) {
				System.out.println("sheet names:"+ workbook.getSheetName(i));
				if(workbook.getSheetName(i).equalsIgnoreCase(sheetName)) {  //access the desired sheet
					System.out.println("sheet names testdata so go inside");
					XSSFSheet sheet = workbook.getSheetAt(i);	
					Iterator<Row> rows = sheet.rowIterator(); //sheet is a collection of row 
					Row firstrow = rows.next();		//first row and now find column "TestCases"
					
					Iterator<Cell> ce =firstrow.cellIterator(); //row is a collection of cell
					int index =0, column=0;
					while (ce.hasNext()) {
						Cell value = ce.next();
						if (value.getStringCellValue().equalsIgnoreCase("TestCases")) {
							column = index;
							break;
						}
						index++;
					}
					System.out.println("index for TestCases column :"+column);
					
					while(rows.hasNext()) {
						Row r = rows.next();
						if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName))
						{	
							//purchase row mila now get cells data of purchase row
							Iterator<Cell> cv =r.cellIterator();
							while(cv.hasNext()) {
								Cell cellValue = cv.next();
								if(cellValue.getCellType() == CellType.STRING) {
									a.add(cellValue.getStringCellValue());
								}else {
								String stringConvertedValue = 	NumberToTextConverter.toText(cellValue.getNumericCellValue());
									a.add(stringConvertedValue);
								}
									
								
							}
						}
					}
				}
				
			}
			return a;
			
	}
}
