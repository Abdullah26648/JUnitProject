import org.junit.Test;
import Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C36_DragAndDropBy extends TestBase {


    //  Go to URL: https://rangeslider.js.org/
    //  Shift 100 units to the right and 100 units to the left on the horizontal axis.

    @Test
    public void dragAndDropByHorizontal(){

    //  Go to URL: https://rangeslider.js.org/

        driver.get("http://rangeslider.js.org/");

    //  Shift 100 units to the right and 100 units to the left on the horizontal axis.

        WebElement slider = driver.findElement(By.xpath("(//div[@class='rangeslider__handle'])[1]"));
        Actions actions = new Actions(driver);
        System.out.println("Before: "+driver.findElement(By.id("js-output")).getText());
        actions.dragAndDropBy(slider,55,0).perform();
        System.out.println("After: "+driver.findElement(By.id("js-output")).getText());
        actions.dragAndDropBy(slider,-50,0).perform();
        System.out.println("Last: "+driver.findElement(By.id("js-output")).getText());

    }

    @Test
    public void dragAndDropByVertical() {

    }

}
