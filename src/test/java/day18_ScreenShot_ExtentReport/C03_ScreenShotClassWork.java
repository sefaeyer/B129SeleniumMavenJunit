package day18_ScreenShot_ExtentReport;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C03_ScreenShotClassWork extends TestBase {

    @Test
    public void classWork() {
        //Techproeducation sayfasina gidelim
        //sayfanin resmini alalim
        //Arama bolumunde java aratalim
        //sonuc yazisinin resmini alalim
        //Yeni bir sekmede amazona gidelim
        //sayfanin resmini alalim
        //arama bolumunde iphone aratalim
        //sonuc yazisinin resmini alalim.
        //Tekrar techproeducation sayfasina gecelim
        //sayfanin resmini alalim

        //Techproeducation sayfasina gidelim
        driver.get("https://techproeducation.com");
        bekle(3);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //sayfanin resmini alalim
        tumSayfaResmi();

        //Arama bolumunde java aratalim
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("java", Keys.ENTER);

        //sonuc yazisinin resmini alalim
        WebElement sonucYazisi = driver.findElement(By.xpath("//h1"));
        webElementResmi(sonucYazisi);

        //Yeni bir sekmede amazona gidelim
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com");

        //sayfanin resmini alalim
        tumSayfaResmi();

        //arama bolumunde iphone aratalim
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone",Keys.ENTER);

        //sonuc yazisinin resmini alalim.
        WebElement sonucYazisi2 = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        webElementResmi(sonucYazisi2);

        //Tekrar techproeducation sayfasina gecelim
        window(0);

        //sayfanin resmini alalim
        tumSayfaResmi();


    }
}
