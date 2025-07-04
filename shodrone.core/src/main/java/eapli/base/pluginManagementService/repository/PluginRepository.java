package eapli.base.pluginManagementService.repository;

import eapli.base.figureManagement.domain.Figure;
import eapli.base.pluginManagementService.domain.Plugin;
import eapli.base.pluginManagementService.domain.PluginName;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface PluginRepository extends DomainRepository<PluginName, Plugin> {

}
