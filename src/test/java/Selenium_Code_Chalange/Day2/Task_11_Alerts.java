package Selenium_Code_Chalange.Day2;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Task_11_Alerts extends TestBase {
    /*
     https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html adresine gidin
     Launch alert buttonuna tıklayın
     Alert pop-up textin <Hello world!> olduğunu doğrulayın

    */

    @Test
    public void testAlert() {
        //switchTo ile
        //Alert alert = driver.switchTo().alert();
        //Assert.assertEquals("Hello world!", alert.getText());
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html");
        driver.findElement(By.id("my-alert")).click();
        Alert a = driver.switchTo().alert();
        Assert.assertTrue(a.getText().equals("Hello world!"));
    }


    @Test
    public void testAlert2() {
        // wait until ile
        // Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        // Assert.assertEquals("Hello world!", alert.getText());
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html");
        driver.findElement(By.id("my-alert")).click();
        WebDriverWait w =new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert alert=w.until(ExpectedConditions.alertIsPresent());
        Assert.assertTrue(alert.getText().equals("Hello world!"));

    }


}
