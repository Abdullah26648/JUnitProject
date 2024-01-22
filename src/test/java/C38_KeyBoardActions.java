import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C38_KeyBoardActions extends TestBase {
    //Go to URL: https://testpages.eviltester.com/styled/basic-html-form-test.html
    //In the username section, print "John" by using the action methods.
    @Test
    public void KeyBoardActions () {
        //Go to URL: https://testpages.eviltester.com/styled/basic-html-form-test.html

        driver.get("https://testpages.eviltester.com/styled/basic-html-form-test.html");

        //In the username section, print "John" by using the action methods.

        WebElement username = driver.findElement(By.xpath("//input[@type='text']"));
        Actions actions = new Actions(driver);
        actions.click(username)
                .click(username)
                .keyDown(Keys.SHIFT)//Shift tuşuna baılı tutar
                .sendKeys("j")//Shift basılı iken j harfini girer
                .keyUp(Keys.SHIFT)//Shift'e basmayı durdurur
                .sendKeys("ohn")//Shift'e basılmazken "ohn" harflerini girer
                .sendKeys(Keys.ENTER)//Enter'a basar
                .perform();

    }
}
