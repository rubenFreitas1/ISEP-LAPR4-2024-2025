package rcomp.server;

import eapli.base.showProposalManagement.application.AnalyseProposalController;
import eapli.base.showProposalManagement.domain.Document;
import eapli.base.showProposalManagement.domain.ShowProposal;
import rcomp.client.HTTPmessage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

class TcpSrvSumThread implements Runnable {
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;

    AnalyseProposalController controller = new AnalyseProposalController();


    public TcpSrvSumThread(Socket cli_s) {
        socket = cli_s;
    }

    public void run() {
        InetAddress clientIP;
        clientIP = socket.getInetAddress();
        System.out.println("New client connection from " + clientIP.getHostAddress() +
                ", port number " + socket.getPort());
        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            HTTPmessage request = new HTTPmessage(in);
            HTTPmessage response = new HTTPmessage();

            switch (request.getURI()) {
                case "/login":
                    String[] parts = request.getContentAsString().split("&");
                    String email = parts[0].split("=")[1];
                    String password = parts[1].split("=")[1];

                    if (new LoginService().validateLogin(email, password)) {
                        response.setResponseStatus("200 OK");
                        response.setContent("Login successful", "text/plain");
                    } else {
                        response.setResponseStatus("401 Unauthorized");
                        response.setContent("Invalid credentials", "text/plain");
                    }
                    break;

                case "/analyseProposal":
                    String customerEmail = request.getContentAsString().split("=")[1];
                    Iterable<ShowProposal> proposals = controller.findByEmailAndStatus(customerEmail);
                    StringBuilder sb = new StringBuilder();
                    for (ShowProposal proposal : proposals) {
                        String code = proposal.document().code();
                        sb.append("http://localhost:9999/download?code=").append(code).append("\n");
                    }
                    response.setResponseStatus("200 OK");
                    response.setContent(sb.toString(), "text/plain");
                    break;
                case "/download":
                    String query = request.getURI();
                    String code = query.substring(query.indexOf("code=") + 5);
                    Document doc = controller.findDocumentByCode(code);
                    if (doc != null) {
                        response.setResponseStatus("200 OK");
                        response.setContent(doc.finalContent(), "application/pdf");
                    } else {
                        response.setResponseStatus("404 Not Found");
                        response.setContent("Document not found", "text/plain");
                    }
                    break;

                default:
                    response.setResponseStatus("404 Not Found");
                    response.setContent("Endpoint unknown", "text/plain");
                    break;
            }

            response.send(out);

        } catch (IOException e) {
            System.err.println("Erro no servidor: " + e.getMessage());
        }
    }
}
