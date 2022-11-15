import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.io.File;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class HomeWork3 {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
    }

    @Test
    void fillFormTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Boris");
        $("#lastName").setValue("Dusan");
        $("#userEmail").setValue("BorisDusan@mail.ru");
        $("[for=\"gender-radio-1\"]").click();
        $("#userNumber").setValue("0123456789");
        $("#dateOfBirthInput").click();
//                executeJavaScript(
//                String.format("$('[id=\"%s\"]').val('%s')",
//                        "dateOfBirthInput", "01 Mar 2007")
//        );
        $(".react-datepicker__year-select").selectOptionByValue("2007");
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__day--001").click();
        $("#subjectsInput").setValue("E").pressEnter();
        $("[for='hobbies-checkbox-1']").click();
        $("[for='hobbies-checkbox-3']").click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/Picture.png"));
        $("#currentAddress").setValue("Grow street 1");
        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#react-select-4-input").setValue("Karnal").pressEnter();
        $("#submit").click();

        $(".table-responsive ").shouldHave(text("Boris Dusan"));
        $(".table-responsive ").shouldHave(text("BorisDusan@mail.ru"));
        $(".table-responsive ").shouldHave(text("Male"));
        $(".table-responsive ").shouldHave(text("0123456789"));
        $(".table-responsive ").shouldHave(text("01 April,2007"));
        $(".table-responsive ").shouldHave(text("English"));
        $(".table-responsive ").shouldHave(text("Sports, Music"));
        $(".table-responsive ").shouldHave(text("Picture.png"));
        $(".table-responsive ").shouldHave(text("Grow street 1"));
        $(".table-responsive ").shouldHave(text("Haryana Karnal"));
    }
}