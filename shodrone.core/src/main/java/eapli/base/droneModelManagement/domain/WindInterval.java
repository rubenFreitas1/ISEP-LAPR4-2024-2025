package eapli.base.droneModelManagement.domain;

import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class WindInterval {
    private double min;

    private double max;

    private double tolerance;

    protected WindInterval() {
        // for ORM
    }


    public WindInterval(double min, double max, double tolerance) {
        if (min < 0 || max < 0) {
            throw new IllegalArgumentException("Wind interval values must be positive.");
        }
        if (min >= max) {
            throw new IllegalArgumentException("Minimum wind speed cannot be greater than maximum wind speed.");
        }
        this.min = min;
        this.max = max;
        this.tolerance = tolerance;
    }

    public boolean contains(double windSpeed) {
        return windSpeed > min && windSpeed <= max;
    }

    public boolean overlaps(WindInterval other) {
        return this.min < other.max && other.min < this.max;
    }

    public double min() {
        return this.min;
    }

    public double max() {
        return this.max;
    }

    public double tolerance() {
        return this.tolerance;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WindInterval that = (WindInterval) o;
        return Double.compare(min, that.min) == 0 && Double.compare(max, that.max) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(min, max);
    }

    @Override
    public String toString() {
        return "WindInterval{" +
                "min=" + min +
                ", max=" + max +
                ", tolerance=" + tolerance +
                '}';
    }
}
