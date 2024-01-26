package Selenium_Code_Chalange.Day2;

import Utilities.TestBase;
import org.junit.Test;

public class Task_11_Alerts extends TestBase {
    /*
     https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html adresine gidin
     Launch alert buttonuna tıklayın
     Alert pop-up textin <Hello world!> olduğunu doğrulayın

    */

    @Test
    public void testAlert() {
        //switchTo ile
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html");
    }


    @Test
    public void testAlert2() {
        // wait until ile
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html");
    }


}
