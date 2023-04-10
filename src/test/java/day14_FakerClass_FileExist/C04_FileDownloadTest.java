package day14_FakerClass_FileExist;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownloadTest extends TestBase {

    @Test
    public void fileDownload() {
        //https://testcenter.techproeducation.com/index.php?page=file-download    adresine gidelim.
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");
        bekle(2);
        File sil = new File("C:\\Users\\Sefa\\Downloads\\b10 all test cases, code.docx");
        sil.delete();

        //b10 all test cases dosyasını indirelim
        driver.findElement(By.xpath("(//a)[3]")).click();
        bekle(5);
        //"C:\Users\Sefa\Downloads\b10 all test cases, code.docx"

        //Dosyanın başarıyla indirilip indirilmediğini test edelim
        //ILK OLARAK DOSYA YOLUNU ALIYORUZ
        String dosyaYolu = System.getProperty("user.home")+"/Downloads/b10 all test cases, code.docx";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
}
