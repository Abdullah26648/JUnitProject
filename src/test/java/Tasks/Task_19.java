package Tasks;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Task_19 extends TestBase {
/*
    Given
        Go to https://testpages.herokuapp.com/styled/tag/table.html
    When
        Calculate the total amount on the table
    Then
        Assert the amount is 110.3
*/
    @Test
    public void Task_19() {
//      Go to https://testpages.herokuapp.com/styled/tag/table.html

        driver.get("https://testpages.herokuapp.com/styled/tag/table.html");

//      Calculate the total amount on the table

        List<WebElement> elements = driver.findElements(By.xpath("//tbody//tr//td[2]"));
        double total = 0;
        for (WebElement element : elements) {
            double number = Double.parseDouble(element.getText());
            total += number;
        }


//      Assert the amount is 110.3

        assertEquals(110.3, total,0.001);


    }
}
