package day13_ActionsClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions02 extends TestBase {
    @Test
    public void actions() {
        //Amazon anasayfasına gidin
        driver.get("https://amazon.com");

        //"Account & List" üzerinde bekleyin (mouse over - hover over)
        bekle(2);
        WebElement accountList = driver.findElement(By.xpath("//*[@id='nav-link-accountList']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(accountList).perform();
        bekle(2);
        //moveToElement methodu ile mause locate ettiğimiz WE'in üzerine gider

        //Açılan menüde "Account" linkine tıklayın
        driver.findElement(By.xpath("//*[text()='Account']")).click();
        bekle(2);
        //Açılan sayfanın başlığının "Your Account" içerdiğini doğrulayın
        Assert.assertEquals("Your Account",driver.getTitle());
    }
}