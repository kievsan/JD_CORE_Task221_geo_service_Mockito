package ru.mail.kievsan.sender;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import ru.mail.kievsan.entity.Country;
import ru.mail.kievsan.entity.Location;
import ru.mail.kievsan.geo.GeoServiceImpl;
import ru.mail.kievsan.i18n.LocalizationServiceImpl;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageSenderImplTest {

    private static String russianText, englishText, MOSCOW_IP, NEW_YORK_IP;
    private static GeoServiceImpl geoServiceImpl;
    private static LocalizationServiceImpl localizationServiceImpl;
    private MessageSenderImpl messageSenderImpl ;
    private Map<String, String> mock;


    @BeforeAll
    public static void beforeAll() {
        System.out.println("MessageSenderImpl tests started");
        geoServiceImpl = Mockito.mock(GeoServiceImpl.class);
        localizationServiceImpl = Mockito.mock(LocalizationServiceImpl.class);
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("\nnew MessageSenderImpl Test started");
        messageSenderImpl = new MessageSenderImpl(geoServiceImpl, localizationServiceImpl);
        mock = new HashMap<>();
    }

    @AfterEach
    public void AfterEach() {
        messageSenderImpl = null;
        mock = null;
        System.out.println("\nMessageSenderImpl Test complete");
    }

    @AfterAll
    public static void AfterAll() {
        geoServiceImpl = null;
        localizationServiceImpl = null;
        MOSCOW_IP = null;
        russianText = null;
        NEW_YORK_IP = null;
        englishText = null;
        System.out.println("\nMessageSenderImpl tests complete");
    }

    @Test
    void testMessageSenderImpl_RUSSIA() {
        MOSCOW_IP = "172.0.32.11";
        russianText = "Добро пожаловать!";

        mock.put(MessageSenderImpl.IP_ADDRESS_HEADER, MOSCOW_IP);

        Mockito.when(geoServiceImpl.byIp(MOSCOW_IP))
                .thenReturn(new Location("Moscow", Country.RUSSIA, "Lenina", 15));
        Mockito.when(localizationServiceImpl.locale(Country.RUSSIA))
                .thenReturn(russianText);

        String expected = russianText;
        String actual = messageSenderImpl.send(mock);
        assertEquals(expected, actual);
    }

    @Test
    void testMessageSenderImpl_USA() {
        NEW_YORK_IP = "96.44.183.149";
        englishText = "Welcome!";

        mock.put(MessageSenderImpl.IP_ADDRESS_HEADER, NEW_YORK_IP);

        Mockito.when(geoServiceImpl.byIp(NEW_YORK_IP))
                .thenReturn(new Location("New York", Country.USA, " 10th Avenue", 32));
        Mockito.when(localizationServiceImpl.locale(Country.USA))
                .thenReturn(englishText);

        String expected = englishText;
        String actual = messageSenderImpl.send(mock);
        assertEquals(expected, actual);
    }

}
