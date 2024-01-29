package Tasks;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.Keys;

public class Task_22 extends TestBase {
    /*
    Given
    Go to https://www.facebook.com/
    When
    Click on "Create New Account"
    And
    Fill all the boxes by using keyboard actions class

    Note: Do not use any locator.
    */
    @Test
    public void Task_22() {
//      Go to https://www.facebook.com/
        driver.get("https://www.facebook.com/");

//      Click on "Create New Account"
        actions.sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).build().perform();

//      Fill all the boxes by using keyboard actions class
//      Note: Do not use any locator
        actions.sendKeys(faker.name().firstName(), Keys.TAB)
                .sendKeys(faker.name().lastName(), Keys.TAB)
                .pause(100)
                .sendKeys("abdullah@abdullah.com", Keys.TAB)
                .sendKeys("abdullah@abdullah.com", Keys.TAB)
                .sendKeys(faker
                        .internet()
                        .password(6
                                ,10
                                ,true
                                ,true
                                ,true))
                .pause(100)
                .sendKeys(Keys.TAB
                        , Keys.TAB
                        , Keys.PAGE_DOWN
                        , Keys.TAB
                        , Keys.PAGE_DOWN
                        , Keys.PAGE_DOWN
                        , Keys.TAB
                        , Keys.PAGE_DOWN
                        , Keys.PAGE_DOWN
                        , Keys.PAGE_DOWN
                        , Keys.PAGE_DOWN
                        , Keys.PAGE_DOWN
                        , Keys.PAGE_DOWN
                        , Keys.TAB
                        , Keys.TAB
                        , Keys.ARROW_RIGHT
                        , Keys.ARROW_RIGHT
                        , Keys.TAB)
                .pause(100)
                .sendKeys(Keys.ARROW_DOWN
                        , Keys.ARROW_DOWN
                        , Keys.ARROW_DOWN
                        , Keys.TAB
                        , "Attack Helicopter :)"
                        , Keys.ENTER)
                .perform();


    }
}
