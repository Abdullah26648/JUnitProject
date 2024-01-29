package Tasks;

import Utilities.TestBase;
import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class Task_25 extends TestBase {
    //Write the sum of numbers in columns 'number1' and 'number2' into the 'sum' column using a loop.

    @Test
    public void Task_25() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "\\resources\\Addition.xlsx");
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        Sheet addition = workbook.getSheet("Numbers");

        for (int i = 1; i <= 7; i++){
            String row1 = addition.getRow(i).getCell(0).toString();
            String row2 = addition.getRow(i).getCell(1).toString();
            String sum = add(row1, row2);
            addition.getRow(i).createCell(2).setCellValue(sum);
        }

    }

    public String add(String number1, String number2) {
        double result = Double.parseDouble(number1) + Double.parseDouble(number2);
        return String.valueOf(result);
    }

}
