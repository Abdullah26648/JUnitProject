package Selenium_Code_Chalange.Day1;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task_06 {
    // Navigate to  https://testpages.herokuapp.com/styled/index.html
    // Click on  Calculate under Micro Apps
    // Type any number in the first input
    // Type any number in the second input
    // Click on Calculate
    // Get the result
    // Print the result
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    public void test() {
        driver.navigate().to("https://testpages.herokuapp.com/styled/index.html");

    }







//2.çözüm method oluştur


//public void myMethod(String sayi1,String sayi2,String islem,String result){
//
//}

    @AfterClass
    public static void tearDown() {
        driver.close();

    }
}
