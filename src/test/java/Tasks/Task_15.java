package Tasks;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;

public class Task_15 extends TestBase {
/*
  Go to http://szimek.github.io/signature_pad/
  Draw the line or shape you want on the screen
  Press the clear button after drawing
*/
    @Test
    public void Task_15() throws AWTException {
    //  Go to http://szimek.github.io/signature_pad/

        driver.get("http://szimek.github.io/signature_pad/");

    //  Draw the line or shape you want on the screen

        WebElement area = driver.findElement(By.xpath("//div[@class='signature-pad--body']"));
        Actions actions = new Actions(driver);

        actions.moveToElement(area)
                .clickAndHold()
                .moveByOffset(50, 0)
                .moveByOffset(0, 50)
                .moveByOffset(-50, 0)
                .moveByOffset(0, -50)
                .release()
                .perform();

    //  Press the clear button after drawing

        driver.findElement(By.xpath("//button[@class='button clear']")).click();

    }

}
