import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class C12_LocatorPractice3 {
/*
    Navigate to website  https://testpages.herokuapp.com/styled/index.html
    Under the Examples
    Click on Locators - Find By Playground Test Page
    Print the URL
    Navigate back
    Print the URL
    Click on WebDriver Example Page
    Print the URL
    Enter value  20 and Enter to "Enter Some Numbers inputBox"
    And then verify 'two, zero' message is displayed
    Close driver.
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
    public void test1() throws InterruptedException {
//        Navigate to website  https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");

//        Under the Examples Click on Locators - Find By Playground Test Page
        Thread.sleep(3000);
        driver.findElement(By.partialLinkText("Locators - Find")).click();

//        Print the URL
        System.out.println(driver.getCurrentUrl());

//        Navigate back
        Thread.sleep(3000);
        driver.navigate().back();

//        Print the URL
        System.out.println(driver.getCurrentUrl());

//        Click on WebDriver Example Page
        Thread.sleep(3000);
        driver.findElement(By.id("webdriverexamplepage")).click();

//        Print the URL
        System.out.println(driver.getCurrentUrl());

//        Enter value  20 and Enter to "Enter Some Numbers inputBox"
        Thread.sleep(3000);
        driver.findElement(By.id("numentry")).sendKeys("20");
        Thread.sleep(3000);
        driver.findElement(By.id("submit-to-server")).click();


//        And then verify 'two, zero' message is displayed
        String message = driver.findElement(By.id("message")).getText();
        assertEquals("two, zero", message);

    }

}
