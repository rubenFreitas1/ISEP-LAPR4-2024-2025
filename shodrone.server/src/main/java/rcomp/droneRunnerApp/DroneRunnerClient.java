package rcomp.droneRunnerApp;

import rcomp.utils.HTTPmessage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class DroneRunnerClient {

    private static final String HOST = "localhost";
    private static final int PORT = 9000;

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: java DroneRunnerClient <email> <password> <filepath> [threshold]");
            return;
        }

        String email = args[0];
        String password = args[1];
        String filepath = args[2];
        int threshold = args.length >= 4 ? Integer.parseInt(args[3]) : 5;

        try {
            if (!login(email, password)) {
                System.out.println("Login failed. Make sure you are a Drone Tech.");
                return;
            }

            if (testSimulator(filepath, threshold)) {
                System.out.println("Test run was successful!");
            } else {
                System.out.println("Test run failed.");
            }

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static boolean login(String email, String password) throws IOException {
        try (Socket socket = new Socket(HOST, PORT)) {
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            HTTPmessage request = new HTTPmessage();
            request.setRequestMethod("POST");
            request.setURI("/login");
            request.setContent("email=" + email + "&password=" + password, "text/plain");
            request.send(out);

            HTTPmessage response = new HTTPmessage(in);
            return response.getStatus().startsWith("200");
        }
    }

    private static boolean testSimulator(String filepath, int threshold) throws IOException {
        try (Socket socket = new Socket(HOST, PORT)) {
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            HTTPmessage request = new HTTPmessage();
            request.setRequestMethod("POST");
            request.setURI("/testSimulator");
            request.setContent("filepath=" + filepath + "&threshold=" + threshold, "text/plain");
            request.send(out);

            HTTPmessage response = new HTTPmessage(in);
            System.out.println("Server Response: " + response.getStatus());
            System.out.println("Message: " + response.getContentAsString());
            return response.getStatus().startsWith("200");
        }
    }
}
