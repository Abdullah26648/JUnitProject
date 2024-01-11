import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_JUnit {
    /*
     ******JUNIT*****
    Java ile en temel framework JUnit ile oluşturulabilir.
    * JUnit açık kaynaklı bir birim test aracıdır ve küçük/büyük kod birimlerini test etmek için kullanılır
    * JUnit testini çalıştırmak için bir sınıf nesnesi oluşturmanız veya main method tanımlamanız gerekmez.
    Developerlar da unit testleri calistirmak icin kullanirlar.
    Biz testlerimizi yapmak icin JUnit'in ileri sürümü olduğundan TestNG framework oluşturup kullanacagiz
    * JUnit ayrıca birden çok test senaryosuna sahip Otomasyon paketini çalıştırmak için kullanılır.

    * Test dediğimizde tek bir method veya içinde birçok class ve package barındıran bir yapı olabilir.
    *  Regression Test, Smoke Test vb.
    * Testmethod’u ise @Test notasyonu kullanılarak oluşturulan ve bağımsız olarak çalıştırabileceğimiz en küçük test yapısıdır.
    @Test annotation : Test methodu
*/

    @Test
    public void test01(){
        //Create driver object
        WebDriver driver = new ChromeDriver();
        //Maximize window
        driver.manage().window().maximize();
        //Go to Google
        driver.get("https://google.com");
        //Close window
        driver.close();
    }

    @Test
    public void test02(){
        //Create driver object
        WebDriver driver = new ChromeDriver();
        //Maximize window
        driver.manage().window().maximize();
        //Go to Clarusway
        driver.get("https://clarusway.com");
        //Close window
        driver.close();
    }

    @Test
    public void test03(){
        //Create driver object
        WebDriver driver = new ChromeDriver();
        //Maximize window
        driver.manage().window().maximize();
        //Go to Facebook
        driver.get("https://facebook.com");
        //Close window
        driver.close();
    }


}
