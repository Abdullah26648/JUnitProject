package Mini_Tasks;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_01 {
    @Test
    public void TC_01() {

        // Invoke Chrome Browser

        WebDriver driver = new ChromeDriver();

        // Navigate to URL: https://www.w3schools.com/

        driver.get("https://www.w3schools.com/");

        // Navigate to URL: https://www.stackoverflow.com/

        driver.get("https://www.stackoverflow.com/");

        // Come back to the w3schools using the back command.

        driver.navigate().back();

        // Again go back to the stackoverflow website using forward command

        driver.navigate().forward();

        // Refresh the Browser using refresh command.

        driver.navigate().refresh();

        // Close the browser.

        driver.quit();

    }

}
