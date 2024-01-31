package Selenium_Code_Chalange.Day2;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Task_10_Waits extends TestBase {
    /*

1) Open the browser
2) Enter the URL “https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html”
3)1 + 3
4) ... should be 4, wait for it
*/
    @Test
    public void test1() throws InterruptedException {
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");
        myMethod("1","3","+","4");

    }
    public void rakam(String number){
        driver.findElement(By.xpath("//span[text()='"+number+"']")).click();
    }
    public void myMethod(String sayi1,String sayi2,String islem,String result) throws InterruptedException {
        driver.navigate().to("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");
        Thread.sleep(5000);
        rakam(sayi1);
        rakam(islem);
        rakam(sayi2);
        rakam("=");
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.textToBe(By.xpath("//div[@class='screen']"),result));
        Assert.assertEquals(result, driver.findElement(By.xpath("//div[@class='screen']")).getText());
    }

}
