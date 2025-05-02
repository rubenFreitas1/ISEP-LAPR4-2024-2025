package eapli.base.showRequestManagement.application;

import eapli.base.customerManagement.domain.Customer;
import eapli.base.figureManagement.application.FigureManagementService;
import eapli.base.figureManagement.domain.Figure;
import eapli.base.figureManagement.repository.FigureRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.showRequestManagement.domain.ShowRequest;
import eapli.base.showRequestManagement.repositories.ShowRequestRepository;
import eapli.base.usermanagement.domain.Roles;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.Calendar;
import java.util.List;

public class RegisterShowRequestController {
    private final TransactionalContext autoTx = PersistenceContext.repositories().newTransactionalContext();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ShowRequestRepository showRequestRepository = PersistenceContext.repositories().showRequests(autoTx);
    private final ShowRequestManagementService showRequestManagementService = new ShowRequestManagementService(showRequestRepository);
    private final FigureRepository figureRepository = PersistenceContext.repositories().figures(autoTx);
    private final FigureManagementService figureManagementService = new FigureManagementService(figureRepository);

    public Iterable<Customer> customers() {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.CRM_COLLABORATOR);
        return null;
    }
    public Iterable<Figure> figures() {
        return figureManagementService.findByExclusivity(false);
    }
    public ShowRequest registerShowRequest(Customer customer, String location, Calendar date, int duration, int droneNumber, List<Figure> figureSequence) {
        return showRequestManagementService.registerShowRequest(customer, location, date, duration, droneNumber, figureSequence);
    }
}
