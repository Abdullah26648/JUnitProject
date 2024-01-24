import org.junit.Test;
import org.openqa.selenium.By;
import Utilities.TestBase;

import static org.junit.Assert.assertEquals;

public class C46_FileUpload extends TestBase {
    //Go to URL: https://testpages.eviltester.com/styled/basic-html-form-test.html
    //Find the path of the file that you want to upload.
    //Click on Upload button.
    //Verify the upload message.

    @Test
    public void fileUploadTest(){

        //Go to URL: https://testpages.eviltester.com/styled/basic-html-form-test.html
        driver.get("https://testpages.eviltester.com/styled/basic-html-form-test.html");

        //Find the path of the file that you want to upload.
        String path = System.getProperty("user.home")+"/Desktop/Flower.bmp";

        //Click on Upload button. -> Bu tuşa click yapmıyoruz. Upload edilecek dosyanın yolunu sendKeys() methodu ile göderiyoruz.
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys(path);

        //Verify the upload message.
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        String uploadMessage = driver.findElement(By.id("_valuefilename")).getText();
        assertEquals("Flower.bmp", uploadMessage);

    }

}