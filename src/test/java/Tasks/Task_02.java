package Tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task_02 {
    /*
    Create chrome driver object via WebDriverManager
    Maximize the window
    Open google home page https://www.google.com/
    Wait for 3 seconds
    Go to the https://www.youtube.com/
    Get the title and URL of the page
    Check if the title contains the word "YouTube" print console "Title contains YouTube" or "Title does not contain YouTube"
    Check if the URL contains the word "youtube" print console "URL contains youtube" or "URL does not contain youtube"
    Then go to https://www.instagram.com/
    Get the title and check if it contains the word "Instagram" and print "Title contains Instagram" or "Title does not contain Instagram"
    Navigate Back to the previous webpage
    Refresh the page
    Navigate to forward
    Wait for 3 seconds
    Close the browser
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
    public void test1() throws InterruptedException {
        // Open google home page https://www.google.com/
        driver.get("https://www.google.com/");

        // Wait for 3 seconds
        Thread.sleep(3000);
    }

    @Test
    public void test2() throws InterruptedException {
        // Go to https://www.youtube.com/
        driver.navigate().to("https://www.youtube.com/");

        // Get the title and URL of the page
        String youtubeTitle = driver.getTitle();
        String youtubeUrl = driver.getCurrentUrl();

        // Check if the title contains the word "YouTube"
        assert youtubeTitle.contains("YouTube") : "Title does not contain YouTube";

        // Check if the URL contains the word "youtube"
        assert youtubeUrl.contains("youtube") : "URL does not contain youtube";

        // Wait for 3 seconds
        Thread.sleep(3000);
    }

    @Test
    public void test3() {
        // Go to https://www.instagram.com/
        driver.navigate().to("https://www.instagram.com/");

        // Get the title and check if it contains the word "Instagram"
        String instagramTitle = driver.getTitle();
        assert instagramTitle.contains("Instagram") : "Title does not contain Instagram";
    }

    @Test
    public void test4() {
        // Navigate Back to the previous webpage
        driver.navigate().back();
    }

    @Test
    public void test5() {
        // Refresh the page
        driver.navigate().refresh();
    }

    @Test
    public void test6() {
        // Navigate forward
        driver.navigate().forward();
    }

    @After
    public void tearDown() throws InterruptedException {
        // Wait for 3 seconds
        // Close the browser
        Thread.sleep(3000);
        driver.quit();
    }
}