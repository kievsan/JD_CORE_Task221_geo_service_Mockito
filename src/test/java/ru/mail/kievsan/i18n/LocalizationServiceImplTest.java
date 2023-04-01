package ru.mail.kievsan.i18n;


import ru.mail.kievsan.entity.Country;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LocalizationServiceImplTest {

    private static String russianText, englishText;
    private LocalizationServiceImpl localizationServiceImpl;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("LocalizationServiceImpl tests started");
        englishText = "Welcome!";
        russianText = "Добро пожаловать!";
    }

    @BeforeEach
    public void beforeEach() {
        localizationServiceImpl = new LocalizationServiceImpl();
        System.out.println("\nnew LocalizationServiceImpl Test started");
    }

    @AfterEach
    public void AfterEach() {
        localizationServiceImpl = null;
        System.out.println("\nLocalizationServiceImpl Test complete");
    }

    @AfterAll
    public static void AfterAll() {
        russianText = null;
        englishText = null;
        System.out.println("\nLocalizationServiceImpl tests complete");
    }

    @Test
    void test31_LocalizationServiceImpl_USA() {
        String expected = englishText;
        String actual = localizationServiceImpl.locale(Country.USA);
        assertEquals(expected, actual);
    }

    @Test
    void test32_LocalizationServiceImpl_RUSSIA() {
        String expected = russianText;
        String actual = localizationServiceImpl.locale(Country.RUSSIA);
        assertEquals(expected, actual);
    }

}
