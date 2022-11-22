package Practice_package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Write_Data_To_Excel_1 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\Excel.xlsx");
        Workbook wb = WorkbookFactory.create(fi);
        wb.getSheet("Sheet1").createRow(7).createCell(1).setCellValue("1234 5674 12341");
        FileOutputStream f=new FileOutputStream(".\\src\\test\\resources\\Excel.xlsx");
        wb.write(f);
        //wb.getSheet("Sheet1").createRow(7).createCell(1).setCellValue("1234 5674 12341");
	
	}
	

}
