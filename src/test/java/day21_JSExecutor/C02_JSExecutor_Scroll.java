package day21_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_JSExecutor_Scroll extends TestBase {
    JavascriptExecutor js;
    @Test
    public void jsExecutorScrollTest() {
        //    Techpro education ana sayfasına git
        driver.get("https://techproeducation.com");
        bekle(1);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //    "We Offer" elementi görünür olacak şekilde üzerine scroll et ve ekran görüntüsünü al
        WebElement weOffer = driver.findElement(By.xpath("//*[text()='we offer']"));
        bekle(2);
        /*
        js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",weOffer);
        */
        scroll(weOffer);
        bekle(1);
        tumSayfaResmi();

        //    Aynı sayfada "Enroll Free "elementi görünür olacak sekilde scroll et ve ekran görüntüsünü al
        WebElement enrollFree = driver.findElement(By.xpath("//*[text()='Enroll Free Course']"));
//        js= (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true);",enrollFree);

        scroll(enrollFree);
        bekle(1);
        tumSayfaResmi();

        //    Aynı sayfada "WHY US?" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        WebElement whyUs = driver.findElement(By.xpath("//*[text()='WHY US?']"));
        /*
        js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",whyUs);
         */
        scroll(whyUs);
        bekle(1);
        tumSayfaResmi();

        //    Aynı sayfada tekrar "Enroll Free" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
//        js= (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true);",enrollFree);

        scroll(enrollFree);
        bekle(1);
        tumSayfaResmi();

        //sayfayi en alta scrol yapalim
        /*
        js= (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        */
        scrollEnd();

        //sayfayi en uste scroll yapalim
        /*
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
        */
        bekle(1);

        scrollHome();
        //js.executeScript("window.scrollTo(0,-500)");

    }
}
