import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;

import java.awt.*;
import java.awt.event.KeyEvent;

public class C41_RobotClass extends TestBase {

    @Test
    public void robotClassTest() throws AWTException, InterruptedException {

        driver.get("https://testpages.eviltester.com/styled/basic-html-form-test.html");

        driver.findElement(By.name("username")).sendKeys("John");

        //Enter tuşuna Robor Class ile basmak istiyoruz
        //1. Adım: Robot Class objesini oluştur
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);//Enter'a bas
        robot.keyRelease(KeyEvent.VK_ENTER);//Enter'a basma işlemini sonlandır --> Unutma

        Thread.sleep(3000);
        //Scroll Down By Mouse
        robot.mouseWheel(4);

        Thread.sleep(3000);
        //Scroll Up By Mouse
        robot.mouseWheel(-4);

    }

}
