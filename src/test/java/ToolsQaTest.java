import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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


    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void EntryPoint() {
        open("/automation-practice-form");

        //set FirstName
        $x("//input[@id='firstName']")
                .shouldBe(Condition.visible.because("Поле FirstName должно отображаться на форме"))
                .setValue(this.firstName);

        //set LastName
        $x("//input[@id='lastName']")
                .shouldBe(Condition.visible.because("Поле LastName должно отображаться на форме"))
                .setValue(this.lastName);


        //set Email
        $x("//input[@id='userEmail']")
                .shouldBe(Condition.visible.because("Поле Email должно отображаться на форме"))
                .setValue(this.email);

        //set Gender
        $x("//input[@value='" + this.gender + "']/../label")
                .shouldBe(Condition.visible.because("Поле Gender[" + this.gender + "] должно отображаться на форме"))
                .click();

        //set Phone
        $x("//input[@id='userNumber']")
                .shouldBe(Condition.visible.because("Поле Mobile должно отображаться на форме"))
                .setValue(this.mobile);

        //set Date
        $x("//input[@id='dateOfBirthInput']")
                .shouldBe(Condition.visible.because("Поле DateOfBirth должно отображаться на форме"))
                .click();

        $x("//div[@class='react-datepicker-popper']")
                .should(Condition.appear.because("Календарь должен появиться на странице"));

        $x("//select[@class='react-datepicker__month-select']")
                .shouldBe(Condition.visible.because("Поле выбора месяца должно отображаться в календаре"))
                .selectOption(this.birthDateMouth);

        $x("//select[@class='react-datepicker__year-select']")
                .shouldBe(Condition.visible.because("Поле выбора года должно отображаться в календаре"))
                .selectOption(this.birthDateYear);

        $x("//div[@class='react-datepicker__day react-datepicker__day--0" + this.birthDateDay + "']")
                .shouldBe(Condition.visible.because("День должен отображаться в календаре"))
                .click();

        //set subjects
        $x("//input[@id='subjectsInput']")
                .shouldBe(Condition.visible.because("Поле Subjects должно отображаться на форме"))
                .setValue(this.subjects)
                .pressEnter();

        //set hobbies
        $x("//label[text()='" + this.hobbies[0] + "']")
                .shouldBe(Condition.visible.because("Чек бокс " + this.hobbies[0] + " должен отображаться на форме"))
                .click();

        $x("//label[text()='" + this.hobbies[1] + "']")
                .shouldBe(Condition.visible.because("Чек бокс " + this.hobbies[1] + " должен отображаться на форме"))
                .click();

        $x("//label[text()='" + this.hobbies[2] + "']")
                .shouldBe(Condition.visible.because("Чек бокс " + this.hobbies[2] + " должен отображаться на форме"))
                .click();

        // set Picture
        $x("//input[@id='uploadPicture']")
                .shouldBe(Condition.visible.because("Поле Picture должно отображаться на форме"))
                .uploadFile(picture);

        //set Current Address
        $x("//textarea[@id='currentAddress']")
                .shouldBe(Condition.visible.because("Поле Current Address должно отображаться на форме"))
                .setValue(this.address);

        //set State
        $x("//div[@id='state']")
                .shouldBe(Condition.visible.because("Поле State должно отображаться на форме"))
                .click();

        $x("//*[text()='" + this.state + "']")
                .shouldBe(Condition.visible.because("У поля State должен появится список элементов"))
                .click();

        //set City
        $x("//div[@id='city']")
                .shouldBe(Condition.visible.because("Поле City должно отображаться на форме"))
                .click();

        $x("//*[text()='" + this.city + "']")
                .shouldBe(Condition.visible.because("У поля City должен появится список элементов"))
                .click();

        $x("//button[@id='submit']")
                .shouldBe(Condition.visible.because("Кнопка Submit должна отображаться на форме"))
                .click();


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
        $x("//div[@class='modal-content']//td[text()='" + label + "']/../td[2]")
                .shouldHave(Condition.text(value).because("Поле " + label + " должно иметь значение " + value));
    }
}
