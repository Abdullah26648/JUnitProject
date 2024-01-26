import com.github.javafaker.Faker;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C50_WriteExcelFirstnameLastname {

    //Create Firstname and Lastname Columns and write names in a new sheet

    @Test
    public void writeExcelTest() throws IOException {
        String filePath = System.getProperty("user.dir")+"\\resources\\Capitals.xlsx";
        FileInputStream fileInputStream = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        //Yeni sayfa oluştur
        Sheet fnameLname = workbook.createSheet("Firstname Lastname");
        //Satır ve sütunları oluştur
        Row row1 = fnameLname.createRow(0);
        row1.createCell(0).setCellValue("Firstname");
        row1.createCell(1).setCellValue("Lastname");

        Row row2 = fnameLname.createRow(1);
        row2.createCell(0).setCellValue("Ali");
        row2.createCell(1).setCellValue("Can");

        //Kalan 99 ismi loop ile yazalım
        for (int i = 2; i<100; i++){
            fnameLname.createRow(i).createCell(0).setCellValue(Faker.instance().name().firstName());
            fnameLname.getRow(i).createCell(1).setCellValue(Faker.instance().name().lastName());
        }


        workbook.write(new FileOutputStream(filePath));

        //Ödev: Adres sütunu ekleyip her kişiye adres giriniz




    }

}