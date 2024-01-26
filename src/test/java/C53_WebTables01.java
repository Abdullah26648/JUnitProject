import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class C53_WebTables01 extends TestBase {
/*
    <table>, bir web tablosunu tanımlamak için kullanılan HTML etiketidir.
    Tablonun başlığını tanımlamak için <th> kullanılırken,
    web tablosu için sırasıyla satırları ve sütunları tanımlamak için <tr> ve <td> etiketleri kullanılır.

    table//tbody//tr ➡ tbody içindeki tüm satırları döndürür.
    table//tbody//tr[1] ➡ tbody'deki ilk satırı döndürür.
    table//tbody//tr[1]//td ➡ İlk satırdaki tüm tablo hücrelerini döndürür.
    table//tbody//tr[1]//td[4] ➡ tbody'deki ilk satırdaki 4. hücreyi döndürür.
    table//tbody//tr[4]//td[5] ➡ 4. satır 5. sütun
    table//tbody//tr[10]//td[2] ➡ Satır 10'daki 2. sütun
    table//tbody//tr//td[5] ➡ 5. sütundaki tüm satırları döndürür.
*/

    //Go to URL: http://demo.guru99.com/test/web-table-element.php
    //To find third row of table
    //To get 3rd row's 2nd column data
    //Get all the values of a Dynamic Table
    @Test public void webTableTest() {

        //Go to URL: http://demo.guru99.com/test/web-table-element.php

        driver.get("http://demo.guru99.com/test/web-table-element.php");

        //To find third row of table

        WebElement row3 = driver.findElement(By.xpath("(//table/tbody/tr)[4]"));
        System.out.println("row3: " + row3.getText());

        //To get 3rd row's 3rd column data

        WebElement row3column2 = driver.findElement(By.xpath("(//table/tbody/tr)[4]/td[3]"));
        System.out.println("row3column2: " + row3column2.getText());

        //Get all the values of a Dynamic Table

        List<WebElement> table = driver.findElements(By.xpath("//tr"));
        for (int i = 1; i < table.size(); i++) {
            System.out.println("Row"+i+" : "+table.get(i).getText());
        }

    }

}
