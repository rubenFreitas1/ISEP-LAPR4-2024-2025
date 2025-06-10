package rcomp.server;

import com.google.gson.*;
import eapli.base.showProposalManagement.application.AnalyseProposalController;
import eapli.base.showProposalManagement.application.GetShowInfoController;
import eapli.base.showProposalManagement.application.ProposalFeedbackController;
import eapli.base.showProposalManagement.domain.Document;
import eapli.base.showProposalManagement.domain.ShowProposal;
import eapli.base.showProposalManagement.dto.ShowProposalDTO;
import eapli.base.showProposalManagement.dto.ShowProposalDTOParser;
import rcomp.client.HTTPmessage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.InetAddress;
import java.net.Socket;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

class TcpSrvSumThread implements Runnable {
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;

    AnalyseProposalController analyseProposalController = new AnalyseProposalController();
    GetShowInfoController getShowInfoController = new GetShowInfoController();
    ProposalFeedbackController proposalFeedbackController = new ProposalFeedbackController();

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
                    Iterable<ShowProposal> proposals = analyseProposalController.findByEmailAndStatus(customerEmail);
                    StringBuilder sb = new StringBuilder();
                    for (ShowProposal proposal : proposals) {
                        String code = proposal.document().code();
                        sb.append("http://localhost:9999/download?code=").append(code).append("\n");
                    }
                    response.setResponseStatus("200 OK");
                    response.setContent(sb.toString(), "text/plain");
                    break;

                case "/completedShows":
                    String customerEmailCompleted = request.getContentAsString().split("=")[1];
                    Iterable<ShowProposalDTO> completedProposals = proposalFeedbackController.findBySent(customerEmailCompleted);

                    Gson gsonCompleted = new GsonBuilder()
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

                    response.setResponseStatus("200 OK");
                    response.setContent(gsonCompleted.toJson(completedProposals), "application/json");
                    break;

                case "/proposalFeedback":
                    String feedbackContent = request.getContentAsString();
                    String[] feedbackParts = feedbackContent.split("&");
                    long proposalId = Long.parseLong(feedbackParts[0].split("=")[1]);
                    String aprroval = feedbackParts[1].split("=")[1];
                    String feedback = feedbackParts[2].split("=")[1];


                    Optional<ShowProposal> proposal = proposalFeedbackController.findById(proposalId);
                    proposalFeedbackController.updateProposalFeedback(proposal, feedback, aprroval);
                    response.setResponseStatus("200 OK");
                    response.setContent("Feedback submitted successfully", "text/plain");
                    break;



                case "/download":
                    String query = request.getURI();
                    String code = query.substring(query.indexOf("code=") + 5);
                    Document doc = analyseProposalController.findDocumentByCode(code);
                    if (doc != null) {
                        response.setResponseStatus("200 OK");
                        response.setContent(doc.finalContent(), "application/pdf");
                    } else {
                        response.setResponseStatus("404 Not Found");
                        response.setContent("Document not found", "text/plain");
                    }
                    break;
                case "/acceptedShows":
                    String customerEmail1 = request.getContentAsString().split("=")[1];

                    Iterable<ShowProposal> shows = getShowInfoController.findAcceptedByCustomer(customerEmail1);
                    ShowProposalDTOParser parser = new ShowProposalDTOParser();
                    List<ShowProposalDTO> dtos =
                            (List<ShowProposalDTO>) parser.transformToShowProposalDTOlist(shows);

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
                    response.setResponseStatus("200 OK");
                    response.setContent(gson.toJson(dtos), "application/json");
                    break;
                case "/getShowInfo":
                    long id = Long.parseLong(request.getContentAsString().split("=")[1]);

                    Optional<ShowProposal> opt = getShowInfoController.findById(id);
                    if (opt.isEmpty()) {
                        response.setResponseStatus("404 Not Found");
                        response.setContent("Show not found", "text/plain");
                        break;
                    }

                    ShowProposalDTO dto = opt.get().toDTO();
                    response.setResponseStatus("200 OK");
                    response.setContent(new Gson().toJson(dto), "application/json");
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
