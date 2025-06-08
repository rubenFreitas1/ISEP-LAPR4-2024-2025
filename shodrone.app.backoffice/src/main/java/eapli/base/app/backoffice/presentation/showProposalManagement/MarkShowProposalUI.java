package eapli.base.app.backoffice.presentation.showProposalManagement;

import eapli.base.app.backoffice.presentation.customerManagement.CustomerDTOPrinter;
import eapli.base.customerManagement.dto.CustomerDTO;
import eapli.base.showProposalManagement.application.MarkShowProposalController;
import eapli.base.showProposalManagement.dto.ShowProposalDTO;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

public class MarkShowProposalUI extends AbstractUI {

    private MarkShowProposalController controller = new MarkShowProposalController();

    @Override
    protected boolean doShow() {
        Iterable<CustomerDTO> listActiveCustomers = controller.getActiveCustomers();
        if(!listActiveCustomers.iterator().hasNext()){
            System.out.println("\nThere are no Active Customers Registered!\n");
            return false;
        }
        String headerCustomerModel = String.format("Select Customer\n#  %-30s%-30s%-30s%-30s", "NAME","STATUS", "PHONE NUMBER", "EMAIL");
        SelectWidget<CustomerDTO> selectorCustomer = new SelectWidget<>(headerCustomerModel, listActiveCustomers, new CustomerDTOPrinter());
        selectorCustomer.show();
        CustomerDTO customerDTO = selectorCustomer.selectedElement();
        if(customerDTO == null){
            System.out.println("Customer cannot be null!");
            return false;
        }
        Iterable<ShowProposalDTO> listShowProposalAccepted = controller.getAnsweredShowProposals(customerDTO);
       if(!listShowProposalAccepted.iterator().hasNext()){
           System.out.println("\nThere are no Show Proposals Accepted by the Customers Representatives!\n");
           return false;
       }
        String headerModel = String.format("Select Show Proposal\n#  %-30s%-30s%-30s%-30s%-30s", "DESCRIPTION","PROPOSAL NUMBER", "CUSTOMER NAME", "DATE", "DURATION");
        SelectWidget<ShowProposalDTO> selector = new SelectWidget<>(headerModel, listShowProposalAccepted, new ShowProposalDTOPrinter());
        selector.show();
        ShowProposalDTO showProposal = selector.selectedElement();
        if(showProposal == null){
            System.out.println("Show Proposal cannot be null!");
            return false;
        }
        if(controller.markShowProposal(showProposal)){
            System.out.println("Show Proposal updated as Accepted!");
            return true;
        }
        System.out.println("Show Proposal was not updated as Accepted!");
        return false;
    }

    @Override
    public String headline() {
        return "Mark Show Proposal";
    }
}
