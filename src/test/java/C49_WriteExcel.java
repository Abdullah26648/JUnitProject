import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C49_WriteExcel {
/*
    Create an object of File class to open xlsx file.
    Create an object of FileInputStream class to read excel file.
    Creating workbook instance that refers to .xlsx file.
    Creating a Sheet object.
    Create a row object to retrieve row at index 3.
    Create a cell object to enter value in it using cell Index.
    Write the data in excel using output stream.
*/

    @Test
    public void writeExcelTest() throws IOException {

//        Create an object of FileInputStream class to read excel file.
        String filePath = System.getProperty("user.dir")+"\\resources\\Capitals.xlsx";
        FileInputStream fileInputStream = new FileInputStream(filePath);

//        Creating workbook instance that refers to .xlsx file.
        Workbook workbook = WorkbookFactory.create(fileInputStream);

//        Creating a Sheet object.
        Sheet yeniSayfa = workbook.createSheet("Yeni Sayfa");

//        Create a row object to retrieve row at index 3.
        Row row4 = yeniSayfa.createRow(3);//3. indekte bir satır oluştu

//        Create a cell object to enter value in it using cell Index.
        row4.createCell(5).setCellValue("Hello");


//        Write the data in excel using output stream.
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);

        workbook.write(fileOutputStream);

    }

}