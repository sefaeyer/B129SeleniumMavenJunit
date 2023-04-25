package day21_JSExecutor;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.sql.Driver;

public class C01_JSExecutor_Click extends TestBase {
    @Test
    public void clickByJSTest() {
        /*
        Eğer bir web sayfasının HTML kodları tamamen yada kısmen JavaScript kullanılarak oluşturulduysa
     o sayfaya müdahale etmek için genellikle JavaScriptExecutor arayüzünü kullanmak gerekir.
        Bu durumda, sayfayı manipüle etmek veya etkileşimde bulunmak için standart WebDriver komutları
     yetersiz kalabilir. Bu nedenle JSExecutor arayüzü, sayfanın JS kodlarına doğrudan erişebilir.
        Ancak, mümkünse WebDriver'in sunduğu standart yöntemlerle sorunları çözmek her zaman daha iyidir.
     Çünkü JS kullanımı, sayfanın daha yavaş yüklenmesine neden olabili.
    */

        //    http://www.uitestpractice.com/Students/Form sayfasına git
        driver.get("http://www.uitestpractice.com/Students/Form");

        //    Formu doldur
        Faker faker = new Faker();
        WebElement firstName = driver.findElement(By.id("firstname"));
        firstName.sendKeys(faker.name().firstName(), Keys.TAB,faker.name().lastName(),Keys.TAB,Keys.TAB,Keys.TAB,
                Keys.TAB,Keys.TAB, Keys.TAB,Keys.TAB,faker.phoneNumber().cellPhone());

        //    Submit tuşuna tıkla
        //org.openqa.selenium.ElementClickInterceptedException: Eğer JS kodlarıyla bir web element oluşturulmuşsa
        //normal click() methodunda bu exception'ı alırız
        WebElement submit = driver.findElement(By.xpath("//*[text()='Submit']"));

//        try {
//            submit.click();
//        } catch (Exception e) {
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            js.executeScript("arguments[0].click();",submit);
//        }
        click(submit);

        //    Sayfa adresinin "http://www.uitestpractice.com/Students/Form?optradio=on" olup olduğunu doğrula.
        Assert.assertNotEquals("http://www.uitestpractice.com/Students/Form?optradio=on",driver.getCurrentUrl());

    }
}
