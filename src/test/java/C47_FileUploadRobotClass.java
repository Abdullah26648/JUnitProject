import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import static org.junit.Assert.assertEquals;

public class C47_FileUploadRobotClass extends TestBase {
    //Go to URL: https://testpages.eviltester.com/styled/basic-html-form-test.html
    //Find the path of the file that you want to upload.
    //Click on choose file button.
    //Verify the upload message.

    @Test
    public void fileUploadTest() throws AWTException, InterruptedException {

        //Go to URL: https://testpages.eviltester.com/styled/basic-html-form-test.html
        driver.get("https://testpages.eviltester.com/styled/basic-html-form-test.html");

        //Find the path of the file that you want to upload.
        String path = System.getProperty("user.dir")+"\\Addresses.txt";
        System.out.println("path = " + path);

        //Click on choose file button.
        driver.findElement(By.xpath("(//tr)[4]")).click();

        //Girilecek dosyanın yolunun yapıştırılabilmesi için önce hafızaya alınması gerekir.
        StringSelection ss = new StringSelection(path);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);
        //CTRL+V
        Robot robot = new Robot();
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        //Release --> Unutma
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        //ENTER
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        //Verify the upload message.
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        String uploadMessage = driver.findElement(By.id("_valuefilename")).getText();
        assertEquals("Addresses.txt", uploadMessage);

    }

}