package Selenium_Code_Chalange.Day3;

import Utilities.TestBase;
import org.junit.Test;

public class Task_15 extends TestBase {
    /*
  ~ Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
  ~ click on Phones & PDAs
  ~ get the brandName of phones
  ~ click on add to button for all elements
  ~ click on black total added cart button
  ~ get the names of list from the cart
  ~ compare the names from displaying list and cart list
   */

    @Test
    public void Test01()  {
        driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");
    }

}