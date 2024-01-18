import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import Utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class C34_Actions extends TestBase {
/*
    Mouse Actions
    click(): Kullanıldığında mevcut konumu tıklar.
    doubleClick(): Fare konumunda çift tıklama yapar.
    clickAndHold(): Fare tıklamasını bırakmadan gerçekleştirir.
    contextClick(): Mevcut fare konumunda sağ tıklama yapar.
    moveToElement(WebElement target): Fare işaretçisini hedef konumun merkezine taşır.
    dragAndDrop(WebElement source, WebElement target): Öğeyi kaynaktan sürükler ve hedef konuma bırakır.
    dragAndDropBy(source, xOffset, yOffset): Bu yöntem, kaynak öğeyi tıklar, belirli bir ofset kadar hareket ettirir, ardından fareyi serbest bırakır. Ofsetler x ve y ile tanımlanır.
        (X = Yatay Kaydırma, Y = Dikey Kaydırma)
    release(): Mevcut konumdaki sol fare düğmesini bırakır.
    perform(): Bir eylemi gerçekleştirir. Bir eylemi tamamlamak için kullanılmalıdır.
    perform() KULLANMAYI UNUTMAYIN!
*/

/*
    Go to URL: https://demoqa.com/buttons
    Run the buttons on the page using the Actions Class.
    Verify the texts that appear after the buttons are operated.
*/

    @Test
    public void test01(){

    //  Go to URL: https://demoqa.com/buttons

        driver.get("https://demoqa.com/buttons");

    //  Run the buttons on the page using the Actions Class.

        WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));
        WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
        WebElement clickBtn = driver.findElement(By.xpath("//button[.='Click Me']"));

    //  1. Adım: Actions objesi oluştur

        Actions actions = new Actions(driver);

    //  2. Adım: Obje ile ilgili metodu uygula

        actions.doubleClick(doubleClickBtn).perform();
        actions.contextClick(rightClickBtn).perform();
        actions.click(clickBtn).perform();  //3. Adım: Perform metodunu kullan


    //  Verify the texts that appear after the buttons are operated.

        WebElement doubleClickMessage = driver.findElement(By.id("doubleClickMessage"));
        WebElement rightClickMessage = driver.findElement(By.id("rightClickMessage"));
        WebElement dynamicClickMessage = driver.findElement(By.id("dynamicClickMessage"));

        assertTrue(doubleClickMessage.isDisplayed() && rightClickMessage.isDisplayed() && dynamicClickMessage.isDisplayed());


    }

}