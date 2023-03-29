package Odevler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C01_facebook {

    /*
        https://www.facebook.com
 adresine gidin
Cookies’i kabul edin
“Create an Account” button’una basin
“radio buttons” elementlerini locate edin
Secili degilse cinsiyet butonundan size uygun olani secin
     */
    WebDriver driver;
    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("test basladi");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("test bitti");
    }

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
        driver.get("https://facebook.com");
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void test01() {
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
    }

    @Test
    public void test02() {
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        WebElement woman = driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
        WebElement man = driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
        WebElement special = driver.findElement(By.xpath("(//input[@type='radio'])[3]"));

        if(!man.isSelected()){
            man.click();
        }
    }
}
