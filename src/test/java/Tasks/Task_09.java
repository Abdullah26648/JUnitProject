package Tasks;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Task_09 extends TestBase {
    /*
         Go to https://testpages.eviltester.com/styled/calculator
         Do all math operations with different @Test methods
         Get the result
         Verify the result
         Print the result
    */
    @Test
    public void Task_09() {
        //        Go to https://testpages.eviltester.com/styled/calculator

        driver.get("https://testpages.eviltester.com/styled/calculator");

        //        Do all math operations with different @Test methods

        WebElement element = driver.findElement(By.id("function"));
        Select select = new Select(element);
        List<WebElement> optionList = select.getOptions();

        driver.findElement(By.id("number1")).sendKeys("15");
        driver.findElement(By.id("number2")).sendKeys("5");

        for (int i = optionList.size() - 1; i >= 0; i--) {

            element = driver.findElement(By.id("function"));
            select = new Select(element);

            select.selectByIndex(i);
            //        Get the result
            driver.findElement(By.cssSelector("#calculate")).click();
            String result = driver.findElement(By.id("answer")).getText();
            //        Print the result
            System.out.println("Result = " + result);

            //        Verify the result
            switch (i) {
                case 3:
                    assertEquals(result, "3");
                    break;
                case 2:
                    assertEquals(result, "10");
                    break;
                case 1:
                    assertEquals(result, "75");
                    break;
                case 0:
                    assertEquals(result, "20");
                    break;
            }

        }


    }
}
