package day_05_practice;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_Files {

    // Desktop(masaustu)'da bir text dosyası olusturun
    // Desktop(masaustu)'da text dosyasının olup olmadıgını test edin

    //"C:\Users\Sefa        \OneDrive\Masaüstü\text"

    @Test
    public void test01() {

        String farkliKisim = System.getProperty("user.home");
        System.out.println(farkliKisim);

        String ortakKisim = "\\OneDrive\\Masaüstü\\text";
        System.out.println(ortakKisim);

        String dosyaYolu = farkliKisim+ortakKisim;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
}
