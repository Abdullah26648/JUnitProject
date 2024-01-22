package Tasks;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task_11 extends TestBase {
    /*
  Given
      Go to http://webdriveruniversity.com/To-Do-List/index.html
  When
      Add todos: (Prepare breakfast, Wash the dishes, Take care of baby, Help your kid's homework, Study Selenium, Sleep)
  And
      Strikethrough all todos.(Üzerlerini çiziniz)
  And
      Delete all todos.
  Then
      Assert that all todos deleted.
    */
    @Test
    public void Task_11() throws InterruptedException {

//        Go to http://webdriveruniversity.com/To-Do-List/index.html

        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");

//        Add todos: (Prepare breakfast, Wash the dishes, Take care of baby, Help your kid's homework, Study Selenium, Sleep)

        List<String> todolist = new ArrayList<String>(Arrays.asList("Prepare breakfast", "Wash the dishes", "Take care of baby", "Help your kid's homework","Study Selenium", "Sleep"));

        for (String todolistItem : todolist) {
            driver.findElement(By.xpath("/html/body/div/input")).sendKeys(todolistItem, Keys.ENTER);
        }

//        Strikethrough all todos.(Üzerlerini çiziniz)

        List<WebElement> Strikethrough = driver.findElements(By.tagName("li"));

        Strikethrough.forEach(WebElement::click);

//        Delete all todos.

        List<WebElement> deleteButtons = driver.findElements(By.xpath("//i[@class='fa fa-trash']"));

        deleteButtons.forEach(WebElement::click);

        Thread.sleep(1000);

//        Assert that all todos deleted.

        List<WebElement> assertDeleteButtons = driver.findElements(By.xpath("//i[@class='fa fa-trash']"));

        Assert.assertEquals(0,assertDeleteButtons.size());

        Assert.assertTrue(assertDeleteButtons.isEmpty());






    }
}
