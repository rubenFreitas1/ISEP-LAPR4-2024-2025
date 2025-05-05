package eapli.base.customerManagement.application;

import eapli.base.customerManagement.domain.Customer;
import eapli.base.customerManagement.repositories.CustomerRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.Roles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

@UseCaseController
public class RegisterCustomerController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    private final CustomerRepository repo = PersistenceContext.repositories().customers();

    private final CustomerManagementService customersvc = new CustomerManagementService(repo);

    public Customer registerCustomer(final String customerName, final String customerAddress, final String customerEmail, final String password, final String customerPhoneNumber, final String customerVatNumber) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.CRM_COLLABORATOR);
        return customersvc.registerNewCustomer(customerName, customerAddress, customerEmail, password, customerPhoneNumber, customerVatNumber, authz.session().get().authenticatedUser(), Customer.CustomerStatus.CREATED);
    }
}
