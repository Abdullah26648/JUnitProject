import Utilities.TestBase;
import org.junit.Test;

public class C28_TestBase extends TestBase {

    @Test
    public void test1() {
        driver.get("http://youtube.com");
        System.out.println(driver.getTitle());
    }
    @Test
    public void test2() {
        driver.get("http://linkedin.com");
        System.out.println(driver.getTitle());
    }
    @Test
    public void test3() {
        driver.get("http://google.com");
        System.out.println(driver.getTitle());
    }
}
