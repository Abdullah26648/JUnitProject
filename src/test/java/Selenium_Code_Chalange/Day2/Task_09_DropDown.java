package Selenium_Code_Chalange.Day2;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static junit.framework.TestCase.assertEquals;

public class Task_09_DropDown extends TestBase {
    /*

 1) Open the browser
 2) Enter the URL “https://bonigarcia.dev/selenium-webdriver-java/web-form.html”
 3)Choose "Three"
 4)Verify option Label
    */
    @Test
    public void test1(){
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        Select select = new Select(driver.findElement(By.className("form-select")));
        select.selectByIndex(3);
        WebElement selectedOption = select.getFirstSelectedOption();
        String selectedOptionLabel = selectedOption.getText();
        assertEquals("Three", selectedOptionLabel);
    }

}
