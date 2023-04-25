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
        js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",weOffer);


        //    Aynı sayfada "Enroll Free "elementi görünür olacak sekilde scroll et ve ekran görüntüsünü al
        //    Aynı sayfada "WHY US?" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        //    Aynı sayfada tekrar "Enroll Free" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
    }
}
