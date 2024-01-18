import org.junit.Test;
import org.openqa.selenium.WindowType;
import Utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class C31_WindowHandle3 extends TestBase {
/*
    Open https://www.youtube.com/
    Create a new tab
    Open https://www.linkedin.com/ in the opened tab
    Switch to first tab without getting its windowhandle
*/

    @Test
    public void test01(){

//        Open https://www.youtube.com/
        driver.get("https://www.youtube.com/");

//        Create a new tab
//        Open https://www.linkedin.com/ in the opened tab
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.linkedin.com/");

//        Switch to first tab without getting its windowhandle
        Set<String> windowHandles = driver.getWindowHandles();
        String currentPageWindowHandle = driver.getWindowHandle();

        for (String w : windowHandles){
            if (!w.equals(currentPageWindowHandle)){//Eğer Set'ten gelen değer driver'ın bulunduğu sayfanın değerine eşit değilse o safyfaya yani diğer sayfaya geç
                driver.switchTo().window(w);
            }
        }

        assertEquals("YouTube", driver.getTitle());

        //2. Yol:
        List<String> windowHandleList = new ArrayList<>(driver.getWindowHandles());//Set içindeki elemanlı index tutan ArrayList içine aktarıyoruz
        driver.switchTo().window(windowHandleList.get(0));
        assertEquals("YouTube", driver.getTitle());

    }

}
