package Selenium_Code_Chalange.Day3;

import Utilities.TestBase;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import junit.framework.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task_16_csv extends TestBase {
    /*
    - https://www.kitapyurdu.com/ sitesi açılır.
    - Ana sayfanın açıldığı kontrol edilir.
    - Ürün arama alanına “roman” yazılır ve klavyeden “enter” tuşuna basılır. (Ürün
      aranına yazılacak roman kelimesi csv uzantılı dosyadan okunması gerekmektedir.)

       <!-- https://mvnrepository.com/artifact/com.opencsv/opencsv -->
        <dependency>
            <groupId>com.opencsv</groupId>
            <artifactId>opencsv</artifactId>
            <version>5.6</version>
        </dependency>
    */
    @Test
    public void test01() throws IOException, CsvException {
        driver.get("https://www.kitapyurdu.com/");
        String title="Kitapyurdu, Kitapla buluşmanın en kolay yolu";
        Assert.assertTrue(driver.getTitle().equals(title));
        List<String>datas=csvReader("data.csv");
        for (int i = 0; i <datas.size() ; i++) {
            searchProduct(datas.get(i));
            Assert.assertTrue(driver.findElement(By.xpath("(//h1[@class='search-heading-title']//span)[2]")).getText().equals(datas.get(i)));
            driver.navigate().back();
        }
    }
    public void searchProduct(String word){
        driver.findElement(By.id("search-input")).sendKeys(word+ Keys.ENTER);
    }
    public List<String> csvReader(String path) throws IOException, CsvException {
        CSVReader reader = new CSVReader(new FileReader(path));
        String[] csvCell;
        List<String> values = new ArrayList<>();
        boolean firstLine = true;
        while ((csvCell = reader.readNext()) != null) {
            if (firstLine) {
                firstLine = false;
                continue;
            }
            String value = csvCell[0];
            values.add(value);
        }
        return values;
    }

}
