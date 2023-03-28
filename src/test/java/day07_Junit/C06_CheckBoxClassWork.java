package day07_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C06_CheckBoxClassWork {
    /*
        Verilen web sayfasına gidin.
        https://the-internet.herokuapp.com/checkboxes
        Checkbox1 ve checkbox2 elementlerini locate edin.
        Checkbox1 seçili değilse onay kutusunu tıklayın
        Checkbox2 seçili değilse onay kutusunu tıklayın
     */
    static WebDriver driver;
    @BeforeClass
    public static void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));

    }

    @AfterClass
    public static void afterClass() throws Exception {
        Thread.sleep(3300);
        driver.close();
        System.out.println("test sonlandi");
    }

    @Test
    public void checkBox() throws InterruptedException {
        //Verilen web sayfasına gidin. https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        //        Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement checkBox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

        //        Checkbox1 seçili değilse onay kutusunu tıklayın
        if(!checkBox1.isSelected()){
            checkBox1.click();
        }

        //        Checkbox2 seçili değilse onay kutusunu tıklayın
        if(!checkBox2.isSelected()){
            checkBox2.click();
            Thread.sleep(3300);
        }

    }
}
