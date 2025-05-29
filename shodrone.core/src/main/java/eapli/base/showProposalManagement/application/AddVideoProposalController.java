package eapli.base.showProposalManagement.application;

import eapli.base.customerManagement.application.CustomerManagementService;
import eapli.base.customerManagement.domain.Customer;
import eapli.base.customerManagement.repositories.CustomerRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.showProposalManagement.domain.ShowProposal;
import eapli.base.showProposalManagement.repositories.ShowProposalRepository;
import eapli.base.showRequestManagement.domain.ShowStatus;
import eapli.base.usermanagement.domain.ExemploPasswordPolicy;
import eapli.base.usermanagement.domain.Roles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PasswordPolicy;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AddVideoProposalController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final PasswordEncoder passwordEncoder = new PlainTextEncoder();
    private final PasswordPolicy passwordPolicy = new ExemploPasswordPolicy();
    private final CustomerRepository customerRepository = PersistenceContext.repositories().customers();
    private final CustomerManagementService customerManagementService = new CustomerManagementService(customerRepository, passwordEncoder, passwordPolicy);
    private final ShowProposalRepository showProposalRepository = PersistenceContext.repositories().showProposals();
    private final ShowProposalManagementService showProposalManagementService = new ShowProposalManagementService(showProposalRepository);

    public Iterable<Customer> listCustomers() {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.CRM_COLLABORATOR);
        return customerManagementService.findAllActiveCustomers();
    }

    public Iterable<ShowProposal> listShowProposals(Customer customer) {
        return showProposalManagementService.findByPendingAndEmptyVideo(customer, ShowStatus.PENDING);
    }

    public boolean addVideoToProposal(String video, ShowProposal showProposal) {
        if (showProposal.addVideoToProposal(video)) {
            this.showProposalRepository.save(showProposal);
            return true;
        }
        return false;
    }
}
