package Tasks;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Task_10 extends TestBase {
    /*
	Go to https://webdriveruniversity.com/Popup-Alerts/index.html
	Click on JavaScript Alert
	Print alert message
	Accept alert
	Click on JavaScript Confirm Box
	Print alert message
	Cancel alert
	Click on Modal Popup Box
	Print alert message
	Close alert
    */
    @Test
    public void Task_10() throws InterruptedException {
//        Go to https://webdriveruniversity.com/Popup-Alerts/index.html

        driver.get("https://webdriveruniversity.com/Popup-Alerts/index.html");

//        Click on JavaScript Alert

        driver.findElement(By.xpath("/html/body/div/div[2]/div/div/span")).click();

//        Print alert message

        System.out.println("Alert Message1: "+driver.switchTo().alert().getText());
        Thread.sleep(1000);

//        Accept alert

        driver.switchTo().alert().accept();

//        Click on JavaScript Confirm Box

        driver.findElement(By.xpath("/html/body/div/div[5]/div/div/span")).click();

//        Print alert message

        System.out.println("Alert Message2: "+driver.switchTo().alert().getText());
        Thread.sleep(1000);

//        Cancel alert

        driver.switchTo().alert().dismiss();

//        Click on Modal Popup Box

        driver.findElement(By.xpath("/html/body/div/div[3]/div/div/span")).click();

//        Print alert message

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String modalPopUpMessage =wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div[class='modal-body']")))).getText();
        System.out.println("modalPopUpMessage = " + modalPopUpMessage);

//        Close alert
        driver.findElement(By.xpath("/html/body/div[1]/div[6]/div/div/div[3]/button")).click();

    }
}
