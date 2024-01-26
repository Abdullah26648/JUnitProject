package Selenium_Code_Chalange.Day2;

import Utilities.TestBase;
import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class Task_08_Faker extends TestBase {
    /*
    1) Open the browser
    2) Enter the URL “https://bonigarcia.dev/selenium-webdriver-java/data-types.html”
    3)Fill form
    4)Verify alert access 10,danger empty
    */
    @Test
    public void test() throws InterruptedException {
//      1) Open the browser
//      2) Enter the URL “https://bonigarcia.dev/selenium-webdriver-java/data-types.html”
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/data-types.html");

//      3)Fill form
        Faker faker = new Faker();
        driver.findElement(By.xpath("//input[@name='first-name']"))
                .sendKeys(faker.name().firstName());
        driver.findElement(By.xpath("//input[@name='last-name']"))
                .sendKeys(faker.name().lastName());
        driver.findElement(By.xpath("//input[@name='address']"))
                .sendKeys(faker.address().fullAddress());
        driver.findElement(By.xpath("//input[@name='zip-code']"))
                .sendKeys(faker.address().zipCode());
        driver.findElement(By.xpath("//input[@name='city']"))
                .sendKeys(faker.address().city());
        driver.findElement(By.xpath("//input[@name='country']"))
                .sendKeys(faker.address().country());
        driver.findElement(By.xpath("//input[@name='e-mail']"))
                .sendKeys(faker.internet().emailAddress());
        driver.findElement(By.xpath("//input[@name='phone']"))
                .sendKeys(faker.phoneNumber().cellPhone());
        driver.findElement(By.xpath("//input[@name='job-position']"))
                .sendKeys(faker.job().field());
        driver.findElement(By.xpath("//input[@name='company']"))
                .sendKeys(faker.company().name());
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();

//      4)Verify alert access 10,danger empty
        


    }

}
