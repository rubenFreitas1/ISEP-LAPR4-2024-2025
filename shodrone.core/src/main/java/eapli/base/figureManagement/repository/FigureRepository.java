package eapli.base.figureManagement.repository;

import eapli.base.figureCategoryManagement.domain.FigureCategory;
import eapli.base.figureManagement.domain.Figure;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface FigureRepository extends DomainRepository<Long, Figure> {

    Optional<Figure> findByKeyword(String keyword);

    Iterable<Figure> findByFigureCategory(FigureCategory figureCategory);

    Iterable<Figure> findByActive(boolean active);

    Iterable<Figure> findByNonExclusivity(boolean exclusive);
}
