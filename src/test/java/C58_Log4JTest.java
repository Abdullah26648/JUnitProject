import Utilities.TestBase;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class C58_Log4JTest extends TestBase {
/*
    Go to URL: https://healthunify.com/bmicalculator/
    Entering weight
    Selecting kilograms
    Selecting height in feet
    Selecting height in inchs
    Clicking on calculate
    Getting SIUnit value
    Getting USUnit value
    Getting UKUnit value
    Getting overall description
*/

    @Test
    public void log4jTest(){

        PropertyConfigurator.configure("log4j.properties");
        Logger logger = Logger.getLogger(C58_Log4JTest.class);

//        Go to URL: https://healthunify.com/bmicalculator/
        driver.get("https://healthunify.com/bmicalculator/");
        logger.info("Go to URL: https://healthunify.com/bmicalculator/");

//        Entering weight
        driver.findElement(By.xpath("//input[@name='wg']")).sendKeys("75");
        logger.info("Entering weight");

//        Selecting kilograms
        Select select1= new Select(driver.findElement(By.xpath("//select[@name='opt1']")));
        select1.selectByIndex(1);
        logger.info("Selecting kilograms");

//        Selecting height in feet
        Select select2 = new Select(driver.findElement(By.xpath("//select[@name='opt2']")));
        select2.selectByIndex(4);
        logger.info("Selecting height in feet");

//        Selecting height in inchs
        Select select3 = new Select(driver.findElement(By.xpath("//select[@name='opt3']")));
        select3.selectByIndex(8);
        logger.info("Selecting height in inchs");

//        Clicking on calculate
        driver.findElement(By.xpath("//input[@value='Calculate']")).click();

        //Ödev: Selenium işlemleri ve kalan loglar

//        Getting SIUnit value
        driver.findElement(By.xpath("//input[@name='si']")).getText();
        logger.info("Getting SI(si) unit value");
//        Getting USUnit value
        driver.findElement(By.xpath("//input[@name='us']")).getText();
        logger.info("Getting SI(us) unit value");
//        Getting UKUnit value
        driver.findElement(By.xpath("//input[@name='uk']")).getText();
        logger.info("Getting SI(uk) unit value");
//        Getting overall description
        driver.findElement(By.xpath("//input[@name='desc']")).getText();
        logger.info("Getting BMI category");


    }

}
