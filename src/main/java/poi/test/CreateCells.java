package poi.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class CreateCells {

	public static void main(String[] args) {

		String path = "C:" + File.separator + "temp" + File.separator + "workbook.xls";
		Workbook workBook  = new HSSFWorkbook();
		CreationHelper createHelper = workBook.getCreationHelper();
		Sheet sheet = workBook.createSheet("first sheet");
		
		Row row1 = sheet.createRow(0);
		Cell cell1 = row1.createCell(0);
		
		cell1.setCellValue(new Date());
		
		CellStyle cellStyle = workBook.createCellStyle();
		cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("yyyy/MM/dd hh:mm:ss"));
		cell1.setCellStyle(cellStyle);
		
		Cell cell2 = row1.createCell(1);
		cell2.setCellValue(Calendar.getInstance());
		cell2.setCellStyle(cellStyle);
		
		Cell cell3 = row1.createCell(2);
		cell3.setCellValue(true);
		
		row1.createCell(3).setCellType(CellType.ERROR);
		
		try(FileOutputStream fileOpt =  new FileOutputStream(new File(path))){
			workBook.write(fileOpt);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
