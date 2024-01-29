package Tasks;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.Assert.assertTrue;

public class Task_23 extends TestBase {

    /*
    Go to https://testpages.herokuapp.com/
    Click on File Downloads
    Click on Server Download
    Verify that file is downloaded
    */

    @Test
    public void Task_23() {
//      Go to https://testpages.herokuapp.com/
        driver.get("https://testpages.herokuapp.com/");

//      Click on File Downloads
        driver.findElement(By.id("download")).click();

//      Click on Server Download
        driver.findElement(By.xpath("//button[@id='server-download']")).click();

//      Verify that file is downloaded
        boolean isFileExist = Files.exists(Path.of(System.getProperty("user.home")+"/İndirilenler/textfile.txt"));
        assertTrue(isFileExist);

    }

}
