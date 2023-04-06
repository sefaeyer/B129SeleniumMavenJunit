package day13_ActionsClass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_Actions03 extends TestBase {
    /*
     https://techproeducation.com adresine gidin
     Sayfanın alt tarafına gidin
     Sayfanın üst tarafına gidin
     */

    @Test
    public void actions() {
        //https://techproeducation.com adresine gidin
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //     Sayfanın alt tarafına gidin
        Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();

        //     Sayfanın üst tarafına gidin
        bekle(2);
        action.sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).sendKeys(Keys.ARROW_UP).perform();
    }

    @Test
    public void actions2() {
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //     Sayfanın alt tarafına gidin
        Actions action = new Actions(driver);
        action.sendKeys(Keys.END);

        //     Sayfanın üst tarafına gidin
        bekle(2);
        action.sendKeys(Keys.HOME).build().perform();
    }

    @Test
    public void actions3() {
        //Amazon anasayfaya fit
        driver.get("https://amazon.com");
        //Arama kutusunda buyuk harflerlesamsung aratalim
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys(Keys.SHIFT,"s","a",Keys.SHIFT,"msung",Keys.ENTER);//SAmsung yazdirir
        driver.navigate().back();
        WebElement aramaKutusu2 = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu2.sendKeys(Keys.SHIFT,"iphone",Keys.ENTER);//IPHONE yazdirir
    }
}
