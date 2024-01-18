import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.WindowType;

public class C29_WindowHandle1 extends TestBase {
    // driver.getWindowHandle(); -> Aktif pencerenin ve sekmenin window handle (ID) değerini döndürür.
    // driver.getWindowHandles(); -> Tüm pencerelerin ve sekmelerin window handle (ID) değerlerini bir Set olarak döndürür.
    // driver.switchTo().window(id); -> Belirtilen kimlik değerine sahip pencere veya sekmeye geçişi sağlar.
    // driver.switchTo().newWindow(TAB); -> Yeni sekme oluşturur.
    // driver.switchTo().newWindow(WINDOW); -> Yeni pencere oluşturur.

/*
    Open browser
    Go to https://www.youtube.com/ in the open tab
    Create new tab
    Go to https://www.linkedin.com/ in the open tab
    Create new window
    Go to https://clarusway.com/ in the window that opens
*/
    @Test
    public void test01() {
        // Open browser



        // Go to https://www.youtube.com/ in the open tab

        driver.get("https://www.youtube.com/");

        // Create new tab

        driver.switchTo().newWindow(WindowType.TAB );

        // Go to https://www.linkedin.com/ in the open tab

        driver.get("https://www.linkedin.com/");

        // Create new window

        driver.switchTo().newWindow(WindowType.TAB);

        // Go to https://clarusway.com/ in the window that opens

        driver.get("https://clarusway.com/");


    }
}
