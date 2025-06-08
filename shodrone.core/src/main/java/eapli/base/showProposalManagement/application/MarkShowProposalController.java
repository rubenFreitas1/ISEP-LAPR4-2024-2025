package eapli.base.showProposalManagement.application;

import eapli.base.customerManagement.domain.Customer;
import eapli.base.customerManagement.dto.CustomerDTO;
import eapli.base.customerManagement.dto.CustomerDTOParser;
import eapli.base.customerManagement.repositories.CustomerRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.showProposalManagement.domain.ShowProposal;
import eapli.base.showProposalManagement.dto.ShowProposalDTO;
import eapli.base.showProposalManagement.dto.ShowProposalDTOParser;
import eapli.base.showProposalManagement.repositories.ShowProposalRepository;
import eapli.framework.application.UseCaseController;

import java.util.Optional;

@UseCaseController
public class MarkShowProposalController {
    private final CustomerRepository customerRepository = PersistenceContext.repositories().customers();
    private final ShowProposalRepository showProposalRepository = PersistenceContext.repositories().showProposals();
    private final ShowProposalDTOParser showProposalDTOParser = new ShowProposalDTOParser();
    private final CustomerDTOParser customerDTOParser = new CustomerDTOParser();




    public Iterable<ShowProposalDTO> getAnsweredShowProposals(CustomerDTO customerDTO){
        Optional<Customer> customer = customerDTOParser.getCustomerFromDTO(customerDTO);
        Iterable<ShowProposal> list = showProposalRepository.findByAcceptedProposals(customer.get());
        return showProposalDTOParser.transformToShowProposalDTOlist(list);
    }

    public Iterable<CustomerDTO> getActiveCustomers(){
        Iterable<Customer> list = customerRepository.findByActive();
        return customerDTOParser.transformToCustomerDTOList(list);
    }

    public boolean markShowProposal(ShowProposalDTO showProposalDTO){
        Optional<ShowProposal> showProposal = showProposalDTOParser.getShowProposalfromDTO(showProposalDTO);
        if(showProposal.isPresent()){
            if(showProposal.get().markShowProposal()){
                showProposalRepository.save(showProposal.get());
                return true;
            }
        }
        return false;
    }
}
