import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertTrue;

public class C37_HoverOver extends TestBase {
//Go to URL: https://www.browserstack.com/
//Hover over on “Products” link.
//Click on "Automate".
//Verify the page URL contains “automate”.
     @Test
    public void HoverOverTest () {
         //Go to URL: https://www.browserstack.com/

         driver.get("https://www.browserstack.com/");

         //Hover over on “Products” link.

         WebElement products = driver.findElement(By.id("products-dd-toggle"));
         Actions actions = new Actions(driver);
         actions.moveToElement(products).perform();

         //Click on "Automate".

         driver.findElement(By.xpath("//div[.='Browser automation grid']")).click();

         //Verify the page URL contains “automate”.

         assertTrue(driver.getCurrentUrl().contains("automate"));

     }
}
