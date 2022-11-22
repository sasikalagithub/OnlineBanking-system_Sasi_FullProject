package Practice_package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Reading_Data_From_Excel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\Excel.xlsx");
        Workbook wb = WorkbookFactory.create(fi);
       String value = wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue(); 
      // Sheet sh = wb.getSheet("Sheet1");
      // Row ro = sh.getRow(1);
      // Cell c = ro.getCell(1);
      // String value = c.getStringCellValue();
       System.out.println(value);
	}

}
