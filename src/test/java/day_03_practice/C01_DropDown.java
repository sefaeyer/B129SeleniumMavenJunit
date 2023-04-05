package day_03_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C01_DropDown {

    // https://www.amazon.com/ sayfasina gidin
    // dropdown'dan "Books" secenegini secin
    // arama cubuguna "Java" aratın
    // arama sonuclarinin Java icerdigini test edin.

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
    }

    @After
    public void tearDown() throws Exception {
        //driver.close();
    }

    @Test
    public void test01() {

        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/");

        // dropdown'dan "Books" secenegini secin
        //-->> dropdown 3 adimda handle edilir:
        //  1. dropdown locate edilmeli
        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        //  2. select objesi olusturulur
        Select select = new Select(ddm);

        //  3. Optionlardan bir tanesi secilir.
        //select.selectByVisibleText("Books");
        //select.selectByIndex(5); // index 0'dan baslar
        select.selectByValue("search-alias=stripbooks-intl-ship");


        // arama cubuguna "Java" aratın
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Java", Keys.ENTER);

        // arama sonuclarinin Java icerdigini test edin.
        WebElement aramasonucu = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String aramasonucYazisi = aramasonucu.getText();

        Assert.assertTrue(aramasonucYazisi.contains("Java"));
    }
}
