package eapli.base.showProposalManagement.application;

import eapli.base.showProposalManagement.domain.Template;
import eapli.base.showProposalManagement.repositories.TemplateRepository;

public class TemplateManagementService {

    private final TemplateRepository templateRepository;

    public TemplateManagementService(final TemplateRepository templateRepository) {
        this.templateRepository = templateRepository;
    }

    public Template createTemplate(final String name, final String content) {
        final Template template = new Template(name, content);
        return this.templateRepository.save(template);
    }

    public Iterable<Template> listAllTemplates() {
        return this.templateRepository.findAll();
    }
}
