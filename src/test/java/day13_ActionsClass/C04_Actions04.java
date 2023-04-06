package day13_ActionsClass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_Actions04 extends TestBase {
    /*
    https://jqueryui.com/droppable/ adresine gidin
    "Drag me to my target" elementini "Drop here" elementi üzerine bırakınız.
     */

    @Test
    public void actions() {
        //https://jqueryui.com/droppable/ adresine gidin
        driver.get("https://jqueryui.com/droppable/");

        //"Drag me to my target" elementini "Drop here" elementi üzerine bırakınız.
        driver.switchTo().frame(0);

        WebElement dragSource = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement dropTarget = driver.findElement(By.xpath("//*[@id='droppable']"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragSource,dropTarget).perform();
        //Source(drag) webelementini alip Target(drop) webelementi uzerine tasir.

    }

    @Test
    public void actions2() {
        //https://jqueryui.com/droppable/ adresine gidin
        driver.get("https://jqueryui.com/droppable/");

        //"Drag me to my target" elementini "Drop here" elementi üzerine bırakınız.
        driver.switchTo().frame(0);

        WebElement dragSource = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement dropTarget = driver.findElement(By.xpath("//*[@id='droppable']"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(dragSource).//webelementi tutup bekler
                moveToElement(dropTarget).//mouse u elementi uzerine tasir
                release().//serbest birakir
                perform();
    }

    @Test
    public void actions3() {
        //https://jqueryui.com/droppable/ adresine gidin
        driver.get("https://jqueryui.com/droppable/");

        //"Drag me to my target" elementini "Drop here" elementi üzerine bırakınız.
        driver.switchTo().frame(0);

        WebElement dragSource = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement dropTarget = driver.findElement(By.xpath("//*[@id='droppable']"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(dragSource).
                moveByOffset(162,35).//Webelementi istedigimiz koordinata tasir
                release().perform();
    }
}
