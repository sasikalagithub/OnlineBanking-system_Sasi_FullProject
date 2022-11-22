package Practice_package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Reading_Multiple_Values_From_Excel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\Excel.xlsx");
        Workbook wb = WorkbookFactory.create(fi);
for(int i=1;i<=7;i++) {
		
String value = wb.getSheet("Sheet1").getRow(i).getCell(1).getStringCellValue(); 
System.out.println(value);
}
	}
}
