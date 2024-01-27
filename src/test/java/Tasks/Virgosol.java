package Tasks;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class Virgosol extends TestBase {
    /*
        Amazon Senaryosu
    //https://www.amazon.com.tr/ sitesi açılır.
    //Ana sayfanın açıldığı kontrol edilir.
    //Çerez tercihlerinden Çerezleri kabul et seçilir.
    //Siteye login olunur.
    //Login işlemi kontrol edilir.
    //Hesabım bölümünden “Virgosol Liste” isimli yeni bir liste oluşturulur.
    //Arama butonu yanındaki kategoriler tabından bilgisayar seçilir.
    //Bilgisayar kategorisi seçildiği kontrol edilir.
    //Arama alanına msi yazılır ve arama yapılır.
    //Arama yapıldığı kontrol edilir.
    //Arama sonuçları sayfasından 2. sayfa açılır.
    //2'inci sayfanın açıldığı kontrol edilir.
    //Sayfadaki 2'inci ürün oluşturulan “Virgosol Liste” listesine eklenir.
    //2'inci Ürünün listeye eklendiği kontrol edilir.
    //Hesabım  Alışveriş Listesi sayfasına gidilir.
    //“Alışveriş Listesi” sayfası açıldığı kontrol edilir.
    //Eklenen ürün Virgosol Liste’sinden silinir.
    //Silme işleminin gerçekleştiği kontrol edilir.
    //Virgosol Liste'si silinir.
    //Üye çıkış işlemi yapılır.
    //Çıkış işleminin yapıldığı kontrol edilir.
    //Not: Virgosol Liste'si task yeniden çalıştırıldığında sorun olmaması için silinmektedir.
     */
    @Test
    public void virgosol() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        //https://www.amazon.com.tr/ sitesi açılır.
        driver.get("https://www.amazon.com.tr/");

        //Ana sayfanın açıldığı kontrol edilir.
        assertTrue(driver.getCurrentUrl().contains("amazon.com.tr"));

        //Çerez tercihlerinden Çerezleri kabul et seçilir.
        WebElement cerezKabulEt = driver.findElement(By.id("sp-cc-accept"));
        if (cerezKabulEt.isDisplayed()) {
            cerezKabulEt.click();
        }

        //Siteye login olunur.
        driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
        driver.findElement(By.id("ap_email")).sendKeys("bigasatranc@gmail.com" + Keys.ENTER);
        driver.findElement(By.id("ap_password")).sendKeys("Pass123" + Keys.ENTER);

        //Login işlemi kontrol edilir.
        assertTrue(driver.findElement(By.id("nav-link-accountList-nav-line-1")).getText().contains("Biga"));

        //Hesabım bölümünden “Virgosol Liste” isimli yeni bir liste oluşturulur.
        driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
        driver.findElement(By.xpath("(//span[@class='a-color-secondary'])[9]")).click();
        driver.findElement(By.xpath("//input[@aria-labelledby='createList-announce']")).click();
        driver.findElement(By.id("list-name")).click();
        driver.findElement(By.id("list-name")).clear();
        driver.findElement(By.id("list-name")).sendKeys("Virgosol Liste");
        WebElement listeOlustur = driver.findElement(By.xpath("(//input[@class='a-button-input a-declarative'])[3]"));
        wait.until(ExpectedConditions.elementToBeClickable(listeOlustur));
        Thread.sleep(2000);
        listeOlustur.sendKeys(Keys.ENTER);

        //Arama butonu yanındaki kategoriler tabından bilgisayar seçilir.
        driver.navigate().refresh();
        WebElement kategoriDropDown = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(kategoriDropDown);
        select.selectByValue("search-alias=computers");

        //Bilgisayar kategorisi seçildiği kontrol edilir.
        assertTrue(select.getFirstSelectedOption().getText().contains("Bilgisayar"));

        //Arama alanına msi yazılır ve arama yapılır.
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("msi" + Keys.ENTER);

        //Arama yapıldığı kontrol edilir.


        //Arama sonuçları sayfasından 2. sayfa açılır.


        //2'inci sayfanın açıldığı kontrol edilir.


        //Sayfadaki 2'inci ürün oluşturulan “Virgosol Liste” listesine eklenir.


        //2'inci Ürünün listeye eklendiği kontrol edilir.


        //Hesabım  Alışveriş Listesi sayfasına gidilir.


        //“Alışveriş Listesi” sayfası açıldığı kontrol edilir.


        //Eklenen ürün Virgosol Liste’sinden silinir.


        //Silme işleminin gerçekleştiği kontrol edilir.


        //Virgosol Liste'si silinir.


        //Üye çıkış işlemi yapılır.


        //Çıkış işleminin yapıldığı kontrol edilir.


        //Not: Virgosol Liste'si task yeniden çalıştırıldığında sorun olmaması için silinmektedir.



    }

}
