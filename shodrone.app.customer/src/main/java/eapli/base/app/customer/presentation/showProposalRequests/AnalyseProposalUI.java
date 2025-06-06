package eapli.base.app.customer.presentation.showProposalRequests;

import eapli.framework.presentation.console.AbstractUI;
import rcomp.client.TcpClient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class AnalyseProposalUI extends AbstractUI {

    private final String filePath = "shodrone.app.customer/src/downloads";

    private final String customerEmail;

    public AnalyseProposalUI(String customerEmail){
        this.customerEmail = customerEmail;
    }
    @Override
    protected boolean doShow() {
        try{
            List<String> links = TcpClient.analyseProposal(customerEmail);
            if(!links.stream().iterator().hasNext()){
                System.out.println("There are no Show Proposals to Analyse!");
                return false;
            }
            JFrame frame = new JFrame("Available Show Proposals");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 300);
            frame.setLayout(new GridLayout(links.size(), 1));

            for (String link : links) {
                JLabel label = new JLabel("<html><a href='" + link + "'>" + link + "</a></html>");
                label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                label.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        try {
                            String code = extractCodeFromLink(link);
                            String fullPath = filePath + File.separator + code + ".pdf";
                            boolean success = TcpClient.downloadDocument(code, fullPath);
                            if(success){
                                JOptionPane.showMessageDialog(frame, "Download done: " + fullPath);

                            }else {
                                JOptionPane.showMessageDialog(frame, "Download failed for: " + code);
                            }
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(frame, "Error trying to download: " + ex.getMessage());
                        }
                    }
                });
                frame.add(label);
            }
            frame.setVisible(true);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    private String extractCodeFromLink(String link) {
        int start = link.indexOf("code=") + 5;
        return link.substring(start);
    }


    @Override
    public String headline() {
        return "Analyse Proposals";
    }
}
