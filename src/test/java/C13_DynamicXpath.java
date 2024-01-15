import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C13_DynamicXpath {
/*
        Multiple Attribute:
    //<HTMLtag>[@attribute_name1='attribute_value1'][@attribute_name2='attribute_value2]

        And:
    //<HTML tag>[@attribute_name1='attribute_value1' and @attribute_name2='attribute_value2]

        Or:
    //<HTMLtag>[@attribute_name1='attribute_value1'][@attribute_name2='attribute_value2]

        Contains:
    //<HTMLtag>[contains(@attribute_name,'attribute_value')]

        Starts-with:
    //<HTMLtag>[starts-with(@attribute_name,'attribute_value')]

        Text:
    //tagname[.='text name’]
    //*[contains(text(),'piece of text’)]
    //*[text( )= 'text name’]
    //*[.='text name’]
*/

/*
    Go to facebook.com
    Enter email
    Enter password
    Click on login(Use Dynamic Xpath)
 */

    private static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        // driver.quit();
    }

    @Test
    public void dynamicXpath(){

//        Go to facebook.com
        driver.get("https://facebook.com");

//        Enter email
        driver.findElement(By.id("email")).sendKeys("johndoe@gmail.com");

//        Enter password
        driver.findElement(By.id("pass")).sendKeys("123");

//        Click on login(Use Dynamic Xpath)
        //driver.findElement(By.xpath("//button[starts-with(@id, 'u_0_5_')]")).click();
        driver.findElement(By.xpath("//button[contains(@id, 'u_0_5_')]")).click();

        driver.findElement(By.xpath("//button[.='Yes, Continue']")).click();//Alert için

        //Click on Create New Accont
        driver.findElement(By.xpath("//a[.='Create new account']")).click();

    }

}
