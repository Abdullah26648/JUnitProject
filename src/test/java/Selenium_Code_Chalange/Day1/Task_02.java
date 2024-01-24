package Selenium_Code_Chalange.Day1;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task_02 {
    /*
    //opening the target website https://openai.com/
    //set expected title
    //using getTitle() to retrieve actual title.
    //click pause button
    //Assertion button text is 'Play video' now.
    //Doing assertion title
    //close driver
    */
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //opening the target website
        driver.get("https://openai.com/");
        System.out.println("opening the target website");
        //set expected title
        String expectedTitle="OpenAI";
        System.out.println("//set expected title");
        //using getTitle() to retrieve actual title.
        String actualTitle=driver.getTitle();
        //click pause button
        WebElement pauseButton= driver.findElement(By.xpath("//button[@aria-label='Pause video']"));
        pauseButton.click();
        //Assertion button text is 'Play video' now.
        Thread.sleep(2000);
        Assert.assertEquals("Play video", pauseButton.getText());
        System.out.println("//Assertion button text is 'Play video' now");
        //Doing assertion title
        Assert.assertEquals("Title eşleşmedi", actualTitle, expectedTitle);

        driver.quit();
    }

}