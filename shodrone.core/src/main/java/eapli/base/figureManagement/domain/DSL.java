package eapli.base.figureManagement.domain;

import eapli.base.pluginManagementService.domain.Plugin;
import eapli.framework.domain.model.DomainEntity;
import jakarta.persistence.Column;

public class DSL implements DomainEntity<Long> {

    @Column(nullable = false)
    private String filePath;

    @Column(nullable = false)
    private Plugin plugin;

    public DSL(String filePath, Plugin plugin) {
        this.filePath = filePath;
        this.plugin = plugin;
    }

    public String filePath() { return filePath; }

    public Plugin plugin() { return plugin; }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Long identity() {
        return 0L;
    }
}
