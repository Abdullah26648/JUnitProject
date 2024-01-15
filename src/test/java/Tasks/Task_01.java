package Tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task_01 {
    /*
     Go to the Amazon URL : https://www.clarusway.com/
     Print the position and size of the page.
     Adjust the position of the page as:
         xCoordinate: 70
         yCoordinate: 70
       Adjust the size of the page as:
         height: 900
         width: 900

     Test that the page is in the position and size you want.
     Close the page.
    */
    private WebDriver driver;
    @Before
    public void setUp() {
        // Use WebDriverManager to automatically download the latest driver version
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver
        driver = new ChromeDriver();
    }

    @Test
    public void test1(){

        // Go to the Amazon URL : https://www.clarusway.com/
        driver.get("https://www.clarusway.com/");

    }

    @Test
    public void test2(){

        // Print the position and size of the page.
        Point position = driver.manage().window().getPosition();
        Dimension size = driver.manage().window().getSize();

        System.out.println("Position: " + position.toString());
        System.out.println("Size: " + size.toString());

    }

    @Test
    public void test3(){

        // Adjust the position of the page as:
        //         xCoordinate: 70
        //         yCoordinate: 70
        //       Adjust the size of the page as:
        //         height: 900
        //         width: 900
        Point newPosition = new Point(70, 70);
        Dimension newSize = new Dimension(900, 900);

        driver.manage().window().setPosition(newPosition);
        driver.manage().window().setSize(newSize);

    }

    @Test
    public void test4(){

        // Test that the page is in the position and size you want.
        Point currentPosition = driver.manage().window().getPosition();
        Dimension currentSize = driver.manage().window().getSize();

        assert currentPosition.getX() == 70;
        assert currentPosition.getY() == 70;
        assert currentSize.getHeight() == 900;
        assert currentSize.getWidth() == 900;

    }

    @After
    public void tearDown() throws InterruptedException {
        // Close the page.
        Thread.sleep(3000);
        driver.quit();
    }

}
