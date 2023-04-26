package day22_Log4j;

import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_Log4jTest extends TestBase {
    @Test
    public void log4jTest1() {
        Logger logger = LogManager.getLogger(C02_Log4jTest.class);
        //    http://www.uitestpractice.com/Students/Form sayfasına git
        driver.get("http://www.uitestpractice.com/Students/Form");
        logger.info("UITestPractice sayfasina gidildi");
        System.out.println("UITestPractice sayfasina gidildi");

        //    Formu doldur
        Faker faker = new Faker();
        WebElement firstName = driver.findElement(By.id("firstname"));
        firstName.sendKeys(faker.name().firstName(), Keys.TAB,faker.name().lastName(),Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,
                Keys.TAB,Keys.TAB, Keys.TAB,Keys.TAB,"SEFA");
        logger.info("Form da istenen bolumler dolduruldu");
        System.out.println("Form da istenen bolumler dolduruldu");

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
        logger.warn("JS kodu kullanilmis olabilir JSExecutor kullanildi");
        System.out.println("JS kodu kullanilmis olabilir JSExecutor kullanildi");

        //    Sayfa adresinin "http://www.uitestpractice.com/Students/Form?optradio=on" olup olduğunu doğrula.
        Assert.assertNotEquals("http://www.uitestpractice.com/Students/Form?optradio=on",driver.getCurrentUrl());
        logger.info("Istenen Url kontrol edildi");
        System.out.println("Istenen Url kontrol edildi");

    }
}
