package day14_FakerClass_FileExist;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {

    @Test
    public void fileExist() {
        //masaustunde bir dosya olusturalim
        //bu dosyanin varligini dogrulayalim:

        System.out.println("System.getProperty(\"user.dir\") = " + System.getProperty("user.dir"));//C:\Users\Sefa\IdeaProjects\B129SeleniumMavenJunit
        //projemizin icinde bulundugu yol

        System.out.println("System.getProperty(\"user.home\") = " + System.getProperty("user.home"));//C:\Users\Sefa
        //Lokalimizdeki kullanici yolunu verir

        //String dosyaYolu = "\"C:\\Users\\Sefa\\OneDrive\\Masaüstü\\b129.txt\"";
        String farkliKisim = System.getProperty("user.home");//her kullanicinin ana yolu farklidir
        String ortakKisim = "\\OneDrive\\Masaüstü\\b129.txt";
        String dosyaYolu = farkliKisim+ortakKisim;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
}
