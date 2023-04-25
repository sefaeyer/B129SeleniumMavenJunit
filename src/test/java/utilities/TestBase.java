package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class TestBase {

    ////TestBase class'indan obje olusturmanin onune gecilmesi icin abstract yapilabilir
    ////Orn: TestBase base=new TestBase();
    ////Bu class'a extend ettigimiz test classlarindan ulasabiliriz.
    protected static WebDriver driver;

    protected static ExtentReports extentReports; //Raporlamayı başlatır
    protected static ExtentHtmlReporter extentHtmlReporter;//Raporu HTML formatında düzenler
    protected static ExtentTest extentTest;//Tüm test aşamalarında extentTest objesi ile bilgi ekleriz
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
        //------------------------------------------
        extentReports = new ExtentReports();
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "TestOutput/reports/extentReport_"+tarih+".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReports.attachReporter(extentHtmlReporter);

        //Raporda gözükmesini istediğimiz bilgiler için
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Tester","Sefa");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("Smoke Test Raporu");
        extentTest=extentReports.createTest("ExtentTest","Test Raporu");
    }

    @After
    public void tearDown() throws Exception {
        extentReports.flush();
        bekle(3);
        //driver.quit();
    }
    //HARD WAIT METHODU
    public static void bekle(int saniye) {
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    //Alert Accept
    public static void alertAccept(){
        driver.switchTo().alert().accept();
    }
    //Alert Dismiss
    public static void alertDismiss(){
        driver.switchTo().alert().dismiss();
    }
    //Alert getText()
    public static void alertText(){
        driver.switchTo().alert().getText();
    }
    //Alert promptBox
    public static void alertprompt(String text){
        driver.switchTo().alert().sendKeys(text);
    }


    //DropDown VisibleText
    /*
        Select select2 = new Select(gun);
        select2.selectByVisibleText("7");

        //ddmVisibleText(gun,"7"); --> Yukarıdaki kullanım yerine sadece method ile handle edebilirim
     */
    public static void ddmVisibleText(WebElement ddm, String secenek){
        Select select = new Select(ddm);
        select.selectByVisibleText(secenek);
    }

    //DropDown Index
    public static void ddmIndex(WebElement ddm,int index){
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }

    //DropDown Value
    public static void ddmValue(WebElement ddm,String secenek){
        Select select = new Select(ddm);
        select.selectByValue(secenek);
    }

    //SwitchTo: sayfalar arasi gecis methodu
    //Index sifir 0'dan baslar
    //Girilen indexteki windowHandle degerini alarak o sayfaya gecis yapar
    public static void switchToWindow(int sayfaIndexi){
        List<String> windowHandleList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandleList.get(sayfaIndexi));

    }

    //SwitchToWindow2
    public static void window(int sayi){
        driver.switchTo().window(driver.getWindowHandles().toArray()[sayi].toString());
    }

    //Explicit Wait
    public static void visibleWait(WebElement element, int sayi){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sayi));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    //Tüm Sayfa ScreenShot
    public static void tumSayfaResmi(){
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "TestOutput/screenshot"+tarih+".png";
        TakesScreenshot ts = (TakesScreenshot) driver;
        try {
            FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Webelement ScreenShot
    public static void webElementResmi(WebElement element){
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "TestOutput/webElementScreenshot"+tarih+".png";
        try {
            FileUtils.copyFile(element.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //ExtentReport
    public void extentReport() {
        extentReports = new ExtentReports();
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "TestOutput/reports/extentReport_" + tarih + ".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReports.attachReporter(extentHtmlReporter);

        //Raporda gözükmesini istediğimiz bilgiler için
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Tester", "Erol");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("Smoke Test Raporu");
    }

    //WebTable
    public void printData(int satir, int sutun){
        WebElement satirSutun = driver.findElement(By.xpath("(//tbody)[1]//tr["+satir+"]//td["+sutun+"]"));
        System.out.println(satirSutun.getText());
    }

    //Click Methodu
    public void click(WebElement element){
        try {
            element.click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();",element);
        }

    }



}
