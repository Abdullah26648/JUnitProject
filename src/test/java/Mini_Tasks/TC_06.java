package Mini_Tasks;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;

public class TC_06 {
    private WebDriver driver;
    @Test
    public void test() {

        // Invoke Firefox Driver

        driver = new FirefoxDriver();

        // Go to https://www.youtube.com/

        driver.get("https://www.youtube.com");

        // Maximize the window

        driver.manage().window().maximize();

        // Verify the page title contains the word "video".

        assertEquals("video",driver.getTitle());

        // Minimize the window

        driver.manage().window().minimize();

        // Verify the page title contains the word "video".

        assertEquals("video",driver.getTitle());

        // Make the page full screen

        driver.manage().window().fullscreen();

        // Close the driver

        driver.quit();
    }
}
