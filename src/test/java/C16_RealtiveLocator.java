import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import static org.junit.Assert.assertEquals;

public class C16_RealtiveLocator {
    /*
    Go to https://clarusway.com/
    Verify that the link on the left of Salesforce is Cybersecurity"
    */

    private static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void realtiveLocator(){

        driver.get("https://clarusway.com/");

        WebElement salesForce = driver.findElement(By.linkText("Salesforce"));
        WebElement cyberSecurity = driver.findElement(RelativeLocator.with(By.tagName("span")).toLeftOf(salesForce));
        //Cybersecurity web elementi için elimizde sadece tag var olduğunu varsayarsak
        // locate edebildiğimiz 'Salesforce' web elementini baz alarak solundaki elementi buluyoruz.

        cyberSecurity.click();

        assertEquals("https://clarusway.com/cyber-security/", driver.getCurrentUrl());

    }

}
