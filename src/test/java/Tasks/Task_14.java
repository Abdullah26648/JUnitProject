package Tasks;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class Task_14 extends TestBase {
     /*
    Given
        Go to https://demo.guru99.com/test/drag_drop.html
    When
        Drag orange elements on proper boxes below
    Then
        Verify they are dropped.
  */
    @Test
    public void Task_14 () {
//      Go to https://demo.guru99.com/test/drag_drop.html

        driver.get("https://demo.guru99.com/test/drag_drop.html");

        Actions actions = new Actions(driver);

//      Drag orange elements on proper boxes below

        WebElement first5000 = driver.findElement(By.xpath("//*[@class='block13 ui-draggable'][1]"));
        WebElement second5000 = driver.findElement(By.xpath("//*[@class='block13 ui-draggable'][2]"));
        WebElement bank = driver.findElement(By.id("credit2"));
        WebElement sales = driver.findElement(By.id("credit1"));

        List<WebElement> elements = driver.findElements(By.xpath("//li[@class='placeholder']"));

//        Verify they are dropped.

        actions
                .dragAndDrop(bank,elements.get(0))
                .dragAndDrop(first5000,elements.get(1))
                .dragAndDrop(sales,elements.get(2))
                .dragAndDrop(second5000,elements.get(3))
                .perform();

        assertTrue(driver.findElement(By.xpath("//a[@class='button button-green']")).isEnabled());
    }

}
