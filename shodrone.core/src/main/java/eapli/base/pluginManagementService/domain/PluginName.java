package eapli.base.pluginManagementService.domain;

import jakarta.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class PluginName implements Comparable<PluginName> {
    private String name;

    protected PluginName() {
    }

    public PluginName(String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Plugin name cannot be null or blank");
        this.name = name;
    }

    public String name() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PluginName)) return false;
        PluginName that = (PluginName) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(PluginName other) {
        return this.name.compareTo(other.name);
    }
}