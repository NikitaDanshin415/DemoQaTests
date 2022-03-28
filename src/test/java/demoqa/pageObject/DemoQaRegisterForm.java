package demoqa.pageObject;

import com.codeborne.selenide.SelenideElement;
import demoqa.components.CalendarComponent;
import demoqa.components.ResultModal;
import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byText;

public class DemoQaRegisterForm {
  private final CalendarComponent calendarComponent = new CalendarComponent();
  private final ResultModal resultModal = new ResultModal();


  private final SelenideElement firstNameInput = $("#firstName");
  private final SelenideElement lastNameInput = $("#lastName");
  private final SelenideElement emailInput = $("#userEmail");
  private final SelenideElement gender = $(".practice-form-wrapper #genterWrapper");
  private final SelenideElement mobileInput = $("#userNumber");
  private final SelenideElement birthDateInput = $("#dateOfBirthInput");
  private final SelenideElement subjectsInput = $("#subjectsInput");
  private final SelenideElement hobbiesInput = $(".practice-form-wrapper #hobbiesWrapper");
  private final SelenideElement pictureUploadInput = $("#uploadPicture");
  private final SelenideElement addressInput = $("#currentAddress");
  private final SelenideElement stateInput = $("#state");
  private final SelenideElement cityInput = $("#city");
  private final SelenideElement submitButton = $("#submit");


  @Step("Ввести имя пользователя")
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

  public DemoQaRegisterForm setBirthDate(int year, String mouth, int day) {
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

  public void submitForm() {
    submitButton
        .click();
  }

  public DemoQaRegisterForm checkResultInModal(String label, String value) {
    resultModal
        .checkTableRow(label, value);

    return this;
  }
}
