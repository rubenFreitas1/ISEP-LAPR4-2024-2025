package eapli.base.app.backoffice.presentation.pluginManagement;

import eapli.base.pluginManagementService.application.DeployPluginController;
import eapli.base.pluginManagementService.domain.Plugin;
import eapli.base.pluginManagementService.domain.PluginType;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class DeployPluginUI extends AbstractUI {
    private final DeployPluginController controller = new DeployPluginController();

    @Override
    protected boolean doShow() {
        Iterable<Plugin> plugins = controller.listPlugins();
        String name = requestPluginName(plugins);
        String description = requestPluginDescription();
        PluginType pluginType = requestPluginType();

        controller.registerPlugin(name, description, pluginType);
        return true;
    }

    private String requestPluginName(Iterable<Plugin> plugins) {
        String name;
        boolean exists;
        do {
            name = Console.readLine("Enter a name for the plugin:");
            if (name.trim().isEmpty()) {
                System.out.println("Name cannot be empty. Please enter a valid name.");
                exists = true;
            } else if (controller.pluginNameExists(name.trim())) {
                System.out.println("A plugin with this name already exists. Please choose another name.");
                exists = true;
            } else {
                exists = false;
            }
        } while (exists);

        return name;
    }

    private String requestPluginDescription() {
        String description;
        do {
            description = Console.readLine("Enter a description for the plugin:");
            if (description.trim().isEmpty()) {
                System.out.println("Description cannot be empty. Please enter a valid description.");
            }
        } while (description.trim().isEmpty());

        return description;
    }

    private PluginType requestPluginType() {
        PluginType selectedType = null;
        boolean valid = false;

        while (!valid) {
            System.out.println("Choose a plugin type:");
            int index = 1;
            for (PluginType type : PluginType.values()) {
                System.out.printf("%d - %s%n", index++, type.name());
            }

            String input = Console.readLine("Enter the number corresponding to the plugin type: ");

            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= PluginType.values().length) {
                    selectedType = PluginType.values()[choice - 1];
                    valid = true;
                } else {
                    System.out.println("Invalid option. Please enter a number between 1 and " + PluginType.values().length + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
            }
        }

        return selectedType;    }
    @Override
    public String headline() {
        return "";
    }
}
