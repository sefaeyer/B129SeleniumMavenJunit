package day16_Exceptions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_TimeOutException extends TestBase {
    @Test
    public void timeOutExceptionTest() {
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//reklami kapatir

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//YANLIS LOCATOR")));
        //TimeOutException explicit wait kullaniminda web element bulunamadigi zaman alinir
    }

    @Test
    public void timeOutExceptionTest2() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.xpath("//div[@id='start']//button")).click();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));//TimeOutException
        boolean isTrue = wait.until(ExpectedConditions.textToBe(By.xpath("//div[@id='finish']//h4"),"Hello World!"));
        //Locator dogru ama yeterli bekleme suresi olmadigi icin TimeOutException aliyoruz
        System.out.println(isTrue);

    }
}
