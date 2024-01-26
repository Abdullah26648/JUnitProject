import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C61_StaleElementException extends TestBase {
/*
    StaleElementReferenceException
    🡪 Etkileşimde olduğunuz öğeye yapılan başvuru artık bayat olduğunda Selenium bir StaleElementReferenceException atar . Bu, öğenin artık web sayfasının gerçek DOM'sine bağlı olmadığı anlamına gelir.
*/

    @Test
    public void staleElementReferenceExceptionTest(){

        driver.get("https://thinking-tester-contact-list.herokuapp.com/");

        WebElement signUp = driver.findElement(By.id("signup"));
        signUp.click();

        driver.get("https://google.com");

        driver.get("https://thinking-tester-contact-list.herokuapp.com/");
        //signUp web elementi eskidi tekrar kullanılamaz. StaleElementReferenceException atar. -> Çözüm: Tekrar locate et.

//        signUp = driver.findElement(By.id("signup")); --> Relocate

        signUp.click();//StaleElementReferenceException -> Element sayfada mevcut ama referansı eski.

    }

    @Test
    public void staleElementReferenceExceptionTest02(){

        driver.get("https://thinking-tester-contact-list.herokuapp.com/");

        WebElement signUp = driver.findElement(By.id("signup"));
        System.out.println("signUp = " + signUp.getText());

        driver.navigate().refresh();//Sayfayı yeniler ve locate edilen referanslar silinir

        //signUp web elementi eskidi tekrar kullanılamaz. StaleElementReferenceException atar. -> Çözüm: Tekrar locate et.

        //signUp = driver.findElement(By.id("signup")); //--> Relocate

        System.out.println("signUp = " + signUp.getText());//StaleElementReferenceException -> Element sayfada mevcut ama referansı eski.

    }

}