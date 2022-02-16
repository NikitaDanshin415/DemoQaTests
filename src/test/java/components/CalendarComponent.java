package components;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    public void setDate(int year, String mouth, int day){
        $(".react-datepicker-popper")
                .should(Condition.appear.because("Календарь должен появиться на странице"));

        $(".react-datepicker__month-select")
                .selectOption(mouth);

        $(".react-datepicker__year-select")
                .selectOption(String.valueOf(year));

        $(".react-datepicker__day--0" + day + "")
                .click();
    }
}
