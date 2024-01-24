import Utilities.TestBase;
import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class C48_ApachePoiReadExcel extends TestBase {
//Workbook → Excel dosyası.
//Sheet → Excel çalışma sayfası (Sheet1, Sheet2, vb.).
//Row (Satır) → Java, yalnızca içinde veri bulunan satırları sayar.
//Cell (Hücre) → Java her satıra bakar ve yalnızca hücrede veri bulunuyorsa hücre sayısını sayar.

//Workbook (excel)> Worksheet (sheet)> Row (satır)> Cell (hücre) -> hiyerarşi

    // Add the excel file on the resources folder.
    // Open the file.
    // Open the workbook using file input stream.
    // Open the first worksheet.
    // Go to first row.
    // Go to first cell on that first row and print.
    // Go to second cell on that first row and print.
    // Go to 2nd row first cell and assert if the data equal to the USA.
    // Go to 3rd row and print 2nd cell
    // Find the number of used row.
    // Print country, capital value pairs as map object.
    // Verify that you have Canada on the list

    @Test
    public void readExcelTest() throws IOException {

        // Add the excel file on the resources folder.
        // Open the file.
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"\\resources\\Capitals.xlsx");

        // Open the workbook using file input stream.
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        // Open the first worksheet.
        Sheet sheet1 = workbook.getSheet("Sheet1");

        // Go to first row.
        Row row1 = sheet1.getRow(0);

        // Go to first cell on that first row and print.
        Cell row1cell1 = row1.getCell(0);
        System.out.println("row1cell1 = " + row1cell1);

        // Go to second cell on that first row and print.
        Cell row1cell2 = row1.getCell(1);
        System.out.println("row1cell2 = " + row1cell2);

        // Go to 2nd row first cell and assert if the data equal to the USA.
        Cell row2cell1 = sheet1.getRow(1).getCell(0);
        System.out.println("row2cell1 = " + row2cell1);
        assertEquals("USA", row2cell1.toString());

        // Go to 3rd row and print 2nd cell
        System.out.println("row3cell2: "+sheet1.getRow(2).getCell(1));

        // Find the number of used row.
        int lastRowNum = sheet1.getLastRowNum();
        System.out.println("lastRowNum = " + lastRowNum);//Son kullanılan satırın indeksi
        System.out.println("Kullanılan satır sayısı: "+(lastRowNum+1));

        //Sadece fiziki kullanılmış satır sayısı:
        int physicalNumberOfRows = sheet1.getPhysicalNumberOfRows();
        System.out.println("fiziki kullanılmış satır sayısı = " + physicalNumberOfRows);

        // Print country, capital value pairs as map object.
        Map<String, String> country_capital = new HashMap<>();

        for (int i = 1; i<=lastRowNum; i++){

            String country = sheet1.getRow(i).getCell(0).toString();
            String capital = sheet1.getRow(i).getCell(1).toString();

            country_capital.put(country, capital );
        }

        System.out.println("country_capital = " + country_capital);


        // Verify that you have Canada on the map
        assertTrue(country_capital.containsKey("Canada"));

        //Reusable metod ile Hücre değeri çağıralım:

        Cell cellValue = getCellValue("Capitals","Sheet1",6, 1 );
        System.out.println("cellValue = " + cellValue);

    }

}
