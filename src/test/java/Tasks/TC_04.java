package Tasks;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import static org.junit.Assert.assertEquals;

public class TC_04 extends TestBase {
    @Test
    public void TC_04() {
        // Go to the w3school URL :https://www.w3school.com/

        driver.get("https://www.w3school.com/");

        // Print the position and size of the page.

        System.out.println("Position: " + driver.manage().window().getPosition());
        System.out.println("Size: " + driver.manage().window().getSize());

        // Adjust the position and size of the page as desired.

        Point newPosition = new Point(70, 70);
        Dimension newSize = new Dimension(900, 900);

        driver.manage().window().setPosition(newPosition);
        driver.manage().window().setSize(newSize);

        // Test that the page is in the position and size you want.

        assertEquals(driver.manage().window().getPosition(),newPosition);
        assertEquals(driver.manage().window().getSize(),newSize);

        // Close the page.

        driver.quit();
    }
}
