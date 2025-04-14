package eapli.base.app.backoffice;

import eapli.base.app.backoffice.presentation.menu.MainMenu;
import eapli.base.app.common.console.BaseApp;
import eapli.base.app.common.console.presentation.authz.LoginUI;
import eapli.base.infrastructure.authz.AuthenticationCredentialHandler;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.application.eventhandlers.SignupAcceptedWatchDog;
import eapli.base.usermanagement.domain.ExemploPasswordPolicy;
import eapli.base.utentemanagement.application.eventhandlers.NewUserRegisteredFromSignupWatchDog;
import eapli.base.utentemanagement.domain.events.NewUserRegisteredFromSignupEvent;
import eapli.base.utentemanagement.domain.events.SignupAcceptedEvent;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.pubsub.EventDispatcher;


public class BaseBackOffice extends BaseApp {

    private BaseBackOffice(){
    }

    /**
     * @param args the command line arguments
     */
    public static void main(final String[] args) {

        AuthzRegistry.configure(PersistenceContext.repositories().users(), new ExemploPasswordPolicy(),
                new PlainTextEncoder());

        new BaseBackOffice().run(args);
    }

    @Override
    protected void doMain(final String[] args) {
        // login and go to main menu
        if (new LoginUI(new AuthenticationCredentialHandler()).show()) {
            // go to main menu
            final var menu = new MainMenu();
            menu.mainLoop();
        }
    }

    @Override
    protected String appTitle() {
        return "Back Office";
    }

    @Override
    protected String appGoodbye() {
        return "Back Office";
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void doSetupEventHandlers(final EventDispatcher dispatcher) {
        dispatcher.subscribe(new NewUserRegisteredFromSignupWatchDog(), NewUserRegisteredFromSignupEvent.class);
        dispatcher.subscribe(new SignupAcceptedWatchDog(), SignupAcceptedEvent.class);
    }
}
