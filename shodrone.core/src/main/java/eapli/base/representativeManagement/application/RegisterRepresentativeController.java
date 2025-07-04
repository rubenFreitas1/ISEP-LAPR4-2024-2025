package eapli.base.representativeManagement.application;

import eapli.base.customerManagement.application.CustomerManagementService;
import eapli.base.customerManagement.domain.Customer;
import eapli.base.customerManagement.repositories.CustomerRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.representativeManagement.repositories.RepresentativeRepository;
import eapli.base.usermanagement.domain.ExemploPasswordPolicy;
import eapli.base.usermanagement.domain.Roles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PasswordPolicy;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.time.util.CurrentTimeCalendars;
import org.springframework.security.crypto.password.PasswordEncoder;

@UseCaseController
public class RegisterRepresentativeController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final PasswordEncoder passwordEncoder = new PlainTextEncoder();
    private final PasswordPolicy passwordPolicy = new ExemploPasswordPolicy();

    private final RepresentativeRepository repreRepo = PersistenceContext.repositories().representatives();

    private final CustomerRepository customerRepo = PersistenceContext.repositories().customers();

    private final RepresentativeManagementService representativesvc = new RepresentativeManagementService(repreRepo, customerRepo, passwordEncoder, passwordPolicy);

    private final CustomerManagementService customersvc = new CustomerManagementService(customerRepo, passwordEncoder, passwordPolicy);


    public void registerRepresentative(final String representativeFirstName, final String representativeLastName, final String representativeEmail, final String representativePassword, final String representativePhoneNumber, final Customer associatedCustomer, final String representativePosition) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.CRM_COLLABORATOR);

        if (associatedCustomer == null) {
            throw new IllegalArgumentException("Associated Customer cannot be null.");
        }

        System.out.println("Registering representative for customer: " + associatedCustomer.identity());
        representativesvc.registerNewRepresentative(representativeFirstName,representativeLastName, representativeEmail, CurrentTimeCalendars.now(), representativePassword, representativePhoneNumber, associatedCustomer, representativePosition, authz.session().get().authenticatedUser());
    }

    public Iterable<Customer> allCustomers() {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.CRM_COLLABORATOR);
        return customersvc.findAllCustomers();
    }

    public boolean isPhoneNumberUsed(String phoneNumber) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.CRM_COLLABORATOR);
        return repreRepo.isPhoneNumberUsed(phoneNumber);
    }

    public boolean isCustomerEmailUsed(String email) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.CRM_COLLABORATOR);
        return customerRepo.isEmailUsed(email);
    }

    public boolean isCustomerPhoneNumberUsed(String phoneNumber) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.CRM_COLLABORATOR);
        return customerRepo.isCustomerPhoneNumberUsed(phoneNumber);
    }
}
