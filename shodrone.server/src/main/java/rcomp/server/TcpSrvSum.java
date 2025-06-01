package rcomp.server;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.ExemploPasswordPolicy;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;

import java.io.*;
import java.net.*;
class TcpSrvSum {
    static ServerSocket sock;
    public static void main(String args[]) throws Exception {
        Socket cliSock;
        try {
            AuthzRegistry.configure(PersistenceContext.repositories().users(), new ExemploPasswordPolicy(), new PlainTextEncoder());
            sock = new ServerSocket(9999);
            System.out.println("Server Opened!");
        } catch(IOException ex) {
            System.out.println("Failed to open server socket"); System.exit(1);
        }
        while(true) {
            cliSock=sock.accept();
            new Thread(new TcpSrvSumThread(cliSock)).start();
        }
    }
}



