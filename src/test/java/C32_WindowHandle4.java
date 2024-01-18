import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;

public class C32_WindowHandle4 extends TestBase {
    /*
        Open https://www.youtube.com/ in the opened tab
        Create a new tab
        Open https://www.linkedin.com/ in the opened tab
        Create a new window
        Open https://clarusway.com/ in the opened window
        Switch to the LinkedIn tab and write 'You found the LinkedIn tab' in the email area
    */
    @Test
    public void test01() throws InterruptedException {

    //  Open https://www.youtube.com/ in the opened tab

        driver.get("https://www.youtube.com");

    //  Create a new tab
    //  Open https://www.linkedin.com/ in the opened tab

        Thread.sleep(3000);
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.linkedin.com/");

    //  Create a new window
    //  Open https://clarusway.com/ in the opened window

        Thread.sleep(3000);
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.linkedin.com");


    //  Switch to the LinkedIn tab and write 'You found the LinkedIn tab' in the email area

        for (String w : driver.getWindowHandles()) {
            Thread.sleep(3000);
            driver.switchTo().window(w);
            if (driver.getCurrentUrl().contains("linkedin")) {
                driver.findElement(By.id("session_key")).sendKeys("You found the LinkedIn tab");
                break;
            }
        }

    }

}
