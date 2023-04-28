package myPractices;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C06_Task12 extends TestBase {

    //https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html adresine gidelim
    //Hesap makinasından 2 basamaklı random iki tane sayı seçelim ve random 4 işlemden birini yaptıralım
    //Sonucu konsola yazdırıp
    //Sonucun doğrulamasını yapalım

    @Test
    public void test01() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");

        WebElement bekleme = driver.findElement(By.xpath("//*[@id='delay']"));
        bekleme.clear();
        bekleme.sendKeys("0");

        driver.findElement(By.xpath("//*[text()='4']")).click();
        driver.findElement(By.xpath("//*[text()='9']")).click();
        driver.findElement(By.xpath("//*[text()='x']")).click();
        driver.findElement(By.xpath("//*[text()='1']")).click();
        driver.findElement(By.xpath("//*[text()='2']")).click();
        driver.findElement(By.xpath("//*[text()='=']")).click();

        WebElement sonuc = driver.findElement(By.cssSelector("*[class='screen']"));
        System.out.println("sonuc = " + sonuc.getText());


    }
}
