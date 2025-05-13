package eapli.base.representativeManagement.application;

import eapli.base.customerManagement.application.CustomerManagementService;
import eapli.base.customerManagement.domain.Customer;
import eapli.base.customerManagement.repositories.CustomerRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.representativeManagement.domain.Representative;
import eapli.base.representativeManagement.repositories.RepresentativeRepository;
import eapli.base.usermanagement.domain.Roles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class DisableRepresentativeController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final CustomerRepository customerRepo = PersistenceContext.repositories().customers();
    private final CustomerManagementService customerManagementService = new CustomerManagementService(customerRepo);
    private final RepresentativeRepository representativeRepo = PersistenceContext.repositories().representatives();
    private final RepresentativeManagementService representativeManagementService = new RepresentativeManagementService(representativeRepo, customerRepo);

    public Iterable<Customer> listCustomers() {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.CRM_COLLABORATOR);
        return customerManagementService.findAllActiveCustomers();
    }

    public Iterable<Representative> listCustomerRepresentatives(Customer customer) {
        return representativeRepo.findByAssociatedCustomer(customer);
    }

    public Representative deactivateCustomerRepresentative(Representative representative) {
        return this.representativeManagementService.deactivateCustomerRepresentative(representative);
    }
}
