package eapli.base.app.backoffice.presentation.showProposalManagement;

import eapli.base.showProposalManagement.application.ConfigureTemplateController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.io.IOException;

public class ConfigureTemplateUI extends AbstractUI {

    private final ConfigureTemplateController controller = new ConfigureTemplateController();

    @Override
    protected boolean doShow() {
        String templateName = Console.readLine("Enter the name of the template: ");

        String templateContent = Console.readLine("Enter the path to the content of the template: ");

        try {
            if (controller.registerTemplate(templateName, templateContent)) {
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
