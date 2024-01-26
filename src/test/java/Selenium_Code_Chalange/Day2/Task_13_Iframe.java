package Selenium_Code_Chalange.Day2;

import Utilities.TestBase;
import org.junit.Test;

public class Task_13_Iframe extends TestBase {
  /*
 https://bonigarcia.dev/selenium-webdriver-java/iframes.html adresine gidin
 Paragraf sayısının 20 adet oldugunu dogrulayın

*/

    @Test
    public void test(){
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/iframes.html");
/*
ExpectedConditions.frameToBeAvailableAndSwitchToIt("my-iframe") ifadesi,
"my-iframe" adındaki bir iframe'in yüklendiğini bekler. İframe kullanılabilir hale geldiğinde,
bu ifade WebDriver'ın bu iframe'e geçiş yapmasını sağlar.
Bu, iframe içeriğine erişmek ve işlem yapmak için kullanışlıdır.
*/




        /*
ExpectedConditions.numberOfElementsToBeMoreThan(pName, 0) ifadesi,
sayfadaki bir veya daha fazla web öğesinin (HTML öğeleri)
varlığını bekler. pName bir By nesnesi olmalıdır ve
bu nesnenin temsil ettiği öğelerin sayısının 0'dan fazla olduğunu kontrol eder.
Yani, pName ile belirtilen türdeki web öğelerinin sayısı 0'dan fazla olduğunda
bekleme işlemi sona erer ve test devam eder.
*/

    }

}
