package rcomp.client;



import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import eapli.base.showProposalManagement.dto.ShowProposalDTO;

import java.io.*;
import java.lang.reflect.Type;
import java.net.*;
import java.time.LocalTime;
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
                List<String> links = new ArrayList<>();
                for (String line : body.split("\n")) {
                    String trimmed = line.trim();
                    if (!trimmed.isEmpty()) {
                        links.add(trimmed);
                    }
                }
                return links;
            }else{
                throw new IOException("Error obtaining Proposals: " + response.getStatus());
            }
        }
    }

    public static List<ShowProposalDTO> listCompletedShows(String email) throws IOException {
        try(Socket socket = new Socket("localhost", 9999)){
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out= new DataOutputStream(socket.getOutputStream());
            HTTPmessage request = new HTTPmessage();
            request.setRequestMethod("POST");
            request.setURI("/completedShows");
            request.setContent("email=" + email, "text/plain");
            request.send(out);

            HTTPmessage response = new HTTPmessage(in);

            if (response.getStatus().startsWith("200")) {
                String json = response.getContentAsString();

                Gson gson = new GsonBuilder()
                        .registerTypeAdapter(LocalTime.class, new JsonDeserializer<LocalTime>() {
                            @Override
                            public LocalTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                                return LocalTime.parse(json.getAsString());
                            }
                        })
                        .create();

                Type listType = new TypeToken<List<ShowProposalDTO>>() {}.getType();
                return gson.fromJson(json, listType);
            } else {
                throw new IOException("Error obtaining completed shows: " + response.getStatus());
            }

        }
    }

    public static boolean proposalFeedback(ShowProposalDTO proposal, boolean accepted, String feedback) throws IOException {
        try(Socket socket = new Socket("localhost", 9999)){
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out= new DataOutputStream(socket.getOutputStream());
            HTTPmessage request = new HTTPmessage();
            request.setRequestMethod("POST");
            request.setURI("/proposalFeedback");
            String content = "id=" + proposal.getShowProposalId() + "&accepted=" + accepted + "&feedback=" + feedback;
            request.setContent(content, "text/plain");
            request.send(out);

            HTTPmessage response = new HTTPmessage(in);
            return response.getStatus().startsWith("200");
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

    public static List<ShowProposalDTO> listAcceptedShows(String customerEmail) throws IOException {
        try (Socket s = new Socket("localhost", 9999)) {
            DataInputStream  in  = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            HTTPmessage request = new HTTPmessage();
            request.setRequestMethod("POST");
            request.setURI("/acceptedShows");
            request.setContent("email=" + customerEmail, "text/plain");
            request.send(out);

            HTTPmessage resp = new HTTPmessage(in);
            if (!resp.getStatus().startsWith("200"))
                throw new IOException("Server error: " + resp.getStatus());

            String json = resp.getContentAsString();
            Type listType = new TypeToken<List<ShowProposalDTO>>(){}.getType();

            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalTime.class, new JsonDeserializer<LocalTime>() {
                        @Override
                        public LocalTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                            return LocalTime.parse(json.getAsString());
                        }
                    })
                    .registerTypeAdapter(LocalTime.class, new JsonSerializer<LocalTime>() {
                        @Override
                        public JsonElement serialize(LocalTime src, Type typeOfSrc, JsonSerializationContext context) {
                            return new JsonPrimitive(src.toString());
                        }
                    })
                    .create();

            return gson.fromJson(json, listType);
        }
    }

    public static ShowProposalDTO showDetails(long proposalId) throws IOException {
        try (Socket s = new Socket("localhost", 9999)) {
            DataInputStream  in  = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            HTTPmessage request = new HTTPmessage();
            request.setRequestMethod("POST");
            request.setURI("/getShowInfo");
            request.setContent("id=" + proposalId, "text/plain");
            request.send(out);

            HTTPmessage resp = new HTTPmessage(in);
            if (!resp.getStatus().startsWith("200"))
                throw new IOException("Server error: " + resp.getStatus());

            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalTime.class, new JsonDeserializer<LocalTime>() {
                        @Override
                        public LocalTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                            return LocalTime.parse(json.getAsString());
                        }
                    })
                    .registerTypeAdapter(LocalTime.class, new JsonSerializer<LocalTime>() {
                        @Override
                        public JsonElement serialize(LocalTime src, Type typeOfSrc, JsonSerializationContext context) {
                            return new JsonPrimitive(src.toString());
                        }
                    })
                    .create();

            return gson.fromJson(resp.getContentAsString(), ShowProposalDTO.class);
        }
    }
}
