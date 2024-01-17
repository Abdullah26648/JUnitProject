import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C25_JSAlerts {
/*
    Alerts: Web sitelerinde iki tür alert bulunmaktadır.
    1. HTML alerts: Sağ tıklayarak incelenebilir ve diğer web elementleri gibi davranır.
    2. JS alerts: Sağ tıklayarak incelenemez, bu nedenle diğer WebElement'lerden farklıdır.

    Interview Sorusu:
    - Alertleri nasıl kullanırsın (handle edersin)?
      driver.switchTo().alert()   bu metotla kullanılır.
      Komutlar:
      accept -> OK, TAMAM yani olumlu butona basmak
      dismiss -> CANCEL, HAYIR yani olumsuz butona basmak
      getText -> Alertin mesajını almak için kullanılır.
      sendKeys -> Alertin inputuna mesaj göndermek için kullanılır.
*/

/*
    Go to URL: https://testpages.eviltester.com/styled/alerts/alert-test.html
    Click on show alert box
    Print alert message on console
    Accept alert
    Click on 'Show confirm box'
    Print alert message on console
    Cancel alert
    Click on Show prompt box
    Type 'Hello World' into alert
    Print the text you sent
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
    public void jsAlertTest() throws InterruptedException {

//        Go to URL: https://testpages.eviltester.com/styled/alerts/alert-test.html
        driver.get("https://testpages.eviltester.com/styled/alerts/alert-test.html");

//        Click on show alert box
        driver.findElement(By.id("alertexamples")).click();

//        Print alert message on console
        String alertMessage1 = driver.switchTo().alert().getText();
        System.out.println("alertMessage1 = " + alertMessage1);

//        Accept alert
        Thread.sleep(3000);
        driver.switchTo().alert().accept();

//        Click on 'Show confirm box'
        Thread.sleep(3000);
        driver.findElement(By.id("confirmexample")).click();

//        Print alert message on console
        String alertMessage2 = driver.switchTo().alert().getText();
        System.out.println("alertMessage2 = " + alertMessage2);

//        Cancel alert
        Thread.sleep(3000);
        driver.switchTo().alert().dismiss();

//        Click on Show prompt box
        Thread.sleep(3000);
        driver.findElement(By.id("promptexample")).click();

//        Type 'Hello World' into alert
        Thread.sleep(3000);
        driver.switchTo().alert().sendKeys("Hello World");
        driver.switchTo().alert().accept();

//        Print the text you sent
        String messageISent = driver.findElement(By.id("promptreturn")).getText();
        System.out.println("messageISent = " + messageISent);

    }

}