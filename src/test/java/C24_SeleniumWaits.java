import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

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

}
