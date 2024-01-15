package Tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task_03 {
    /*
    Go to Clarusway homepage
    Do the following tasks by creating 3 different test methods.
    Check if the URL contains clarusway.
    Check if the title does not contain Python.
    Check if the title equals to "Online IT Bootcamp; Learn Coding, Data Science, AWS, DevOps, Cyber Security & Salesforce"
    */
    private WebDriver driver;

    @Before
    public void setUp() {
        // Create chrome driver object via WebDriverManager
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // Maximize the window
        driver.manage().window().maximize();
    }

    @Test
    public void test1() {
        // Go to Clarusway homepage
        driver.get("https://www.clarusway.com/");

        // Check if the URL contains clarusway
        assert driver.getCurrentUrl().contains("clarusway") : "URL does not contain clarusway";
    }

    @Test
    public void test2() {
        // Check if the title does not contain Python
        driver.get("https://www.clarusway.com/");
        assert !driver.getTitle().contains("Python") : "Title contains Python";
    }

    @Test
    public void test3() {
        // Check if the title equals to "Online IT Bootcamp; Learn Coding, Data Science, AWS, DevOps, Cyber Security & Salesforce"
        driver.get("https://www.clarusway.com/");
        String expectedTitle = "Online IT Bootcamp; Learn Coding, Data Science, AWS, DevOps, Cyber Security & Salesforce";
        assert driver.getTitle().equals(expectedTitle) : "Title does not match the expected value";
    }

    @After
    public void tearDown() throws InterruptedException {
        // Wait for 3 seconds
        // Close the browser
        Thread.sleep(3000);
        driver.quit();
    }

}