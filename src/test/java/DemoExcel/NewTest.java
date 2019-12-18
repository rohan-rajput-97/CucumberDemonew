package DemoExcel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class NewTest {
  @Test
  public void f() throws IOException {
	  
	  XSSFWorkbook xb = new XSSFWorkbook();
	  FileOutputStream out = new FileOutputStream(new File("demoRohan.xlsx"));
	  
	  xb.write(out);
	  out.close();
	  
	  System.out.println("File Created Successfully");
  }
  
  
}
