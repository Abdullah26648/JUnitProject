import Utilities.TestBase;
import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;

public class C63_LocalPageTest extends TestBase {

    //Fill the local TestPage form and confirm

    @Test
    public void localPageTest() {
        Faker faker = new Faker();

        driver.get(System.getProperty("user.dir")+"\\resources\\TestPage.html");

        driver.findElement(By.id("ssn")).sendKeys("123-33-4567");
        driver.findElement(By.id("firstName")).sendKeys(faker.name().firstName());
        driver.findElement(By.id("lastName")).sendKeys(faker.name().lastName());
        driver.findElement(By.xpath("//label[@for='male']")).click();
        Select select = new Select(driver.findElement(By.xpath("//select[@id='job']")));
        select.selectByIndex(1);
        driver.findElement(By.xpath("//input[@id='username']"))
                .sendKeys(faker.name().username());
        driver.findElement(By.xpath("//input[@id='email']"))
                .sendKeys(faker.internet().emailAddress());
        driver.findElement(By.xpath("//input[@id='password']"))
                .sendKeys(faker
                        .internet()
                        .password(8
                                ,10
                                ,true
                                ,false
                                ,true));

        //Ödev: Gerekli alanları doldurup confirm sonrası assertion yapınız

        driver.findElement(By.id("cv")).sendKeys(System.getProperty("user.dir")+"\\resources\\Cv.pdf");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //assertEquals();

        assertEquals("Form submitted!",driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
    }

}
