package selenium.practice.seleniumtests.Data;

import com.github.javafaker.Faker;

import java.util.Locale;


public class Person {
    Faker faker = new Faker(Locale.ENGLISH);
    public String name = faker.name().fullName();
    public String email = faker.internet().emailAddress();
    public String firstAddress = faker.address().fullAddress();
    public String secondAddress = faker.address().secondaryAddress();

}
