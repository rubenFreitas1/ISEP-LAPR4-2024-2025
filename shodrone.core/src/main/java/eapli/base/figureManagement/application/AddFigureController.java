package eapli.base.figureManagement.application;

import eapli.base.figureCategoryManagement.domain.FigureCategory;
import eapli.base.figureManagement.domain.Figure;
import eapli.base.figureManagement.repository.FigureRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.Roles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.HashSet;

@UseCaseController
public class AddFigureController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

     private final FigureRepository repo = PersistenceContext.repositories().figures();

    private final FigureManagementService figureManagementService = new FigureManagementService(repo);

    public Figure addFigure(final String figureDescription, final HashSet<String> keywords, final FigureCategory figureCategory, boolean exclusive) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.SHOW_DESIGNER);
        return figureManagementService.registerNewFigure(figureDescription, keywords, figureCategory, exclusive);
    }
}
