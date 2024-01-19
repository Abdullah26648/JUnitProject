package Tasks;

import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_05 {
    @Test
    public void TC_05() throws InterruptedException {

        // Invoke Chrome Browser.

        WebDriver driver = new ChromeDriver();

        // Open URL:https://www.w3schools.com/

        driver.get("http://www.w3schools.com");

        // Maximize the window.

        driver.manage().window().maximize();

        // Print the position and size of the page.

        System.out.println("Position: " + driver.manage().window().getPosition());
        System.out.println("Size: " + driver.manage().window().getSize());

        // Minimize the page.

        driver.manage().window().minimize();

        // Wait 7 seconds in the icon state and maximize the page.

        Thread.sleep(7000);
        driver.manage().window().maximize();

        // Print the position and dimensions of the page in maximized state.

        Dimension size = driver.manage().window().getSize();
        System.out.println("Dimensions: Width=" + size.getWidth() + ", Height=" + size.getHeight());

        // Make the page full screen.

        driver.manage().window().fullscreen();

        // Close the Browser.

        driver.quit();

    }

}
