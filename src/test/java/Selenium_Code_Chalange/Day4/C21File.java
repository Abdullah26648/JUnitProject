package Selenium_Code_Chalange.Day4;

import org.junit.Test;
import Utilities.TestBase;
import org.openqa.selenium.By;

import java.io.IOException;

import static org.junit.Assert.assertEquals;


public class C21File extends TestBase {
    /*
    "https://bonigarcia.dev/selenium-webdriver-java/web-form.html" sayfasina gidin
    tempfiles.tmp şeklinde bir dosya oluşturun
    File Input altındaki Dosya Seç kısmına ekleyin
    Submit butonuna tıklayın
    Form submitted
    Received! yazısını doğrulayın
   */
    @Test
    public void testUploadFile() throws IOException, IOException, InterruptedException {
        //        "https://bonigarcia.dev/selenium-webdriver-java/web-form.html" sayfasina gidin
        String initUrl = "https://bonigarcia.dev/selenium-webdriver-java/web-form.html";
        driver.get(initUrl);

        //        tempfiles.tmp şeklinde bir dosya oluşturun
        //        File Input altındaki Dosya Seç kısmına ekleyin
        String path = System.getProperty("user.dir")+"/Resources/tempfiles.tmp";
        driver.findElement(By.name("my-file")).sendKeys(path);

        //        Submit butonuna tıklayın
        driver.findElement(By.xpath("//button[@class='btn btn-outline-primary mt-3']")).click();

        //        Form submitted
        String submit = driver.findElement(By.xpath("//h1[@class='display-6']")).getText();
        assertEquals("Form submitted",submit);

        //        Received! yazısını doğrulayın
        String received = driver.findElement(By.xpath("//p[@class='lead']")).getText();
        assertEquals("Received!",received);

    }
}
