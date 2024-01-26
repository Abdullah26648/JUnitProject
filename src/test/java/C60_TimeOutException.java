import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C60_TimeOutException extends TestBase {
    /*
    TimeOutException
    🡪 Selenium beklemelerini uyguladıktan ve bir süre geçtikten sonra eleman hala görünmüyorsa, TimeOutException'ı görürüz.
    🡪 Basitçe söylemek gerekirse, bekleme süresi bitti ama task step tamamlanmadı ise karşılaşırız.
    */

    @Test
    public void timeOutExceptionTest(){

        driver.get("https://linkedin.com");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//OlmayanXpath")));
        element.click();

    }

}
