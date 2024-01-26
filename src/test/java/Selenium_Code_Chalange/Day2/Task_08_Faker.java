package Selenium_Code_Chalange.Day2;

import Utilities.TestBase;
import org.junit.Test;

public class Task_08_Faker extends TestBase {
    /*

1) Open the browser
2) Enter the URL “https://bonigarcia.dev/selenium-webdriver-java/data-types.html”
3)Fill form
4)Verify alert access 10,danger empty
  */
    @Test
    public void test() throws InterruptedException {
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/data-types.html");
    }


}
