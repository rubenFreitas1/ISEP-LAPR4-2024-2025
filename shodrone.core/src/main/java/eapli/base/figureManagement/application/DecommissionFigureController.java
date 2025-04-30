package eapli.base.figureManagement.application;

import eapli.base.figureManagement.domain.Figure;
import eapli.base.figureManagement.repository.FigureRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.Roles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

@UseCaseController
public class DecommissionFigureController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    private final FigureRepository repo = PersistenceContext.repositories().figures();

    private final FigureManagementService figureManagementService = new FigureManagementService(repo);

    public Iterable<Figure> activeFigures() {
        return this.figureManagementService.activeFigures();
    }

    public Figure decommissionFigure(Figure figure) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.CRM_MANAGER);
        return this.figureManagementService.decommissionFigure(figure);
    }
}
