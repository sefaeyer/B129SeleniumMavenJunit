package day14_FakerClass_FileExist;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C02_Faker {
    @Test
    public void faker() {
        //1. Faker objesi olustururuz
        Faker faker = new Faker();

        //YADA Faker.instance() methodu ile de kullanabiliriz Faker faker = Faker.instance();

        //Firstname yazdiralim
        System.out.println("fake first Name = " + faker.name().firstName());
        System.out.println("Faker.instance().firstName() = " + Faker.instance().name().firstName());

        //LastName yazdiralim
        System.out.println("faker.name().lastName() = " + faker.name().lastName());

        //Kullanici Adi yazdiralim
        System.out.println("faker.name().username() = " + faker.name().username());

        //meslek ismi
        System.out.println("faker.name().title() = " + faker.name().title());
        System.out.println("faker.job().position() = " + faker.job().position());

        //sehir ismi
        System.out.println("faker.address().city() = " + faker.address().city());

        //ulke ismi
        System.out.println("faker.address().country() = " + faker.address().country());

        //adres yazdiralim
        System.out.println("faker.address().fullAddress() = " + faker.address().fullAddress());

        //telefon number
        System.out.println("faker.phoneNumber().cellPhone() = " + faker.phoneNumber().cellPhone());

        //ulke kodu
        System.out.println("Faker.instance().address().countryCode() = " + Faker.instance().address().countryCode());
        //zipcode
        System.out.println("faker.address().zipCode() = " + faker.address().zipCode());

        //rastgele 15 haneli bir numara
        System.out.println("faker.number().digits(15) = " + faker.number().digits(15));

        //email adres
        System.out.println("faker.internet().emailAddress() = " + faker.internet().emailAddress());
    }



}
