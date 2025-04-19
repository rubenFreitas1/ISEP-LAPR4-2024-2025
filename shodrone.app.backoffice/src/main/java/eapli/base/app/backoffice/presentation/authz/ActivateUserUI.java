package eapli.base.app.backoffice.presentation.authz;

import eapli.base.usermanagement.application.ActivateUserController;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ActivateUserUI extends AbstractUI {

    private static final Logger LOGGER = LoggerFactory.getLogger(ActivateUserUI.class);

    private final ActivateUserController theController = new ActivateUserController();

    @Override
    protected boolean doShow() {
        final Iterable<SystemUser> iterable = this.theController.deactiveUsers();
        if (!iterable.iterator().hasNext()) {
            System.out.println("There is no registered User");
        } else {
            System.out.printf("%-6s%-30s%-30s%-30s%-30s%n", "Nº:", "Username", "Firstname", "Lastname", "Status");
            final SelectWidget<SystemUser> selector = new SelectWidget<>("Select User to Activate", iterable, new SystemUserPrinter());
            selector.show();
            final SystemUser user = selector.selectedElement();
            if (user == null) {
                System.out.println("No user selected");
            } else {
                try {
                    this.theController.activateUser(user);
                } catch (IntegrityViolationException | ConcurrencyException ex) {
                    LOGGER.error("Error performing the operation", ex);
                    System.out.println(
                            "Unfortunatelly there was an unexpected error in the application. Please try again and if the problem persists, contact your system admnistrator.");
                }
            }
        }
        return true;
    }

    @Override
    public String headline() {
        return "Active User";
    }

}
