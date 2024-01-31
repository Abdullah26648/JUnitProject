package Mini_Tasks;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class TC_09 {
    // Do the following tasks by creating 3 different test methods.
    static WebDriver driver;
    @BeforeClass
    public static void Setup() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // Tüm test() methodları çalışmadan önce "STARTED" yazdıralım.

        System.out.println("STARTED");
    }
    @AfterClass
    public static void Cleanup() throws InterruptedException {

        // Tüm test() methodları çalıştıktan sonra "STARTED" yazdıralım.

        System.out.println("FINISHED");
        Thread.sleep(3000);
        driver.quit();

    }
    @Before
    public void setup() {
        // Go to w3school homepage

        driver.get("https://www.w3school.com");

        // Her test() methodu çalışmadan önce "Test başladı" yazdıralım.

        System.out.println("Test başladı");

    }
    @After
    public void cleanup() {
        // Her test() methodu çalıştıktan sonra "Test bitti" yazdıralım.

        System.out.println("Test bitti");
    }
    @Test
    public void TC_09_1() {
        // Tüm test methodlarının içine "method adı + çalışıyor" yazdıralım

        System.out.println("TC_09_1() çalışıyor");

        // Test if the title contains "w3school" when the page window is minimize

        driver.manage().window().minimize();
        System.out.println(driver.getTitle());
        assertTrue(driver.getTitle().contains("w3school"));
    }
    @Test
    public void TC_09_2() {
        // Tüm test methodlarının içine "method adı + çalışıyor" yazdıralım

        System.out.println("TC_09_2() çalışıyor");

        // Test if the title does not contain "boss" when the page window is ful screen

        driver.manage().window().fullscreen();
        System.out.println(driver.getTitle());
        assertTrue(!driver.getTitle().contains("boss"));
    }
}
