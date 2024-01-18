import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class C33_WindowHandle5 extends TestBase {

    /*
        Go to https://testpages.eviltester.com/styled/windows-test.html
        Click on Basic Ajax in new page
        Click on Code In
        Assert that submit button is  'Code In It'
    */
    @Test
    public void test01(){
//        Go to https://testpages.eviltester.com/styled/windows-test.html
        driver.get("https://testpages.eviltester.com/styled/windows-test.html");

//        Click on 'Basic Ajax in new page'
        driver.findElement(By.id("gobasicajax")).click();//Bu link yeni bir sayfa açıyor

//        Click on Code In
        //driver bir önceki sayfada kaldı. Bu yüzden yeni sayfaya switch yapmalıyız
        String page2WindowHandle = new ArrayList<>(driver.getWindowHandles()).get(1);
        driver.switchTo().window(page2WindowHandle);

        driver.findElement(By.name("submitbutton")).click();

//        Assert that submit button is  'Code In It'
        String codeInIt = driver.findElement(By.id("_valuesubmitbutton")).getText();
        assertEquals("Code In It", codeInIt);

    }

}