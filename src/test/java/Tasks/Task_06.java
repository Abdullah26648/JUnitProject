package Tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task_06 {
    /*
    Go to http://test.rubywatir.com/ifelse.php
    Click the correct submit button declared in the yellow line
    Finish the test after 50 correct click
    */
    private WebDriver driver;
    @Before
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @After
    public void tearDown() throws InterruptedException {

        Thread.sleep(3000);
        driver.quit();

    }

    @Test
    public void test() {
        // Go to http://test.rubywatir.com/ifelse.php
        driver.get("http://test.rubywatir.com/ifelse.php");

        // Finish the test after 50 correct clicks
        for (int i = 0; i < 50; i++) {

            // Get the displayed number
            String displayedNumber = driver.findElement(By.xpath("/html/body/div/div[3]/div/div/div[2]/div[1]/h2")).getText();

            // Find and click the submit button based on the displayed number using switch
            WebElement submitButton = driver.findElement(By.xpath("//input[contains(@name,"+displayedNumber+")]"));
            submitButton.click();

        }
        System.out.println("Test is done");
    }

}
