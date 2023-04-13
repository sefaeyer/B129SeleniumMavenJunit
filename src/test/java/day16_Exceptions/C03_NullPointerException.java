package day16_Exceptions;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import utilities.TestBase;

public class C03_NullPointerException extends TestBase{

    Faker faker;
    Integer number;
    String name;
    @Test
    public void nullPointerExceptionTest() {
        driver = null;
        driver.get("https://techproeducation.com");//NullPointer exceptn aatae

    }

    @Test
    public void nullPointerExceptionTest2() {

        System.out.println(faker.number().numberBetween(1,10));
    }

    @Test
    public void nullPointerExceptionTest3() {
        //number=4;
        System.out.println(number+6);
    }

    @Test
    public void nullPointerExceptionTest4() {
        //name="Ali";
        System.out.println(name.charAt(0));
    }
}
