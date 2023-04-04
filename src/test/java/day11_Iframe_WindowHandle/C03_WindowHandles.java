package day11_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C03_WindowHandles extends TestBase {

    @Test
    public void windowHandles() {

        //https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //    İlk sayfanın ID'sini(Window Handle değerini) alın.
        String ilkSayfaWindowHandle = driver.getWindowHandle();

        //    Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement sayfaTexti = driver.findElement(By.xpath("//h3"));
        Assert.assertEquals("Opening a new window",sayfaTexti.getText());

        //    Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle = driver.getTitle();
        Assert.assertEquals("The Internet",actualTitle);

        //    "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();

        //    Açılan pencereye geçin.
        /*
        eger bir butona click yapinca kontrolumuz disinda yeni pencere aciliyorsa o pencere icindeki webElementleri handle
        edebilmem icin switchTo methodu ile gecis yapilir. kontolumuz disinda oldugu icin tum acilan pencereleri
        getWindowHandles ile  bir SET e assign ederiz
         */
        Set<String> tumPencereler = driver.getWindowHandles();
        for(String w:tumPencereler){
            if(!w.equals(ilkSayfaWindowHandle)){
                driver.switchTo().window(w);
            }
        }//Burda amac bizim kontrolumuz disinda acilan pencereye gecis yapmak
        //2.YOL:
//        List<String> tumWindowHandles = new ArrayList<String>(driver.getWindowHandles());
//        driver.switchTo().window(tumWindowHandles.get(1));


        //    Açılan yeni pencerenin sayfa başlığının(title) “New Window” olduğunu doğrulayın.
        bekle(2);
        String gercekBaslik = driver.getTitle();
        Assert.assertEquals("New Window",gercekBaslik);
        String ikinciSayfaHandle = driver.getWindowHandle();

        //    Bir önceki pencereye dönüp sayfa başlığının “The Internet” olduğunu  doğrulayın.
        bekle(2);
        driver.switchTo().window(ilkSayfaWindowHandle);
        Assert.assertEquals("The Internet",driver.getTitle());

        //    2. pencereye tekrar geçin.
        bekle(2);
        driver.switchTo().window(ikinciSayfaHandle);


        //    1. pencereye tekrar dönün.
        bekle(2);
        driver.switchTo().window(ilkSayfaWindowHandle);

    }
}
