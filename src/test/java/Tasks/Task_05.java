package Tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task_05 {

    /*
    Go to https://thinking-tester-contact-list.herokuapp.com/
    Create a user
    Sing in Application
    Add 5 contacts
    */

    private WebDriver driver;
    @Before
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @After
    public void tearDown() throws InterruptedException {

        Thread.sleep(3000);
        driver.quit();

    }

    @Test
    public void test() throws InterruptedException {

        // Go to https://thinking-tester-contact-list.herokuapp.com/

        driver.get("https://thinking-tester-contact-list.herokuapp.com/");

        // Create a user

        driver.findElement(By.id("signup")).click();
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Abdullah");
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Ozdemir");
        driver.findElement(By.id("email")).sendKeys("thisisanemail@email.com");
        driver.findElement(By.xpath("//input[contains(@id,'password')]")).sendKeys("12345678");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // Sing in Application

        driver.navigate().back();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("thisisanemail@email.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("12345678");
        driver.findElement(By.id("submit")).click();



        // Add 5 contacts

        Thread.sleep(1000);
        driver.findElement(By.id("add-contact")).click();
        driver.findElement(By.id("firstName")).sendKeys("Cristiano");
        driver.findElement(By.id("lastName")).sendKeys("Ronaldo");
        driver.findElement(By.id("birthdate")).sendKeys("1");
        driver.findElement(By.id("email")).sendKeys("2");
        driver.findElement(By.id("phone")).sendKeys("3");
        driver.findElement(By.id("street1")).sendKeys("4");
        driver.findElement(By.id("street2")).sendKeys("5");
        driver.findElement(By.id("city")).sendKeys("6");
        driver.findElement(By.id("stateProvince")).sendKeys("7");
        driver.findElement(By.id("country")).sendKeys("8");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("add-contact")).click();
        driver.findElement(By.id("firstName")).sendKeys("Lionel");
        driver.findElement(By.id("lastName")).sendKeys("Messi");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("add-contact")).click();
        driver.findElement(By.id("firstName")).sendKeys("Karim");
        driver.findElement(By.id("lastName")).sendKeys("Benzema");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("add-contact")).click();
        driver.findElement(By.id("firstName")).sendKeys("David");
        driver.findElement(By.id("lastName")).sendKeys("Beckham");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("add-contact")).click();
        driver.findElement(By.id("firstName")).sendKeys("Mauro");
        driver.findElement(By.id("lastName")).sendKeys("Icardi");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(1000);

    }

}
