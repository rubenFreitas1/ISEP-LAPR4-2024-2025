package eapli.base.showProposalManagement.application;

import eapli.base.customerManagement.application.CustomerManagementService;
import eapli.base.customerManagement.domain.Customer;
import eapli.base.customerManagement.dto.CustomerDTO;
import eapli.base.customerManagement.dto.CustomerDTOParser;
import eapli.base.customerManagement.repositories.CustomerRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.showProposalManagement.LPROGConnection.ProposalWriter;
import eapli.base.showProposalManagement.domain.ShowProposal;
import eapli.base.showProposalManagement.domain.Template;
import eapli.base.showProposalManagement.repositories.ShowProposalRepository;
import eapli.base.showProposalManagement.repositories.TemplateRepository;
import eapli.base.showRequestManagement.application.ShowRequestManagementService;
import eapli.base.showRequestManagement.domain.GeoLocation;
import eapli.base.showRequestManagement.domain.ShowRequest;
import eapli.base.showRequestManagement.dto.ShowRequestDTO;
import eapli.base.showRequestManagement.dto.ShowRequestDTOParser;
import eapli.base.showRequestManagement.repositories.ShowRequestRepository;
import eapli.base.usermanagement.domain.ExemploPasswordPolicy;
import eapli.base.usermanagement.domain.Roles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PasswordPolicy;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalTime;
import java.util.Calendar;
import java.util.Optional;

public class RegisterShowProposalController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final PasswordEncoder passwordEncoder = new PlainTextEncoder();
    private final PasswordPolicy passwordPolicy = new ExemploPasswordPolicy();
    private final ProposalWriter proposalWriter = new ProposalWriter();
    private final CustomerRepository customerRepository = PersistenceContext.repositories().customers();
    private final CustomerManagementService customerManagementService = new CustomerManagementService(customerRepository, passwordEncoder, passwordPolicy);
    private final ShowRequestRepository showRequestRepository = PersistenceContext.repositories().showRequests();
    private final ShowRequestManagementService showRequestManagementService = new ShowRequestManagementService(showRequestRepository);
    private final ShowProposalRepository showProposalRepository = PersistenceContext.repositories().showProposals();
    private final ShowProposalManagementService showProposalManagementService = new ShowProposalManagementService(showProposalRepository, proposalWriter);
    private final TemplateRepository templateRepository = PersistenceContext.repositories().templates();
    private final TemplateManagementService templateManagementService = new TemplateManagementService(templateRepository);

    private final CustomerDTOParser customerDTOParser = new CustomerDTOParser();
    private final ShowRequestDTOParser showRequestDTOParser = new ShowRequestDTOParser();

    public Iterable<CustomerDTO> listCustomers() {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.CRM_COLLABORATOR);
        Iterable <Customer> customers = customerManagementService.findAllActiveCustomers();
        return customerDTOParser.transformToCustomerDTOList(customers);
    }

    public Iterable<ShowRequestDTO> listShowRequests(CustomerDTO customerDTO) {
        Optional<Customer> customer = customerDTOParser.getCustomerFromDTO(customerDTO);
        Iterable<ShowRequest> showRequests = showRequestManagementService.findByCustomer(customer.get());
        return showRequestDTOParser.transformToShowRequestDTOlist(showRequests);
    }

    public ShowProposal registerShowProposal(ShowRequestDTO showRequestDTO, GeoLocation location, Calendar date, LocalTime time, int duration, int totalDroneNumber, Template template, double insurance) {
        Optional<ShowRequest> showRequest = showRequestDTOParser.getShowRequestfromDTO(showRequestDTO);
        return showProposalManagementService.registerShowProposal(showRequest.get(), location, date, time, duration, totalDroneNumber, authz.session().get().authenticatedUser(), template, insurance);
    }

    public Iterable<Template> listTemplates() {
        return templateManagementService.listAllTemplates();
    }
}