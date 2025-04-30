package eapli.base.figureManagement.application;

import eapli.base.figureCategoryManagement.application.FigureCategoryManagementService;
import eapli.base.figureCategoryManagement.domain.FigureCategory;
import eapli.base.figureManagement.domain.Figure;
import eapli.base.figureManagement.repository.FigureRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.Roles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.HashSet;
import java.util.Set;

@UseCaseController
public class AddFigureController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

     private final FigureRepository repo = PersistenceContext.repositories().figures();

    private final FigureManagementService figureManagementService = new FigureManagementService(repo);

    private final FigureCategoryManagementService figureCategoryManagementService = new FigureCategoryManagementService(PersistenceContext.repositories().figureCategories());

    public Figure addFigure(final String figureDescription, final Set<String> keywords, final FigureCategory figureCategory, boolean exclusive) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.SHOW_DESIGNER);
        return figureManagementService.registerNewFigure(figureDescription, keywords, figureCategory, exclusive);
    }

    public Iterable<FigureCategory> listFigureCategories() {
        return figureCategoryManagementService.findByActive(true);
    }
}
