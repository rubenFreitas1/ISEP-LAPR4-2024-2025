package eapli.base.app.backoffice.presentation.showProposalManagement;

import eapli.base.showProposalManagement.application.ConfigureTemplateController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.io.IOException;

public class ConfigureTemplateUI extends AbstractUI {

    private final ConfigureTemplateController controller = new ConfigureTemplateController();

    @Override
    protected boolean doShow() {

        String name = null, content = null;

        while (true) {
            try {
                name = Console.readLine("Enter the name of the template: ");
                if (name.trim().isEmpty()) {
                    throw new IllegalArgumentException("Name of the template cannot be empty.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        while (true) {
            try {
                content = Console.readLine("Enter the path to the content of the template: ");
                if (content.trim().isEmpty()) {
                    throw new IllegalArgumentException("Content of the template cannot be empty.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        try {
            if (controller.registerTemplate(name, content)) {
                System.out.println("Template configured successfully!");
                return true;
            } else {
                System.out.println("Error configuring template.");
                return false;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String headline() {
        return "Configure Show Proposal Template";
    }

}
