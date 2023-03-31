package ru.mail.kievsan.sender;

import ru.mail.kievsan.entity.Country;
import ru.mail.kievsan.entity.Location;
import ru.mail.kievsan.geo.GeoService;
import ru.mail.kievsan.i18n.LocalizationService;

import java.util.Map;
import java.util.Objects;

public class MessageSenderImpl implements MessageSender {

    public static final String IP_ADDRESS_HEADER = "x-real-ip";
    private final GeoService geoService;

    private final LocalizationService localizationService;

    public MessageSenderImpl(GeoService geoService, LocalizationService localizationService) {
        this.geoService = geoService;
        this.localizationService = localizationService;
    }

    public String send(Map<String, String> headers) {
        String ipAddress = String.valueOf(headers.get(IP_ADDRESS_HEADER));
        if (ipAddress != null && !ipAddress.isEmpty()) {
            Location location = geoService.byIp(ipAddress);
            System.out.printf("Отправлено сообщение: %s", localizationService.locale(location.getCountry()));
            return localizationService.locale(location.getCountry());
        }
        return localizationService.locale(Country.USA);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MessageSenderImpl)) return false;
        MessageSenderImpl that = (MessageSenderImpl) obj;
        return Objects.equals(geoService, that.geoService)
                && Objects.equals(localizationService, that.localizationService);
    }

    @Override
    public int hashCode() {
        return Objects.hash(geoService, localizationService);
    }

    @Override
    public String toString() {
        return "MessageSenderImpl{" +
                "geoService=" + geoService +
                ", localizationService=" + localizationService +
                '}';
    }
}
