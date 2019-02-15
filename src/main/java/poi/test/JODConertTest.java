package poi.test;

import java.io.File;

import org.jodconverter.DocumentConverter;
import org.jodconverter.office.LocalOfficeManager;
import org.jodconverter.office.OfficeException;
import org.jodconverter.office.OfficeManager;
import org.jodconverter.LocalConverter;


public class JODConertTest {

	public static void main(String[] args) {
		initConvert();
	}
		
	public static void initConvert() {
		
		File sourceFile = new File("C:" + File.separator + "temp" + File.separator + "test.docx");
		File targetFile = new File("C:" + File.separator + "temp" + File.separator + "test.pdf");
		
		OfficeManager officeManager = LocalOfficeManager.builder().officeHome("C:\\Program Files (x86)\\OpenOffice 4").build();
		DocumentConverter documentConverter = LocalConverter.make(officeManager);
		try {
			officeManager.start();
		} catch (OfficeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			documentConverter.convert(sourceFile).to(targetFile).execute();
		} catch (OfficeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				officeManager.stop();
			} catch (OfficeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	}

}
