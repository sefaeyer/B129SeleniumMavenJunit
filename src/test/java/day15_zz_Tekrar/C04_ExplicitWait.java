package day15_zz_Tekrar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C04_ExplicitWait extends TestBase {

     /*
    https://the-internet.herokuapp.com/dynamic_controls sayfasına gidin
    Remove tuşuna basın
    "It's gone!" yazısını doğrulayın
     */

    @Test
    public void test01() {
        //    https://the-internet.herokuapp.com/dynamic_controls sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //    Remove tuşuna basın
        driver.findElement(By.xpath("//button[.='Remove']")).click();

        //    "It's gone!" yazısını doğrulayın
        Assert.assertTrue(driver.findElement(By.id("message")).isDisplayed());
        //Explicit Wait kullanma gerekği yoktur. Implicit wait yeterlidir.
        //Explicit wait bazı özel durumlar için kullanılır.
    }
}
