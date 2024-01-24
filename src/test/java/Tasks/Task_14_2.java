package Tasks;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class Task_14_2 extends TestBase {
    /*
   Given
       Go to https://demo.guru99.com/test/drag_drop.html
   When
       Drag orange elements on proper boxes below
   Then
       Verify they are dropped.
 */
    @Test
    public void test2() throws InterruptedException, AWTException {
        driver.get("https://demo.guru99.com/test/drag_drop.html");

        List<WebElement> sourceElements = driver.findElements(By.xpath("//li[contains(@class,' ui-draggable')]"));
        List<WebElement> targetElements = driver.findElements(By.xpath("//ol[contains(@class,' ui-droppable ui-sortable')]"));
        Actions action = new Actions(driver);

        for (int i = 0; i < sourceElements.size(); i++) {
            WebElement sourceElement = sourceElements.get(i);
            action.clickAndHold(sourceElement).perform();
            for (int j = 0; j < targetElements.size(); j++) {
                WebElement targetElement = targetElements.get(j);
                action.moveToElement(targetElement).perform();
                String backgroundColor = targetElement.getCssValue("background-color");
                if (backgroundColor.contains("152, 175, 199, 1")) {
                    action.release().pause(2000).perform();
                    break;
                }
            }
            action.release().perform();
        }
        action.dragAndDrop(driver.findElement(By.xpath("//*[@class='block13 ui-draggable'][2]")),driver.findElement(By.id("amt8"))).perform();
        assertTrue(driver.findElement(By.xpath("//div[@class='table4_result']")).isDisplayed());

    }

}
