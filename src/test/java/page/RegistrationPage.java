package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private SelenideElement firstNameTextField = $("#firstName");
    private SelenideElement lastNameTextField = $("#lastName");
    private SelenideElement phoneNumberTextField = $("#userNumber");
    private SelenideElement emailTextField = $("#userEmail");
    private SelenideElement results = $(".table-responsive");
    private SelenideElement yearField = $(".react-datepicker__year-select");
    private SelenideElement monthField = $(".react-datepicker__month-select");
    private ElementsCollection dayField = $$(".react-datepicker__day:not(.react-datepicker__day--outside-month)");
    private ElementsCollection intertest = $$(".custom-control-label");
    private ElementsCollection gender = $$("[for=\"gender-radio-1\"]");


    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        return this;
    }

    public RegistrationPage mainDataOfPerson(String name, String secondName, String mail, long phoneNumber) {
        firstNameTextField.setValue(name);
        lastNameTextField.setValue(secondName);
        emailTextField.setValue(mail);
        phoneNumberTextField.setValue(String.valueOf(phoneNumber));
        return this;
    }

    public RegistrationPage chooseGender(String genderOfPeople) {

        gender.findBy(text(genderOfPeople)).click();
        return this;
    }

    public RegistrationPage dateOfBirthday(String year, String month, String day) {
        $("#dateOfBirthInput").click();
        yearField.selectOptionByValue(year);
        monthField.selectOption(month);
        dayField.findBy(exactText(day)).click();
        return this;
    }

    public RegistrationPage subject() {
        $("#subjectsInput").setValue("E").pressEnter();
        return this;
    }

    public RegistrationPage interests(String differentInterests) {
        intertest.findBy(text(differentInterests)).click();
        return this;
    }

    public RegistrationPage addFile() {
        $("#uploadPicture").uploadFile(new File("src/test/resources/Picture.png"));
        return this;
    }

    public RegistrationPage adress() {
        $("#currentAddress").setValue("Grow street 1");
        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#react-select-4-input").setValue("Karnal").pressEnter();
        return this;
    }

    public RegistrationPage submit() {
        $("#submit").click();
        return this;
    }


    public RegistrationPage checking(String data) {
        results.shouldHave(text(data));
        return this;
    }
}
