import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class C17_ChromeOptions {
    /*
     ChromeOptions Class

    Selenium WebDriver'da Chrome sürücüsünün çeşitli özelliklerini değiştirmek için kullanılan bir kavramdır.
    start-maximized: Chrome'u büyütme modunda açar.
    incognito: Chrome'u gizli modda açar.
    headless: Chrome'u görüntülenmeyen modda çalıştırır.(headless modda)
    disable-extensions: Chrome tarayıcısında mevcut uzantıları devre dışı bırakır.
    disable-popup-blocking: Chrome tarayıcısında görüntülenen açılır pencereleri devre dışı bırakır.
    make-default-browser: Chrome'u varsayılan tarayıcı yapar.
    version: Chrome tarayıcı sürümünü yazdırır.
    disable-infobars: Chrome'un "Chrome otomatik yazılım tarafından kontrol ediliyor" bildirimini görüntülemesini engeller.
    --disbale-cookies: Cookie'leri(Çerezleri) engeller
     */

    private WebDriver driver;

    @Before
    public void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        //chromeOptions.addArguments("incognito");
        chromeOptions.addArguments("disable-extensions");
        chromeOptions.addArguments("disable-popup-blocking");
        chromeOptions.addArguments("--disbale-cookies");
        chromeOptions.addArguments("disable-infobars");
        //chromeOptions.addArguments("--headless=new");

        driver = new ChromeDriver(chromeOptions);

    }


    @Test
    public void test01() {

        driver.get("https://google.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

    }


    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


}