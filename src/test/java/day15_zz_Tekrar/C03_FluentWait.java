package day15_zz_Tekrar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C03_FluentWait extends TestBase {
    /*
    https://the-internet.herokuapp.com/dynamic_loading/1
    Start buttonuna tıklayın
    Hello World! Yazının sitede oldugunu test edin
     */

    @Test
    public void test01() {
        //    https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //    Start buttonuna tıklayın
        driver.findElement(By.xpath("//div[@id='start']/button")).click();

        //    Hello World! Yazının sitede oldugunu test edin
//      Fluent wait in explicit wait ten farki wait objesinin olusturulmasinda ortaya cikar

        Wait<WebDriver> wait = new FluentWait<>(driver).
                                withTimeout(Duration.ofSeconds(20)).//Max bekleme süresi
                                pollingEvery(Duration.ofSeconds(3)).//Deneme aralıkları: Her 3 saniyede bir bulma denemesi yapar
                                withMessage("Exception Ignore edildi").//Mesaj yazdırılabilir: Zorunlu değil.
                                ignoring(NoSuchElementException.class);//Exception handle edilebilir: zorunlu değil.

        WebElement helloWorldText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));

        Assert.assertTrue(helloWorldText.isDisplayed());
    }
}
