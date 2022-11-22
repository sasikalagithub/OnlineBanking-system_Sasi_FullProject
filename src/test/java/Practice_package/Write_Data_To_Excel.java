package Practice_package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Write_Data_To_Excel {

	public static void main(String[] args) throws IOException {
		FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\Excel.xlsx");
        Workbook wb = WorkbookFactory.create(fi);
        
       Sheet sh = wb.getSheet("Sheet1");
       Row ro = sh.createRow(2);
       Cell c = ro.createCell(1);
       c.setCellValue("1011 7310 11536");
        
       FileOutputStream fi1=new FileOutputStream(".\\src\\test\\resources\\Excel.xlsx");      
        wb.write(fi1);

	}

}
