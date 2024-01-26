package Selenium_Code_Chalange.Day2;

import Utilities.TestBase;
import org.junit.Test;

public class Task_10_Waits extends TestBase {
    /*

1) Open the browser
2) Enter the URL “https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html”
3)1 + 3
4) ... should be 4, wait for it
*/
    @Test
    public void test1(){
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");
    }


}
