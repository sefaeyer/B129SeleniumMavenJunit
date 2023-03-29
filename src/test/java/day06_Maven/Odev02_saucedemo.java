package day06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Odev02_saucedemo {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));

        //  O D E V  2
        //“https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");

        //Username kutusuna “standard_user” yazdirin
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");

        //Password kutusuna “secret_sauce” yazdirin
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");

        //Login tusuna basin
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement ilkUrun = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
        ilkUrun.click();

        //Add to Cart butonuna basin
        driver.findElement(By.xpath("//button[text()='Add to cart']")).click();

        //Alisveris sepetine tiklayin
        WebElement sepet = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        sepet.click();

        //Sectiginiz urunun basarili olarak sepete eklendigini control edin
        String expected ="Sauce Labs Backpack";
        String actuel = driver.findElement(By.xpath("//*[@class='inventory_item_name']")).getText();
        if(actuel.equals(expected)){
            System.out.println("urun eklendi");
        }else System.out.println("urun yanlis");

        //Sayfayi kapatin
        driver.close();


    }
}
