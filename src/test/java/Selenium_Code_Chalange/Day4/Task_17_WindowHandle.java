package Selenium_Code_Chalange.Day4;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;

public class Task_17_WindowHandle extends TestBase {
    // Step 1: Go to the URL
    //accept cookies
    //driver.findElement(By.id("accept-choices")).click();
    // Step 2: Switch to the iframe containing the "Try it" button
    // Locate and click the "Try it" button
    // Step 3: Switch to the new window that opened
    // Step 4: Switch back to the original window by using the window handle
    @Test
    public void Task_17() {
        // Step 1: Go to the URL
        driver.get("");
        //accept cookies
        driver.findElement(By.id("accept-choices")).click();
        // Step 2: Switch to the iframe containing the "Try it" button
        // Locate and click the "Try it" button
        // Step 3: Switch to the new window that opened
        // Step 4: Switch back to the original window by using the window handle
    }
}
