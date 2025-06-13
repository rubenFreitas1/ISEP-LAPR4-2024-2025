package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.pluginManagementService.domain.Plugin;
import eapli.base.pluginManagementService.domain.PluginName;
import eapli.base.pluginManagementService.repository.PluginRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaPluginRepository extends JpaAutoTxRepository<Plugin, PluginName, PluginName> implements PluginRepository {
    public JpaPluginRepository(TransactionalContext autoTx) { super(autoTx, "pluginId"); }

    public JpaPluginRepository(final String puname){
        super(puname, Application.settings().getExtendedPersistenceProperties(), "pluginId");
    }

    @Override
    public boolean containsOfIdentity(PluginName id) {
        return PluginRepository.super.containsOfIdentity(id);
    }
}
