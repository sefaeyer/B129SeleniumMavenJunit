package day11_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class C02_WindowHandle extends TestBase {


    @Test
    public void windowHandle() {
        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        //String techproWindowHandle = driver.getWindowHandle();
        //System.out.println("techproWindowHandle = " + techproWindowHandle);

        //Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        String actualTitle = driver.getTitle();
        String expectedTitle = "Techpro Education | Online It Courses & Bootcamps";
        Assert.assertEquals(expectedTitle,actualTitle);

        //Window 2'de https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://youtube.com");
        //String youtubeWindowHandle = driver.getWindowHandle();

        //Window 3'te https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        //String linkedinWindowHandle = driver.getWindowHandle();

        List<String> tumWindowList = new ArrayList<>(driver.getWindowHandles());
        // butun actigim pencerelerin handle degerlerini liste icine aldik

        //techproeducation sayfasına geçiniz:
        bekle(3);
        //driver.switchTo().window(techproWindowHandle);
        driver.switchTo().window(tumWindowList.get(0));//--> ilk actigimiz pencereyeindex ile gecebiliriz

        //youtube sayfasına geçiniz:
        bekle(3);
        //driver.switchTo().window(youtubeWindowHandle);
        driver.switchTo().window(tumWindowList.get(1));

        //linkedIn sayfasına geçiniz:
        bekle(3);
        //driver.switchTo().window(linkedinWindowHandle);
        driver.switchTo().window(tumWindowList.get(2));
    }
}
