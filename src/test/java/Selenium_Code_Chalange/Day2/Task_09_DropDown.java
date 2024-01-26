package Selenium_Code_Chalange.Day2;

import Utilities.TestBase;
import org.junit.Test;

public class Task_09_DropDown extends TestBase {
    /*

 1) Open the browser
 2) Enter the URL “https://bonigarcia.dev/selenium-webdriver-java/web-form.html”
 3)Choose "Three"
 4)Verify option Label
    */
    @Test
    public void test1(){
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
    }

}
