import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import page.RegistrationPage;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class BaseTest {

    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();
    String name = faker.name().firstName();
    String secondName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    long phoneNumber = (long) ((Math.random() * (9999999999L - 1000000000L)) + 1000000000L);
    String month = "April";
    String year = "2007";
    String day = "15";


    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
    }

    @Test
    void fillFormTest() {


        registrationPage.openPage()
                .mainDataOfPerson(name, secondName, email, phoneNumber)
                .chooseGender("Male")
                .dateOfBirthday(year, month, day)
                .subject()
                .interests("Music")
                .interests("Sports")
                .addFile()
                .adress()
                .submit()
                .checking(name + " " + secondName);
    }
}