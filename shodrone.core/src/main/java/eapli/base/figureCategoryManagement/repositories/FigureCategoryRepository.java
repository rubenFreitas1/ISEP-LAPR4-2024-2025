package eapli.base.figureCategoryManagement.repositories;

import eapli.base.figureCategoryManagement.domain.FigureCategory;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface FigureCategoryRepository extends DomainRepository<Long, FigureCategory> {

    Iterable<FigureCategory> findByActive(boolean active);

    boolean isFigureCategoryNameUsed(String name);

    Iterable<FigureCategory> findByName(String name);

    Iterable<FigureCategory> findByDescription(String description);

    Iterable<FigureCategory> findByType(String type);

    Optional<FigureCategory> findById(Long id);
}
