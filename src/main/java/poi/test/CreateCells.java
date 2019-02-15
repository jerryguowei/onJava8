package poi.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.hssf.record.Margin;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.PageOrder;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.DefaultIndexedColorMap;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFPrintSetup;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class CreateCells {

	public static void main(String[] args) {

		String path = "C:" + File.separator + "temp" + File.separator + "workbook.xls";
		
		createDiffCells(path);
		
	}
	
	public static void createDiffCells(String path) {
		Workbook wb = new HSSFWorkbook();  //new XSSFWorkbook();
		Sheet sheet = wb.createSheet("new Sheet");
		Row row = sheet.createRow(2);
		row.createCell(0).setCellValue(2);
		sheet.setMargin(Sheet.BottomMargin, 6);
//		row.createCell(1).setCellValue(1.1);
//		row.createCell(2).setCellValue(Calendar.getInstance());
//		row.createCell(3).setCellValue("a String");
//		row.createCell(4).setCellValue(true);
//		row.createCell(5).setCellType(CellType.NUMERIC);
//		System.out.println(sheet.getFitToPage());

//		sheet.getPrintSetup().setDraft(true);  // Draft quanlity
//		sheet.getPrintSetup().setNoColor(true); //black and white
//		((XSSFPrintSetup) sheet.getPrintSetup()).setPageOrder(PageOrder.DOWN_THEN_OVER);
//		sheet.getPrintSetup().setHResolution((short)1200);
	
//		sheet.getPrintSetup().setPaperSize(PrintSetup.LETTER_PAPERSIZE);
//		
//		wb.setPrintArea(0, "$A$1:$J$7");
//		sheet.getPrintSetup().setUsePage(true);
		//sheet.getPrintSetup().setPageStart((short)4);
//		
//		sheet.setPrintGridlines(true);
//		sheet.setPrintRowAndColumnHeadings(true); //
//		sheet.setRepeatingRows(CellRangeAddress.valueOf("1:1"));
//		
//		sheet.setRepeatingColumns(CellRangeAddress.valueOf("A:B"));
		
//		sheet.getPrintSetup().setLandscape(true);
//		sheet.getPrintSetup().setLandscape(false);

		
//		sheet.getPrintSetup().setScale((short)80);		
//		sheet.getPrintSetup().setFitHeight((short)7);
//		sheet.getPrintSetup().setFitWidth((short) 2) ;
//		sheet.setFitToPage(true);
		

//		sheet.setFitToPage(false);
		sheet.setAutobreaks(true);
		System.out.println(sheet.getFitToPage());
//		sheet.setMargin(Sheet.TopMargin,8/2.54);
		//sheet.setVerticallyCenter(true);  	
		//sheet.setHorizontallyCenter(true);
//		sheet.getPrintSetup().setLeftToRight(false);
//		sheet.getPrintSetup().setLandscape(true);

		try(OutputStream fileout = new FileOutputStream(path)){
			wb.write(fileout);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	public static void createDateCell(String path) {
		
		Workbook workBook  = new HSSFWorkbook();
		CreationHelper createHelper = workBook.getCreationHelper();
		Sheet sheet = workBook.createSheet("first sheet");
		
		Row row1 = sheet.createRow(0);
		Cell cell1 = row1.createCell(0);
		
		cell1.setCellValue(new Date());
		
		CellStyle cellStyle = workBook.createCellStyle();
		cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("yyyy/MM/dd hh:mm:ss"));
		cell1.setCellStyle(cellStyle);
		
		Font font =workBook.createFont();
			font.setColor(IndexedColors.PALE_BLUE.getIndex());
			cellStyle.setFont(font);
		    cellStyle.setFillForegroundColor(HSSFColorPredefined.GOLD.getIndex());
		    cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

			
		
		try(FileOutputStream fileOpt =  new FileOutputStream(new File(path))){
			workBook.write(fileOpt);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static HSSFColor setColor(HSSFWorkbook workbook, byte r, byte g, byte b){
		HSSFPalette palette = workbook.getCustomPalette();
		HSSFColor hssfColor = new HSSFColor();
		try{
			hssfColor = palette.findColor(r, g, b);
			if (hssfColor == null){
				palette.setColorAtIndex(HSSFColorPredefined.LAVENDER.getIndex(), r, g, b);
				hssfColor = palette.getColor(HSSFColorPredefined.LAVENDER.getIndex());
			}
		} catch (Exception e){
		}

		return hssfColor;
	}

}
