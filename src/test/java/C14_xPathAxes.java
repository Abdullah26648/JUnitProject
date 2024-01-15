import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertTrue;
public class C14_xPathAxes {
    private static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void xpathAxes() throws InterruptedException {

        //Go to https://thinking-tester-contact-list.herokuapp.com/
        driver.get("https://thinking-tester-contact-list.herokuapp.com/");

        //Click on submit button
        driver.findElement(By.xpath("//form/p[3]/button")).click();

        //Assert error message
        Thread.sleep(2000);
        assertTrue(driver.findElement(By.xpath("//div[3]/span")).isDisplayed());

    }

}
