package eapli.base.persistence.impl.inmemory;

import eapli.base.pluginManagementService.domain.Plugin;
import eapli.base.pluginManagementService.domain.PluginName;
import eapli.base.pluginManagementService.repository.PluginRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryPluginRepository extends InMemoryDomainRepository<Plugin, PluginName> implements PluginRepository {
    private final List<Plugin> plugins = new ArrayList<>();

}
