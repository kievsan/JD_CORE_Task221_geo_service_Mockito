package ru.mail.kievsan.i18n;

import ru.mail.kievsan.entity.Country;

public interface LocalizationService {
    String locale(Country country);
}
