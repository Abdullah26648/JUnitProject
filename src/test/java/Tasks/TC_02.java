package Tasks;

import Utilities.TestBase;
import org.junit.Test;

public class TC_02 extends TestBase {
    @Test
    public void TC_02() {

        // Go to ww.yahoo.com

        driver.get("https://www.yahoo.com");

        // Maximize Window

        driver.manage().window().maximize();

        // Go to www.amazon.com

        driver.get("https://www.yahoo.com");

        // Maximize Window

        driver.manage().window().maximize();

        // Navigate Back

        driver.navigate().back();

        // Navigate Forward

        driver.navigate().forward();

        // Refresh The Page

        driver.navigate().refresh();

    }
}
