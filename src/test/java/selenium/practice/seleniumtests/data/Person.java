package selenium.practice.seleniumtests.data;

import com.github.javafaker.Faker;

import java.util.Locale;


public class Person {
    Faker faker = new Faker(Locale.ENGLISH);
    public String name = faker.name().fullName();
    public String lastName = faker.name().lastName();
    public String email = faker.internet().emailAddress();
    public String firstAddress = faker.address().fullAddress();
    public String secondAddress = faker.address().secondaryAddress();
    public String age = (faker.random().nextInt(18, 90)).toString();
    public String salary = (faker.random().nextInt(200, 400)).toString();
    public String department = faker.job().field();

}
