package day10_Alert_Iframe;

import org.junit.Test;
import utilities.TestBase;

public class C01_AlertMethods extends TestBase {

    //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
    //    Bir metod olusturun: acceptAlert
    //    1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
    //    Bir metod olusturun: dismissAlert
    //    2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    //    “successfuly” icermedigini test edin.
    //    Bir metod olusturun: sendKeysAlert
    //    3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    //    tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.


    @Test
    public void AcceptAlert() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

    }
}
