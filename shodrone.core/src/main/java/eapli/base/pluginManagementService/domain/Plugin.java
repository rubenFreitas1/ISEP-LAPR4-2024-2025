package eapli.base.pluginManagementService.domain;

import eapli.framework.domain.model.AggregateRoot;
import jakarta.persistence.*;

public class Plugin implements AggregateRoot<Long> {

    @Version
    private String version;

    @Column(nullable = false)
    private String pluginName;

    @Column(nullable = false)
    private String pluginDescription;

    public Plugin() {

    }

    public Plugin(String pluginName, String pluginDescription) {
        this.pluginName = pluginName;
        this.pluginDescription = pluginDescription;
    }

    public String pluginName() { return this.pluginName; }

    public String pluginDescription() { return this.pluginDescription; }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Long identity() {
        return 0L;
    }
}
