package myPractices;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C02_100DefaTikla extends TestBase {
    //- http://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz
    //- Add Element butonuna 100 defa basınız
    //- 100 defa basıldığını test ediniz
    //- 90 defa delete butonuna basınız
    //- 90 defa basıldığını doğrulayınız
    //- Sayfayı kapatınız


    @Test
    public void test1() {
        //- http://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        //- Add Element butonuna 100 defa basınız
        WebElement addElm =  driver.findElement(By.xpath("//button[@onclick='addElement()']"));

        for(int i=0; i<100; i++){
            addElm.click();
        }

        //- 100 defa basıldığını test ediniz
        List<WebElement> deleteElmns = driver.findElements(By.xpath("//button[@onclick='deleteElement()']"));
        Assert.assertEquals(100,deleteElmns.size());

        //- 90 defa delete butonuna basınız
        for (int i = 0; i < 90; i++) {
            driver.findElement(By.xpath("//*[@onclick='deleteElement()']")).click();
        }

        //- 90 defa basıldığını doğrulayınız
        List<WebElement> deleteElmns2 = driver.findElements(By.xpath("//button[@onclick='deleteElement()']"));
        Assert.assertEquals(10,deleteElmns2.size());

        //- Sayfayı kapatınız
        driver.close();
    }
}
