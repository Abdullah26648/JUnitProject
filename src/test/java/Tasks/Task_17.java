package Tasks;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class Task_17 {
    /*
    Create a reusable method to assert a String exists in an Excel column.
    */

    @Test
    public void Task_17() {

        assertTrue(
                assertStringExistsInColumnAndRow(
                        System.getProperty("user.dir") + "\\resources\\Capitals.xlsx"
                        , "Sheet1"
                        ,0
                        ,5));

    }

    public boolean assertStringExistsInColumnAndRow
            (String filePath, String sheetName, int columnIndex, int rowIndex) {

        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             Workbook workbook = WorkbookFactory.create(fileInputStream)) {

            Sheet sheet = workbook.getSheet(sheetName);

            if (sheet != null) {
                Row row = sheet.getRow(rowIndex);

                if (row != null) {
                    Cell cell = row.getCell(columnIndex);

                    if (cell != null) {
                        String cellValue = cell.getStringCellValue();
                        System.out.println(cellValue); // Optional
                        return true;
                    } else {
                        System.out.println("Cell at columnIndex: " + columnIndex + " is null in the specified row.");
                    }
                } else {
                    System.out.println("Row at rowIndex: " + rowIndex + " is null in the Excel sheet.");
                }
            } else {
                System.out.println("Sheet '" + sheetName + "' not found in the Excel file.");
            }

        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

        return false;
    }

}
