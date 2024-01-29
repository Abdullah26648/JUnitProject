package Tasks;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;

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
    public void Task_21() {
//      Go to https://form.jotform.com/73302671092956
        driver.get("https://form.jotform.com/73302671092956");

//      Click on start
        driver.findElement(By.id("jfCard-welcome-start")).click();


//      Enter firstname and lastname
        driver.findElement(By.name("q1_name[first]")).sendKeys(faker.name().firstName());
        driver.findElement(By.name("q1_name[last]")).sendKeys(faker.name().lastName());

//      Click on next
        driver.findElement(By.xpath("//button[@data-testid='nextButton_0']")).click();

//      Enter email
        driver.findElement(By.name("q2_email")).sendKeys(faker.internet().emailAddress());

//      Click on next
        driver.findElement(By.xpath("//button[@data-testid='nextButton_1']")).click();

//      Enter message
        driver.findElement(By.id("label_3")).sendKeys(faker.lorem().sentence());

//      Click on next
        driver.findElement(By.xpath("//button[@data-testid='nextButton_2']")).click();

//      Handle captcha
        driver.switchTo().frame(0);
        String first = driver.findElement(By.xpath("//span[@id='number']")).getText();
        String mathSymbol = driver.findElement(By.xpath("//span[@id='function']")).getText();
        String second = driver.findElement(By.xpath("//span[@id='number2']")).getText();
        String result = basicMath(first, mathSymbol, second);
        driver.findElement(By.name("equal")).sendKeys(result);

//      Click on submit
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//button[@class='jfInput-button forSubmit form-submit-button u-right']")).click();

//      Assert that submission is received
        String submitmessage = driver.findElement(By.xpath("//div[@class='jfThankYou-description form-subHeader']")).getText();
        assertEquals("Your submission has been received!",submitmessage );

//      Flash web elements before use


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
                case "*":
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
