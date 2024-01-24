package Selenium_Code_Chalange.Day1;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task_05 {
        /*
        go to https://eviltester.github.io/simpletodolist/todolists.html
        then
        verify display eviltester on todo_list
        and
        delete eviltester
        Then
        Enter new todo_list as "Clarusway"
        And
        Verify new todo_list is created
        Then
        add new Todo_ as "merhaba admin" on the new todo_list
        And
        Verify new Todo_ is added
        Then
        Login as Admin
        And
        Verify
         {"active":1,"completed":0,"total":1}
         Then
        Delete the new Todo_ and the new todo_list
        And
        Verify is deleted
        */


    static WebDriver driver;//class seviyesinde tanımlamalıyız

    @BeforeClass
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();


    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://eviltester.github.io/simpletodolist/todolists.html");
        WebElement deleteToDo = driver.findElement(By.xpath("//button[@class='destroy']"));

        deleteToDo.click();
        Thread.sleep(5000);

        driver.switchTo().alert().accept();
        Thread.sleep(5000);
        Assert.assertFalse(deleteToDo.isDisplayed());
        WebElement input_newTodoList = driver.findElement(By.xpath("//input[@class='new-todo-list']"));
        input_newTodoList.sendKeys("Clarusway" + Keys.ENTER);
        Thread.sleep(5000);
        WebElement claruswayTodo = driver.findElement(By.xpath("//ul[@class='todo-list-list']//li"));

        Assert.assertTrue(claruswayTodo.getAttribute("data-id").equals("Clarusway"));

        WebElement useButton = driver.findElement(By.xpath("//a[contains(text(),'use')]"));
        useButton.click();
        Thread.sleep(5000);
        WebElement newTodo = driver.findElement(By.xpath("//input[@class='new-todo']"));
        newTodo.sendKeys("merhaba admin");

    }


    @AfterClass
    public static void tearDown() {
        driver.close();

    }
}