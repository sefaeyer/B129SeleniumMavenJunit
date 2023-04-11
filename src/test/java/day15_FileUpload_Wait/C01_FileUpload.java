package day15_FileUpload_Wait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.awt.*;

public class C01_FileUpload extends TestBase {
    /*
        https://the-internet.herokuapp.com/upload adresine gidin
        logo.jpeg dosyasını yükleyin(upload)
        “File Uploaded!” textinin görüntülendiğini test edin
        */
    @Test
    public void fileUpload() {
         /*
        Bir Web sayfasında upload işlemi yapmamız gerekirse;
            1-Öncelikle upload edeceğimiz webelementi locate ederiz
            2-Upload edeceğimiz dosya yolunu bir string'e assingn ederiz
            3-Locate ettiğimiz webelement'e sendkeys() methodu ile dosyayolunu aldığımız string değişkeni göndeririz
         */

        //https://the-internet.herokuapp.com/upload adresine gidin
        driver.get("https://the-internet.herokuapp.com/upload");

        //        logo.jpeg dosyasını yükleyin(upload)
        WebElement dosyaSecWE = driver.findElement(By.id("file-upload"));
        bekle(3);
        String dosyaYolu = "C:\\Users\\Sefa\\OneDrive\\Masaüstü\\b129.txt";
        //String dosyaYolu = System.getProperty("user.home")+"\\OneDrive\\Masaüstü\\b129.txt";
        dosyaSecWE.sendKeys(dosyaYolu);
        bekle(3);

        //        “File Uploaded!” textinin görüntülendiğini test edin
        driver.findElement(By.id("file-submit")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());

    }
}
