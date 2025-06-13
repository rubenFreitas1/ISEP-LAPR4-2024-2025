package eapli.base.persistence.impl.inmemory;

import eapli.base.pluginManagementService.domain.Plugin;
import eapli.base.pluginManagementService.repository.PluginRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryPluginRepository extends InMemoryDomainRepository<Plugin, Long> implements PluginRepository {
    private final List<Plugin> plugins = new ArrayList<>();

}
