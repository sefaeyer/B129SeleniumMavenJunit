package day15_zz_Tekrar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_FileUpload extends TestBase {

    /*
    https://the-internet.herokuapp.com/upload adresine gidin
    logo.jpeg dosyasını yükleyin(upload)
    “File Uploaded!” textinin görüntülendiğini test edin
    */
    @Test
    public void test01() {

        //https://the-internet.herokuapp.com/upload adresine gidin
        driver.get("https://the-internet.herokuapp.com/upload");

        //    logo.jpeg dosyasını yükleyin(upload)
        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        bekle(2);

        chooseFile.sendKeys(System.getProperty("user.home")+"\\OneDrive\\Masaüstü\\b129.txt");

        WebElement fileUploadButton = driver.findElement(By.id("file-submit"));
        fileUploadButton.click();

        //    “File Uploaded!” textinin görüntülendiğini test edin
        WebElement fileUploadedText = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(fileUploadedText.isDisplayed());
    }
}
