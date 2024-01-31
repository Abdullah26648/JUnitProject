package Selenium_Code_Chalange.Day2;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Task_12_BasicAuthentication extends TestBase {
    /*
    Syntax:  driver.get("https://USERNAME:PASSWORD@URL");
    driver.get("https://guest:guest@https://jigsaw.w3.org/HTTP/Basic/");
    Verify body contains "Your browser made it!"
    */

    @Test
    public void test01() {
        driver.get("https://guest:guest@jigsaw.w3.org/HTTP/Basic/");
        WebElement body = driver.findElement(By.tagName("body"));

        Assert.assertTrue(body.getText().equals("Your browser made it!"));
    }


}