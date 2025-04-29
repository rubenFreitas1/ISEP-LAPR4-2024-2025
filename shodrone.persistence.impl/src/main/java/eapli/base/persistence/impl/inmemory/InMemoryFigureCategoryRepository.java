package eapli.base.persistence.impl.inmemory;

import eapli.base.figureCategoryManagement.domain.FigureCategory;
import eapli.base.figureCategoryManagement.repositories.FigureCategoryRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.Optional;

public class InMemoryFigureCategoryRepository extends InMemoryDomainRepository<FigureCategory, Long>
        implements FigureCategoryRepository {

    @Override
    public Iterable<FigureCategory> findByName(String name) {
        return match(e -> e.name().equals(name));
    }

    @Override
    public Iterable<FigureCategory> findByDescription(String description) {
        return match(e -> e.description().equals(description));
    }

    @Override
    public Iterable<FigureCategory> findByType(String type) {
        return match(e -> e.description().equals(type));
    }

    @Override
    public Iterable<FigureCategory> findByActive(boolean active) {
        return this.match((e) -> {
            return e.isActive() == active;
        });
    }

    @Override
    public boolean isFigureCategoryNameUsed(String name) {
        return matchOne(e -> e.name().equalsIgnoreCase(name)).isPresent();
    }

    @Override
    public Optional<FigureCategory> findById(Long id) {
        return matchOne(e -> e.identity().equals(id));
    }
}
