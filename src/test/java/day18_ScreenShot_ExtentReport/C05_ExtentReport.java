package day18_ScreenShot_ExtentReport;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_ExtentReport extends TestBase {
    @Test
    public void test() {
        extentTest=extentReports.createTest("ExtentTest","Test Raporu");
        driver.get("https://techproeducation.com");
        extentTest.info("Techproeducation sayfasina gidildi.");
        bekle(2);
        extentTest.info("2 saniye bekletildi");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        extentTest.info("Cikan reklam kapatildi");

        //sayfanin resmini alalim
        tumSayfaResmi();
        extentTest.info("Tum sayfanin resmi alindi");

        //Arama bolumunde java aratalim
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("java", Keys.ENTER);
        extentTest.info("Arama bolumunde java aratildi");

        //sonuc yazisinin resmini alalim
        WebElement sonucYazisi = driver.findElement(By.xpath("//h1"));
        webElementResmi(sonucYazisi);
        extentTest.info("Sonuc yazisinin resmi alindi");
        extentTest.pass("Test sonlandirildi");
    }
}
