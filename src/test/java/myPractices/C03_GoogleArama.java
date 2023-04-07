package myPractices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_GoogleArama {

    //-BeforeClass methodu ile driver ı olusturun ve Maximize edin, 15 sn bekletin
    //-Before methodunda http://www.google.com adresine gidin
    //-Üç farklı test methodu ile;
    //-arama kutusuna "The God Father" yazip, cikan sonuc sayisini yazdirin
    //-arama kutusuna  "Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
    //-arama kutusuna  "Kill Bill" yazip, cikan sonuc sayisini yazdirin
    //-NOT: Çıkan sonuç sayılarını After methodunda yazdırınız
    //-AfterClass ile kapatın

    static WebDriver driver;
    @BeforeClass
    public static void beforeClass() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
    }

    @AfterClass
    public static void afterClass() throws Exception {
        driver.close();
    }


    @Before
    public void setUp() throws Exception {
        driver.get("https://google.com");
    }

    @After
    public void tearDown() throws Exception {
        String [] sonuc = driver.findElement(By.xpath("//*[@id='result-stats']")).getText().split(" ");
        System.out.println("arama Sonuc Yazisi = " + sonuc[1]);
    }

    @Test
    public void t1() {
        //-arama kutusuna "The God Father" yazip, cikan sonuc sayisini yazdirin
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys("The God Father",Keys.ENTER);

    }

    @Test
    public void t2() {
        //-arama kutusuna  "Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys("Lord of the Rings",Keys.ENTER);
    }

    @Test
    public void t3() {
        //-arama kutusuna  "Kill Bill" yazip, cikan sonuc sayisini yazdirin
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys("Kill Bill",Keys.ENTER);

    }
}
