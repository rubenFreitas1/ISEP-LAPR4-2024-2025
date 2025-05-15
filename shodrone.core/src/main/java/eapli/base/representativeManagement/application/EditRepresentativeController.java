package eapli.base.representativeManagement.application;

import eapli.base.customerManagement.application.CustomerManagementService;
import eapli.base.customerManagement.domain.Customer;
import eapli.base.customerManagement.repositories.CustomerRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.representativeManagement.domain.Representative;
import eapli.base.representativeManagement.repositories.RepresentativeRepository;
import eapli.base.usermanagement.domain.Roles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

@UseCaseController
public class EditRepresentativeController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    private final RepresentativeRepository representativeRepo = PersistenceContext.repositories().representatives();

    private final CustomerRepository customerRepo = PersistenceContext.repositories().customers();

    private final RepresentativeManagementService representativesvc = new RepresentativeManagementService(representativeRepo, customerRepo);

    private final CustomerManagementService customersvc = new CustomerManagementService(customerRepo);

    public Representative editRepresentative(Representative representative,String representativeName, String representativeEmail, String representativePassword, String representativePhoneNumber, String representativePosition){
        authz.ensureAuthenticatedUserHasAnyOf(Roles.CRM_COLLABORATOR);
        representativesvc.editRepresentative(representative, representativeName, representativeEmail, representativePassword, representativePhoneNumber, representativePosition);
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
}
