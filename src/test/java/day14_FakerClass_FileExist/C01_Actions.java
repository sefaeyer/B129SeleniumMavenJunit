package day14_FakerClass_FileExist;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;
/*
    "https://techproeducation.com/" gidin
    İlk kelime SHIFT tuşuna basılı şekilde, ikinci kelime basılmadan "TECHPRO education" araması yapın.
     */
public class C01_Actions extends TestBase {
    @Test
    public void actions() {
        //"https://techproeducation.com/" gidin
        driver.get("https://techproeducation.com/");
        driver.findElement(By.cssSelector("i[class='eicon-close']")).click();
        //    İlk kelime SHIFT tuşuna basılı şekilde, ikinci kelime basılmadan "TECHPRO education" araması yapın.
        WebElement search = driver.findElement(By.xpath("//*[@type='search']"));
        Actions actions = new Actions(driver);
        actions.keyDown(search, Keys.SHIFT).
                sendKeys("techpro").
                keyUp(Keys.SHIFT).
                sendKeys(" education",Keys.ENTER).perform();
        bekle(3);
        //Sayfayi Richmond Collage Enrollmet Form linkine kadar asagi in
        WebElement richmondCollage = driver.findElement(By.xpath("(//h3//a)[9]"));
        actions.scrollToElement(richmondCollage).perform();// bu cok isinize yarar...
        //scrollToElement() methodu ile locate ettiğiniz bir webelemente kadar yani o element görünene kadar scroll
        //yapabilirsiniz
    }
}
