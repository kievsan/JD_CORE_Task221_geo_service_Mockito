package ru.mail.kievsan.geo;


import ru.mail.kievsan.entity.Country;
import ru.mail.kievsan.entity.Location;
import java.util.List;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GeoServiceImplTest {

    private static String MOSCOW_IP, NEW_YORK_IP;
    private static Location locationUSA_1, locationRUS_1;
    private static GeoServiceImpl geoServiceImpl;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("LocalizationServiceImpl tests started");
        geoServiceImpl = new GeoServiceImpl();
        NEW_YORK_IP = "96.44.183.149";
        MOSCOW_IP = "172.0.32.11";
        locationUSA_1 = new Location("New York", Country.USA, " 10th Avenue", 32);
        locationRUS_1 = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("\nnew LocalizationServiceImpl Test started");
    }

    @AfterEach
    public void AfterEach() {
        System.out.println("\nLocalizationServiceImpl Test complete");
    }

    @AfterAll
    public static void AfterAll() {
        geoServiceImpl = null;
        MOSCOW_IP = null;
        NEW_YORK_IP = null;
        System.out.println("\nLocalizationServiceImpl tests complete");
    }

    @Test
    public void test21_geoServiceImpl_getCity_ByIp() {
        Location expected = locationUSA_1;

        Location actual = geoServiceImpl.byIp(NEW_YORK_IP);

        assertEquals(expected.getCity(), actual.getCity());
    }

    @Test
    public void test21_geoServiceImpl_getCountry_ByIp() {
        Location expected = locationRUS_1;

        Location actual = geoServiceImpl.byIp(MOSCOW_IP);

        assertEquals(expected.getCountry(), actual.getCountry());
    }

}
