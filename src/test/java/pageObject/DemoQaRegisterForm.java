package pageObject;

import com.codeborne.selenide.SelenideElement;
import components.CalendarComponent;
import components.ResultModal;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class DemoQaRegisterForm {
    final private CalendarComponent calendarComponent = new CalendarComponent();
    final private ResultModal resultModal = new ResultModal();


    final private SelenideElement firstNameInput = $("#firstName");
    final private SelenideElement lastNameInput = $("#lastName");
    final private SelenideElement emailInput = $("#userEmail");
    final private SelenideElement gender = $(".practice-form-wrapper #genterWrapper");
    final private SelenideElement mobileInput = $("#userNumber");
    final private SelenideElement birthDateInput = $("#dateOfBirthInput");
    final private SelenideElement subjectsInput = $("#subjectsInput");
    final private SelenideElement hobbiesInput = $(".practice-form-wrapper #hobbiesWrapper");
    final private SelenideElement pictureUploadInput = $("#uploadPicture");
    final private SelenideElement addressInput = $("#currentAddress");
    final private SelenideElement stateInput = $("#state");
    final private SelenideElement cityInput = $("#city");
    final private SelenideElement submitButton = $("#submit");


    public DemoQaRegisterForm setFirstNameInput(String firstNameInput) {
        this.firstNameInput
                .setValue(firstNameInput);

        return this;
    }

    public DemoQaRegisterForm setLastName(String lastName) {
        this.lastNameInput
                .setValue(lastName);

        return this;
    }

    public DemoQaRegisterForm setUserEmail(String email) {
        this.emailInput
                .setValue(email);

        return this;
    }

    public DemoQaRegisterForm setGender(String gender) {
        this.gender
                .$(byText(gender))
                .click();

        return this;
    }

    public DemoQaRegisterForm setMobile(String mobile) {
        this.mobileInput
                .setValue(mobile);

        return this;
    }

    public DemoQaRegisterForm setBirthDate(String year, String mouth, String day) {
        birthDateInput
                .click();

        calendarComponent
                .setDate(year, mouth, day);

        return this;
    }

    public DemoQaRegisterForm setSubjects(String subjects) {
        subjectsInput
                .setValue(subjects)
                .pressEnter();

        return this;
    }

    public DemoQaRegisterForm setHobby(String hobby) {
        hobbiesInput
                .$(byText(hobby))
                .click();

        return this;
    }

    public DemoQaRegisterForm setHobbies(String[] hobbies) {
        for (String hobby : hobbies) {
            hobbiesInput
                    .$(byText(hobby))
                    .click();
        }

        return this;
    }

    public DemoQaRegisterForm setPicture(File picture) {
        pictureUploadInput
                .uploadFile(picture);
        return this;
    }

    public DemoQaRegisterForm setAddress(String address) {
        addressInput
                .setValue(address);

        return this;
    }

    public DemoQaRegisterForm setState(String state) {
        $(stateInput)
                .click();

        $(byText(state))
                .click();

        return this;
    }

    public DemoQaRegisterForm setCity(String city) {
        $(cityInput)
                .click();

        $(byText(city))
                .click();

        return this;
    }

    public DemoQaRegisterForm submitForm() {
        submitButton
                .click();

        return this;
    }

    public DemoQaRegisterForm checkResultInModal(String label, String value) {
        resultModal.checkTableRow(label, value);

        return this;
    }
}
