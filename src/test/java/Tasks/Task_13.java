package Tasks;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Task_13 extends TestBase {
/*
	Go to URL: https://foundation.zurb.com/sites/docs/v/5.5.3/components/range_slider.html
	Shift 34 units to the up and 34 units to the down on the vertical axis.
*/
    @Test
    public void Task_13() {

//        Go to URL: https://foundation.zurb.com/sites/docs/v/5.5.3/components/range_slider.html

        driver.get("https://foundation.zurb.com/sites/docs/v/5.5.3/components/range_slider.html");

//        Shift 34 units to the up and 34 units to the down on the vertical axis.

        WebElement slider = driver.findElement(By.xpath("/html/body/div/div/section/div[1]/div[2]/div[2]/div[1]/div/div[1]/div/span[1]"));

        Actions actions = new Actions(driver);
        actions.dragAndDropBy(slider,0,34).perform();
        actions.dragAndDropBy(slider,0,-34).perform();
    }
}
