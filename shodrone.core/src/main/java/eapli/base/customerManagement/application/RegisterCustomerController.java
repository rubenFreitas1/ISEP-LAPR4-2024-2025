package eapli.base.customerManagement.application;

import eapli.base.customerManagement.domain.Customer;
import eapli.base.customerManagement.repositories.CustomerRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.representativeManagement.application.RepresentativeManagementService;
import eapli.base.representativeManagement.repositories.RepresentativeRepository;
import eapli.base.usermanagement.domain.ExemploPasswordPolicy;
import eapli.base.usermanagement.domain.Roles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserManagementService;
import eapli.framework.infrastructure.authz.domain.model.PasswordPolicy;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.authz.domain.model.Role;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@UseCaseController
public class RegisterCustomerController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final PasswordEncoder passwordEncoder = new PlainTextEncoder();
    private final PasswordPolicy passwordPolicy = new ExemploPasswordPolicy();

    private final CustomerRepository repo = PersistenceContext.repositories().customers();
    private final RepresentativeRepository repo2 = PersistenceContext.repositories().representatives();

    private final CustomerManagementService customersvc = new CustomerManagementService(repo, passwordEncoder, passwordPolicy);
    private final RepresentativeManagementService representativesvc = new RepresentativeManagementService(repo2, repo, passwordEncoder, passwordPolicy);

    private final UserManagementService userSvc = AuthzRegistry.userService();


    public Customer registerCustomer(final String customerFirstName, final String customerLastName, final String customerAddress, final String customerEmail, final String password, final String customerPhoneNumber, final String customerVatNumber, final String representativeFirstName, final String representativeLastName, final String representativeEmail, final String representativePassword,  final String representativePhoneNumber,final String representativePosition) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.POWER_USER,Roles.CRM_COLLABORATOR);
        Customer newCustomer = customersvc.registerNewCustomer(customerFirstName, customerLastName, customerAddress, customerEmail, password, customerPhoneNumber, customerVatNumber, authz.session().get().authenticatedUser());
        representativesvc.registerNewRepresentative(representativeFirstName, representativeLastName, representativeEmail, representativePassword, representativePhoneNumber, newCustomer, representativePosition, authz.session().get().authenticatedUser());
        final Set<Role> customerRoleType = new HashSet<>();
        customerRoleType.add(Roles.CUSTOMER);
        final Set<Role> representativeRoleType = new HashSet<>();
        representativeRoleType.add(Roles.CUSTOMER_REPRESENTATIVE);
        userSvc.registerUser(newCustomer.customerEmail(),newCustomer.customerPassword(),newCustomer.customerName(),customerRoleType);
        return newCustomer;
    }

    public boolean isRepresentativeEmailUsed(String email) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.CRM_COLLABORATOR);
        return repo2.isEmailUsed(email);
    }

    public boolean isCustomerEmailUsed(String email) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.CRM_COLLABORATOR);
        return repo.isEmailUsed(email);
    }

    public boolean isCustomerVatNumberUsed(String vatNumber) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.CRM_COLLABORATOR);
        return repo.isVatNumberUsed(vatNumber);
    }

    public boolean isRepresentativePhoneNumberUsed(String phoneNumber) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.CRM_COLLABORATOR);
        return repo2.isPhoneNumberUsed(phoneNumber);
    }

    public boolean isCustomerPhoneNumberUsed(String phoneNumber) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.CRM_COLLABORATOR);
        return repo.isCustomerPhoneNumberUsed(phoneNumber);
    }
}
