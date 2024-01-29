package Tasks;

import Utilities.TestBase;
import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Task_24 extends TestBase {
    //  Place the winners of the World Cup and the
    //  European Cup in two separate maps with their years.
    @Test
    public void Task_24() throws IOException {

        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "\\resources\\CupWinners.xlsx");

        Map<String, String> Years_Winners_WorldCup = new HashMap<>();
        Map<String, String> Years_Winners_EuropeanCup = new HashMap<>();

        Workbook workbook = WorkbookFactory.create(fileInputStream);

        Sheet WorldCup = workbook.getSheet("WorldCup");
        Sheet EuropeanCup = workbook.getSheet("EuropeanCup");

        int lastRowNum1 = WorldCup.getLastRowNum();
        int lastRowNum2 = EuropeanCup.getLastRowNum();


        for (int i = 1; i <= lastRowNum1; i++) {

            String country = WorldCup.getRow(i).getCell(0).toString();
            String capital = WorldCup.getRow(i).getCell(1).toString();

            Years_Winners_WorldCup.put(country, capital);
        }
        System.out.println(Years_Winners_WorldCup);

        for (int i = 1; i <= lastRowNum2; i++) {

            String country = EuropeanCup.getRow(i).getCell(0).toString();
            String capital = EuropeanCup.getRow(i).getCell(1).toString();

            Years_Winners_EuropeanCup.put(country, capital);
        }
        System.out.println(Years_Winners_EuropeanCup);
    }
}
