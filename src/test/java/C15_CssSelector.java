import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class C15_CssSelector {
    //    http://the-internet.herokuapp.com/add_remove_elements/
    //    Click on the "Add Element" button 100 times.
    //    Write a function that takes a number, and clicks the "Delete" button.
    //    Given number of times, and then validates that given number of buttons was deleted.
    //1. Method: createButtons(100)
    //2. Method: DeleteButtonsAndValidate()

    private static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void cssSelector() throws InterruptedException {

        createButtons(100);
        deleteButtonsAndValidate(90);

    }

    private void createButtons(int number){

        WebElement addElement = driver.findElement(By.cssSelector("button[onclick='addElement()']"));
        for (int i = 0; i < number; i++){
            addElement.click();
        }
    }
    private void deleteButtonsAndValidate(int number){
        List<WebElement> deleteButtons = driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));
        System.out.println("deleteButtons = " + deleteButtons.size());

        for (int i = 0; i<number ; i++){
            deleteButtons.get(i).click();
        }

        List<WebElement> ButtonsAfterDelete = driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));
        System.out.println("ButtonsAfterDelete = " + ButtonsAfterDelete.size());

        assertEquals(deleteButtons.size()-number,ButtonsAfterDelete.size());
    }
}
