package eapli.base.pluginManagementService.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.pluginManagementService.domain.Plugin;
import eapli.base.pluginManagementService.domain.PluginName;
import eapli.base.pluginManagementService.domain.PluginType;
import eapli.base.pluginManagementService.repository.PluginRepository;
import eapli.base.usermanagement.domain.Roles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.stream.StreamSupport;


public class DeployPluginController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final PluginRepository pluginRepository = PersistenceContext.repositories().plugins();

    public Plugin registerPlugin(String name, String description, PluginType pluginType) {
        Plugin plugin = new Plugin(new PluginName(name), description, pluginType);
        return (Plugin) this.pluginRepository.save(plugin);
    }

    public Iterable<Plugin> listPlugins() {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.DRONE_TECH);
        return this.pluginRepository.findAll();
    }
    public boolean pluginNameExists(String name) {
        return StreamSupport.stream(listPlugins().spliterator(), false)
                .anyMatch(p -> p.pluginName().toString().equalsIgnoreCase(name));
    }
}
