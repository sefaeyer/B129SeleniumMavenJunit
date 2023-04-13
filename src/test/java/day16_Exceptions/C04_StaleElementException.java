package day16_Exceptions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

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

}
