import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class C42_Cookies extends TestBase {
    //Go to URL: https://kitchen.applitools.com/ingredients/cookie
    //Print all the cookies.
    //Get Cookie.
    //Find the total number of cookies.
    //Add Cookie.
    //Edit Cookie.
    //Delete Cookie.
    //Delete All Cookies.

    @Test
    public void cokkiesTest(){

        //Go to URL: https://kitchen.applitools.com/ingredients/cookie
        driver.get("https://kitchen.applitools.com/ingredients/cookie");

        //Print all the cookies.
        Set<Cookie> allCookies = driver.manage().getCookies();
        allCookies.forEach(System.out::println);//Lambda

        //Get Cookie.
        System.out.println("--Get Cookie--");
        System.out.println("Protein Cookie: " + driver.manage().getCookieNamed("protein"));
        System.out.println("Protein Cookie Value: " + driver.manage().getCookieNamed("protein").getValue());

        //Find the total number of cookies.
        int totalNumberOfCookies = driver.manage().getCookies().size();
        System.out.println("totalNumberOfCookies = " + totalNumberOfCookies);

        //Add Cookie.
        Cookie cookieSugar = new Cookie("Karbonhidrat", "Sugar");
        driver.manage().addCookie(cookieSugar);
        System.out.println("Sugar eklandikten sonra totalNumberOfCookies: " + driver.manage().getCookies().size());

        //Edit Cookie.

        //Delete Cookie.
        driver.manage().deleteCookie(cookieSugar);
        driver.manage().deleteCookieNamed("vegetable");
        System.out.println("Sugar ve vegetable silindikten sonra totalNumberOfCookies: " + driver.manage().getCookies().size());

        //Delete All Cookies.
        driver.manage().deleteAllCookies();
        System.out.println("Tüm cookies silindikten sonra: " + driver.manage().getCookies().size());

    }

}