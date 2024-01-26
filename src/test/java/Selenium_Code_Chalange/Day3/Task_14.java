package Selenium_Code_Chalange.Day3;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task_14 {
    /*
    1. http://zero.webappsecurity.com sayfasina gidin
    2. Signin buttonuna tiklayin
    3. Login alanine  "username" yazdirin
    4. Password alanine "password" yazdirin
    5. Sign in buttonuna tiklayin (hata mesaji icin back tusuna tiklayin)
    6. Online Banking menusunden Pay Bills sayfasina gidin
    7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
    8. tarih kismina "2020-09-10" yazdirin
    9. Pay buttonuna tiklayin
    10. "The payment was successfully submitted." mesajinin ciktigini kontrol edin
    */
    @Test
    public void Task_14() {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        // 1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com ");
    }
}