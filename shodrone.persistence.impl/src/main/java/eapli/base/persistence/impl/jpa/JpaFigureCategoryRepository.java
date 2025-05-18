package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.figureCategoryManagement.domain.FigureCategory;
import eapli.base.figureCategoryManagement.repositories.FigureCategoryRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class JpaFigureCategoryRepository extends JpaAutoTxRepository<FigureCategory, Long, Long> implements FigureCategoryRepository {

    public JpaFigureCategoryRepository(TransactionalContext autoTx){
        super(autoTx, "figureCategoryId");
    }

    public JpaFigureCategoryRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "figureCategoryId");
    }

    @Override
    public Iterable<FigureCategory> findByName(String name) {
        return match("e.name=:name", new Object[]{"name", name});
    }

    @Override
    public Iterable<FigureCategory> findByDescription(String description) {
        return match("e.description=:description", new Object[]{"description", description});
    }

    @Override
    public Iterable<FigureCategory> findByType(String type) {
        return match("e.type=:type", new Object[]{"type", type});
    }

    @Override
    public Iterable<FigureCategory> findByActive(boolean active) {
        return match("e.active=:active", new Object[]{"active", active});
    }

    @Override
    public boolean isFigureCategoryNameUsed(String name) {
        final Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        return matchOne("e.name = :name", params).isPresent();
    }

    @Override
    public Optional<FigureCategory> findById(Long id) {
        final Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return matchOne("e.figureCategoryId = :id", params);
    }
}
