package Selenium_Code_Chalange.Day4;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class Task_19_HoverOver extends TestBase {
    /*
    web sayfasına gidin: https://bonigarcia.dev/selenium-webdriver-java/mouse-over.html
    Sayfadaki dört farklı görüntüyü (images) temsil eden elementleri tanımlayın.
    görüntünün üzerine gelin ve görünen yazıyı alın.
    Bu yazının, "compass"olup olmadığını doğrulayın.
    İkinci görüntünün üzerine gelin ve görünen yazıyı alın.
    Bu yazının, "calendar" olup olmadığını doğrulayın.
    Üçüncü ve dördüncü görüntüler için aynı işlemleri tekrarlayın.
    */
    @Test
    public void Task_19() {
        //web sayfasına gidin: https://bonigarcia.dev/selenium-webdriver-java/mouse-over.html
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/mouse-over.html");

        //Sayfadaki dört farklı görüntüyü (images) temsil eden elementleri tanımlayın.
        WebElement Compass = driver.findElement(By.xpath("//div[@class='figure text-center col-3 py-2'][1]"));
        WebElement Calendar = driver.findElement(By.xpath("//div[@class='figure text-center col-3 py-2'][2]"));
        WebElement Award = driver.findElement(By.xpath("//div[@class='figure text-center col-3 py-2'][3]"));
        WebElement Landscape = driver.findElement(By.xpath("//div[@class='figure text-center col-3 py-2'][4]"));

        actions.moveToElement(Compass).pause(2000).perform();
        String compass = Compass.getText();
        actions.moveToElement(Calendar).pause(2000).perform();
        String calendar = Calendar.getText();
        actions.moveToElement(Award).pause(2000).perform();
        String award = Award.getText();
        actions.moveToElement(Landscape).pause(2000).perform();
        String landscape = Landscape.getText();


        //görüntünün üzerine gelin ve görünen yazıyı alın.
        //Bu yazının, "compass"olup olmadığını doğrulayın.
        //İkinci görüntünün üzerine gelin ve görünen yazıyı alın.
        //Bu yazının, "calendar" olup olmadığını doğrulayın.
        //Üçüncü ve dördüncü görüntüler için aynı işlemleri tekrarlayın

        assertEquals("Compass",compass);
        assertEquals("Calendar",calendar);
        assertEquals("Award",award);
        assertEquals("Landscape",landscape);
    }

}
