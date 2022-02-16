import org.junit.jupiter.api.Test;
import pageObject.DemoQaRegisterForm;
import utils.BaseTest;


import static com.codeborne.selenide.Selenide.*;
import static utils.TestData.*;

public class ToolsQaTest extends BaseTest {
    final private DemoQaRegisterForm demoQaRegisterForm = new DemoQaRegisterForm();

    @Test
    void EntryPoint() {
        open("/automation-practice-form");

        //step_1
        //fill form data
        demoQaRegisterForm
                .setFirstNameInput(firstName)
                .setLastName(lastName)
                .setUserEmail(email)
                .setGender(gender)
                .setMobile(mobile)
                .setBirthDate(birthDateYear, birthDateMouth, birthDateDay)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .setPicture(picture)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .submitForm();

        //step_2
        //Check results
        demoQaRegisterForm
                .checkResultInModal("Student Name", firstName + " " + lastName)
                .checkResultInModal("Student Email", email)
                .checkResultInModal("Gender", gender)
                .checkResultInModal("Mobile", mobile)
                .checkResultInModal("Date of Birth", birthDate)
                .checkResultInModal("Mobile", mobile)
                .checkResultInModal("Subjects", subjects)
                .checkResultInModal("Hobbies", String.join(", ", hobbies))
                .checkResultInModal("Picture", picture.getName())
                .checkResultInModal("Address", address)
                .checkResultInModal("State and City", state + " " + city);
    }

}
