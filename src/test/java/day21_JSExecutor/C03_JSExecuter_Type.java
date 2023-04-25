package day21_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_JSExecuter_Type extends TestBase {
    @Test
    public void typeTest() {
        //Techpro education ana sayfasina git
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //Arama kutusuna QA yaz
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@title='Search']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        /*
            Bazi giriş kutuları normal sendKeys() methodu ile metin gönderilmesine izim vermez.
            Bu gibi durumlarda aşağıdaki örnekteki gibi JSExecutor kullanılır
         */
        //js.executeScript("arguments[0].value='QA'",aramaKutusu);
        sendKeysJS(aramaKutusu,"QA");
        /*
        Eğer js.executeScript("arguments[0].value='QA'",aramaKutusu); bu kullanımdaki gibi metin gönderemezsek
        aşağıdaki örnekteki gibi value attribute'ne değer atayabiliriz
         */
       // js.executeScript("arguments[0].setAttribute('value','QA')",aramaKutusu);
        sendAttributeJS(aramaKutusu,"QA");
        aramaKutusu.submit();
    }
}
