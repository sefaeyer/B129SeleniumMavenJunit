package day06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Calisma01 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));


        //  O D E V  1
//  https://www.google.com/ adresine gidin  3- cookies uyarisini kabul ederek kapatin
        driver.get("https://www.google.com/");

//Sayfa basliginin “Google” ifadesi icerdigini test edin
        String baslik = driver.getTitle();
        if(baslik.contains("Google")){
            System.out.println("test passed");
        }else System.out.println("test failed");

//Arama cubuguna “Nutella” yazip aratin
        driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("Nutella", Keys.ENTER);

//Bulunan sonuc sayisini yazdirin
        WebElement sonucYazisi = driver.findElement(By.xpath("//div[@id='result-stats']"));
        String [] sonucSayisi = sonucYazisi.getText().split(" ");
        System.out.println("sonuc Sayisi = " + sonucSayisi[1]);

//sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        String sonuc = sonucSayisi[1];
        sonuc = sonuc.replace(".","");
        int sonucInt = Integer.parseInt(sonuc);

        if(sonucInt>10000000){
            System.out.println("10 milyondan buyuk");
        }else System.out.println("10 milyondan kucuk");

//Sayfayi kapatin
        driver.close();
    }
}
