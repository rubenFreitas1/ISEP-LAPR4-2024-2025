package eapli.base.showRequestManagement.application;

import eapli.base.customerManagement.application.CustomerManagementService;
import eapli.base.customerManagement.domain.Customer;
import eapli.base.customerManagement.repositories.CustomerRepository;
import eapli.base.figureCategoryManagement.application.FigureCategoryManagementService;
import eapli.base.figureCategoryManagement.domain.FigureCategory;
import eapli.base.figureCategoryManagement.repositories.FigureCategoryRepository;
import eapli.base.figureManagement.application.FigureManagementService;
import eapli.base.figureManagement.domain.Figure;
import eapli.base.figureManagement.repository.FigureRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.showRequestManagement.domain.GeoLocation;
import eapli.base.showRequestManagement.domain.ShowRequest;
import eapli.base.showRequestManagement.repositories.ShowRequestRepository;
import eapli.base.usermanagement.domain.Roles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

@UseCaseController
public class EditShowRequestController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final CustomerRepository customerRepository = PersistenceContext.repositories().customers();
    private final CustomerManagementService customerManagementService = new CustomerManagementService(customerRepository);
    private final ShowRequestRepository showRequestRepository = PersistenceContext.repositories().showRequests();
    private final ShowRequestManagementService showRequestManagementService = new ShowRequestManagementService(showRequestRepository);
    private final FigureRepository figureRepository = PersistenceContext.repositories().figures();
    private final FigureManagementService figureManagementService = new FigureManagementService(figureRepository);
    private final FigureCategoryRepository figureCategoryRepository = PersistenceContext.repositories().figureCategories();
    private final FigureCategoryManagementService figureCategoryManagementService = new FigureCategoryManagementService(figureCategoryRepository);

    public Iterable<Customer> listCustomers() {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.CRM_COLLABORATOR);
        return customerManagementService.findAllActiveCustomers();
    }

    public Iterable<ShowRequest> listCustomerShowRequests(Customer customer) {
        return showRequestManagementService.findByCustomer(customer);
    }

    public Iterable<Figure> figures(Customer customer) {
        return figureManagementService.findByExclusivityAndCustomer(false, customer);
    }

    public Figure addFigure(String figureDescription, Set<String> keywords, FigureCategory figureCategory, boolean exclusive, Customer customer) {
        return figureManagementService.registerNewFigure(figureDescription, keywords, figureCategory, exclusive, customer, authz.session().get().authenticatedUser());
    }

    public Iterable<FigureCategory> listFigureCategories() {
        return figureCategoryManagementService.findByActive(true);
    }

    public ShowRequest editShowRequestLocation(ShowRequest showRequest, GeoLocation location) {
        return this.showRequestManagementService.editShowRequestLocation(showRequest, location);
    }
    public ShowRequest editShowRequestDescription(ShowRequest showRequest, String description) {
        showRequest.changeDescription(description);
        return (ShowRequest) this.showRequestRepository.save(showRequest);
    }

    public ShowRequest editShowRequestDate(ShowRequest showRequest, Calendar date) {
        return this.showRequestManagementService.editShowRequestDate(showRequest, date);
    }

    public ShowRequest editShowRequestDroneNumber(ShowRequest showRequest, int droneNumber) {
        return this.showRequestManagementService.editShowRequestDroneNumber(showRequest, droneNumber);
    }

    public ShowRequest editShowRequestDuration(ShowRequest showRequest, int duration) {
        return this.showRequestManagementService.editShowRequestDuration(showRequest, duration);
    }

    public ShowRequest editShowRequestSequenceOfFigures(ShowRequest showRequest, List<Figure> sequenceOfFigures) {
        return this.showRequestManagementService.editShowRequestSequenceOfFigures(showRequest, sequenceOfFigures);
    }
}
