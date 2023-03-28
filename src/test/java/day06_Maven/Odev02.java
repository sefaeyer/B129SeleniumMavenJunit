package day06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Odev02 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));

        //  O D E V  2
        //“https://www.saucedemo.com” Adresine gidin
        //Username kutusuna “standard_user” yazdirin
        //Password kutusuna “secret_sauce” yazdirin
        //Login tusuna basin
        //Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        //Add to Cart butonuna basin
        //Alisveris sepetine tiklayin
        //Sectiginiz urunun basarili olarak sepete eklendigini control edin
        //Sayfayi kapatin



    }
}
