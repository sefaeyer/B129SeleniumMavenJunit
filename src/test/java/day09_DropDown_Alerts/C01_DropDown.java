package day09_DropDown_Alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_DropDown {
    /*
--DropDown Nedir: Alt basliklarin oldugu acilir menu listesi
--DropDown nasil automate edilir?(Handle):
      a-DropDown menuyu ilk olarak locate ederiz
      b-Select objesi olustururuz
      c-Select objesinin DropDown menu Webelementinin icerigine ve seceneklerine
      erisim saglamasi icin Select sinifina argument olarak Locate ettigimiz
      webelementi koyariz
      ORNEK: Select select= new Select(DDM Webelement)

      d-Select class'i sadece <select> tag'i ile olusturulmus DropDown menulere uygulanabilir.
      e-select objesi ddm yu handle edebilmek icin 3 method kullamilir
        -selectByVisibleText() ->Ddm deki elemente görünür metin ile ulaşmak için kullanılır
                 -selectByIndex() -> Index ile ulaşmak için kullanılır(Index 0 dan başlar)
                 -selectByValue() -> Elementin değeri ile ulaşmak için kullanılır(option tag'ındaki değer ile)
           f-getOptions()->Locate ettiğimiz ddm'deki tüm seçenekleri bize döndürür
           g-getFirstSelectedOption()->Ddm'deki en son seçili kalan ilk seçeneği bize döndürür

     */

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @Test
    public void test02() {
        //a. Tüm eyalet isimlerini yazdıralım
       /* WebElement tumEyaletler = driver.findElement(By.cssSelector("select[id='state']"));
        Select select = new Select(tumEyaletler);
        List<WebElement> stateList = select.getOptions();// butun options tag lerini getir
//        for (WebElement w:stateList){
//            System.out.println(w.getText());
//        }
        stateList.forEach(t-> System.out.println(t.getText()));
         */
        List<WebElement> tumEyaletler = driver.findElements(By.xpath("//*[@id='state']//option"));
        System.out.println(tumEyaletler.get(2).getText());
        System.out.println("****************************");
        tumEyaletler.forEach(t-> System.out.println(t.getText()));

        //b sayfadaki tum dd
        List<WebElement> eyaletlerList = driver.findElements(By.tagName("option"));
        eyaletlerList.forEach(t-> System.out.println(t.getText()));
        System.out.println("*********");
        System.out.println(tumEyaletler.size());
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3300);
        driver.close();
    }
}
