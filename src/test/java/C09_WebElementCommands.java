import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class C09_WebElementCommands {

// sendKeys(String keys) methodu: Elementimize klavyeyle yazılmış gibi değer gönderir.
// isDisplayed() methodu: Elementin sayfada görüntülenip görüntülenmediğini boolean olarak döndürür.
// isSelected() methodu: Elementin seçili olup olmadığını bilgisini verir (checkbox, radio).
// isEnabled() methodu: Bir elementin aktif olup olmadığını bilgisini verir (button ve girdi yapılan elementlerde kullanılabilir).
// submit() methodu: Formları göndermemize yardımcı olur, ENTER tuşunun görevini görür.
// click() methodu: Bir elemente sol tıklamamızı sağlar.
// getLocation() methodu: Elementin konumunu bize verir.
// clear() methodu: Input alanlarındaki yazıları temizler.
// getText() methodu: Elementin text içeriğini bize verir.
// getAttribute(String key) methodu: Elementin istediğimiz özellik değerini getirir.
// getSize() methodu: Elementin boyutunu bize verir.



/*
    Go to https://testpages.herokuapp.com/styled/basic-html-form-test.html
    Fill username, password and TextArea Comment
    Cancel butonunun görünür olup olmadığını isDisplayed() methodu ile yazdırınız.
*/

    private WebDriver driver;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void webElementCommands(){
//        Go to https://testpages.herokuapp.com/styled/basic-html-form-test.html
        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");

//        Fill username, password and TextArea Comment
        WebElement usernameInput = driver.findElement(By.xpath("//input[@name='username']"));
        usernameInput.sendKeys("john_doe");

        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
        passwordInput.sendKeys("123");

        WebElement textArea = driver.findElement(By.xpath("//textarea[@name='comments']"));
        textArea.clear();//Text alanını temizler
        textArea.sendKeys("Hello World");

//        Cancel butonunun görünür olup olmadığını isDisplayed() methodu ile yazdırınız.
        WebElement cancelButton = driver.findElement(By.xpath("//input[@type='reset']"));
        boolean isDisplayed = cancelButton.isDisplayed();
        System.out.println("isDisplayed = " + isDisplayed);
        assertTrue(isDisplayed);

    }

}