import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;

public class C59_NoSuchElemtException extends TestBase {
    /*
    NoSuchElementException
    🡪 Locator yanlış, WebElement gizli, yükleme ve senkronizasyon sorunu.
    🡪 Iframe, pop-up veya new window nedeniyle WebElement sayfada bulunamadı.
    */
    @Test
    public void noSuchElementExceptionTest(){

        driver.get("https://thinking-tester-contact-list.herokuapp.com/");

        driver.findElement(By.id("olmayanId")).click();//Bu id ile web element bulunamayacağından NoSuchElementException atacak

    }

    @Test
    public void noSuchElementExceptionTest02(){

        driver.get("https://jqueryui.com/droppable/");

        //driver.switchTo().frame(0);

        String text = driver.findElement(By.id("draggable")).getText();//NoSuchElementException --> Bu element iFrame içinde
        System.out.println("text = " + text);

    }

}
