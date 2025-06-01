package eapli.base.app.customer;

import eapli.base.app.common.console.BaseApp;
import eapli.base.app.customer.presentation.menu.MainMenuCustomer;
import eapli.framework.infrastructure.pubsub.EventDispatcher;
import rcomp.client.TcpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaseCustomer extends BaseApp {





    public static void main(final String[] args) {

        new BaseCustomer().run(args);
    }

    @Override
    protected void doMain(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Email: ");
            String email = reader.readLine();
            System.out.print("Password: ");
            String password = reader.readLine();

            if (TcpClient.login(email, password)) {
                System.out.println("Login was successfully!");
                final var menu = new MainMenuCustomer(email);
                menu.mainLoop();
            } else {
                System.out.println("Login failed!.");
            }

        } catch (IOException e) {
            System.err.println("Error trying to communicate with server: " + e.getMessage());
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
