package Selenium_Code_Chalange.Day1;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task_04 {
/*
    ****React Uygulama,değişken XPath
    Given
    Go to https://react-shopping-cart-67954.firebaseapp.com
    When
    Click random 3 Add To Cart Button
    Then
    Verify that there are 3 items in the cart
    And
    Click Checkout Button
    Then
    Verify Subtotal
*/
    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();


    }

    public void selectProduct(String productName) {
        driver.
                findElement(By.xpath("//p[contains(text(),'" + productName + "')]//following-sibling::button")).click();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://react-shopping-cart-67954.firebaseapp.com");
        Thread.sleep(5000);
        //random
        selectProduct("Cropped Stay Groovy off white");
        selectProduct("Basic Cactus White T-shirt");
        selectProduct("Black Batman T-shirt");
        String sepetMiktari = driver.findElement(By.xpath("(//span[contains(text(),'Cart')]/parent::div//div//div)")).getText();
        Assert.assertTrue(sepetMiktari.equals("3"));
        String subTotal = driver.findElement(By.xpath("((//p[contains(text(),'SUBTOTAL')]/following-sibling::div)//p)[1]")).getText();
        System.out.println("subTotal = " + subTotal);
        driver.findElement(By.xpath("//button[contains(text(),'Checkout')]")).click();

        System.out.println("driver.switchTo().alert().getText() = " + driver.switchTo().alert().getText());
    }


    @AfterClass
    public static void tearDown() {
        driver.quit();

    }


}