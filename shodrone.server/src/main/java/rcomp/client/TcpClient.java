package rcomp.client;



import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Arrays;
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

    public static List<String> analyseProposal(String email) throws IOException{
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
                String body = response.getContentAsString();
                List<String> links = new ArrayList<>(Arrays.asList(body.split("\n")));
                return links;
            }else{
                throw new IOException("Error obtaining Proposals: " + response.getStatus());
            }
        }
    }

    public static boolean downloadDocument(String code, String filePath) throws IOException{
        try(Socket socket = new Socket("localhost", 9999)){
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out= new DataOutputStream(socket.getOutputStream());
            HTTPmessage request = new HTTPmessage();
            request.setRequestMethod("GET");
            request.setURI("/download?code=" + code);
            request.send(out);

            HTTPmessage response = new HTTPmessage(in);

            if (!response.getStatus().startsWith("200")) {
                System.out.println("Error obtaining document: " + response.getStatus());
                return false;
            }

            byte[] content = response.getContent();
            if (content == null || content.length == 0) {
                System.out.println("Ficheiro vazio ou não encontrado.");
                return false;
            }

            FileOutputStream fos = new FileOutputStream(filePath);
            fos.write(content);
            fos.close();

            System.out.println("Documento guardado com sucesso em: " + filePath);
            return true;
        }

    }


}
