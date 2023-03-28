package day06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Odev01 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));


        //  https://www.google.com/ adresine gidin  3- cookies uyarisini kabul ederek kapatin
        driver.get("https://google.com");

        //Sayfa basliginin “Google” ifadesi icerdigini test edin
        String baslik = driver.getTitle();
        System.out.println("baslik = " + baslik);
        if(baslik.contains("Google")){
            System.out.println("test gecti");
        }else System.out.println("test kaldi");

        //Arama cubuguna “Nutella” yazip aratin
        driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("Nutella", Keys.ENTER);

        //Bulunan sonuc sayisini yazdirin
        WebElement sonucYazisi = driver.findElement(By.cssSelector("div[id='result-stats']"));
        String [] sonucarr = sonucYazisi.getText().split(" ");

        //System.out.println("sonuc Sayisi = " + sonucarr[1]);
        //sonuc sayisinin 10 milyon’dan fazla oldugunu test edin


        //sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        String soncc11 = sonucarr[1];
        System.out.println("soncc11 = " + soncc11);
        soncc11=soncc11.replace(".","");
        System.out.println("soncc11 = " + soncc11);
        int sonucInt = Integer.parseInt(soncc11);



        if(sonucInt > 10000000){
            System.out.println("test passed");
        }else System.out.println("test failed");

        //Sayfayi kapatin
        driver.close();
    }
}
