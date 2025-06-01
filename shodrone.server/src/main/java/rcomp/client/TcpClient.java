package rcomp.client;


import java.io.*;
import java.net.*;

public class TcpClient {



    public static boolean login(String email, String password) throws IOException {
        try (Socket socket = new Socket("localhost", 9999)) {
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out= new DataOutputStream(socket.getOutputStream());
            HTTPmessage request = new HTTPmessage();
            request.setRequestMethod("POST");
            request.setURI("/login");
            request.setContent("email=" + email + "&password=" + password, "text/plain");
            request.send(out);

            HTTPmessage response = new HTTPmessage(in);
            socket.close();
            return response.getStatus().startsWith("200");
        }
    }


}
