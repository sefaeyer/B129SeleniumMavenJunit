package day18_ScreenShot_ExtentReport;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C02_WebElementScreenShot extends TestBase {
    @Test
    public void webElementScreenShot() throws IOException {
        //Amazon sayfasına gidiniz
        driver.get("https://amazon.com");

        //Arama bölümünde iphone aratınız
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //Sonuc yazısının resmini alınız
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "TestOutput/screenshot"+tarih+".png";
        FileUtils.copyFile(sonucYazisi.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
        /*
            Sadece bir webelementin resmini almak istersek, FileUtils.copyFile() methodu ile locate ettigimiz
            webelementi getScreenshotAs() methodu kullanarak rermini alabiliriz.
         */
    }
}
