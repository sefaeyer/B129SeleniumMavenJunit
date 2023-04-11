package day15_FileUpload_Wait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C05_ExplicitWait extends TestBase {
    @Test
    public void explicitWait() {
        //https://the-internet.herokuapp.com/dynamic_controls sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //    Remove tuşuna basın
        driver.findElement(By.xpath("//*[text()='Remove']")).click();

        //    "It's gone!" yazısını doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("(//p)[2]")).isDisplayed());
        //Implictly wait ile assertion yapabildik. Dolayısıyla diğer wait'lere gerek kalmadı

    }
}
