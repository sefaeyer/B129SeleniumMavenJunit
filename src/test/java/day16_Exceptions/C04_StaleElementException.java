package day16_Exceptions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C04_StaleElementException extends TestBase {
    @Test
    public void staleElementExceptionTest() {

        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//reklami kapatir

        driver.navigate().refresh();

        WebElement lmsLogin = driver.findElement(By.linkText("LMS LOGIN"));
        lmsLogin.click();//Calisti


    }

    @Test
    public void staleElementExceptionTest2() {

        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//reklami kapatir

        WebElement lmsLogin = driver.findElement(By.linkText("LMS LOGIN"));

        driver.navigate().refresh();
        lmsLogin.click();//StaleElementReferenceException
        //Locator dogru fakat adres refresh sonrasi silindigi icin LMSLogin konteryneri artik kullanilamaz
        //Yeniden Locate gerekir

    }

    @Test
    public void staleElementExceptionTest3() {

        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//reklami kapatir

        WebElement lmsLogin = driver.findElement(By.linkText("LMS LOGIN"));
        lmsLogin.click();

        bekle(2);
        driver.navigate().back();//==> geri dondu ve yenilendi
        bekle(2);
        lmsLogin.click();//StaleElementReferenceException
    }

    @Test
    public void staleElementExceptionTest4() {

        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//reklami kapatir

        WebElement lmsLogin = driver.findElement(By.linkText("LMS LOGIN"));
        lmsLogin.click();

        bekle(2);
        driver.navigate().back();//==> get back and refresh --> webelement eskidi
        bekle(2);
        lmsLogin = driver.findElement(By.linkText("LMS LOGIN"));//Tekrar locate islemi yaparak lmsLogin objesine yeni adres
        lmsLogin.click();//Works smoothly

    }

    @Test
    public void staleElementExceptionTest5() {

        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//reklami kapatir

        WebElement lmsLogin = driver.findElement(By.linkText("LMS LOGIN"));
        lmsLogin.click();

        driver.get("https://techproeducation.com");//gittikten sonra sayfaya geri donerek sayfayi yenilemis olur
        try {//reklamin cikma yda cikmama ihtimaline karsi try-catch yaparak olusabilecek exception i handle ederiz
            driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        } catch (Exception ignored) {

        }

        lmsLogin.click();//StaleElementReferenceException

    }

    @Test
    public void StaleElementReferanceExceptionTest5() {

        //NOT:StaleElementReferanceException hatası almamız gerekiyor
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //Çıkan sonuclardan ilk 5'ine tıklayıp sayfa başlıklarını alalım konsola yazdıralım
        List<WebElement> urunler = driver.findElements(By.xpath("//h2"));
        for (int i = 0; i < urunler.size(); i++) {
            urunler.get(i).click();
            bekle(3);
            driver.navigate().back();
            bekle(3);
            if (i == 4) {
                break;
            }
            //Sayfayı kapatalım

        }


    }

    @Test
    public void StaleElementReferanceExceptionTest7() {

        //NOT:StaleElementReferanceException hatası almamız gerekiyor
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //Çıkan sonuclardan ilk 5'ine tıklayıp sayfa başlıklarını alalım konsola yazdıralım
        List<WebElement> urunler = driver.findElements(By.xpath("//h2"));
        for (int i = 0; i < urunler.size(); i++) {
            urunler.get(i).click();
            bekle(3);
            driver.navigate().back();
            bekle(3);
            if (i == 4) {
                break;
            }
            urunler = driver.findElements(By.xpath("//h2"));
            //Sayfayı kapatalım

        }
    }
}


