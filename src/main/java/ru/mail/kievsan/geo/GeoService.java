package ru.mail.kievsan.geo;

import ru.mail.kievsan.entity.Location;

public interface GeoService {

    Location byIp(String ip);

    Location byCoordinates(double latitude, double longitude);
}
