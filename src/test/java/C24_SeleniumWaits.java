import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class C24_SeleniumWaits {
    /*
            Implicit Wait  ve Explicit Wait

    Implicit: Bütün elemanlar için kullanılır ve bir kere tanımlanır.
    Explicit: Tek bir eleman özel kriter olarak tanımlanır, sadece ilgili elemanda geçerlidir.

    Her ikisi tanımlı ise: Önce Implicit kullanılır ve üzerine Explicit'in süresi eklenerek toplam hata sınırı süresi ortaya çıkar.
    Selenium waits (senkronizasyon): Kodlarımızı, internet ve bilgisayarın çalışmasını uyumlu hale getirmek için bazen kodlarımızı bekletmemiz gerekir.
        - Thread.sleep(): Java'dan gelir ve kodları durdurur. Kendisine verilen sürenin tamamını bekler. Dinamik değil, statiktir.

        implicitlyWait: Selenium'dan gelir. Sayfanın yüklenmesi ve her bir WebElement'in locate edilmesi için beklenecek maksimum süreyi belirler. Esnektir. Esas olan beklemek değil, kodun çalışmasını sağlamaktır. Kod çalışırsa beklemeden devam eder, çalışmazsa maksimum süre doluncaya kadar bekler ve sonra hata mesajı verir (Exception).

        explicitlyWait: Selenium'dan gelir ve belirli bir işlem için beklenecek maksimum süreyi belirler. ExplicitlyWait kullanabilmek için wait objesi oluşturmamız gerekir.
        - wait.until(expectedConditions… İstediğimiz fonksiyon) şeklinde kullanılır. Genellikle wait.until() method'u locate ile birlikte kullanılır.

        ExpectedConditions:
        - .titleIs -> Başlık bu olana kadar bekle
        - .titleContains -> Başlıkta bu kelime geçene kadar bekle
        - .visibilityOfTheElement -> Eleman görünür olana kadar bekle
        - .elementToBeClickable -> Eleman tıklanabilir olana kadar bekle
        - .elementToBeSelected -> Eleman seçilebilir olana kadar bekle
        - .alertIsPresent() -> Alert çıkana kadar bekle
        - .textToBe -> Elemanda verilen metin gözükene kadar bekle
        - .invisibilityOfTheElement -> Eleman kaybolana kadar bekle
    */

    private static WebDriver driver;

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

    @Test
    public void pageLoadTimeOut(){
        //Sayfanın yüklenmesi için 20 saniyeye kadar bekleme koyuyoruz
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        //Belirlenen süre kadar safyanın yüklenmesini bekler, yüklenmezse TimeoutException atar.

        driver.get("https://seleniumatfingertips.wordpress.com/");

        driver.findElement(By.id("menu-item-738")).click();

    }

    @Test
    public void implicitWatTest(){
    /*
        Implicit (kapsamlı) bekleme, tüm sayfadaki elemanlar için varsayılan bir bekleme süresi atar.
        Ancak, eleman bulunduğu anda daha fazla beklemeyi bırakır.
        Bu, sayfadaki tüm elemanlar için geçerlidir ve verilen süre kadar bir eleman bulunana kadar bekler.
        Yani, NoSuchElementException hatası almamak için belirtilen süre boyunca bekler.
        Implicit bekleme globaldir, yani tüm web elementleri için aynı bekleme süresi kullanılır.
    */
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//Bu satırı bir kez belirterek sayfadaki tüm elemenalara uyguluyoruz

        driver.get("https://thinking-tester-contact-list.herokuapp.com/");

        //Olmayan bir web elementini tıklayalım.
        driver.findElement(By.id("XYZ")).click();

    }

    @Test
    public void explicitWaitTest(){
    /*
        // WebDriverWait ve explicit wait, WebDriver'ın belirli bir koşulu beklemesi için kullanılır.
        // WebDriverWait objesi, beklemenin yapılandırılması ve yönetilmesi için kullanılır.

        WebDriverWait wait = new WebDriverWait(driver, 10); // 10 saniyeye kadar beklemeyi ayarla

        // until methodu, belirli bir koşul gerçekleşene kadar veya zaman aşımına ulaşana kadar beklemeyi sağlar.
        // ExpectedConditions sınıfı, yaygın olarak kullanılan koşulları içerir.
        // Örneğin, bir elementin görünür olmasını beklemek için:

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("exampleId")));

        // Element görünür hale geldiğinde bekleme sona erer ve ilgili WebElement döndürülür.

    */

        //Go to https://thinking-tester-contact-list.herokuapp.com/"
        driver.get("https://thinking-tester-contact-list.herokuapp.com/");

        //Click on submit
        driver.findElement(By.id("submit")).click();

        //Get error message and validate
        String errorMessageBeforeWait = driver.findElement(By.id("error")).getText();
        System.out.println("errorMessageBeforeWait = " + errorMessageBeforeWait);//Mesaj boş dönüyür çünkü senkronizasyon problemi var.

        //Senkronizasyon problemini Explicit Wait ile çözelim:
        //1. Adım: Wait objesi oluştur
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 saniyeye kadar beklemeyi ayarla
        //2. Adım:  Obje ile until() methodunu kullan
        String errorMessageAfterWait = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error"))).getText();
        System.out.println("errorMessageAfterWait = " + errorMessageAfterWait);

        assertEquals("Incorrect username or password", errorMessageAfterWait);

    }

    @Test
    public void fluentWaitTest(){
        // Elementin belirli bir koşulu sağlayıp sağlamadığını kontrol eden Fluent Wait örneği.
        // Belirtilen süre boyunca koşul sağlandığında devam eder, aksi takdirde bir NoSuchElementException atar.
        //Go to https://softwaretestingplace.blogspot.com/2017/02/selenium-fluent-wait.html
        driver.get("https://softwaretestingplace.blogspot.com/2017/02/selenium-fluent-wait.html");

        //Click on 'Click Me - Fluent Wait'
        driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();

        //Click işlemi sonrası istenilen elementin gelmesi 10 saniye alacağından elementin görünür olmasını bekleyecek bir Fluent Wait koyalım
        //1. Adım: Fluent wait objesi oluştur.
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))//Toplam bekleme süresi
                .pollingEvery(Duration.ofSeconds(2))//Her 2 saniyede bir elementin varlığını kontrol eder
                .ignoring(NoSuchElementException.class);//NoSuchElementException'ı görmezden gelir

        //2. Adım:  Obje ile until() methodunu kullan
        String message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[.='Software Testing Material - DEMO PAGE']"))).getText();

        assertEquals("Software Testing Material - DEMO PAGE", message);

    }
}