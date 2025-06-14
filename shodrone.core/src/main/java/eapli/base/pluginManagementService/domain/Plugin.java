package eapli.base.pluginManagementService.domain;

import eapli.framework.domain.model.AggregateRoot;
import jakarta.persistence.*;

@Entity
public class Plugin implements AggregateRoot<PluginName> {

    @EmbeddedId
    private PluginName pluginName;

    @Column(nullable = false)
    private String pluginDescription;

    @Enumerated(EnumType.STRING)
    private PluginType pluginType;

    private String pluginClassName;

    public Plugin() {

    }

    public Plugin(PluginName pluginName, String pluginDescription, PluginType pluginType) {
        this.pluginName = pluginName;
        this.pluginDescription = pluginDescription;
        this.pluginType = pluginType;
    }

    public PluginName pluginName() { return this.pluginName; }

    public String pluginDescription() { return this.pluginDescription; }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public PluginName identity() {
        return pluginName;
    }


}
