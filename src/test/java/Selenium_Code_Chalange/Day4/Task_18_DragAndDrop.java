package Selenium_Code_Chalange.Day4;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertEquals;

public class Task_18_DragAndDrop {
    private WebDriver driver;
    private Actions actions;
    /*
    web sayfasına gidin: https://bonigarcia.dev/selenium-webdriver-java/drag-and-drop.html
    Sayfadaki "draggable" elementini tanımlayın ve başlangıç konumunu alın.
    "draggable" elementini sürükleyerek sağa doğru 100 piksel hareket ettirin, ardından sola, yukarı ve aşağı yönlere sırasıyla 100 piksel hareket ettirin.
    sürükle ve bırak işlemi sonrasında, "draggable" elementinin yeni konumunu alın ve başlangıç konumuyla karşılaştırın.
    Eğer başlangıç konumuyla aynıysa, bu adım başarılı kabul edilir.
    "draggable" elementini "target" elementine sürükleyin.
    "draggable" elementinin son konumunu alın ve bu konumun "target" elementiyle aynı olduğunu doğrulayın.
    */
    @Test
    public void Task_18() throws InterruptedException {
        driver = new FirefoxDriver();
        actions = new Actions(driver);
//      web sayfasına gidin: https://bonigarcia.dev/selenium-webdriver-java/drag-and-drop.html
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/drag-and-drop.html");

//      Sayfadaki "draggable" elementini tanımlayın ve başlangıç konumunu alın.
        WebElement draggable = driver.findElement(By.xpath("//div[@class='card ui-draggable ui-draggable-handle']"));
        String firstLocation = draggable.getLocation().toString();

//      "draggable" elementini sürükleyerek sağa doğru 100 piksel hareket ettirin, ardından sola, yukarı ve aşağı yönlere sırasıyla 100 piksel hareket ettirin.
        actions.
                dragAndDropBy(draggable, 100, 0).
                pause(2000).
                dragAndDropBy(draggable, -100, 0).
                pause(2000).
                dragAndDropBy(draggable, 0, 100).
                pause(2000).
                dragAndDropBy(draggable, 0, -100).perform();

//      sürükle ve bırak işlemi sonrasında, "draggable" elementinin yeni konumunu alın ve başlangıç konumuyla karşılaştırın.
        String secondLocation = draggable.getLocation().toString();

//      Eğer başlangıç konumuyla aynıysa, bu adım başarılı kabul edilir.
        assertEquals(firstLocation,secondLocation); // Roney hocaya sorulacak !!!

//      "draggable" elementini "target" elementine sürükleyin.
        WebElement target = driver.findElement(By.id("target"));
        String expected = driver.findElement(By.id("target")).getLocation().toString();
        actions.pause(2000).dragAndDrop(draggable, target).perform();

//      "draggable" elementinin son konumunu alın ve bu konumun "target" elementiyle aynı olduğunu doğrulayın.
        String thirdLocation = draggable.getLocation().toString();
        assertEquals(expected, thirdLocation);

        Thread.sleep(3000);
        driver.quit();
    }

}
