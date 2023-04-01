package ru.mail.kievsan;

import java.util.Map;
import java.util.HashMap;
import org.mockito.Mockito;
import org.junit.jupiter.api.*;

import ru.mail.kievsan.entity.Country;
import ru.mail.kievsan.entity.Location;
import ru.mail.kievsan.geo.GeoServiceImpl;
import ru.mail.kievsan.i18n.LocalizationServiceImpl;
import ru.mail.kievsan.sender.MessageSenderImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MainTest {

    public String MOSCOW_IP = "172.0.32.11";
    public String russianText = "Добро пожаловать";

    public String NEW_YORK_IP = "96.44.183.149";
    public String englishText = "Welcome";

    @BeforeAll
    public static void beforeAllMethod() {
        System.out.println("BeforeAll call");
    }

    @BeforeEach
    public void beforeEachMethod() {
        System.out.println("BeforeEach call");
    }

    @AfterEach
    public void afterEachMethod() {
        System.out.println("AfterEach call");
    }

    @AfterAll
    public static void afterAllMethod() {
        System.out.println("AfterEach call");
    }

    // Тест для проверки определения локации по ip (класс GeoServiceImpl)
    @Test
    void testDeterminingGeolocationByIp() {
        System.out.println("Тест №3 - проверка определения локации по ip");
        GeoServiceImpl geoServiceImpl = new GeoServiceImpl();
        Location expected = new Location("New York", Country.USA, " 10th Avenue", 32);
        Location actual = geoServiceImpl.byIp(NEW_YORK_IP);     // Проверил работу метода public Location byIp(String ip)
        assertEquals(expected.getCity(), actual.getCity());
        assertEquals(expected.getCountry(), actual.getCountry());
    }
}
