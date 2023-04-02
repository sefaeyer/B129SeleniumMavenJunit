package day10_Alert_Iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_Iframe extends TestBase {
    //Sinif : IFrame
    //➢ https://testcenter.techproeducation.com/index.php?page=iframe
    //➢ Ana sayfadaki ‘An iframe with a thin black border:’ metninde ‘black border’ yazisinin   oldugunu test edelim
    //➢ Ayrica ‘Applications lists’ yazisinin sayfada oldugunu test edelim
    //➢ Son olarak footer daki ‘Povered By’ yazisini varligini test edilip


    @Test
    public void iframe() {
        // https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

        //➢ Ana sayfadaki ‘An iframe with a thin black border:’ metninde ‘black border’ yazisinin   oldugunu test edelim
        String actualText = driver.findElement(By.xpath("//p[text()='An iframe with a thin black border:']")).getText();
        Assert.assertTrue(actualText.contains("black border"));



        //➢ Ayrica ‘Applications lists’ yazisinin sayfada oldugunu test edelim
        driver.switchTo().frame(0);
        /*
        Eğer iki tane iframe olsaydı ve 2. frame'e geçmek isteseydim index'i 1 almam gerekicekti
        Örneğin:
            <body>
                <iframe id="outerIframe" src="https://www.w3schools.com">
                    <iframe id="innerIframe" src="https://www.google.com"></iframe>
                </iframe>
            </body>
        -Index ile yukarıda bahsettiğimiz gibide yapabilirsiniz
        -iframe'i locate ederekte örneğin yukarıdaki kodun "iframe[id='outerIframe']" ccsSelector ile locate edilmiş hali
        -id ve name attributu varsa "driver.switchTo().frame("outerIframe")" bu şekildede geçiş yapabilirsiniz
         */
        String actaulText2 = driver.findElement(By.xpath("//*[text()='Applications lists']")).getText();
        Assert.assertEquals(actaulText2,"Applications lists");


        //➢ Son olarak footer daki ‘Povered By’ yazisini varligini test edilip
        driver.switchTo().defaultContent();
        WebElement poweredByYazisi = driver.findElement(By.xpath("//*[text()='Povered By']"));
        Assert.assertTrue(poweredByYazisi.getText().contains("Povered By"));

    }
}
