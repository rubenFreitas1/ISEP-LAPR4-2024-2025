package eapli.base.representativeManagement.application;

import eapli.base.customerManagement.application.CustomerManagementService;
import eapli.base.customerManagement.domain.Customer;
import eapli.base.customerManagement.repositories.CustomerRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.representativeManagement.domain.Representative;
import eapli.base.representativeManagement.repositories.RepresentativeRepository;
import eapli.base.usermanagement.domain.Roles;
import eapli.framework.application.UseCaseController;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.time.util.CurrentTimeCalendars;

@UseCaseController
public class RegisterRepresentativeController {

    private final TransactionalContext autoTx = PersistenceContext.repositories().newTransactionalContext();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    private final RepresentativeRepository repreRepo = PersistenceContext.repositories().representatives(autoTx);

    private final CustomerRepository customerRepo = PersistenceContext.repositories().customers(autoTx);

    private final RepresentativeManagementService representativesvc = new RepresentativeManagementService(repreRepo);

    private final CustomerManagementService customersvc = new CustomerManagementService(customerRepo);


    public Representative registerRepresentative(final String representativeName, final String representativeEmail, final String representativePassword, final String representativePhoneNumber, final Customer associatedCustomer, final String representativePosition) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.CRM_COLLABORATOR);

        if (associatedCustomer == null) {
            throw new IllegalArgumentException("Associated Customer cannot be null.");
        }

        System.out.println("Registering representative for customer: " + associatedCustomer.identity());


        return representativesvc.registerNewRepresentative(representativeName, representativeEmail, CurrentTimeCalendars.now(), representativePassword, representativePhoneNumber, associatedCustomer, representativePosition, authz.session().get().authenticatedUser());
    }

    public Iterable<Customer> allCustomers() {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.CRM_COLLABORATOR);
        return customersvc.findAllCustomers();
    }
}
