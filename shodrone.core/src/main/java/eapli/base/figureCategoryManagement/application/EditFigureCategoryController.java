package eapli.base.figureCategoryManagement.application;

import eapli.base.figureCategoryManagement.domain.FigureCategory;
import eapli.base.figureCategoryManagement.repositories.FigureCategoryRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.Roles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class EditFigureCategoryController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    private final FigureCategoryRepository repo = PersistenceContext.repositories().figureCategories();

    private final FigureCategoryManagementService figureCategorySvc = new FigureCategoryManagementService(repo);

    public FigureCategory editFigureCategory(FigureCategory figureCategory, String newName, String newDescription) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.SHOW_DESIGNER);
        figureCategorySvc.editFigureCategory(figureCategory, newName, newDescription);
        return figureCategory;
    }



    public Iterable<FigureCategory> allActiveFigureCategories() {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.SHOW_DESIGNER);
        return this.figureCategorySvc.findByActive(true);
    }
}
