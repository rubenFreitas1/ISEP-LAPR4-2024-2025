package eapli.base.app.testing;

import eapli.base.app.common.console.BaseApp;
import eapli.base.app.testing.presentation.menu.MainMenuTestingApp;
import eapli.framework.infrastructure.pubsub.EventDispatcher;
import rcomp.testingAppUser.TestingAppUser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaseTesting extends BaseApp {

    public static void main(final String[] args) {
        new BaseTesting().run(args);
    }
    @Override
    protected void doMain(String[] args) {
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Username: ");
            String username = reader.readLine();
            System.out.print("Password: ");
            String password = reader.readLine();
            if(TestingAppUser.login(username, password)){
                System.out.println("Login was successfully!");
                final var menu = new MainMenuTestingApp(username);
                menu.mainLoop();
            }else {
                System.out.println("Login failed!.");
            }

        }catch (IOException E){
            System.out.println("Error: " + E.getMessage());
        }
    }

    @Override
    protected String appTitle() {
        return "Testing App";
    }

    @Override
    protected String appGoodbye() {
        return "Testing App";
    }

    @Override
    protected void doSetupEventHandlers(EventDispatcher dispatcher) {

    }
}
