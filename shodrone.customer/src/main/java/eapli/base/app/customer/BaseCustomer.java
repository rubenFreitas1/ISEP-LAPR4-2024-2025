package eapli.base.app.customer;

import eapli.base.app.common.console.BaseApp;
import eapli.base.app.common.console.presentation.authz.LoginUI;
import eapli.base.app.customer.presentation.menu.MainMenuCustomer;
import eapli.base.infrastructure.authz.AuthenticationCredentialHandler;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.ExemploPasswordPolicy;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.pubsub.EventDispatcher;

public class BaseCustomer extends BaseApp {

    private BaseCustomer() {
    }

    public static void main(final String[] args) {

        AuthzRegistry.configure(PersistenceContext.repositories().users(), new ExemploPasswordPolicy(),
                new PlainTextEncoder());

        new BaseCustomer().run(args);
    }

    @Override
    protected void doMain(String[] args) {
        if (new LoginUI(new AuthenticationCredentialHandler()).show()) {
            final var menu = new MainMenuCustomer();
            menu.mainLoop();
        }
    }

    @Override
    protected String appTitle() {
        return "Customer App";
    }

    @Override
    protected String appGoodbye() {
        return "Customer App";
    }

    @Override
    protected void doSetupEventHandlers(EventDispatcher dispatcher) {

    }
}
