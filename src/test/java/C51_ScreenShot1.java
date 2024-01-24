import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import Utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C51_ScreenShot1 extends TestBase {
/*
    Go to Clarusway
    Take full page screenshot
    Take a specific element's screenshot
*/

    @Test
    public void fullPageScreenShotTest() throws IOException {

        driver.get("https://clarusway.com/");

        //1. Adım: Type casting
        TakesScreenshot ts = (TakesScreenshot)driver;

        //2. Adım: getScreenshotAs() metodu
        File ss = ts.getScreenshotAs(OutputType.FILE);

        //3. Adım: Alınan screeenshot dosyasını bir hedefe kopyala
        String now = new SimpleDateFormat("yyMMddhhmmss").format(new Date())+System.nanoTime();
        FileUtils.copyFile(ss, new File(".\\test-output\\screenshots\\FullScreenshot"+now+".png") );

    }

    @Test
    public void specificElementsScreenShotTest() throws IOException, InterruptedException {

        driver.get("https://google.com");

        WebElement imgWebElement = driver.findElement(By.xpath("//img[@alt='Google']"));

        //1. Adım: Locate edilen web element ile getScreenshotAs() metodunu kullan
        File ss = imgWebElement.getScreenshotAs(OutputType.FILE);

        //2. Adım: Screenshot'ı ilgili yere kopyala
        String now = new SimpleDateFormat("yyMMddhhmmss").format(new Date())+System.nanoTime();
        FileUtils.copyFile(ss, new File(".\\test-output\\screenshots\\specificElementScreenShot"+now+".png") );

    }

}