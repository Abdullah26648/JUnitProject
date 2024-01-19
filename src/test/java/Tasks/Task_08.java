package Tasks;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class Task_08 extends TestBase {
    /*
        Go to URL: https://app.endtest.io/guides/docs/how-to-test-checkboxes/
        Select all checkboxes
        Assert that they are all selected
    */
    @Test
    public void test() {
        driver.get("https://app.endtest.io/guides/docs/how-to-test-checkboxes/");
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[type='checkbox']"));
        checkboxes.forEach(t-> t.click());
        assertTrue("Not all checkboxes are selected!", checkboxes.stream().allMatch(WebElement::isSelected));

    }

}
