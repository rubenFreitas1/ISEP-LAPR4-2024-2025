package eapli.base.figureManagement.application;

import eapli.base.figureCategoryManagement.application.FigureCategoryManagementService;
import eapli.base.figureCategoryManagement.domain.FigureCategory;
import eapli.base.figureCategoryManagement.repositories.FigureCategoryRepository;
import eapli.base.figureManagement.domain.Figure;
import eapli.base.figureManagement.repository.DSLRepository;
import eapli.base.figureManagement.repository.FigureRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.Roles;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class SearchFigureController {
    private final TransactionalContext autoTx = PersistenceContext.repositories().newTransactionalContext();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final FigureRepository figureRepository = PersistenceContext.repositories().figures(autoTx);
    private final DSLRepository dslRepository = PersistenceContext.repositories().dsls();
    private final FigureManagementService figureManagementService = new FigureManagementService(figureRepository, dslRepository);
    private final FigureCategoryRepository figureCategoryRepository = PersistenceContext.repositories().figureCategories(autoTx);
    private final FigureCategoryManagementService figureCategoryManagementService = new FigureCategoryManagementService(figureCategoryRepository);

    public void ensureAuthenticatedUser() {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.CRM_COLLABORATOR);
    }

    public Iterable<FigureCategory> figuresCategories() {
        return figureCategoryManagementService.findByActive(true);
    }
    public Iterable<Figure> findFiguresByKeyword(String keyword) {
        return figureManagementService.findByKeyword(keyword);
    }

    public Iterable<Figure> findFiguresByCategory(FigureCategory category) {
        return figureManagementService.findByCategory(category);
    }

    public Iterable<Figure> findFiguresByKeywordAndCategory(String keyword, FigureCategory category) {
        return figureManagementService.findByKeywordAndCategory(keyword, category);
    }
}
