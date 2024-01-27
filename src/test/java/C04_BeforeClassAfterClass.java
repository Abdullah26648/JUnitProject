import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_BeforeClassAfterClass {

    static WebDriver driver;

    @BeforeClass//Tüm class öncesi bir kez çalışır
    public static void beforeClass() {
        System.out.println("Before Class 1");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass//Tüm class sonrası bir kez çalışır
    public static void afterClass() throws InterruptedException {
        System.out.println("After Class 1");
        Thread.sleep(3000);
        driver.quit();
    }

    @Before
    public void before() {
        System.out.println("Before 2");
    }

    @After
    public void after() {
        System.out.println("After 2");
    }

    @Test
    public void test01() {
        System.out.println("Test 1");
        driver.get("https://google.com");
    }

    @Test
    public void test02() {
        System.out.println("Test 2");
        driver.get("https://linkedin.com");
    }

    @Test @Ignore
    public void test03() {
        System.out.println("Test 3");
        driver.get("https://youtube.com");
    }


}