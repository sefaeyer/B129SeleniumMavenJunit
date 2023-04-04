package day09_DropDown_Alerts;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class Ornek01 extends TestBase {

    @Test
    public void test01() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

        //a. Tüm eyalet isimlerini yazdıralım
        WebElement state = driver.findElement(By.id("state"));
        Select select = new Select(state);
//        select.selectByIndex(4);
//        select.selectByVisibleText("Utah");
//        select.selectByValue("TX");
        List<WebElement> allState = select.getOptions();
        allState.forEach(t-> System.out.println(t.getText()));

        System.out.println("************************");

        List<WebElement> tumDDM = driver.findElements(By.tagName("option"));
        tumDDM.forEach(t-> System.out.println(t.getText()));

    }
}
