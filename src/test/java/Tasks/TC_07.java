package Tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class TC_07 {

    // Do the following tasks by creating 4 different test methods.
    static WebDriver driver;

    @BeforeClass
    public static void SetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Before
    public void setUp() {
        // Her test() methodundan önce "Test çalışıyor" yazdıralım

        System.out.println("Test çalışıyor");

        // Go to YouTube homepage

        driver.get("http://www.youtube.com");
    }

    @After
    public void tearDown() throws InterruptedException {
        // Her test() methodundan sonra "Test bitti" yazdıralım

        System.out.println("Test bitti");
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void TC_07_1() {

        // Test if the current URL contains "youtube"

        assertTrue(driver.getCurrentUrl().contains("youtube"));
    }

    @Test
    public void TC_07_2() {
        // Test if the title does not contain "Video"

        assertTrue(!driver.getTitle().contains("Video"));
    }

    @Test
    public void TC_07_3() {
        // Test if the URL contains "youtube"

        assertTrue(driver.getCurrentUrl().contains("youtube"));
    }

    @Test
    public void TC_07_4() {
        // Test if the sourcePge contains "youtube"

        assertTrue(driver.getPageSource().contains("youtube"));
    }

}
