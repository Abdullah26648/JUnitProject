import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_WebDriverManager {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();//Önce setup() yapılır.
        WebDriver driver = new ChromeDriver();//Selenium 4.6 öncesi direkt olarak Selenium kütüphanesi ile driver objesi oluşturulamıyordu.

        driver.get("https://clarusway.com");


        driver.quit();

    }

}
