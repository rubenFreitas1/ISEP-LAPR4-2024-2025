package eapli.base.showProposalManagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.showProposalManagement.LPROGConnection.plugins.ShowProposalValidator;
import eapli.base.showProposalManagement.domain.Template;
import eapli.base.showProposalManagement.repositories.ShowProposalRepository;
import eapli.base.showProposalManagement.repositories.TemplateRepository;
import eapli.base.usermanagement.domain.Roles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@UseCaseController
public class ConfigureTemplateController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final TemplateRepository templateRepository = PersistenceContext.repositories().templates();
    private final TemplateManagementService templateManagementSvc = new TemplateManagementService(templateRepository);

    public boolean registerTemplate(String name, String contentPath)  throws IOException {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.CRM_MANAGER);
        String template = Files.readString(Paths.get(contentPath));
        if (ShowProposalValidator.validateShowProposalPlaceholders(template)) {
            templateManagementSvc.createTemplate(name, template);
            return true;
        }
        throw new IllegalArgumentException("Template content does not contain the required placeholders.");
    }
}
