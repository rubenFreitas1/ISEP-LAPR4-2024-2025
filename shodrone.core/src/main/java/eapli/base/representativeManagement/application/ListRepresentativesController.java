package eapli.base.representativeManagement.application;

import eapli.base.customerManagement.application.CustomerManagementService;
import eapli.base.customerManagement.domain.Customer;
import eapli.base.customerManagement.repositories.CustomerRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.representativeManagement.domain.Representative;
import eapli.base.representativeManagement.repositories.RepresentativeRepository;
import eapli.base.usermanagement.domain.ExemploPasswordPolicy;
import eapli.base.usermanagement.domain.Roles;
import eapli.framework.application.UseCaseController;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PasswordPolicy;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@UseCaseController
public class ListRepresentativesController {

    private final TransactionalContext autoTx = PersistenceContext.repositories().newTransactionalContext();
    private final PasswordEncoder passwordEncoder = new PlainTextEncoder();
    private final PasswordPolicy passwordPolicy = new ExemploPasswordPolicy();

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    private final RepresentativeRepository repreRepo = PersistenceContext.repositories().representatives(autoTx);

    private final CustomerRepository customerRepo = PersistenceContext.repositories().customers(autoTx);

    private final RepresentativeManagementService representativesvc = new RepresentativeManagementService(repreRepo, customerRepo);

    private final CustomerManagementService customersvc = new CustomerManagementService(customerRepo, passwordEncoder, passwordPolicy);

    public Iterable<Representative> allRepresentatives(Customer customer) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.CRM_COLLABORATOR);
        return representativesvc.findByAssociatedCustomer(customer);
    }

    public Iterable<Customer> allCustomers() {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.CRM_COLLABORATOR);
        return customersvc.findAllCustomers();
    }
}
