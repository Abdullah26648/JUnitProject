package Tasks;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Task_07 extends TestBase {
/*
    Go to https://testpages.eviltester.com/styled/find-by-playground-test.html
    Assert that there are 42 web elements with 'p' tag on the page
*/
    @Test
    public void test() {
        driver.get("https://testpages.eviltester.com/styled/find-by-playground-test.html");
        List<WebElement> plist=driver.findElements(By.xpath("//p"));
        System.out.println("plist.size() = " + plist.size());
        assertEquals("There are no 42 elements with p tag in this website",42,plist.size());
    }
}
