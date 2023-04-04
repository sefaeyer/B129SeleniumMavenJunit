package day09_DropDown_Alerts;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Ornek02 extends TestBase {

    @Test
    public void test01() {

        // https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //    1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        //    “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("//*[@onclick='jsAlert()']")).click();
        bekle(3);
        driver.switchTo().alert().accept();

    }

    @Test
    public void test02() {
        // https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //    2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının

    }
}
