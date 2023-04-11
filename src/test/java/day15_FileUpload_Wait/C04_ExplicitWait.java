package day15_FileUpload_Wait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_ExplicitWait extends TestBase {
    @Test
    public void ExplicitWait() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //    Start buttonuna tıklayın
        driver.findElement(By.xpath("//button")).click();

        WebElement helloWorldText = driver.findElement(By.xpath("(//h4)[2]"));
        visibleWait(helloWorldText,15);//method from TestBase

        //    Hello World! Yazının sitede oldugunu test edin
        Assert.assertTrue(helloWorldText.isDisplayed());
    }
}
