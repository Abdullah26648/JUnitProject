package Tasks;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Task_16 {
    /*
    Create a reusable method to get an Excel column data as a list.
    */

    @Test
    public void Task_16() {

        System.out.println(getExcelColumnData(System.getProperty("user.dir") + "\\resources\\Capitals.xlsx", "Sheet1", 0));
    }

    public List<String> getExcelColumnData(String filePath, String sheetName, int columnIndex) {

        List<String> columnData = new ArrayList<>();

        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             Workbook workbook = WorkbookFactory.create(fileInputStream)) {

            Sheet sheet = workbook.getSheet(sheetName);

            if (sheet != null) {

                Iterator<Row> rowIterator = sheet.iterator();

                while (rowIterator.hasNext()) {
                    Row row = rowIterator.next();
                    Cell cell = row.getCell(columnIndex);

                    String cellValue = cell != null ? cell.toString() : "";
                    columnData.add(cellValue);
                }
            } else {
                System.out.println("Sheet '" + sheetName + "' not found in the Excel file.");
            }

        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

        return columnData;
    }
}
