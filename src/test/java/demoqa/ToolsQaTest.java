package demoqa;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import demoqa.pageObject.DemoQaRegisterForm;
import demoqa.utils.BaseTest;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static demoqa.utils.TestData.*;

public class ToolsQaTest extends BaseTest {

    @Feature("Проверка DemoQa")
    @Story("Проверка заполнения /automation-practice-form")
    @DisplayName("Automation-practice-form")
    @Owner("Danshin N.P.")
    @Test
    void FirstTest() {
        final DemoQaRegisterForm demoQaRegisterForm = new DemoQaRegisterForm();

        step("Открытие формы", () -> open("/automation-practice-form"));

        step("Заполнение формы", () -> demoQaRegisterForm
                .setFirstNameInput(firstName)
                .setLastName(lastName)
                .setUserEmail(email)
                .setGender(gender)
                .setMobile(mobile)
                .setBirthDate(birthDateYear, birthDateMouth, birthDateDay)
                .setSubjects(subjects)
                .setHobbies(hobbies)
//                    .setPicture(picture)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .submitForm());

        step("Проверка значений формы", () -> demoQaRegisterForm
                .checkResultInModal("Student Name", firstName + " " + lastName)
                .checkResultInModal("Student Email", email)
                .checkResultInModal("Gender", gender)
                .checkResultInModal("Mobile", mobile)
                .checkResultInModal("Date of Birth", birthDate)
                .checkResultInModal("Mobile", mobile)
                .checkResultInModal("Subjects", subjects)
                .checkResultInModal("Hobbies", String.join(", ", hobbies))
//                    .checkResultInModal("Picture", picture.getName())
                .checkResultInModal("Address", address)
                .checkResultInModal("State and City", state + " " + city));
    }
}
