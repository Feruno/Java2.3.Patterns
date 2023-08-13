package ru.netology;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;


public class DataGenerator {

    private DataGenerator() {
    }

    public static String generDate(int date) {
        return LocalDate.now().plusDays(date).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generCity() {
        var city = new String[]{"Москва", "Уфа", "Курск", "Рязань", "Самара"};
        return city[new Random().nextInt(city.length)];
    }

    public static String generName(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.name().fullName();
    }

    public static String generPhone(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();
    }

    public static class Regist {
        private Regist() {
        }

        public static userInfo generetUser(String locale) {
            return new userInfo(generCity(), generName(locale), generPhone(locale));
        }
    }

    @Value
    public static class userInfo {
        String city;
        String name;
        String phone;
    }
}
