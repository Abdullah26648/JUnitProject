package Selenium_Code_Chalange.Day4;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class C20 extends TestBase {
    //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
    //2. "Hover over Me First" kutusunun ustune gelin
    //3. "Link 1" e tiklayin
    //4. Popup mesajini yazdirin
    //5. Popup'i tamam diyerek kapatin
    //6. "Click and hold" kutusuna basili tutun
    //7. "Click and hold" kutusunda cikan yaziyi yazdirin
    //8. "Double click me" butonunu cift tiklayin
    //9. "Double click me" butonunun renk değiştridiğini doğrulayın
    @Test
    public void Task_20() {
        //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        //2. "Hover over Me First" kutusunun ustune gelin
        WebElement first = driver.findElement(By.xpath("//button[contains(text(),'Hover Over Me First!')]"));
        actions.moveToElement(first).pause(500).perform();

        //3. "Link 1" e tiklayin
        driver.findElement(By.xpath("//a[@class='list-alert'][1]")).click();

        //4. Popup mesajini yazdirin
        System.out.println("Alert Text: " + driver.switchTo().alert().getText());

        //5. Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        //6. "Click and hold" kutusuna basili tutun
        WebElement clickhold = driver.findElement(By.id("click-box"));
        actions.moveToElement(clickhold).clickAndHold().pause(500).perform();

        //7. "Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println("Clickhold Text: " + clickhold.getText());

        //8. "Double click me" butonunu cift tiklayin
        WebElement doubleclick = driver.findElement(By.id("double-click"));
        actions.moveToElement(doubleclick).doubleClick().pause(500).perform();

        //9. "Double click me" butonunun renk değiştridiğini doğrulayın
        assertEquals("rgba(147, 203, 90, 1)",doubleclick.getCssValue("background-color"));


    }
}
