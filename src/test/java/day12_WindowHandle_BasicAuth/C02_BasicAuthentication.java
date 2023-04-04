package day12_WindowHandle_BasicAuth;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C02_BasicAuthentication extends TestBase {

/*
    Aşağıdaki bilgileri kullanarak authentication yapınız:
    Url: https://the-internet.herokuapp.com/basic_auth
    Username: admin
    Password: admin
    Başarılı girişi doğrulayın.
     */

    @Test
    public void test01() {
        //Url: https://the-internet.herokuapp.com/basic_auth
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        //paragrafin congratulation icerdigini dogrulayin
        String paragraf = driver.findElement(By.xpath("//p")).getText();
        Assert.assertTrue(paragraf.contains("Congratulations"));


    }
}
