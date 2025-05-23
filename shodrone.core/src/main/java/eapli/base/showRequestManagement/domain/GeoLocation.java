package eapli.base.showRequestManagement.domain;

import eapli.framework.domain.model.ValueObject;
import jakarta.persistence.Embeddable;

@Embeddable
public class GeoLocation implements ValueObject {
    private double latitude;
    private double longitude;
    private int altitude;

    protected GeoLocation() {
    }

    public GeoLocation(double latitude, double longitude, int altitude) {
        if (latitude < -90 || latitude > 90)
            throw new IllegalArgumentException("Latitude must be between -90 and 90.");
        if (longitude < -180 || longitude > 180)
            throw new IllegalArgumentException("Longitude must be between -180 and 180.");
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
    }

    public double latitude() {
        return this.latitude;
    }

    public double longitude() {
        return this.longitude;
    }

    public int altitude() { return this.altitude; }

    @Override
    public String toString() {
        return String.format("Lat: %.6f, Long: %.6f, Altitude: %d m", latitude, longitude, altitude);
    }
}

