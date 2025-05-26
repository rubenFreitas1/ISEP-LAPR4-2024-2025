package eapli.base.representativeManagement.application;

import eapli.base.customerManagement.application.CustomerManagementService;
import eapli.base.customerManagement.domain.Customer;
import eapli.base.customerManagement.repositories.CustomerRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.representativeManagement.domain.Representative;
import eapli.base.representativeManagement.repositories.RepresentativeRepository;
import eapli.base.usermanagement.domain.ExemploPasswordPolicy;
import eapli.base.usermanagement.domain.Roles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PasswordPolicy;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class DisableRepresentativeController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final PasswordEncoder passwordEncoder = new PlainTextEncoder();
    private final PasswordPolicy passwordPolicy = new ExemploPasswordPolicy();
    private final CustomerRepository customerRepo = PersistenceContext.repositories().customers();
    private final CustomerManagementService customerManagementService = new CustomerManagementService(customerRepo, passwordEncoder, passwordPolicy);
    private final RepresentativeRepository representativeRepo = PersistenceContext.repositories().representatives();
    private final RepresentativeManagementService representativeManagementService = new RepresentativeManagementService(representativeRepo, customerRepo);

    public Iterable<Customer> listCustomers() {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.CRM_COLLABORATOR);
        return customerManagementService.findAllActiveCustomers();
    }

    public Iterable<Representative> listCustomerRepresentatives(Customer customer) {
        return representativeManagementService.findByAssociatedCustomer(customer);
    }

    public Representative deactivateCustomerRepresentative(Representative representative) {
        return this.representativeManagementService.deactivateCustomerRepresentative(representative);
    }
}
