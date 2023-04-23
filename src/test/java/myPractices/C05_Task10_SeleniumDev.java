package myPractices;

import com.aventstack.extentreports.ExtentReports;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C05_Task10_SeleniumDev extends TestBase {
    //https://www.selenium.dev/downloads/ adresine gidelim
    //Sayfanın resmini alalım
    //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
    //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
    //Documentation webelementinin resmini alalım
    //All versions available in Downloads altında Latest stable release olan linki tıklayalım
    //Açılan pencerede chromedriver'i indirelim
    //Driver'in indiğini doğrulayalım
    //İndirmiş olduğumuz dosyayı silelim
    //Silindiğini doğrulayalım
    //Not: Bu task'in her adımı için Html rapor oluşturalım(Extent Report)


    @Test
    public void test01() throws IOException {
        extentTest=new ExtentReports().createTest("Extent Test","Test Raporu");
        //https://www.selenium.dev/downloads/ adresine gidelim
        driver.get("https://www.selenium.dev/downloads/");
        String firstWinHandle = driver.getWindowHandle();
        extentTest.info("selenium.dev sayfasina gidildi ");

        //Sayfanın resmini alalım
        tumSayfaResmi();

        //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
        Actions actions = new Actions(driver);
        WebElement platform = driver.findElement(By.xpath("//*[@class='btn btn-dark btn-lg btn-block rounded-0 text-left']"));
        actions.scrollToElement(platform).perform();
        extentTest.info("Platforms yazisina dogru asagiya inildi ");


        //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
        driver.findElement(By.xpath("//*[@class='btn btn-dark btn-lg btn-block rounded-0 text-left']")).click();
        extentTest.info("Chrome driver indirildi ");
        bekle(2);
        driver.findElement(By.xpath("//*[@href='https://chromedriver.chromium.org/']")).click();
        bekle(2);

        //Documentation webelementinin resmini alalım
        WebElement docWebElement = driver.findElement(By.xpath("(//*[@class='C9DxTc aw5Odc '])[2]"));
        webElementResmi(docWebElement);
        docWebElement.click();

        Set<String> handles = driver.getWindowHandles();
        List<String> list = new ArrayList<>(handles);

        String birinci = list.get(0);
        String ikinci = list.get(1);

        if(firstWinHandle.equals(birinci)){
            driver.switchTo().window(ikinci);
        }else{
            driver.switchTo().window(birinci);
        }

        //All versions available in Downloads altında Latest stable release olan linki tıklayalım
        //Açılan pencerede chromedriver'i indirelim
        driver.findElement(By.xpath("//*[text()='chromedriver_win32.zip']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //Driver'in indiğini doğrulayalım
        String userHome = System.getProperty("user.home");
        boolean existFile = Files.exists(Paths.get(userHome+"\\Downloads\\chromedriver_win32.zip"));
        Assert.assertTrue(existFile);

        //İndirmiş olduğumuz dosyayı silelim
        Files.delete(Paths.get(userHome+"\\Downloads\\chromedriver_win32.zip"));

        //Silindiğini doğrulayalım
        boolean existFile2 = Files.exists(Paths.get(userHome+"\\Downloads\\chromedriver_win32.zip"));
        Assert.assertFalse(existFile2);


        //Not: Bu task'in her adımı için Html rapor oluşturalım(Extent Report)
        extentTest.pass("Test sonlandirildi");
    }
}
