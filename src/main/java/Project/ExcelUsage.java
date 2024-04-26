package Project;
//Java Packages
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUsage {

	public static void Output(String out) throws IOException {
//	To store the result in excel sheet
		Workbook wb = new XSSFWorkbook();
		Sheet s = wb.createSheet("Output");
		Row r=s.createRow(0);
		Cell c=r.createCell(0);
		c.setCellValue(out);
		
		FileOutputStream f = new FileOutputStream(new File("./src/input.xlsx"));
		wb.write(f);
	}
//To get the input data from excel
	public static String getValue(int row,int cell) throws InvalidFormatException, IOException {
		Workbook wb = new XSSFWorkbook(new File("./src/GetInputData.xlsx"));
		Sheet s = wb.getSheetAt(0);
		return s.getRow(row).getCell(cell).getStringCellValue();		
		
	}

}
