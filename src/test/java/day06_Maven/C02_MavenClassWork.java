package day06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class C02_MavenClassWork {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));

//        http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

//        Signin buttonuna tiklayin
        driver.findElement(By.xpath("//*[@id='signin_button']")).click();

//        Login alanine  “username” yazdirin
        WebElement login = driver.findElement(By.xpath("//*[@id='user_login']"));
        login.sendKeys("username");

//        Password alanine “password” yazdirin
        WebElement password = driver.findElement(with(By.tagName("input")).below(login));
        password.sendKeys("password");

//        Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.navigate().back();//--> geri don

//        Pay Bills sayfasina gidin --> once online banking e gidilir
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        driver.findElement(By.xpath("//*[text()='Pay Bills']")).click();

//        amount kismina yatirmak istediginiz herhangi bir miktari yazin
        WebElement amount = driver.findElement(By.cssSelector("input[id='sp_amount']"));
        amount.sendKeys("15750", Keys.ENTER);

//        tarih kismina “2020-09-10” yazdirin
        WebElement tarih = driver.findElement(By.cssSelector("input[id='sp_date']"));
        tarih.sendKeys("2020-09-10");

//        Pay buttonuna tiklayin
        driver.findElement(By.cssSelector("input[id='pay_saved_payees']")).click();

//        “The payment was successfully submitted.” mesajinin ciktigini control edin
        WebElement mesaj = driver.findElement(By.xpath("//*[text()='The payment was successfully submitted.']"));
        if(mesaj.isDisplayed()){
            System.out.println("TEST PASSED");
        }else System.out.println("TEST FAILED");

       // driver.close();
    }
}
//  O D E V  1
//  https://www.google.com/ adresine gidin  3- cookies uyarisini kabul ederek kapatin
//Sayfa basliginin “Google” ifadesi icerdigini test edin
//Arama cubuguna “Nutella” yazip aratin
//Bulunan sonuc sayisini yazdirin
//sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
//Sayfayi kapatin


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