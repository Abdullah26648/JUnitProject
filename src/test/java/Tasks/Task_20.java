package Tasks;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;

public class Task_20 extends TestBase {

    //  Bir web table body'si içerisindeki
    //  istediğiniz satırın istediğiniz sütununu
    //  String olarak dönen bir metod yazınız.

    @Test public void practice() {
        driver.get("https://testpages.herokuapp.com/styled/tag/table.html");
        // Example 1
        System.out.println("Result :"+getStringInColumnAndRow("//tbody", 1,"th", 2));
        // Example 2
        System.out.println("Result :"+getStringInColumnAndRow("//tbody", 3,"td", 1));
    }
    public String getStringInColumnAndRow
            (String Target_tbody, int columnIndex,String rowname, int rowIndex) {
            return driver.findElement(By.xpath
                            (Target_tbody + "//tr[" + columnIndex + "]//"+rowname+"[" + rowIndex + "]")).getText();
    }

}
