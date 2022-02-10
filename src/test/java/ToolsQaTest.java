import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
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


    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void EntryPoint() {
        open("/automation-practice-form");

        //set FirstName
        $("#firstName")
                .setValue(this.firstName);

        //set LastName
        $("#lastName")
                .setValue(this.lastName);


        //set Email
        $("#userEmail")
                .setValue(this.email);

        //set Gender
        $(byText(this.gender))
                .click();

        //set Phone
        $("#userNumber")
                .setValue(this.mobile);

        //set Date
        $("#dateOfBirthInput")
                .click();

        $(".react-datepicker-popper")
                .should(Condition.appear.because("Календарь должен появиться на странице"));

        $(".react-datepicker__month-select")
                .selectOption(this.birthDateMouth);

        $(".react-datepicker__year-select")
                .selectOption(this.birthDateYear);

        $(".react-datepicker__day--0" + this.birthDateDay + "")
                .click();

        //set subjects
        $("#subjectsInput")
                .setValue(this.subjects)
                .pressEnter();

        //set hobbies
        $(byText(this.hobbies[0]))
                .click();

        $(byText(this.hobbies[1]))
                .click();

        $(byText(this.hobbies[2]))
                .click();

        // set Picture
        $("#uploadPicture")
                .uploadFile(picture);

        //set Current Address
        $("#currentAddress")
                .setValue(this.address);

        //set State
        $("#state")
                .click();

        $(byText(this.state))
                .click();

        //set City
        $("#city")
                .click();

        $(byText(this.city))
                .click();

        //submit form
        $("#submit")
                .click();

        //check result table
        checkTableRow("Student Name", this.firstName + " " + this.lastName);
        checkTableRow("Student Email", this.email);
        checkTableRow("Gender", this.gender);
        checkTableRow("Mobile", this.mobile);
        checkTableRow("Date of Birth", birthDate);
        checkTableRow("Mobile", this.mobile);
        checkTableRow("Subjects", this.subjects);
        checkTableRow("Hobbies", String.join(", ", this.hobbies));
        checkTableRow("Picture", this.picture.getName());
        checkTableRow("Address", this.address);
        checkTableRow("State and City", this.state + " " + this.city);
    }

    /**
     * метод для проверки значения поля в таблице.
     *
     * @param label - название поля.
     * @param value - предполагаемое значение.
     */
    public void checkTableRow(String label, String value) {
        $(".table")
                .shouldHave(Condition.text(label), Condition.text(value));
    }
}
