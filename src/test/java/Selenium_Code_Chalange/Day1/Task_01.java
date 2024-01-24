package Selenium_Code_Chalange.Day1;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task_01 {
    /*
    1) Open the browser
    2) Enter the URL “https://hava-durumu-apps.netlify.app/”
    3) Enter Istanbul on ınput area
    4) Verify result contains Istanbul
   */
    static WebDriver driver;//class seviyesinde tanımlamalıyız
    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://hava-durumu-apps.netlify.app/");
        driver.findElement(By.id("input")).sendKeys("Istanbul");
        Thread.sleep(5000);
        String result = driver.findElement(By.xpath("//h2[@class='text-2xl font-semibold mb-3']")).getText();
        Assert.assertTrue(result.contains("Istanbul"));
    }
    @AfterClass
    public static void tearDown() {
        driver.close();
    }
}
