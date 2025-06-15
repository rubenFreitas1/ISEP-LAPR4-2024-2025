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
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PasswordPolicy;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@UseCaseController
public class EditRepresentativeController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final PasswordEncoder passwordEncoder = new PlainTextEncoder();
    private final PasswordPolicy passwordPolicy = new ExemploPasswordPolicy();

    private final RepresentativeRepository representativeRepo = PersistenceContext.repositories().representatives();

    private final CustomerRepository customerRepo = PersistenceContext.repositories().customers();

    private final RepresentativeManagementService representativesvc = new RepresentativeManagementService(representativeRepo, customerRepo, passwordEncoder, passwordPolicy);

    private final CustomerManagementService customersvc = new CustomerManagementService(customerRepo, passwordEncoder, passwordPolicy);

    public Representative editRepresentative(Representative representative,String representativeFirstName, String representativeLastName, String representativeEmail, String representativePassword, String representativePhoneNumber, String representativePosition){
        authz.ensureAuthenticatedUserHasAnyOf(Roles.CRM_COLLABORATOR);
        representativesvc.editRepresentative(representative, representativeFirstName, representativeLastName, representativeEmail, representativePassword, representativePhoneNumber, representativePosition);
        return representative;
    }
    public Iterable<Representative> allRepresentatives(Customer customer) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.CRM_COLLABORATOR);
        return representativesvc.findByAssociatedCustomer(customer);
    }

    public Iterable<Customer> allCustomers() {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.CRM_COLLABORATOR);
        return customersvc.findAllCustomers();
    }

    public boolean isEmailUsed(String email) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.CRM_COLLABORATOR);
        return representativeRepo.isEmailUsed(email);
    }

    public boolean isPhoneNumberUsed(String phoneNumber) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.CRM_COLLABORATOR);
        return representativeRepo.isPhoneNumberUsed(phoneNumber);
    }

    public boolean isCustomerPhoneNumberUsed(String phoneNumber) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.CRM_COLLABORATOR);
        return customerRepo.isCustomerPhoneNumberUsed(phoneNumber);
    }

    public Iterable<Representative> findByAssociatedCustomerAndActive(Customer associatedCustomer, boolean active) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.CRM_COLLABORATOR);
        return representativeRepo.findByAssociatedCustomerAndActive(associatedCustomer, active);
    }
}
