package eapli.base.app.customer.presentation.showProposalRequests;

import eapli.framework.presentation.console.AbstractUI;
import rcomp.client.TcpClient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class AnalyseProposalUI extends AbstractUI {

    private final String filePath = "shodrone.app.customer/src/downloads";

    private final String customerEmail;

    public AnalyseProposalUI(String customerEmail){
        this.customerEmail = customerEmail;
    }
    @Override
    protected boolean doShow() {
        try{
            List<String> codes = TcpClient.analyseProposal(customerEmail);
            if(codes == null || codes.isEmpty()){
                System.out.println("There are no Show Proposals to Analyse!");
                return false;
            }
            System.out.println("Links recebidos: " + codes);

            CountDownLatch latch = new CountDownLatch(1);

            JFrame frame = new JFrame("Available Show Proposals");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(600, 300);
            frame.setLayout(new GridLayout(codes.size(), 1));

            for (String code : codes) {
                JLabel label = new JLabel("<html><a href='#'>" + code + "</a></html>");
                label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                label.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        try {
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

            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    latch.countDown();
                }
            });
            frame.setVisible(true);
            latch.await();
        }catch (IOException | InterruptedException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public String headline() {
        return "Analyse Proposals";
    }
}
