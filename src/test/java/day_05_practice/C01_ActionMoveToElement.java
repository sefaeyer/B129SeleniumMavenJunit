package day_05_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.Set;

public class C01_ActionMoveToElement extends TestBase {

    // https://amazon.com adresine gidiniz
    // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
    // Change country/region butonuna basiniz
    // United States dropdown'undan 'Turkey (Türkiye)' seciniz
    // Go to website butonuna tiklayiniz
    // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz


    @Test
    public void test01() {
        // https://amazon.com adresine gidiniz
        driver.get("https://amazon.com");
        String sayfa1Handle = driver.getWindowHandle();

        // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim

        WebElement dilMenu = driver.findElement(By.xpath("//div[text()='EN']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(dilMenu).perform();
        bekle(3);

        // Change country/region butonuna basiniz
        driver.findElement(By.xpath("(//div[@class='icp-mkt-change-lnk'])[1]")).click();
        bekle(2);

        // United States dropdown'undan 'Turkey (Türkiye)' seciniz
        WebElement ddm = driver.findElement(By.xpath("//select[@id='icp-dropdown']"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Turkey (Türkiye)");
        bekle(2);

        //!!! -->  ddm manusu acik kaldigi icin sayfada herhangi bi yere tikliyoruz
        driver.findElement(By.xpath("//span[text()='Changing country/region website']")).click();
        bekle(2);

        // Go to website butonuna tiklayiniz
        driver.findElement(By.xpath("//input[@class='a-button-input']")).click();

        // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz
        Set<String> winHandlesSet = driver.getWindowHandles();
        System.out.println(winHandlesSet);
        System.out.println(sayfa1Handle);

        String sayfa2Handle="";
        for(String each:winHandlesSet){
            if(!each.equals(sayfa1Handle)){
                sayfa2Handle=each;
            }
        }
        driver.switchTo().window(sayfa2Handle);

        String titleOfSecWin = driver.getTitle();
        System.out.println(titleOfSecWin);

        Assert.assertTrue(titleOfSecWin.contains("Elektronik"));

    }
}
