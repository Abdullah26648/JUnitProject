import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class C54_WebTables02 extends TestBase {
    //Go to URL: http://demo.guru99.com/test/web-table-element.php
//To find first row of table
//To get 3rd row's 3rd column data
//Get all the values of a Dynamic Table

    @Test//Bir web table'ı locate edip içindeki row ve cell değerlerine bu web element ile ulaşabiliriz
    public void webTableTest(){
        //Go to URL: http://demo.guru99.com/test/web-table-element.php
        driver.get("http://demo.guru99.com/test/web-table-element.php");

        //To find first row of table
        WebElement webTable = driver.findElement(By.xpath("//table[@class='dataTable']"));
        WebElement row1 = webTable.findElement(By.xpath(".//tbody/tr[1]"));// . (nokta) işareti locate edilen web lement üzerinden devam et anlamı taşır
        System.out.println("row1 = " + row1.getText());

        //To get 3rd row's 3rd column data
        WebElement r3c3 = webTable.findElement(By.xpath(".//tbody/tr[3]/td[3]"));
        System.out.println("r3c3 = " + r3c3.getText());

        //Get all the values of a Dynamic Table
        List<WebElement> tableRows = webTable.findElements(By.xpath(".//tr"));

        for (WebElement w : tableRows){

            //System.out.println(w.getText());
            List<WebElement> rowCells = w.findElements(By.xpath(".//td"));
            for (WebElement u : rowCells){

                System.out.println(u.getText());

            }

        }

        //Reusable metod kullanarak yukarıda locate edilen table'ın 5. satırının 4. sütunun yazdırınız.
        String r5c4 = getTableCell(webTable, 5, 4);
        System.out.println("r5c4 = " + r5c4);

    }

}
