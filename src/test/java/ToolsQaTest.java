import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pageObject.DemoQaRegisterForm;
import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class ToolsQaTest {
    //константы для теста
    final String firstName = "Nikita";
    final String lastName = "Danshin";
    final String email = "danshinnp@yandex.ru";
    final String gender = "Male";
    final String mobile = "1234567890";
    final String birthDateDay = "17";
    final String birthDateMouth = "December";
    final String birthDateYear = "1996";
    final String birthDate = this.birthDateDay + " " + this.birthDateMouth + "," + this.birthDateYear;
    final String subjects = "Computer Science";
    final String[] hobbies = {"Sports", "Reading", "Music"};
    final File picture = new File("src/test/resources/selenide.jpeg");
    final String address = "My address";
    final String state = "NCR";
    final String city = "Delhi";

    final private DemoQaRegisterForm demoQaRegisterForm = new DemoQaRegisterForm();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

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
