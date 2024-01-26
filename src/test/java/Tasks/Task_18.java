package Tasks;

import com.github.javafaker.Faker;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task_18 {
    /*
    Capitals excel dosyasındaki Firstname Lastname sayfasına Adres sütunu ekleyip her kişiye adres giriniz.
    */

    @Test public void Task_18() throws IOException {
        String filePath = System.getProperty("user.dir")+"\\resources\\Capitals.xlsx";
        FileInputStream fileInputStream = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        Sheet fnameLname = workbook.getSheet("Firstname Lastname");
        Row row1 = fnameLname.getRow(0);

        //Ödev: Adres sütunu ekleyip her kişiye adres giriniz

        row1.createCell(2).setCellValue("Address");

        for (int i = 1; i < 100; i++) {
            fnameLname.getRow(i).createCell(2).setCellValue(Faker.instance().address().fullAddress());
        }

        workbook.write(new FileOutputStream(filePath));

    }

}
