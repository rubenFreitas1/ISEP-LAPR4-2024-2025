package rcomp.serverTestingApp;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.ExemploPasswordPolicy;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimulatorServer {

    static ServerSocket sock;

    public static void main(String args[]) throws Exception {
        Socket cliSock;
        try {
            AuthzRegistry.configure(PersistenceContext.repositories().users(), new ExemploPasswordPolicy(), new PlainTextEncoder());
            sock = new ServerSocket(9000);
            System.out.println("Server Opened!");
        } catch(IOException ex) {
            System.out.println("Failed to open server socket"); System.exit(1);
        }
        while(true) {
            cliSock=sock.accept();
            new Thread(new SimulatorServerThread(cliSock)).start();
        }
    }
}
