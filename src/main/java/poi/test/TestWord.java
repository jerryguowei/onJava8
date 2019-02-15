package poi.test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.model.StyleSheet;
import org.apache.poi.hwpf.usermodel.CharacterRun;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.ParagraphProperties;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.hwpf.usermodel.Table;

public class TestWord {

	public static void main(String[] args) throws IOException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		String path = "C:" + File.separator + "temp" + File.separator + "test.doc";
		
		String pathOut =  "C:" + File.separator + "temp" + File.separator + "test1.doc";
		
		OutputStream out = new FileOutputStream(new File(pathOut));
		
		InputStream is = new FileInputStream(new File(path));
		HWPFDocument hwpfDocument = new HWPFDocument(is);
		
		//OLD METHOD
//		Range range = hwpfDocument.getRange();
//		ParagraphProperties pprops = new ParagraphProperties();
//		Paragraph p1 = range.insertBefore(pprops, StyleSheet.NIL_STYLE);
//		p1.insertBefore("*** VOID – FOR REFERENCE ONLY***");
//		CharacterRun run =  p1.getCharacterRun(0);
		
		//=======================
		
		//===My solution=====
//		Range range = hwpfDocument.getRange();
//		ParagraphProperties pprops = new ParagraphProperties();
//		Method getMapMethod = Range.class.getDeclaredMethod("insertBefore",ParagraphProperties.class, int.class);
//		getMapMethod.setAccessible(true);
//		Paragraph p1 = (Paragraph) getMapMethod.invoke(range, pprops,StyleSheet.NIL_STYLE);
//		p1.insertBefore("*** VOID – FOR REFERENCE ONLY***");
//		CharacterRun run =  p1.getCharacterRun(0);
		//my solution========
		
		
		Range range = hwpfDocument.getRange();
//		Table table = range.insertTableBefore((short)1, 1);
		CharacterRun run =range.insertBefore("hello");
//		CharacterRun run = table.insertBefore("*** VOID – FOR REFERENCE ONLY***");
		
		run.setBold(true);
		run.setColor(6);
		run.setFtcAscii(5);
		run.setFtcOther(5);
		run.setFontSize(24);
		hwpfDocument.write(out);
		out.close();
//		hwpfDocument.close();
		try {
		hwpfDocument.write(out);
		out.close();
//		hwpfDocument.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
