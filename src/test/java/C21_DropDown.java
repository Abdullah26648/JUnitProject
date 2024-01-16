import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class C21_DropDown {
    // Dropdown: Açılır pencere
    // Dropdownlar özel etkileşimler gerektirdiği için Selenium bize dropdownlar için ayrı bir class oluşturmuştur.
    // Class: Select

/*
    // Dropdownlar ile çalışırken:
    // <select> elementi locate edilir: //select[@id='oldSelectMenu']
    // Select elementi kullanılarak Select objesi oluşturulur:
    Select select = new Select(webElement);
    // Select objesi aracılığıyla metotlar kullanılır:
    // 1- selectByIndex(): Option elementinin indexi
    // 2- selectByValue(): Option elementinin value attribute'u
    // 3- selectByVisibleText(): Option elementinin görünür yazısı

    // Select elementlerinde bilgi amaçlı kullanılan metotlar:
    select.getOptions(); // Select elementinin tüm option'larını liste halinde döndürür.
    select.getAllSelectedOptions(); // Multi-select'te seçili tüm değerleri bize döndüren metoddur.
    select.getFirstSelectedOption(); // Seçili ilk option elementini bize getirir.
    select.isMultiple(); // Select elementinin multiple seçime uygun olup olmadığını bize boolean olarak döndürür.

    // Deselect işlemleri:
    // 1- deselectByIndex() -> Option elementini index ile kaldırır
    // 2- deselectByValue() -> Option elementini value attribute'u ile kaldırır
    // 3- deselectByVisibleText() -> Option elementini görünür yazısı (içeriği) ile kaldırır
    // 4- deselectAll() -> Bütün seçimleri kaldırır.

 */

    /*
       Launch the browser.
       Open "https://formstone.it/components/dropdown/demo/".
       Locate the Dropdown "Default Label Select Menu" using the element id.
       Print all the options of the dropdown.
       Select 'California' using the index.
       After that, select 'Florida' using visible text.
       Select 'New York' using value.
       Close the browser.
   */
    private static WebDriver driver;

    @Test
    public void dropDownTest() throws InterruptedException {

//        Open "https://formstone.it/components/dropdown/demo/".
        driver.get("https://formstone.it/components/dropdown/demo/");


//        Locate the Dropdown "Default Label Select Menu" using the element id.
        WebElement defaultLabel = driver.findElement(By.id("demo_label"));
        //Dropdown üzerinde işlem yapabilmek için Select objesi oluşturmamız gerekir:
        Select select = new Select(defaultLabel);//Select constractor Webelement parametresi kabul eder

//        Print all the options of the dropdown.
        List<WebElement> optionsList = select.getOptions();

//        for (WebElement w : optionsList) {
//            System.out.println(w.getText());
//        }

        optionsList.forEach(t-> System.out.println(t.getText()));//Lambda kullanmak tercih edilmeli


//        Select 'California' using the index.
        select.selectByIndex(5);

//        After that, select 'Florida' using visible text.
        Thread.sleep(3000);
        select.selectByVisibleText("Florida");

//        Select 'New York' using value.
        Thread.sleep(3000);
        select.selectByValue("NY");

    }

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
