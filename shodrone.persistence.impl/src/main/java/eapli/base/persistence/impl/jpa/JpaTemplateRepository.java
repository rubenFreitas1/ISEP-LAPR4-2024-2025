package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.showProposalManagement.domain.Template;
import eapli.base.showProposalManagement.repositories.TemplateRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class JpaTemplateRepository extends JpaAutoTxRepository<Template, Long, Long> implements TemplateRepository {

    public JpaTemplateRepository(TransactionalContext autoTx) {
        super(autoTx, "templateId");
    }

    public JpaTemplateRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "templateId");
    }

    @Override
    public Optional<Template> findByName(String name) {
        final Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        return matchOne("e.name = :name", params);
    }

    @Override
    public boolean isNameUsed(String name) {
        final Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        return matchOne("e.name = :name", params).isPresent();
    }

    @Override
    public boolean isContentUsed(String content) {
        final Map<String, Object> params = new HashMap<>();
        params.put("content", content);
        return matchOne("e.content = :content", params).isPresent();
    }
}
