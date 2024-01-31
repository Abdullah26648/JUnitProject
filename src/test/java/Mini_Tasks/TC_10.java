package Mini_Tasks;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_10 {
    WebDriver driver;
    @Test
    public void TC_10() throws InterruptedException {

        // Automation Exercises sitesinde çalışıyoruz
        // İlgili alanların Locatorlarını bulalım ve tıklayalım
        // https://www.automationexercise.com/

        driver = new ChromeDriver();
        driver.get("https://www.automationexercise.com/");

        // Task 01 --> "Home"

        driver.findElement(By.xpath("//i[@class='fa fa-home']")).click();

        // Task 02 --> "Products"

        driver.findElement(By.xpath("//i[@class='material-icons card_travel']")).click();
        driver.navigate().back();

        // Task 03 --> "Cart"

        driver.findElement(By.xpath("//i[@class='fa fa-shopping-cart']")).click();
        driver.navigate().back();

        // Task 04 --> "Singup / Login"

        driver.findElement(By.xpath("//i[@class='fa fa-lock']")).click();
        driver.navigate().back();

        // Task 05 --> "Test Cases"

        driver.findElement(By.xpath("//*[.=' Test Cases']")).click();
        driver.navigate().back();

        // Task 06 --> "API Testing"

        driver.findElement(By.xpath("//*[.=' API Testing']")).click();
        driver.navigate().back();

        // Task 07 --> "Video Tutorials"

        driver.findElement(By.xpath("//i[@class='fa fa-youtube-play']")).click();
        driver.navigate().back();

        // Task 08 --> "Contact us"

        driver.findElement(By.xpath("//i[@class='fa fa-envelope']")).click();
        driver.navigate().back();

        Thread.sleep(3000);
        driver.quit();
    }

}
