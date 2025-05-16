package eapli.base.figureCategoryManagement.application;

import eapli.base.figureCategoryManagement.domain.FigureCategory;
import eapli.base.figureCategoryManagement.repositories.FigureCategoryRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.Roles;
import eapli.framework.application.UseCaseController;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

@UseCaseController
public class ListFigureCategoryController {

    private final TransactionalContext autoTX = PersistenceContext.repositories().newTransactionalContext();

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    private final FigureCategoryRepository repo = PersistenceContext.repositories().figureCategories(autoTX);

    private final FigureCategoryManagementService figureCategorySvc = new FigureCategoryManagementService(repo);

    public Iterable<FigureCategory> allFigureCategories() {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.SHOW_DESIGNER,Roles.CRM_COLLABORATOR);

        return figureCategorySvc.findAll();
    }
}
