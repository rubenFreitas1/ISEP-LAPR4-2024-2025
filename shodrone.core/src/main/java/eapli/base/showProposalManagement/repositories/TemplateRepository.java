package eapli.base.showProposalManagement.repositories;

import eapli.base.showProposalManagement.domain.Template;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface TemplateRepository extends DomainRepository<Long, Template> {

    Optional<Template> findById(Long id);

    Optional<Template> findByName(String name);

    boolean isNameUsed(String name);

    boolean isContentUsed(String content);
}
