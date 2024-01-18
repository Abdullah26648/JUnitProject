package Utilities;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public abstract class TestBase {
    /*
    TestBase Class: Her test class'ında tekrar tekrar yazdığımız setup ve teardown method'larını tekrar
    yazmaktan kurtulmak için Java OOP konseptini kullanarak oluşturduğumuz bir class'tır.

    - Test Base'i parent olarak kabul eden class'lar hazırlık için oluşturduğumuz driver, setup() ve teardown()
    metodlarını oluşturmak zorunda kalmazlar; kendilerinde olmasa bile parent class'tan kullanılabilir.

    - TestBase genellikle testlerden farklı bir pakette bulunduğundan driver'ı kullanabilmek için public veya
    protected yapmamız gerekir. Biz hep child class'lardan kullanacağımız için protected yapmayı tercih ettik.

    - Bu class sadece child class'lardan inheritance özellikleri ile kullanılsın istediğimizden, bu class'ın
    obje oluşturularak kullanılmasına engel olmak için class'ı abstract YAPABİLİRİZ.

    - Abstract yaparak TestBase Class'ından obje oluşturulmasının önüne geçeriz. TestBase Class'ını sadece
    extends ile inherit ederek kullanacağız. Dolayısıyla oluşturduğumuz driver variable'ı için protected access
    modifier'ı seçiyoruz.
    */

    protected WebDriver driver;

    @Before
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    @After
    public void tearDown() throws InterruptedException {

        Thread.sleep(3000);
        driver.quit();

    }

}
