package eapli.base.showProposalManagement.application;

import eapli.base.showProposalManagement.domain.Template;
import eapli.base.showProposalManagement.repositories.TemplateRepository;

public class TemplateManagementService {

    private final TemplateRepository templateRepository;

    public TemplateManagementService(final TemplateRepository templateRepository) {
        this.templateRepository = templateRepository;
    }

    public Template createTemplate(final String name, final String content) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Template Name cannot be null or empty");
        } else if (isNameUsed(name)) {
            throw new IllegalArgumentException("Template Name already in use");
        }
        if (content == null || content.isEmpty()) {
            throw new IllegalArgumentException("Template Content cannot be null or empty");
        } else if (isContentUsed(content)) {
            throw new IllegalArgumentException("Template Content already in use");
        }

        final Template template = new Template(name, content);
        return this.templateRepository.save(template);
    }

    public Iterable<Template> listAllTemplates() {
        return this.templateRepository.findAll();
    }

    public boolean isNameUsed(final String name) {
        return this.templateRepository.isNameUsed(name);
    }

    public boolean isContentUsed(final String content) {
        return this.templateRepository.isContentUsed(content);
    }
}
