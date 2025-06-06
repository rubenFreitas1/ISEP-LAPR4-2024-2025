package eapli.base.app.customer.presentation.showProposalRequests;

import eapli.framework.presentation.console.AbstractUI;
import rcomp.client.TcpClient;

import java.io.IOException;

public class AnalyseProposalUI extends AbstractUI {

    private final String customerEmail;

    public AnalyseProposalUI(String customerEmail){
        this.customerEmail = customerEmail;
    }
    @Override
    protected boolean doShow() {
        try{
            Iterable<String> codes = TcpClient.analyseProposal(customerEmail);
            if(!codes.iterator().hasNext()){
                System.out.println("There are no Show Proposals to Analyse!");
                return false;
            }

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public String headline() {
        return "Analyse Proposals";
    }
}
