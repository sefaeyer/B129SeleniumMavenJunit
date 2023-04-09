package myPractices;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C04_Task04_AmazonDropDown extends TestBase {

    //-Amazon sayfasına gidelim
    //-Arama Kutusundaki Dropdown menuyu yazdıralım
    //-Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
    //başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım
    //Not: Select Class'ı kullanalım


    @Test
    public void test1() {
        //-Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //-Arama Kutusundaki Dropdown menuyu yazdıralım
        WebElement aramaDDM = driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
        Select select = new Select(aramaDDM);
        for (WebElement w: select.getOptions()) {
            System.out.println(w.getText());
        }
        System.out.println("******************************");

        //-Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
        //başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım
        int sayac=1;
        for (WebElement w:select.getOptions()) {
            Select option = new Select(driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']")));
            option.selectByIndex(sayac);
            driver.findElement(By.xpath("//*[@type='submit']")).click();
            System.out.println(driver.getTitle());
            bekle(2);
            driver.navigate().back();
            bekle(2);
            sayac++;
            if(sayac>=6){
                break;
            }
        }
        driver.close();
    }
}
