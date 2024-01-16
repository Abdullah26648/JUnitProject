import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class C23_HardWait {

    //Hard Wait --> Java Wait --> Java'nın çalışmasını bir süreliğine bekletir.
    // Zaman tabanlı senkronizasyon - Statik bekleme
    // Statik bekleme, belirli bir süre boyunca beklemeyi temsil eder
    // Ve yalnızca belirtilen süre dolduğunda işlemin devam etmesini sağlar
    // Java ile Selenium'da statik bekleme sağlamak için Thread.sleep() yöntemini kullanırız

    /*
        Go to https://webdriveruniversity.com/Popup-Alerts/index.html
        Click on Ajax Loader
        Click on 'Click Me'
        Assert text "Well Done For Waiting....!!!"
    */
    private static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void hardWaitTest() throws InterruptedException {

//        Go to https://webdriveruniversity.com/Popup-Alerts/index.html
        driver.get("https://webdriveruniversity.com/Popup-Alerts/index.html");

//        Click on Ajax Loader
        driver.findElement(By.id("button3")).click();

//        Click on 'Click Me'
        Thread.sleep(5000);//ElementNotInteractableException aldığımız için bir süre bekliyoruz
        driver.findElement(By.id("button1")).click();


//        Assert text "Well Done For Waiting....!!!"
        Thread.sleep(1000);
        String text = driver.findElement(By.tagName("h4")).getText();

        assertEquals("Well Done For Waiting....!!!", text);

    }

}
