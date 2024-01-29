package Tasks;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;

public class Task_21 extends TestBase {
    /*
    Go to https://form.jotform.com/73302671092956
    Click on start
    Enter firstname and lastname
    Click on next
    Enter email
    Click on next
    Enter message
    Click on next
    Handle captcha
    Click on submit
    Assert that submission is received
    Flash web elements before use
    */
    @Test
    public void Task_21() throws InterruptedException {
//      Go to https://form.jotform.com/73302671092956
        driver.get("https://form.jotform.com/73302671092956");

//      Flash web elements before use
//      Click on start
        WebElement elementToFlash1 = driver.findElement(By.id("jfCard-welcome-start"));
        flashElement(driver, elementToFlash1);
        elementToFlash1.click();


//      Enter firstname and lastname
        WebElement elementToFlash2 = driver.findElement(By.name("q1_name[first]"));
        flashElement(driver, elementToFlash2);
        elementToFlash2.sendKeys(faker.name().firstName());

        WebElement elementToFlash3 = driver.findElement(By.name("q1_name[last]"));
        flashElement(driver, elementToFlash3);
        elementToFlash3.sendKeys(faker.name().lastName());

//      Click on next
        WebElement elementToFlash4 = driver.findElement(By.xpath("//button[@data-testid='nextButton_0']"));
        flashElement(driver, elementToFlash4);
        elementToFlash4.click();

//      Enter email
        WebElement elementToFlash5 = driver.findElement(By.name("q2_email"));
        flashElement(driver, elementToFlash5);
        elementToFlash5.sendKeys(faker.internet().emailAddress());

//      Click on next
        WebElement elementToFlash6 = driver.findElement(By.xpath("//button[@data-testid='nextButton_1']"));
        flashElement(driver, elementToFlash6);
        elementToFlash6.click();

//      Enter message
        WebElement elementToFlash7 = driver.findElement(By.xpath("//textarea[@class='jfInput-textarea form-textarea']"));
        flashElement(driver, elementToFlash7);
        elementToFlash7.sendKeys(faker.lorem().sentence());

//      Click on next
        WebElement elementToFlash8 = driver.findElement(By.xpath("//button[@data-testid='nextButton_2']"));
        flashElement(driver, elementToFlash8);
        driver.findElement(By.xpath("//button[@data-testid='nextButton_2']")).click();

//      Handle captcha
        driver.switchTo().frame(0);
        String first = driver.findElement(By.xpath("//span[@id='number']")).getText();
        flashElement(driver, driver.findElement(By.xpath("//span[@id='number']")));
        String mathSymbol = driver.findElement(By.xpath("//span[@id='function']")).getText();
        flashElement(driver, driver.findElement(By.xpath("//span[@id='function']")));
        String second = driver.findElement(By.xpath("//span[@id='number2']")).getText();
        flashElement(driver, driver.findElement(By.xpath("//span[@id='number2']")));
        String result = basicMath(first, mathSymbol, second);
        driver.findElement(By.name("equal")).sendKeys(result);
        flashElement(driver, driver.findElement(By.name("equal")));

//      Click on submit
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//button[@class='jfInput-button forSubmit form-submit-button u-right']")).click();

//      Assert that submission is received
        String submitmessage = driver.findElement(By.xpath("//div[@class='jfThankYou-description form-subHeader']")).getText();
        assertEquals("Your submission has been received!",submitmessage );

    }

    private static void flashElement(WebDriver driver, WebElement element) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String originalStyle = element.getAttribute("style");

        for (int i = 0; i < 3; i++) {
            js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", element);
            sleep(200);
            js.executeScript("arguments[0].setAttribute('style', '" + originalStyle + "');", element);
            sleep(200);
        }
    }

    public String basicMath(String first, String mathSymbol, String second) {
        try {
            double num1 = Double.parseDouble(first);
            double num2 = Double.parseDouble(second);
            double result = 0;

            switch (mathSymbol) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "x":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        return "Error: Division by zero is undefined.";
                    }
                    break;
                default:
                    return "Error: Invalid math symbol.";
            }

            return ""+result;
        } catch (NumberFormatException e) {
            return "Error: Invalid number format.";
        }
    }
}
