package rcomp.client;



import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

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

    public static Iterable<String> analyseProposal(String email) throws IOException{
        try(Socket socket = new Socket("localhost", 9999)){
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out= new DataOutputStream(socket.getOutputStream());
            HTTPmessage request = new HTTPmessage();
            request.setRequestMethod("POST");
            request.setURI("/analyseProposal");
            request.setContent("email=" + email, "text/plain");
            request.send(out);

            HTTPmessage response = new HTTPmessage(in);
            if (response.getStatus().startsWith("200")) {
                List<String> codes = new ArrayList<>();
                String body = response.getContentAsString();
                for (String line : body.split("\n")) {
                    codes.add(line);
                }
                return codes;
            }else{
                throw new IOException("Error obtaining Proposals: " + response.getStatus());
            }
        }
    }


}
