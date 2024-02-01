package Selenium_Code_Chalange.Day4;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Task_17_WindowHandle extends TestBase {
    // Step 1: Go to the URL
    // https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open
    // accept cookies
    // driver.findElement(By.id("accept-choices")).click();
    // Step 2: Switch to the iframe containing the "Try it" button
    // Locate and click the "Try it" button
    // Step 3: Switch to the new window that opened
    // Step 4: Switch back to the original window by using the window handle
    @Test
    public void Task_17() throws InterruptedException {
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");

        driver.switchTo().frame("iframeResult");

        WebElement TryItButton=driver.findElement(By.xpath("//button[text()='Try it']"));
        Assert.assertTrue(TryItButton.isDisplayed());
        TryItButton.click();
        System.out.println(driver.getTitle());
        System.out.println(driver.getWindowHandles());

        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
            String newWindowUrl = driver.getCurrentUrl();
            System.out.println("newWindowUrl = " + newWindowUrl);
            String newWindowTitle = driver.getTitle();
            System.out.println("newWindowTitle = " + newWindowTitle);
            driver.switchTo().window(driver.getWindowHandles().iterator().next());
        }
    }

}
