package day07_zz_Tekrar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C06_ClassWork2 {
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void test01() {
        //        Verilen web sayfasına gidin.
        //        https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        //        Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement cb1 = driver.findElement(By.xpath("(//*[@type='checkbox'])[1]"));
        WebElement cb2 = driver.findElement(By.xpath("(//*[@type='checkbox'])[2]"));

        //        Checkbox1 seçili değilse onay kutusunu tıklayın
        if(!cb1.isSelected()){
            cb1.click();
        }

        //        Checkbox2 seçili değilse onay kutusunu tıklayın
        if(!cb2.isSelected()){
            cb2.click();
        }
    }
}
