package day18_ScreenShot_ExtentReport;

import org.junit.Test;
import utilities.TestBase;

public class C01_ScreenShot extends TestBase {
    @Test
    public void name() {
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        //Sayfanın resmini alalım
        tumSayfaResmi();
        //Sonra amazon sayfasına gidelim
        driver.get("https://amazon.com");
        //Amazon sayfasının ekran görüntüsünü alalım
        tumSayfaResmi();//Method kullanarak tüm ekran resmini aldık

    }
}
