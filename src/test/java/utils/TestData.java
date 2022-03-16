package utils;

import com.github.javafaker.Faker;

import java.io.File;
import java.util.Locale;

public class TestData {
  private static final Faker faker = new Faker(new Locale("ru"));

  public static final String firstName = faker.name().firstName();
  public static final String lastName = faker.name().lastName();
  public static final String email = new Faker(new Locale("en")).internet().emailAddress();
  public static final String gender = "Male";
  public static final String mobile = faker.phoneNumber().subscriberNumber(10);
  public static final int birthDateDay = faker.number().numberBetween(1, 30);
  public static final String birthDateMouth = "December";
  public static final int birthDateYear = faker.number().numberBetween(1990, 2022);
  public static final String birthDate = birthDateDay + " " + birthDateMouth + "," + birthDateYear;
  public static final String subjects = "Computer Science";
  public static final String[] hobbies = {"Sports", "Reading", "Music"};
  public static final File picture = new File("src/test/resources/selenide.jpeg");
  public static final String address = faker.address().fullAddress();
  public static final String state = "NCR";
  public static final String city = "Delhi";
}