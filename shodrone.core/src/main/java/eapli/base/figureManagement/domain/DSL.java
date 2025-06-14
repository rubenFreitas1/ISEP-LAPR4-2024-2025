package eapli.base.figureManagement.domain;

import eapli.base.pluginManagementService.domain.Plugin;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntity;
import eapli.framework.domain.model.ValueObject;
import jakarta.persistence.*;

@Entity
public class DSL implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long dslId;

    @Column(nullable = false, unique = true)
    private String filePath;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Plugin plugin;

    private String version;

    public DSL(String filePath, Plugin plugin, String version) {
        this.filePath = filePath;
        this.plugin = plugin;
        this.version = version;
    }

    public DSL() {
    }

    public String filePath() { return filePath; }

    public Plugin plugin() { return plugin; }

    public String version() { return version; }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Long identity() {
        return dslId;
    }
}
