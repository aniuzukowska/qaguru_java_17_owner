package utils;
import com.github.javafaker.Faker;
import tests.StudentRegistrationTestData;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class RandomStudent {
    StudentRegistrationTestData studentRegistrationTestData = new StudentRegistrationTestData();
    public static Faker faker = new Faker(new Locale("en"));

    public String getRandomFirstName() {
        return faker.name().firstName();
    }

    public String getRandomLastName() {
        return faker.name().lastName();
    }

    public String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public String getRandomGender() {
        return faker.options().option(studentRegistrationTestData.genders);
    }

    public String getRandomPhone() {
        return ("7" + faker.number().randomNumber(9, true));
    }

    public String getRandomBirthDay(String value) {
        Date birthDay = faker.date().birthday(17, 60);
        SimpleDateFormat sdfDay = new SimpleDateFormat("dd", Locale.ENGLISH);
        SimpleDateFormat sdfMonth = new SimpleDateFormat("MMMM", Locale.ENGLISH);
        SimpleDateFormat sdfYear = new SimpleDateFormat("y", Locale.ENGLISH);

        if (value.equals("day")) {
            return sdfDay.format(birthDay);
        }
        else if (value.equals("month")) {
            return sdfMonth.format(birthDay);
        }
        else if (value.equals("year")) {
            return sdfYear.format(birthDay);
        }
        else {
            throw new IllegalArgumentException("Некорреткное значение. Укажите: day, month или year");
        }
    }

    public String getRandomSubject() {
        return faker.options().option(studentRegistrationTestData.subjects);
    }

    public String getRandomHobby() {
        return faker.options().option(studentRegistrationTestData.hobbies);
    }

    public String getRandomAddress() {
        return faker.address().fullAddress();
    }

    public String getRandomState() {
        return faker.options().option(studentRegistrationTestData.states);
    }

    public String getRandomCity(String state) {
        if (state.equals("NCR")) {
            return faker.options().option(studentRegistrationTestData.ncrCities);
        }
        else if (state.equals("Uttar Pradesh")) {
            return faker.options().option(studentRegistrationTestData.uttarPradeshCities);
        }
        else if (state.equals("Haryana")) {
            return faker.options().option(studentRegistrationTestData.haryanaCities);
        }
        else if (state.equals("Rajasthan")) {
            return faker.options().option(studentRegistrationTestData.rajasthanCities);
        }
        else {
            throw new IllegalArgumentException("Указано некорректное наименование штата!");
        }
    }

    public String getFullName() {
        return "img/picture.jpg";
    }

    public String getFileName() {
        return "picture.jpg";
    }
}

