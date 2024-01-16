import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertTrue;

public class C22_MultipleDropdown {
    /*
        Launch the browser.
        Open "https://testpages.herokuapp.com/styled/basic-html-form-test.html".
        Locate the 'Multiple Select Values' element.
        Verifying that the element is multi-select.
        Select 'Selection Item 3' using the index and deselect the same using index.
        Select 'Selection Item 1' using visible text and deselect the same using value.
        Select all items using the index .
        Deselect all the options.
        Close the browser.
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
    public void multipleDropdownTest() throws InterruptedException {

//        Open "https://testpages.herokuapp.com/styled/basic-html-form-test.html".
        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");

//        Locate the 'Multiple Select Values' element.
        WebElement multipleSelect = driver.findElement(By.xpath("//select[@multiple='multiple']"));

//        Verifying that the element is multi-select.
        Select select = new Select(multipleSelect);
        assertTrue(select.isMultiple());

//        Select 'Selection Item 3' using the index and deselect the same using index.
        select.deselectAll();//Önce seçili öğeleri kaldıralım
        select.selectByIndex(2);
        Thread.sleep(3000);
        select.deselectByIndex(2);

//        Select 'Selection Item 1' using visible text and deselect the same using value.
        Thread.sleep(3000);
        select.selectByVisibleText("Selection Item 1");
        Thread.sleep(3000);
        select.deselectByValue("ms1");

//        Select all items using the index .
        Thread.sleep(3000);
        select.selectByIndex(3);
        Thread.sleep(1000);
        select.selectByIndex(2);
        Thread.sleep(1000);
        select.selectByIndex(1);
        Thread.sleep(1000);
        select.selectByIndex(0);

//        Deselect all the options.
        Thread.sleep(3000);
        select.deselectByIndex(3);
        Thread.sleep(1000);
        select.deselectByIndex(2);
        Thread.sleep(1000);
        select.deselectByIndex(1);
        Thread.sleep(1000);
        select.deselectByIndex(0);


    }

}
