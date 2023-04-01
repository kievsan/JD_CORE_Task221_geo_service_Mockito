package ru.mail.kievsan.i18n;

import ru.mail.kievsan.entity.Country;

public class LocalizationServiceImpl implements LocalizationService {

    public String locale(Country country) {
        if (country == Country.RUSSIA) {
            return "Добро пожаловать!";
        }
        return "Welcome!";
    }
}
