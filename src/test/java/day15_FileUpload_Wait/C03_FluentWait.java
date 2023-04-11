package day15_FileUpload_Wait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import utilities.TestBase;

import java.time.Duration;

public class C03_FluentWait extends TestBase {
    @Test
    public void fluentWait() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //    Start buttonuna tıklayın
        driver.findElement(By.xpath("//button")).click();

        //    Hello World! Yazının sitede oldugunu test edin
        Wait<WebDriver> wait = new FluentWait<>(driver).
                withTimeout(Duration.ofSeconds(30)). //Fluent wait icin max. sureyi belirtir.
                pollingEvery(Duration.ofSeconds(3)).//her uc saniyede bir webelemnti kontrol eder
                withMessage("Ignore Exception").//zorunlu degil
                ignoring(NoSuchElementException.class);//zorunlu degil

        WebElement helloWorldText2 = driver.findElement(By.xpath("(//h4)[2]"));
        wait.until(ExpectedConditions.visibilityOf(helloWorldText2));

        Assert.assertTrue(helloWorldText2.isDisplayed());

        /*
            Thread.sleep: Javdan gelen bu bekleme ile belirttigimiz sure kadar kodlari bekletir.
            Implicitly Wait: Sayfadaki tum webelementler icin max sure kadar sayfanin yuklemesini bekler
            Explicitly Wait: Belirli bir kosul gerceklesene kadar belirttigimiz sure boyunca driver in beklemesini saglar
            Fluent Wait: Belirli bir kosul gerceklesene kadar belirttigimiz araliklarla beklemeye devam eder.
         */
    }
}
