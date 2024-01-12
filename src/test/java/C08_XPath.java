import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class C08_XPath {

    WebDriver driver;

    @Before
    public void setUp(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://thinking-tester-contact-list.herokuapp.com/");
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


    @Test
    public void absoluteXPathTest(){
        //Absolute xpath sayfa değişikliklerinde element yolunda değişiklik olacağından elementi locate etmede başarısız olacaktır. Bu yüzden tavsiye edilmez.
        WebElement signUpButton = driver.findElement(By.xpath("/html/body/div[3]/button"));
        signUpButton.click();

    }

    @Test
    public void relativeXPathTest(){

        WebElement email = driver.findElement(By.xpath("//input[@placeholder='Email']"));
        email.sendKeys("clarusway@hotmail.com");

        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("Clarusway.123");

        driver.findElement(By.xpath("//button[@id='submit']")).click();

    }

    @Test
    public void relativeXPathNegativeTest() throws InterruptedException {

        WebElement email = driver.findElement(By.xpath("//input[@placeholder='Email']"));
        email.sendKeys("incorrect@hotmail.com");

        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("WrongPassword");

        driver.findElement(By.xpath("//button[@id='submit']")).click();

        Thread.sleep(2000);//Senkronizasyon için
        String errorMessage = driver.findElement(By.xpath("//span[@id='error']")).getText();
        String expectedMessage = "Incorrect username or password";
        assertEquals(expectedMessage, errorMessage);

    }

}