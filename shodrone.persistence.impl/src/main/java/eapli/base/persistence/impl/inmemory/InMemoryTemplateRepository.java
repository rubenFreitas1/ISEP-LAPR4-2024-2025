package eapli.base.persistence.impl.inmemory;


import eapli.base.showProposalManagement.domain.Template;
import eapli.base.showProposalManagement.repositories.TemplateRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.Optional;

public class InMemoryTemplateRepository extends InMemoryDomainRepository<Template, Long> implements TemplateRepository {


    @Override
    public Optional<Template> findById(Long id) {
        return matchOne(e -> e.identity().equals(id));
    }

    @Override
    public Optional<Template> findByName(String name) {
        return matchOne(e -> e.name().equals(name));
    }

    @Override
    public boolean isNameUsed(String name) {
        return matchOne(e -> e.name().equals(name)).isPresent();
    }
    @Override
    public boolean isContentUsed(String content) {
        return matchOne(e -> e.content().equals(content)).isPresent();
    }
}
