import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.WindowType;

public class C30_WindowHandle2 extends TestBase {
/*
    Open browser
    Create a new tab
    Create a new window
    Open https://www.linkedin.com/ in the second tab
    Open https://clarusway.com/ in the last window
*/
    @Test
    public void test01() {
        // Open browser

        String tab1WindowHandle = driver.getWindowHandle();

        // Create a new tab

        driver.switchTo().newWindow(WindowType.TAB);
        String tab2WindowHandle = driver.getWindowHandle();

        // Create a new window

        driver.switchTo().newWindow(WindowType.WINDOW);
        String newWindowHandle = driver.getWindowHandle();

        // Open https://www.linkedin.com/ in the second tab

        driver.switchTo().window(tab2WindowHandle).get("https://www.linkedin.com/");

        // Open https://clarusway.com/ in the last window

        driver.switchTo().window(newWindowHandle).get("https://clarusway.com/");

    }
}
