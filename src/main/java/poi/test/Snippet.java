package poi.test;

import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Snippet {
	public static void main(String[] args) throws Exception {
	  Workbook workbook = new XSSFWorkbook();
	  Sheet sheet = workbook.createSheet();
	
	  //create at least one cell so print preview is possible
	  sheet.createRow(0).createCell(0).setCellValue("Cell A1");
	
	  //set page setup to fit to one page width but multiple pages height
	  sheet.setFitToPage(true);
	  sheet.getPrintSetup().setFitWidth((short)1);
	  sheet.getPrintSetup().setFitHeight((short)0);
	
	  FileOutputStream fileOut = new FileOutputStream("PrintSetupFitWidth.xlsx");
	  workbook.write(fileOut);
	  fileOut.close();
	 }
	}
