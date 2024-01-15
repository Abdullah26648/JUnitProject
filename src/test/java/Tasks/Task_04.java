package Tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class Task_04 {
    /*
    Create chrome driver object by using @Before annotation
    Navigate to  https://testpages.herokuapp.com/styled/index.html
    Click on  Calculator under Micro Apps
    Type any number in the first input
    Type any number in the second input
    Click on Calculate
    Get the result(getText() method)
    Verify the result
    Print the result
    Close the browser by using @After annotation
    */
    private WebDriver driver;
    @Before
    public void setup() {
        // Create chrome driver object by using @Before annotation
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }
    @Test
    public void test() {
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        // Click on Calculator under Micro Apps
        WebElement calculatorLink = driver.findElement(By.xpath("//*[@id=\"calculatetest\"]"));
        calculatorLink.click();

        // Type any number in the first input
        WebElement number1Input = driver.findElement(By.id("number1"));
        number1Input.sendKeys("75");

        // Type any number in the second input
        WebElement number2Input = driver.findElement(By.id("number2"));
        number2Input.sendKeys("57");

        // Click on Calculate
        WebElement calculateButton = driver.findElement(By.className("styled-click-button"));
        calculateButton.click();

        // Get the result
        WebElement answer = driver.findElement(By.id("answer"));
        String result = answer.getText();

        // Verify the result with a descriptive message
        assertEquals("Calculation result is incorrect", "130", result);

        // Print the result
        System.out.println("Reult: "+result);
    }

    @After
    public void tearDown() throws InterruptedException {
        // Close the browser by using @After annotation
        Thread.sleep(3000);
        driver.quit();
    }

}
