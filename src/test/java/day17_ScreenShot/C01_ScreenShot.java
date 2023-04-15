package day17_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ScreenShot extends TestBase {
    @Test
    public void screenShotTest() throws IOException {
        //Tum ekran goruntusunu Selenium dan gelen getScreenShotAs methodu ile aliriz.
        //Bu method Seleniumdaki TakesScreenShot arayuzunden gelir.

        //Techproeducation sayfasina gidelim.
        driver.get("https://techproeducation.com");

        //-->1. adim -- ilk olarak dosyayi nereye kaydedecegimizi belirtiriz.
        String dosyaYolu = "test_output/screenshot.png";

        //-->2. adim -- TakeScreenShot arayuzunden obje olusturmak
        TakesScreenshot ts = (TakesScreenshot) driver;

        //-->3. adim --
        //FileUtils class i file nesneleri ile birlikte kullanabilecegimiz methodlar icerir.
        //Bu methodlari kullanarak dosyalarda okuma yazma kopyalama ve silme islemlerini cok daha kolay yapabiliriz.
        //-->Note: fils.write() methodu da ayni islemi gorur.
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));

        //Ekran resmini projemize kaydedelim.

    }

    @Test
    public void screenShotTest2() throws IOException {
        driver.get("https://amazon.com");
        //Kaydettigimiz ekran resmi her seferinde ayni dosyanin uzerine yazmamasi icin dosya isminden sonra tarih atayabiliriz.
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());

        String dosyaYolu = "test_output/screenshot"+tarih+".png";
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));

    }
}
