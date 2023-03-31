import java.util.HashMap;
import java.util.Map;

import ru.mail.kievsan.geo.GeoService;
import ru.mail.kievsan.geo.GeoServiceImpl;
import ru.mail.kievsan.i18n.LocalizationService;
import ru.mail.kievsan.i18n.LocalizationServiceImpl;
import ru.mail.kievsan.sender.MessageSender;
import ru.mail.kievsan.sender.MessageSenderImpl;

public class Main {

    public static void main(String[] args) {
        GeoService geoService = new GeoServiceImpl();
        LocalizationService localizationService = new LocalizationServiceImpl();
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.123.12.19");
        messageSender.send(headers);
    }
}
