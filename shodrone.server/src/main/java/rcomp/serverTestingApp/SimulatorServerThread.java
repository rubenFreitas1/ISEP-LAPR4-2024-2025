package rcomp.serverTestingApp;

import rcomp.utils.HTTPmessage;
import rcomp.login.LoginService;
import scomp.simulatorRunner.SimulatorRunner;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class SimulatorServerThread implements Runnable{

    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;

    public SimulatorServerThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        InetAddress testerIP = socket.getInetAddress();
        try{
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            HTTPmessage request = new HTTPmessage(in);
            HTTPmessage response = new HTTPmessage();
            System.out.printf("IP: %-15s | PORT NUMBER: %-5d | REQUEST: %s%n", testerIP.getHostAddress(), socket.getPort(), request.getURI());
            switch (request.getURI()){
                case "/login":
                    String[] parts = request.getContentAsString().split("&");
                    String username = parts[0].split("=")[1];
                    String password = parts[1].split("=")[1];
                    if (new LoginService().validateLoginDroneTech(username, password)){
                        response.setResponseStatus("200 OK");
                        response.setContent("Login successful", "text/plain");
                    } else {
                        response.setResponseStatus("401 Unauthorized");
                        response.setContent("Invalid credentials", "text/plain");
                    }
                    break;
                case "/testSimulator":
                    String[] parts1 = request.getContentAsString().split("&");
                    String filepath = parts1[0].split("=")[1];
                    String collisionsThreshold = parts1[1].split("=")[1];
                    int threshold = Integer.parseInt(collisionsThreshold);
                    if(SimulatorRunner.runSimulator(filepath, threshold)){
                        response.setResponseStatus("200 OK");
                        response.setContent("Show Proposal Tested", "text/plain");
                    }else{
                        System.out.println("nao deu");
                        response.setResponseStatus("401 Unauthorized");
                        response.setContent("Show Proposal was not Tested", "text/plain");
                    }
                    break;
                default:
                    response.setResponseStatus("404 Not Found");
                    response.setContent("Endpoint unknown", "text/plain");
                    break;
            }
            response.send(out);
        }catch (IOException e){
            System.out.println("Error on the server: " + e.getMessage());
        }
    }
}
