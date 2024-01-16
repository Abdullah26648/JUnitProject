import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class C19_RadioButton {
    //Radio Button: Gruplanmış seçeneklerden sadece birinin seçilebildiği girdilerdir.

    /*
        Go to URL:  http://test.rubywatir.com/radios.php
        Then click on the radio button 'radio with id'
        Assert radio button 'radio with id' is selected and radio buton 1 is not selected
    */

    private static WebDriver driver;

    @Test
    public void test1(){
//        Go to URL:  http://test.rubywatir.com/radios.php
        driver.get("http://test.rubywatir.com/radios.php");

//        Then click on the radio button 'radio with id'
        WebElement radioWithId = driver.findElement(By.id("radioId"));
        radioWithId.click();

//        Assert radio button 'radio with id' is selected and radio buton 1 is not selected
        WebElement radio1 = driver.findElement(By.xpath("//input[@value='Radio1']"));
        assertTrue(radioWithId.isSelected());//radioWithId'nin seçili olduğu doğrulandı
        assertFalse(radio1.isSelected());//radio1'ın seçili olmadığı doğrulandı

    }

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

}
