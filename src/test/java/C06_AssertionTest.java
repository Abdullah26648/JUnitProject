import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class C06_AssertionTest {
    /*
        Go to Clarus homepage "https://clarusway.com/"
        Do the following tasks by creating 3 different test methods.
        1- Test if the URL contains clarusway.
        2- Test if the title does not contain Facebook.
        3- Test if the URL equals to "https://clarusway.com/"
    */
    private static WebDriver driver;

    @BeforeClass
    public static void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://clarusway.com/");

    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();

    }


    @Test
    public void test01UrlTest() {
        //Test if the URL contains clarusway.
        String url = driver.getCurrentUrl();//Actual Result
        boolean isContain = url.contains("clarusway");
        assertTrue(isContain);

    }

    @Test
    public void test02TitleTest() {
        //Test if the title does not contain Facebook.
        String title = driver.getTitle();
        boolean isContain = title.contains("Facebook");
        assertFalse(isContain);
    }


    @Test
    public void test03UrlTest() {
        //Test if the URL equals to "https://clarusway.com/"

        String actualUrl = driver.getCurrentUrl();//Actual Result
        String expectedUrl = "https://clarusway.com/";

        assertEquals("Url did not match", expectedUrl,actualUrl);

    }

}