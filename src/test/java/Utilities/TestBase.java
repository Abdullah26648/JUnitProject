package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    protected static ExtentReports extentReports; // Raporlama işlemini gerçekleştirir
    protected static ExtentSparkReporter extentHtmlReporter; // Raporu HTML olarak düzenler
    protected static ExtentTest extentTest; // Testimizin pass veya fail olduğunu saklayan objemiz. Ekran görüntüleri için de kullanılır


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

    public void getSpecificElementsScreenShot(WebElement element){

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

    //Bu metod parantez içinde belirtilen web table'ın istediğimiz satır ve sütunundaki değeri String olarak döner.
    public String getTableCell(WebElement table, int row, int cell){

        return table.findElement(By.xpath(".//tbody/tr["+row+"]/td["+cell+"]")).getText();

    }

    public ExtentReports extentReportsSetUp() {

        // Extent report objelerimizi oluşturuyoruz
        extentReports = new ExtentReports();

        // Kaydedeceğimiz dosya için tarih stringi oluşturuldu
        String currentDate = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String filePath = System.getProperty("user.dir") + "/test-output/reports/testReport_" + currentDate;

        // HTML raporu oluşturacak obje dosya yoluyla initialize edildi
        extentHtmlReporter = new ExtentSparkReporter(filePath);

        // Raporlama yapan extentreport objemize HTML reporter bağlandı
        extentReports.attachReporter(extentHtmlReporter);

        // Test başlatılıyor
        //extentTest = extentReports.createTest(TestBase.class.getSimpleName() + " - " + Thread.currentThread().getStackTrace()[2].getMethodName());

        // Rapor ile alakalı ekstra opsiyonel bilgiler verildi
        extentReports.setSystemInfo("Environment", "QA");
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Tester", "Tester CW");
        extentReports.setSystemInfo("Company", "Clarusway");

        // HTML raporunda görüntülemek istediğimiz konfigürasyonlar yapıldı
        extentHtmlReporter.config().setDocumentTitle("JUnit_Report");
        extentHtmlReporter.config().setReportName("Test run report");

        // extentReports.flush(); --> Test sonu raporun oluştutulması için unutulmamalıdır.

        return extentReports;

    }

    //Bu metod explicit wait kullanarak bir web elementi locate eder
    public WebElement waitForVisibility(By by){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));

    }

}
