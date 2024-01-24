package Utilities;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

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
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    public static Cell getCellValue(String excelFileName, String sheetName, int rowIndex, int cellIndex) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"\\resources\\"+excelFileName+".xlsx");

        Workbook workbook = WorkbookFactory.create(fileInputStream);

        return workbook.getSheet(sheetName).getRow(rowIndex).getCell(cellIndex);

    }

    public void getFullPageScreenShot() {

        //1. Adım: Type casting
        TakesScreenshot ts = (TakesScreenshot)driver;

        //2. Adım: getScreenshotAs() metodu
        File ss = ts.getScreenshotAs(OutputType.FILE);

        //3. Adım: Alınan screeenshot dosyasını bir hedefe kopyala
        String now = new SimpleDateFormat("yyMMddhhmmss").format(new Date())+System.nanoTime();

        try {
            FileUtils.copyFile(ss, new File(".\\test-output\\screenshots\\FullScreenshot"+now+".png") );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public void getSpecificElementScreenShot(WebElement element){

        //1. Adım: Locate edilen web element ile getScreenshotAs() metodunu kullan
        File ss = element.getScreenshotAs(OutputType.FILE);

        //2. Adım: Screenshot'ı ilgili yere kopyala
        String now = new SimpleDateFormat("yyMMddhhmmss").format(new Date())+System.nanoTime();
        try {
            FileUtils.copyFile(ss, new File(".\\test-output\\screenshots\\specificElementScreenShot"+now+".png") );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
