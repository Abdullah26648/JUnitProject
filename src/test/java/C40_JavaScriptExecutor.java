import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C40_JavaScriptExecutor extends TestBase {
    //Go to URL: https://api.jquery.com/dblclick/
    //Double-click on the blue square at the bottom of the page and then write the changed color.

    @Test
    public void javaScriptExecutorTest() throws InterruptedException {

        //Go to URL: https://api.jquery.com/dblclick/
        driver.get("https://api.jquery.com/dblclick/");
        driver.switchTo().frame(0);//İlgili web elementi iframe içinde yer alıyor

        //Double-click on the blue square at the bottom of the page and then write the changed color.


        //Css değerleri alma yada değiştirme işlemlerini JS Executor ile yada Selenium metodları ile yapabiliriz
        WebElement square = driver.findElement(By.tagName("div"));
        //1. Adım: Type Casting
        JavascriptExecutor js = (JavascriptExecutor)driver;

        //2. Adım: JS metodlarını kullan
        js.executeScript("arguments[0].scrollIntoView()", square);

        Actions actions = new Actions(driver);
        Thread.sleep(3000);
        System.out.println(square.getCssValue("background-color"));
        actions.doubleClick(square).perform();
        System.out.println(square.getCssValue("background-color"));

        Thread.sleep(3000);
        //Scroll Up
        driver.switchTo().defaultContent();//Tüm sayfada işlem yapmak için--> driver iç framde kalmamalı
        js.executeScript("window.scrollTo(0,0)");//En yukarı kaydır

        //Scroll Down
        Thread.sleep(3000);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");//En aşağı kaydır --> document.body.scrollHeight: Sayfanın kaydırılabilir en büyük değeri


    }

}