import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

public class C57_ExtendReportTest extends TestBase {
    @Test
    public void extendReportTest01() {

        //Go to linkedIn
        extentTest = extentReportsSetUp().createTest("LinkedIn Test", "Navigate method");

        extentTest.info("Anasayfaya gidiliyor");
        driver.get("https://linkedin.com");
        extentTest.pass("Anasayfaya gidildi");

        //Click on Sign In
        driver.findElement(By.partialLinkText("Oturum aç")).click();
        extentTest.pass("Sign in tıklandı");

        //Nagigate back
        driver.navigate().back();
        extentTest.pass("Sayfaya geri dönüldü");

        extentReports.flush();//Ara belleği
    }

    @Test
    public void extentReportTest2() throws InterruptedException {

        extentTest = extentReportsSetUp().createTest("Contact List Test", "ABC");

        // Go to https://thinking-tester-contact-list.herokuapp.com/
        driver.get("https://thinking-tester-contact-list.herokuapp.com/");
        extentTest.pass("Go to https://thinking-tester-contact-list.herokuapp.com/");

        //Enter email as clarusway@hotmail.com
        driver.findElement(By.id("email")).sendKeys("clarusway@hotmail.com");
        extentTest.pass("Enter email as clarusway@hotmail.com");

        //Enter password as Clarusway.123
        driver.findElement(By.id("password")).sendKeys("Clarusway.123");
        extentTest.pass("Enter password as Clarusway.123");

        //Click on Submit
        driver.findElement(By.id("submit")).click();
        extentTest.pass("Click on Submit");

        //Assert header is Contact List
        Thread.sleep(2000);
        String header = driver.findElement(By.tagName("h1")).getText();
        assertEquals("Contact List", header);
        extentTest.pass("Assert header is Contact List");

        extentReports.flush();

    }

}
