package Selenium_Code_Chalange.Day3;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Task_15 extends TestBase {
    /*
  ~ Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
  ~ click on Phones & PDAs
  ~ get the brandName of phones
  ~ click on add to button for all elements
  ~ click on black total added cart button
  ~ get the names of list from the cart
  ~ compare the names from displaying list and cart list
   */

    @Test
    public void Task_15() throws InterruptedException {
        driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");
        driver.findElement(By.xpath("//a[contains(text(),\"Phones & PDAs\")]")).click();
        getName();
        clickAllAddButtons();
        Thread.sleep(3000);
        driver.findElement(By.id("cart-total")).click();
        getNameCartList();

        Assert.assertTrue(getName().containsAll(getNameCartList()));
    }

    public List<String> getName(){
        List<WebElement>brandNames=driver.findElements(By.xpath("//h4//a"));
        List<String>brandList=new ArrayList<>();
        for (int i = 0; i <brandNames.size() ; i++) {
            brandList.add(i,brandNames.get(i).getText());
        }

        return brandList;
    }

    public void clickAllAddButtons(){
        List<WebElement>addButtonList=driver.findElements(By.xpath("//div[@class='button-group']"));
        for(WebElement w:addButtonList){
            w.click();
        }
    }
    public List<String>getNameCartList(){
        List<WebElement>productsOnCart=driver.findElements(By.xpath("//table[@class='table table-striped']//tr//td[2]//a"));
        List<String> cartList=new ArrayList<>();
        for (int i = 0; i <productsOnCart.size() ; i++) {
            cartList.add(i,productsOnCart.get(i).getText());
        }

        return cartList;
    }
}