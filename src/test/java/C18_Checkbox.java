import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class C18_Checkbox {
    /*
        Go to https://the-internet.herokuapp.com/checkboxes
        Locate the elements of checkboxes.
        Then click on checkbox 1 if box is not selected.
        Then click on checkbox 2 if box is not selected.
        Then verify that checkbox 1 is checked.
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
    public void checkBoxTest() {

//      Go to https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");

//      Locate the elements of checkboxes.
        WebElement checkbox1 = driver.findElement(By.xpath("//form/input[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//form/input[2]"));

//      Then click on checkbox 1 if box is not selected.
        if (!checkbox1.isSelected()){
            checkbox1.click();
        }

//      Then click on checkbox 2 if box is not selected.
        if (!checkbox2.isSelected()){
            checkbox2.click();
        }

//      Then verify that checkbox 1 is checked.
        assertTrue(checkbox1.isSelected() && checkbox2.isSelected());

    }

}
