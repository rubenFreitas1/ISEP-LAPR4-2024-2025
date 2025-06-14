package rcomp.testingAppUser;

import rcomp.utils.HTTPmessage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class TestingAppUser {

    public static boolean login(String email, String password) throws IOException {
        try (Socket socket = new Socket("localhost", 9000)) {
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

    public static boolean testSimulator(String filepath, int threshold)throws IOException{
        try(Socket socket = new Socket("localhost", 9000)){
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out= new DataOutputStream(socket.getOutputStream());
            HTTPmessage request = new HTTPmessage();
            request.setRequestMethod("POST");
            request.setURI("/testSimulator");
            request.setContent("filepath=" + filepath + "&threshold=" + threshold, "text/plain");
            request.send(out);
            HTTPmessage response = new HTTPmessage(in);
            socket.close();
            return response.getStatus().startsWith("200");
        }
    }



}
