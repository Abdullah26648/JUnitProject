import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class C26_BasicAuthentication {

/*
    BasicAuthentication : Normal olarak web sitelerinde login fonksiyonu icin kullanici adi ve sifre
    webelementlerine bilgileri girip, login buttonuna basariz.
    Ancak bazi websitelerinde ve ozellikle API haberlesmesinde kullanici adi ve sifreyi manuel olarak tek
    tek girmek yerine, servis saglayicinin bize vereccegi bilgiler dogrultusunda, kulllanici adi ve sifreyi
    URL’e ekleyebiliriz.
    Boylece sayfaya gitme ve login fonksiyonu tek adimda halledilmis olur.

    Auth güvenlik nedeniyle kullanılır
    Yetkilendirmenin bir yolu, aşağıdaki sözdizimini kullanmaktır:
    https://kullanıcı adı:şifre@URL
*/

/*
    Go to URL: https://the-internet.herokuapp.com/basic_auth
    Username: admin
    Password: admin
    Syntax:  driver.get("https://USERNAME:PASSWORD@URL");
    Authenticate using the above method and test data.
    https://admin:admin@the-internet.herokuapp.com/basic_auth
    Verify the congratulations message.
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
    public void basicAuthenticationTest(){

    //  Go to URL: https://the-internet.herokuapp.com/basic_auth
    //  Username: admin
    //  Password: admin
    //  Syntax:  driver.get("https://USERNAME:PASSWORD@URL");
    //  Authenticate using the above method and test data.
    //  https://admin:admin@the-internet.herokuapp.com/basic_auth
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

    //  Verify the congratulations message.
        String congratulationsMessage = driver.findElement(By.tagName("p")).getText();
        assertTrue(congratulationsMessage.contains("Congratulations"));

    }

}
