package Tasks;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class Task_12 extends TestBase {
/*
    Go to https://testpages.herokuapp.com/styled/events/javascript-events.html
    Click all the buttons and verify they are all clicked
*/
    @Test
    public void Task_12() {

//      Go to https://testpages.herokuapp.com/styled/events/javascript-events.html

        driver.get("https://testpages.herokuapp.com/styled/events/javascript-events.html");

//      Click all the buttons and verify they are all clicked

        List<WebElement> buttons =driver.findElements(By.xpath("//button[contains(@class, 'click-button')]"));
        Actions actions = new Actions(driver);

        for (int i = 1 ; i <= buttons.size()-1 ; i++) {
            actions
                    .click(buttons.get(i))
                    .sendKeys(Keys.TAB)
                    .contextClick(buttons.get(i))
                    .doubleClick(buttons.get(i))
                    .sendKeys(Keys.RETURN)
                    .perform();

        }
        assertTrue(driver.findElement(By.id("reset-challenge")).isEnabled());

    }

}
