import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class C62_NullPointerException {
    /*
    NullPointerException
    🡪 Bir değişken oluşturulduğunda ancak başlatılamadığında veya işaretçi herhangi bir değer göstermediğinde NullPointerException alırız.
    🡪 Genelde driver başlatıldığında sık karşılaşılır.
    */
    WebDriver driver;//Burada driver null değerdedir.

    @Test
    public void nullPointerExceptionTest(){

        //driver = new FirefoxDriver();// Bu durumda driver artıl null değil

        driver.get("https://clarusway.com");//NullPointerException --> WebDriver initialize edilmedi. Çözüm: Null obje initialize edilmeli.


    }

}
