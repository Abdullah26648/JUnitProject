package Selenium_Code_Chalange.Day1;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Task_06 {
    // Navigate to  https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html
    // Click on  Calculate under Micro Apps
    // Type any number in the first input
    // Type any number in the second input
    // Click on Calculate
    // Get the result
    // Print the result
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    public void rakam(String number){
        driver.findElement(By.xpath("//span[text()='"+number+"']")).click();
    }
    @Test
    public void test() throws InterruptedException {

        myMethod("5","4","+","9");

    }







//2.çözüm method oluştur


    public void myMethod(String sayi1,String sayi2,String islem,String result) throws InterruptedException {
        driver.navigate().to("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");
        Thread.sleep(5000);
        rakam(sayi1);
        rakam(islem);
        rakam(sayi2);
        rakam("=");
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(6));
        wait.until(ExpectedConditions.textToBe(By.xpath("//div[@class='screen']"),result));
        Assert.assertEquals(result, driver.findElement(By.xpath("//div[@class='screen']")).getText());
    }

    @AfterClass
    public static void tearDown() {
        driver.close();

    }
}
