package eapli.base.showProposalManagement.application;

import eapli.base.customerManagement.application.CustomerManagementService;
import eapli.base.customerManagement.domain.Customer;
import eapli.base.customerManagement.dto.CustomerDTO;
import eapli.base.customerManagement.dto.CustomerDTOParser;
import eapli.base.customerManagement.repositories.CustomerRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.showProposalManagement.domain.ShowProposal;
import eapli.base.showProposalManagement.dto.ShowProposalDTO;
import eapli.base.showProposalManagement.dto.ShowProposalDTOParser;
import eapli.base.showProposalManagement.repositories.ShowProposalRepository;
import eapli.base.showRequestManagement.domain.ShowStatus;
import eapli.base.showRequestManagement.dto.ShowRequestDTOParser;
import eapli.base.usermanagement.domain.ExemploPasswordPolicy;
import eapli.base.usermanagement.domain.Roles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PasswordPolicy;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public class AddVideoProposalController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final PasswordEncoder passwordEncoder = new PlainTextEncoder();
    private final PasswordPolicy passwordPolicy = new ExemploPasswordPolicy();
    private final CustomerRepository customerRepository = PersistenceContext.repositories().customers();
    private final CustomerManagementService customerManagementService = new CustomerManagementService(customerRepository, passwordEncoder, passwordPolicy);
    private final ShowProposalRepository showProposalRepository = PersistenceContext.repositories().showProposals();
    private final ShowProposalManagementService showProposalManagementService = new ShowProposalManagementService(showProposalRepository);

    private final CustomerDTOParser customerDTOParser = new CustomerDTOParser();
    private final ShowProposalDTOParser showProposalDTOParser = new ShowProposalDTOParser();

    public Iterable<CustomerDTO> listCustomers() {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.CRM_COLLABORATOR);
        Iterable <Customer> customers = customerManagementService.findAllActiveCustomers();
        return customerDTOParser.transformToCustomerDTOList(customers);
    }

    public Iterable<ShowProposalDTO> listShowProposals(CustomerDTO customerDTO) {
        Optional<Customer> customer = customerDTOParser.getCustomerFromDTO(customerDTO);
        Iterable<ShowProposal> showProposals = showProposalManagementService.findByPendingAndEmptyVideo(customer.get(), ShowStatus.PENDING);
        return showProposalDTOParser.transformToShowProposalDTOlist(showProposals);
    }

    public boolean addVideoToProposal(String video, ShowProposalDTO showProposalDTO) {
        Optional<ShowProposal> showProposal = showProposalDTOParser.getShowProposalfromDTO(showProposalDTO);
        if (showProposal.isPresent()) {
            if (showProposal.get().addVideoToProposal(video)) {
                this.showProposalRepository.save(showProposal.get());
                return true;
            }
        }
        return false;
    }
}
