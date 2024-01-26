package Selenium_Code_Chalange.Day2;

import Utilities.TestBase;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class Task_07 extends TestBase {
    /*
   go to https://sweetshop.vivrichards.co.uk/
   click "Browse Sweets" button
   Then
   Click Add to Basket Button for "Sherbert Straws","Bon Bons" and "Bubble Gums"
   And
   Go to Basket
   Then
   Verify Your Basket inculuding are "Sherbert Straws","Bon Bons" and "Bubble Gums"
   And
   Delete "Bubble Gums" for Basket
   Then
   You use faker class and enter your payment and delivery details.
   And
   Click "Continue to checkout"Button
    */

    public void addToCartSweet(String sweet){
        driver.findElement(By.xpath("//a[@data-name='"+sweet+"']")).click();

    }
    public void detailsInput(String element,String value){
        driver.findElement(By.xpath("//label[@for='"+element+"']/following-sibling::input")).sendKeys(value);
    }

    @Test
    public void test01(){
        driver.get("https://sweetshop.vivrichards.co.uk/");
        WebElement BrowseSweetsButton=driver.findElement(By.xpath("//ul//a[@href='/sweets']"));
        BrowseSweetsButton.click();
        addToCartSweet("Sherbert Straws");
        addToCartSweet("Strawberry Bon Bons");
        addToCartSweet("Bubble Gums");
        driver.navigate().to("https://sweetshop.vivrichards.co.uk/basket");
        List<String> expectedCartList=new ArrayList<>();
        expectedCartList.add("Strawberry Bon Bons");
        expectedCartList.add("Bubble Gums");
        expectedCartList.add("Sherbert Straws");
        List<WebElement> cart=driver.findElements(By.xpath("//ul[@id='basketItems']//h6"));

        List<String>ActualcartList = new ArrayList<>();

        for (int i = 0; i <cart.size() ; i++) {
            ActualcartList.add(i,cart.get(i).getText());
        }
        System.out.println(expectedCartList);
        System.out.println(ActualcartList);
        Assert.assertTrue(expectedCartList.equals(ActualcartList));


        driver.findElement(By.xpath("(//a[contains(text(),'Delete Item')])[2]")).click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        Faker faker= new Faker();

        detailsInput("firstName",faker.name().firstName());
        detailsInput("lastName",faker.name().lastName());
        detailsInput("email",faker.internet().emailAddress());
        detailsInput("address",faker.address().fullAddress());


        Select selectcountry=new Select(driver.findElement(By.id("country")));
        Select selectcity=new Select(driver.findElement(By.id("city")));

        selectcountry.selectByIndex(1);
        selectcity.selectByIndex(2);

        detailsInput("zip",faker.address().zipCode());
        detailsInput("cc-name",faker.name().fullName());
        detailsInput("cc-number",faker.business().creditCardNumber());
        driver.findElement(By.xpath("(//label[@for='cc-expiration']/following-sibling::input)[1]"))
                .sendKeys(faker.business().creditCardExpiry());
        driver.findElement(By.xpath("(//label[@for='cc-expiration']/following-sibling::input)[2]"))
                .sendKeys("000");
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();



    }

}