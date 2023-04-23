package day_05_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FilesDownload extends TestBase {

    // 'https://the-internet.herokuapp.com/download' adresine gidiniz
    // some-file.txt dosyasini indirelim
    // dosyanin bilgisayarınızda Downloads(indirilenler)'a basariyla indirilip indirilmedigini test ediniz


    @Test
    public void test01() {
        // 'https://the-internet.herokuapp.com/download' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/download");
bekle(2);
        // some-file.txt dosyasini indirelim
        driver.findElement(By.xpath("//a[text()='some-file.txt']")).click();
bekle(2);

        // dosyanin bilgisayarınızda Downloads(indirilenler)'a basariyla indirilip indirilmedigini test ediniz


        /*
            dosyanin bilgisayara indirilip indirilmedigini Java ile test edicem cunku Selenium webSayfasi test eder
            bilgisayardaki downloads a musahale edemez.
         */

        // "C:\Users\BURAK\Downloads\some-file.txt"
        //"C:\Users\Sefa\Downloads\chromedriver_win32 (1).zip"

        String farkliKisim = System.getProperty("user.home");

        String ortakKisim = "\\Downloads\\some-file.txt";

        String dosyaYolu = farkliKisim+ortakKisim;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}
