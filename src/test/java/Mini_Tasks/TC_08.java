package Mini_Tasks;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TC_08 {

    // Do the following tasks by creating 3 different test methods.
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // Tüm test() methodlarından önce "Testler çalışmaya başlıyor" yazdıralım

        System.out.println("Testler çalışmaya başlıyor");

        // Go to google homepage

        driver.get("http://www.google.com");
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {

        // Tüm test() methodlarından sonra "Testlerin çalışması bitti" yazdıralım

        System.out.println("Testlerin çalışması bitti");
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void TC_08_1() {

        // Test if the title is the same when the page window is maximize and minimize

        driver.manage().window().maximize();
        String title1 = driver.getTitle();
        driver.manage().window().minimize();
        String title2 = driver.getTitle();

        assertEquals(title1, title2);
    }

    @Test
    public void TC_08_2() {

        // Test if the title does not contain "Video" when the page window is full screen

        driver.manage().window().fullscreen();
        assertTrue(!driver.getTitle().contains("Video"));
    }

    @Test
    public void TC_08_3() {

        // Test if the URL contains "google"

        assertTrue(driver.getCurrentUrl().contains("google"));
    }
}
