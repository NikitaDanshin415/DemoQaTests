package utils;

import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;

import java.io.File;
import java.util.Locale;

public class TestData {
    static Faker faker = new Faker(new Locale("ru"));

    public final static String firstName = faker.name().firstName();
    public final static String lastName = faker.name().lastName();
    public final static String email = "test@test.ru";
    public final static String gender = "Male";
    public final static String mobile = faker.phoneNumber().subscriberNumber(10);
    public final static int birthDateDay = faker.number().numberBetween(1, 30);
    public final static String birthDateMouth = "December";
    public final static int birthDateYear = faker.number().numberBetween(1990, 2022);
    public final static String birthDate = birthDateDay + " " + birthDateMouth + "," + birthDateYear;
    public final static String subjects = "Computer Science";
    public final static String[] hobbies = {"Sports", "Reading", "Music"};
    public final static File picture = new File("src/test/resources/selenide.jpeg");
    public final static String address = faker.address().fullAddress();
    public final static String state = "NCR";
    public final static String city = "Delhi";
}
